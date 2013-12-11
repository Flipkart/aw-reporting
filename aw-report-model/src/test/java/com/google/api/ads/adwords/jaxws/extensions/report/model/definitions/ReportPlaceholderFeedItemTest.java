/**
 * 
 */
package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportPlaceholderFeedItem;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.BigDecimalUtil;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

/**
 * Tests the Placeholder Feed Item report definition.
 * 
 *  * @author markbowyer@google.com (Mark R. Bowyer)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportPlaceholderFeedItemTest extends
    AbstractReportDefinitionTest<ReportPlaceholderFeedItem> {

  /**
   * C'tor
   */
  public ReportPlaceholderFeedItemTest() {

    super(ReportPlaceholderFeedItem.class,
    ReportDefinitionReportType.PLACEHOLDER_FEED_ITEM_REPORT,
    "src/test/resources/csv/placeholder-feeditem.csv") ;
  }

  @Override
  protected void testFirstEntry(ReportPlaceholderFeedItem first) {
    Assert.assertEquals(128401167L, first.getCampaignId().longValue());
    Assert.assertEquals(7788826047L, first.getAdGroupId().longValue());
    Assert.assertEquals(421887, first.getFeedId().longValue());
    Assert.assertEquals(1785447, first.getFeedItemId().longValue());
    Assert.assertEquals(1, first.getFeedPlaceholderType());
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(first.getValuePerConversion1()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(first.getValuePerConversionMany()));
    Assert.assertEquals("Les Ecuries De Kerballan - Gommenech", first.getAccountDescriptiveName());
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.7"), BigDecimalUtil.parseFromNumberString(first.getCost()));
    Assert.assertEquals(9, first.getClicks().intValue());
    Assert.assertEquals(74, first.getImpressions().intValue());
    Assert.assertEquals(0, first.getConversions().intValue());
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("12.16"), BigDecimalUtil.parseFromNumberString(first.getCtr()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("9.46"), BigDecimalUtil.parseFromNumberString(first.getAvgCpm()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.08"), BigDecimalUtil.parseFromNumberString(first.getAvgCpc()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("2.2"), BigDecimalUtil.parseFromNumberString(first.getAvgPosition()));
    Assert.assertEquals("Headline", first.getClickType());
    Assert.assertEquals("Search Network", first.getAdNetwork());    
  }

  @Override
  protected void testLastEntry(ReportPlaceholderFeedItem last) {
    Assert.assertEquals(128401167L, last.getCampaignId().longValue());
    Assert.assertEquals(7788826287L, last.getAdGroupId().longValue());
    Assert.assertEquals(421887, last.getFeedId().longValue());
    Assert.assertEquals(1785567, last.getFeedItemId().longValue());
    Assert.assertEquals(1, last.getFeedPlaceholderType());
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(last.getValuePerConversion1()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(last.getValuePerConversionMany()));
    Assert.assertEquals("Les Ecuries De Kerballan - Gommenech", last.getAccountDescriptiveName());
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(last.getCost()));
    Assert.assertEquals(0, last.getClicks().intValue());
    Assert.assertEquals(130, last.getImpressions().intValue());
    Assert.assertEquals(0, last.getConversions().intValue());
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(last.getCtr()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(last.getAvgCpm()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("0.0"), BigDecimalUtil.parseFromNumberString(last.getAvgCpc()));
    Assert.assertEquals(BigDecimalUtil.parseFromNumberString("2.8"), BigDecimalUtil.parseFromNumberString(last.getAvgPosition()));
    Assert.assertEquals("Sitelink", last.getClickType());
    Assert.assertEquals("Search Network", last.getAdNetwork());
  }

  @Override
  protected int retrieveCsvEntries() {
    return 10;
  }

  @Override
  protected String[] retrievePropertiesToBeSelected() {
    return new String[] {
        "ExternalCustomerId",
        "AccountDescriptiveName",
        "AccountTimeZoneId",
        "AdGroupId",
        "AdGroupName",
        "AdId",
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
        "Date",
        "Month",
        "AdNetworkType1",
        "AdNetworkType2",
        "Device",
        "ClickType",
        "ConversionValue",
        "ConversionRate",
        "ConversionRateManyPerClick",
        "CostPerConversion",
        "CostPerConversionManyPerClick",
        "CustomerDescriptiveName",
        "FeedId",
        "FeedItemId",
        "PlaceholderType",
        "PrimaryCompanyName",
        "TotalConvValue",
        "ValuePerConv",
        "ValuePerConvManyPerClick"};
  }
}
