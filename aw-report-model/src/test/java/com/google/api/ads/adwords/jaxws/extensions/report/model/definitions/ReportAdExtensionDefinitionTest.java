package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdExtension;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Ad Extensions Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportAdExtensionDefinitionTest
    extends AbstractReportDefinitionTest<ReportAdExtension> {

  /**
   * C'tor
   */
  public ReportAdExtensionDefinitionTest() {
    super(ReportAdExtension.class, ReportDefinitionReportType.AD_EXTENSIONS_PERFORMANCE_REPORT,
        "src/test/resources/csv/ad-extensions.csv");
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportAdExtension first) {

    Assert.assertEquals(319387457L, first.getAdExtensionId().longValue());
    Assert.assertEquals(119807057L, first.getCampaignId().longValue());
    Assert.assertEquals("active", first.getStatus());
    Assert.assertEquals("eligible", first.getApprovalStatus());
    Assert.assertEquals("location extension", first.getAdExtensionType());

    Assert.assertEquals("Computers", first.getDevice());
    Assert.assertEquals("Headline", first.getClickType());

    Assert.assertEquals("2013-05-01", first.getDay());
    Assert.assertEquals(0L, first.getClicks().longValue());
    Assert.assertEquals(47L, first.getImpressions().longValue());
    Assert.assertEquals(0L, first.getConversions().longValue());
    Assert.assertEquals("0.00", first.getCost());
    Assert.assertEquals("0.00", first.getCtr());
    Assert.assertEquals("0.00", first.getAvgCpc());
    Assert.assertEquals("0.00", first.getAvgCpm());
    Assert.assertEquals("4.51", first.getAvgPosition());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportAdExtension last) {

    Assert.assertEquals(327723137L, last.getAdExtensionId().longValue());
    Assert.assertEquals(122782217L, last.getCampaignId().longValue());
    Assert.assertEquals("active", last.getStatus());
    Assert.assertEquals("eligible", last.getApprovalStatus());
    Assert.assertEquals("site links extension", last.getAdExtensionType());

    Assert.assertEquals("Computers", last.getDevice());
    Assert.assertEquals("Sitelink", last.getClickType());

    Assert.assertEquals("2013-05-05", last.getDay());
    Assert.assertEquals(0L, last.getClicks().longValue());
    Assert.assertEquals(1L, last.getImpressions().longValue());
    Assert.assertEquals(0L, last.getConversions().longValue());
    Assert.assertEquals("0.00", last.getCost());
    Assert.assertEquals("0.00", last.getCtr());
    Assert.assertEquals("0.00", last.getAvgCpc());
    Assert.assertEquals("0.00", last.getAvgCpm());
    Assert.assertEquals("3.00", last.getAvgPosition());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {
    return 23;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrievePropertiesToBeSelected()
   */
  @Override
  protected String[] retrievePropertiesToBeSelected() {

    return new String[] {
        "Cost",
        "Clicks",
        "Impressions",
        "Conversions",
        "Ctr",
        "AverageCpm",
        "AverageCpc",
        "AveragePosition",
        "Date",
        "Month",
        "AdNetworkType1",
        "AdNetworkType2",
        "CampaignId",
        "AdExtensionId",
        "AdExtensionType",
        "Status",
        "ApprovalStatus",
        "Device",
        "ClickType"};
  }
}