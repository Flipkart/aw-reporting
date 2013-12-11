package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdGroup;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Ad Group Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportAdGroupDefinitionTest extends AbstractReportDefinitionTest<ReportAdGroup> {

  /**
   * C'tor
   */
  public ReportAdGroupDefinitionTest() {
    super(ReportAdGroup.class, ReportDefinitionReportType.ADGROUP_PERFORMANCE_REPORT,
        "src/test/resources/csv/ad-group.csv");
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportAdGroup first) {

    Assert.assertEquals(2450945640L, first.getAccountId().longValue());
    Assert.assertEquals("2013-05-07", first.getDay());
    Assert.assertEquals("2.72", first.getCost());
    Assert.assertEquals(6L, first.getClicks().longValue());
    Assert.assertEquals(16L, first.getImpressions().longValue());
    Assert.assertEquals(0L, first.getConversions().longValue());
    Assert.assertEquals("37.50", first.getCtr());
    Assert.assertEquals("170.00", first.getAvgCpm());
    Assert.assertEquals("0.45", first.getAvgCpc());
    Assert.assertEquals("2.69", first.getAvgPosition());
    Assert.assertEquals("EUR", first.getCurrencyCode());
    Assert.assertEquals(129807304L, first.getCampaignId().longValue());
    Assert.assertEquals(7253055064L, first.getAdGroupId().longValue());
    Assert.assertEquals("enabled", first.getStatus());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportAdGroup last) {

    Assert.assertEquals(2450945640L, last.getAccountId().longValue());
    Assert.assertEquals("2013-05-10", last.getDay());
    Assert.assertEquals("0.60", last.getCost());
    Assert.assertEquals(1L, last.getClicks().longValue());
    Assert.assertEquals(72L, last.getImpressions().longValue());
    Assert.assertEquals(0L, last.getConversions().longValue());
    Assert.assertEquals("1.39", last.getCtr());
    Assert.assertEquals("8.33", last.getAvgCpm());
    Assert.assertEquals("0.60", last.getAvgCpc());
    Assert.assertEquals("2.58", last.getAvgPosition());
    Assert.assertEquals("EUR", last.getCurrencyCode());
    Assert.assertEquals(129807304L, last.getCampaignId().longValue());
    Assert.assertEquals(7253055064L, last.getAdGroupId().longValue());
    Assert.assertEquals("enabled", last.getStatus());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {
    return 4;
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
        "AdGroupName",
        "Status",
        "Date",
        "Month",
        "AdNetworkType1",
        "AdNetworkType2",
        "Device",
        "ClickType"};
  }
}