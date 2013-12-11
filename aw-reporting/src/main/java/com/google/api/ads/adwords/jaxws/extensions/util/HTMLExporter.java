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

package com.google.api.ads.adwords.jaxws.extensions.util;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import com.lowagie.text.DocumentException;
import com.samskivert.mustache.Mustache;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.XMLResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class to export reports to HTML using JMoustache, and convert HTML to PDF using Flying Saucer
 *
 * @author markbowyer@google.com (Mark R. Bowyer)
 */
public class HTMLExporter {

  public HTMLExporter() {}

  /**
   * Exports an HTML file of the given report
   *
   * @param reportTitle The Title text to use
   * @param reportType the report type, which selects the template file
   * @param reports the data from the Report
   * @param templateFile where to read out the HTML template
   * @param outputFile where to write out the HTML
   * @throws IOException error writing HTML file
   * @throws FileNotFoundException error reading template file
   */
  public static void exportHTML(final String reportTitle, ReportDefinitionReportType reportType,
      final List<? extends Report> reports, File templateFile, final File outputFile)
          throws IOException {

    FileReader templateReader = new FileReader(templateFile);
    FileWriter fileWriter = new FileWriter(outputFile);

    Object feed = createFeedObject(reportTitle, reports);

    Mustache.compiler().compile(templateReader).execute(feed, fileWriter);

    fileWriter.flush();
    fileWriter.close();
    templateReader.close();
  }

  /**
   * Creates the object that will be used on the template.
   *
   * @param reportTitle the report title
   * @param reports the list with the report rows
   * @return the feed Object containing the properties to be set on the template
   */
  private static Object createFeedObject(
      final String reportTitle, final List<? extends Report> reports) {

    return new Object() {
      String title = reportTitle;

      @SuppressWarnings("unused")
      String title() {
        return title;
      }

      @SuppressWarnings("unused")
      Object rows = reports;
    };
  }

  /**
   * Convert a given HTML file to a PDF file
   *
   * @param inFile The HTML file
   * @param outFile The resulting PDF file
   * @throws DocumentException error creating PDF file
   * @throws IOException error closing file
   */
  public static void convertHTMLtoPDF(File inFile, File outFile)
      throws DocumentException, IOException {

    FileReader htmlReader = new FileReader(inFile);

    Document document = XMLResource.load(htmlReader).getDocument();
    ITextRenderer renderer = new ITextRenderer();
    renderer.getSharedContext().setReplacedElementFactory(
        new MediaReplacedElementFactory(renderer.getSharedContext().getReplacedElementFactory()));
    renderer.setDocument(document, null);

    renderer.layout();

    FileOutputStream fos = new FileOutputStream(outFile);

    renderer.createPDF(fos, true);

    fos.flush();
    fos.close();
  }
}
