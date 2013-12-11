// Copyright 2013 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.jaxws.extensions.kratu;

import com.google.api.ads.adwords.jaxws.extensions.AwReporting;
import com.google.api.ads.adwords.jaxws.extensions.kratu.data.Account;
import com.google.api.ads.adwords.jaxws.extensions.kratu.data.KratuProcessor;
import com.google.api.ads.adwords.jaxws.extensions.kratu.data.StorageHelper;
import com.google.api.ads.adwords.jaxws.extensions.kratu.restserver.RestServer;
import com.google.api.ads.adwords.jaxws.extensions.processors.ReportProcessor;
import com.google.api.ads.adwords.jaxws.extensions.proxy.JaxWsProxySelector;
import com.google.api.ads.adwords.jaxws.extensions.util.DataBaseType;
import com.google.api.ads.adwords.jaxws.extensions.util.DynamicPropertyPlaceholderConfigurer;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ProxySelector;
import java.util.Properties;
import java.util.Scanner;

/**
 * Main class that executes the report processing logic delegating to the {@link ReportProcessor}.
 *
 *  This class holds a Spring application context that manages the creation of all the beans needed.
 * No configuration is done in this class.
 *
 *  Credentials and properties are pulled from the ~/aw-report-sample.properties.properties file or
 * -file <file> provided.
 *
 * See README for more info.
 *
 * @author jtoledo@google.com (Julian Toledo)
 */
public class KratuMain {

  /**
   * The DB type key specified in the properties file.
   */
  private static final String AW_REPORT_MODEL_DB_TYPE = "aw.report.model.db.type";

  /**
   * Default properties file name.
   */
  private static final String CLASSPATH_AW_REPORT_MODEL_PROPERTIES_LOCATION =
      "kratubackend-sample.properties";

  /**
   * The Spring application context used to get all the beans.
   */
  private static ApplicationContext appCtx;

  /**
   * Main method.
   *
   * @param args the command line arguments.
   */
  public static void main(String args[]) {

    // Proxy
    JaxWsProxySelector ps = new JaxWsProxySelector(ProxySelector.getDefault());
    ProxySelector.setDefault(ps);

    Options options = createCommandLineOptions();

    boolean errors = false;
    String propertiesPath = CLASSPATH_AW_REPORT_MODEL_PROPERTIES_LOCATION;

    try {
      CommandLineParser parser = new BasicParser();
      CommandLine cmdLine = parser.parse(options, args);

      if (cmdLine.hasOption("file")) {
        propertiesPath = cmdLine.getOptionValue("file");
      }
      System.out.println("Using properties from: " + propertiesPath);

      if (cmdLine.hasOption("startServer")) {
        // Start the Rest Server
        System.out.println("Starting Rest Server...");
        initApplicationContextAndProperties(propertiesPath);
        updateAccounts();

        RestServer.createRestServer(appCtx, propertiesPath);

      } else {
        if (cmdLine.hasOption("startDate") && cmdLine.hasOption("endDate")) {
          if (cmdLine.hasOption("processKratus")) {
            // Process Kratus, this process runs for the whole MCC
            // within the given dates and creates a daily Kratu per account.
            System.out.println("Starting Process Kratus...");
            initApplicationContextAndProperties(propertiesPath);
            updateAccounts();

            KratuProcessor kratuProcessor = appCtx.getBean(KratuProcessor.class);
            kratuProcessor.processKratus(
                cmdLine.getOptionValue("startDate"), cmdLine.getOptionValue("endDate"));
            System.exit(0);

          } else {
            // Download Reports,
            // this porcess downloads 7 report types for each account under the MCC
            System.out.println("Starting Download Reports porcess...");
            AwReporting.main(args);
            System.exit(0);

          }
        } else {
          errors = true;
          System.out.println("Configuration incomplete. Missing options for command line.");
        }
      }
    } catch (IOException e) {
      errors = true;
      System.out.println("Properties file (" + propertiesPath + ") not found: " + e.getMessage());
    } catch (ParseException e) {
      errors = true;
      System.out.println(
          "Error parsing the values for the command line options: " + e.getMessage());
    } catch (Exception e) {
      errors = true;
      System.out.println("Unexpected error: " + e.getMessage());
    }

    if (errors) {
      printHelpMessage(options);
      System.exit(1);      
    }
  }

  /**
   * Refreshes the Accounts by downloading the whole list using the API
   * and refreshes the report indexes before heavily reading reports.
   */
  private static void updateAccounts() throws Exception {
    StorageHelper storageHelper = appCtx.getBean(StorageHelper.class);
    ReportProcessor reportProcessor = appCtx.getBean(ReportProcessor.class);

    // Refresh Account List and refresh indexes
    System.out.println("Updating Accounts from server... (may take few seconds)");
    storageHelper.getEntityPersister().save(Account.fromList(reportProcessor.getAccounts()));
    System.out.println("Updating DB indexes... (may take few seconds)");
    storageHelper.createReportIndexes();
  }

  /**
   * Creates the command line options.
   *
   * @return the {@link Options}.
   */
  private static Options createCommandLineOptions() {

    Options options = new Options();
    Option help = new Option("help", "print this message");
    options.addOption(help);

    OptionBuilder.withArgName("startServer");
    OptionBuilder.hasArg(false);
    OptionBuilder.withDescription(
        "Starts the Rest Server. No dates required");
    OptionBuilder.isRequired(false);
    options.addOption(OptionBuilder.create("startServer"));

    OptionBuilder.withArgName("processKratus");
    OptionBuilder.hasArg(false);
    OptionBuilder.withDescription(
        "Process Kratus processes the 7 reports peraccount and creates a daily Kratu");
    OptionBuilder.isRequired(false);
    options.addOption(OptionBuilder.create("processKratus"));

    OptionBuilder.withArgName("file");
    OptionBuilder.hasArg(true);
    OptionBuilder.withDescription(
        "kratubackend-sample.properties file " + 
        " (./kratubackend-sample.properties by default if not provided)");
    OptionBuilder.isRequired(false);
    options.addOption(OptionBuilder.create("file"));

    OptionBuilder.withArgName("YYYYMMDD");
    OptionBuilder.hasArg(true);
    OptionBuilder.withDescription("Start date for CUSTOM_DATE Reports (YYYYMMDD)");
    OptionBuilder.isRequired(false);
    options.addOption(OptionBuilder.create("startDate"));

    OptionBuilder.withArgName("YYYMMDD");
    OptionBuilder.hasArg(true);
    OptionBuilder.withDescription("End date for CUSTOM_DATE Reports (YYYYMMDD)");
    OptionBuilder.isRequired(false);
    options.addOption(OptionBuilder.create("endDate"));

    OptionBuilder.withArgName("DateRangeType");
    OptionBuilder.hasArg(true);
    OptionBuilder.withDescription("ReportDefinitionDateRangeType");
    OptionBuilder.isRequired(false);
    options.addOption(OptionBuilder.create("dateRange"));
    return options;
  }

  /**
   * Prints the help message.
   *
   * @param options the options available for the user.
   */
  private static void printHelpMessage(Options options) {

    // automatically generate the help statement
    System.out.println();
    HelpFormatter formatter = new HelpFormatter();
    formatter.setWidth(120);

    formatter.printHelp("java -Xmx4G -jar kratubackend.jar -startDate YYYYMMDD -endDate YYYYMMDD -file <file>\n"
        + "-Xmx4G -jar kratubackend.jar -processKratus -startDate YYYYMMDD -endDate YYYYMMDD -file <file>\n"
        + "-Xmx4G -jar kratubackend.jar -startServer -file <file>\n", options);

    printSamplePropertiesFile();
    System.out.println();
  }

  /**
   * Prints the sample properties file on the default output.
   */
  private static void printSamplePropertiesFile() {

    System.out.println("\n  File: kratubackend-sample.properties example");

    ClassPathResource sampleFile = new ClassPathResource(CLASSPATH_AW_REPORT_MODEL_PROPERTIES_LOCATION);
    Scanner fileScanner = null;
    try {
      fileScanner = new Scanner(sampleFile.getInputStream());
      while (fileScanner.hasNext()) {
        System.out.println(fileScanner.nextLine());
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fileScanner != null) {
        fileScanner.close();
      }
    }
  }

  /**
   * Initialize the application context, adding the properties configuration file depending on the
   * specified path.
   *
   * @param propertiesPath the path to the file.
   * @return the resource loaded from the properties file.
   * @throws IOException error opening the properties file.
   */
  private static Properties initApplicationContextAndProperties(String propertiesPath)
      throws IOException {

    Resource resource = new ClassPathResource(propertiesPath);
    if (!resource.exists()) {
      resource = new FileSystemResource(propertiesPath);
    }
    DynamicPropertyPlaceholderConfigurer.setDynamicResource(resource);

    Properties properties = PropertiesLoaderUtils.loadProperties(resource);
    String dbType = (String) properties.get(AW_REPORT_MODEL_DB_TYPE);
    if (dbType != null && dbType.equals(DataBaseType.MONGODB.name())) {
      appCtx = new ClassPathXmlApplicationContext("classpath:kratubackend-mongodb-beans.xml");
    } else {
      appCtx = new ClassPathXmlApplicationContext("classpath:kratubackend-sql-beans.xml");
    }

    return properties;
  }
}