package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAd;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Ad Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportAdDefinitionTest extends AbstractReportDefinitionTest<ReportAd> {

  /**
   * C'tor
   */
  public ReportAdDefinitionTest() {
    super(ReportAd.class, ReportDefinitionReportType.AD_PERFORMANCE_REPORT,
        "src/test/resources/csv/ad-performance.csv");
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportAd first) {

    Assert.assertEquals(1001270004L, first.getAccountId().longValue());
    Assert.assertEquals("2013-05-01", first.getDay());
    Assert.assertEquals("9.39", first.getCost());
    Assert.assertEquals(32L, first.getClicks().longValue());
    Assert.assertEquals(1258L, first.getImpressions().longValue());
    Assert.assertEquals(0L, first.getConversions().longValue());
    Assert.assertEquals("2.54", first.getCtr());
    Assert.assertEquals("7.46", first.getAvgCpm());
    Assert.assertEquals("0.29", first.getAvgCpc());
    Assert.assertEquals("2.12", first.getAvgPosition());
    Assert.assertEquals("EUR", first.getCurrencyCode());

    Assert.assertEquals(132958027L, first.getCampaignId().longValue());
    Assert.assertEquals(6113972227L, first.getAdGroupId().longValue());
    Assert.assertEquals(20549800987L, first.getAdId().longValue());
    Assert.assertEquals("enabled", first.getAdState());
    Assert.assertEquals("approved", first.getCreativeApprovalStatus());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportAd last) {

    Assert.assertEquals(1001270004L, last.getAccountId().longValue());
    Assert.assertEquals("2013-05-10", last.getDay());
    Assert.assertEquals("1.46", last.getCost());
    Assert.assertEquals(2L, last.getClicks().longValue());
    Assert.assertEquals(58L, last.getImpressions().longValue());
    Assert.assertEquals(0L, last.getConversions().longValue());
    Assert.assertEquals("3.45", last.getCtr());
    Assert.assertEquals("25.17", last.getAvgCpm());
    Assert.assertEquals("0.73", last.getAvgCpc());
    Assert.assertEquals("3.29", last.getAvgPosition());
    Assert.assertEquals("EUR", last.getCurrencyCode());

    Assert.assertEquals(132958027L, last.getCampaignId().longValue());
    Assert.assertEquals(6114146707L, last.getAdGroupId().longValue());
    Assert.assertEquals(20551837747L, last.getAdId().longValue());
    Assert.assertEquals("enabled", last.getAdState());
    Assert.assertEquals("approved", last.getCreativeApprovalStatus());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {
    return 20;
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
        "AdGroupId",
        "Id",
        "Status",
        "DisplayUrl",
        "Url",
        "Headline",
        "Description1",
        "Description2",
        "CreativeApprovalStatus",
        "Date",
        "Month",
        "AdNetworkType1",
        "AdNetworkType2",
        "Device",
        "ClickType"};
  }
}