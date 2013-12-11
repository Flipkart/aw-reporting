package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaign;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Campaign Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportCampaignDefinitionTest extends AbstractReportDefinitionTest<ReportCampaign> {

  /**
   * C'tor
   */
  public ReportCampaignDefinitionTest() {

    super(ReportCampaign.class, ReportDefinitionReportType.CAMPAIGN_PERFORMANCE_REPORT,
        "src/test/resources/csv/campaign.csv");
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportCampaign first) {

    Assert.assertEquals(1252422563L, first.getAccountId().longValue());
    Assert.assertEquals("2013-05-01", first.getDay());
    Assert.assertEquals("1.11", first.getCost());
    Assert.assertEquals(5L, first.getClicks().longValue());
    Assert.assertEquals(927L, first.getImpressions().longValue());
    Assert.assertEquals(0L, first.getConversions().longValue());
    Assert.assertEquals("0.54", first.getCtr());
    Assert.assertEquals("1.20", first.getAvgCpm());
    Assert.assertEquals("0.22", first.getAvgCpc());
    Assert.assertEquals("3.59", first.getAvgPosition());
    Assert.assertEquals("EUR", first.getCurrencyCode());

    Assert.assertEquals(132449648L, first.getCampaignId().longValue());
    Assert.assertEquals("active", first.getStatus());
    Assert.assertEquals("1.00", first.getBudget());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportCampaign last) {

    Assert.assertEquals(1252422563L, last.getAccountId().longValue());
    Assert.assertEquals("2013-05-10", last.getDay());
    Assert.assertEquals("0.88", last.getCost());
    Assert.assertEquals(6L, last.getClicks().longValue());
    Assert.assertEquals(757L, last.getImpressions().longValue());
    Assert.assertEquals(0L, last.getConversions().longValue());
    Assert.assertEquals("0.79", last.getCtr());
    Assert.assertEquals("1.16", last.getAvgCpm());
    Assert.assertEquals("0.15", last.getAvgCpc());
    Assert.assertEquals("3.21", last.getAvgPosition());
    Assert.assertEquals("EUR", last.getCurrencyCode());

    Assert.assertEquals(132449648L, last.getCampaignId().longValue());
    Assert.assertEquals("active", last.getStatus());
    Assert.assertEquals("1.00", last.getBudget());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {

    return 10;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrievePropertiesToBeSelected()
   */
  @Override
  protected String[] retrievePropertiesToBeSelected() {

    return new String[] {
        "ExternalCustomerId",
        "AccountDescriptiveName",
        "Cost",
        "Clicks",
        "Impressions",
        "Conversions",
        "Ctr",
        "AverageCpm",
        "AverageCpc",
        "AveragePosition",
        "AccountCurrencyCode",
        "CampaignId",
        "CampaignName",
        "Status",
        "Amount",
        "Date",
        "Month",
        "AdNetworkType1",
        "AdNetworkType2",
        "Device",
        "ClickType"};
  }
}