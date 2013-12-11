package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportKeyword;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Keyword Performace report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportKeywordDefinitionTest extends AbstractReportDefinitionTest<ReportKeyword> {

  /**
   * C'tor
   */
  public ReportKeywordDefinitionTest() {

    super(ReportKeyword.class, ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT,
        "src/test/resources/csv/keyword.csv");
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportKeyword first) {

    Assert.assertEquals(8661954824L, first.getAccountId().longValue());
    Assert.assertEquals("2013-05-01", first.getDay());
    Assert.assertEquals("0.00", first.getCost());
    Assert.assertEquals(0L, first.getClicks().longValue());
    Assert.assertEquals(20L, first.getImpressions().longValue());
    Assert.assertEquals(0L, first.getConversions().longValue());
    Assert.assertEquals("0.00", first.getCtr());
    Assert.assertEquals("0.00", first.getAvgCpm());
    Assert.assertEquals("0.00", first.getAvgCpc());
    Assert.assertEquals("4.50", first.getAvgPosition());
    Assert.assertEquals("EUR", first.getCurrencyCode());

    Assert.assertEquals(86352677L, first.getCampaignId().longValue());
    Assert.assertEquals(3398915357L, first.getAdGroupId().longValue());
    Assert.assertEquals(41933620L, first.getKeywordId().longValue());
    Assert.assertEquals("enabled", first.getStatus());
    Assert.assertEquals("10.00", first.getQualityScore());
    Assert.assertEquals("Broad", first.getKeywordMatchType());
    Assert.assertEquals("achat forêt", first.getKeywordText());
    Assert.assertEquals("", first.getDestinationUrl());
    Assert.assertFalse(first.isNegative());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportKeyword last) {

    Assert.assertEquals(8661954824L, last.getAccountId().longValue());
    Assert.assertEquals("2013-05-10", last.getDay());
    Assert.assertEquals("0.00", last.getCost());
    Assert.assertEquals(0L, last.getClicks().longValue());
    Assert.assertEquals(1L, last.getImpressions().longValue());
    Assert.assertEquals(0L, last.getConversions().longValue());
    Assert.assertEquals("0.00", last.getCtr());
    Assert.assertEquals("0.00", last.getAvgCpm());
    Assert.assertEquals("0.00", last.getAvgCpc());
    Assert.assertEquals("6.00", last.getAvgPosition());
    Assert.assertEquals("EUR", last.getCurrencyCode());

    Assert.assertEquals(86352677L, last.getCampaignId().longValue());
    Assert.assertEquals(3398915357L, last.getAdGroupId().longValue());
    Assert.assertEquals(44877775648L, last.getKeywordId().longValue());
    Assert.assertEquals("enabled", last.getStatus());
    Assert.assertEquals("10.00", last.getQualityScore());
    Assert.assertEquals("Broad", last.getKeywordMatchType());
    Assert.assertEquals("propriete sologne a vendre", last.getKeywordText());
    Assert.assertEquals("", last.getDestinationUrl());
    Assert.assertFalse(last.isNegative());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {

    return 149;
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
        "QualityScore",
        "KeywordMatchType",
        "KeywordText",
        "DestinationUrl",
        "IsNegative",
        "Date",
        "Month",
        "AdNetworkType1",
        "AdNetworkType2",
        "Device",
        "ClickType"};
  }
}