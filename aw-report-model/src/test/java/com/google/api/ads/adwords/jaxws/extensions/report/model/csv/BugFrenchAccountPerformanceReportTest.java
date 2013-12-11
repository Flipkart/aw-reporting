package com.google.api.ads.adwords.jaxws.extensions.report.model.csv;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAccount;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.ModifiedCsvToBean;

import au.com.bytecode.opencsv.CSVReader;
import junit.framework.Assert;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

/**
 * Test the bug with the french characters in the CSV file.
 */
public class BugFrenchAccountPerformanceReportTest {

  @Test
  public void testAnnotationMapping() throws UnsupportedEncodingException, FileNotFoundException {

    Locale.setDefault(Locale.US);

    CSVReader csvReader = new AwReportCsvReader(new InputStreamReader(
        new FileInputStream("src/test/resources/csv/bug-account-france.csv"), "UTF-8"), ',', '\"',
        1);

    AnnotationBasedMappingStrategy<ReportAccount> mappingStrategy =
        new AnnotationBasedMappingStrategy<ReportAccount>(ReportAccount.class);

    ModifiedCsvToBean<ReportAccount> csvToBean = new ModifiedCsvToBean<ReportAccount>();
    List<ReportAccount> parsedBeans = csvToBean.parse(mappingStrategy, csvReader);

    Assert.assertEquals(28, parsedBeans.size());

    ReportAccount reportAccount = parsedBeans.get(0);
    Assert.assertEquals(1003027038L, reportAccount.getAccountId().longValue());
    Assert.assertEquals("2013-10-04", reportAccount.getDay());
    Assert.assertEquals(
        "L'occitane Automobiles - Pezenas", reportAccount.getAccountDescriptiveName());
    Assert.assertEquals("6.70", reportAccount.getCost());
    Assert.assertEquals(4L, reportAccount.getClicks().longValue());
    Assert.assertEquals(87L, reportAccount.getImpressions().longValue());
    Assert.assertEquals(0L, reportAccount.getConversions().longValue());
    Assert.assertEquals("4.60", reportAccount.getCtr());
    Assert.assertEquals("77.01", reportAccount.getAvgCpm());
    Assert.assertEquals("1.68", reportAccount.getAvgCpc());
    Assert.assertEquals("1.40", reportAccount.getAvgPosition());
    Assert.assertEquals("EUR", reportAccount.getCurrencyCode());

    reportAccount = parsedBeans.get(27);
    Assert.assertEquals(1003027038L, reportAccount.getAccountId().longValue());
    Assert.assertEquals("2013-10-31", reportAccount.getDay());
    Assert.assertEquals("EUR", reportAccount.getCurrencyCode());

  }
}
