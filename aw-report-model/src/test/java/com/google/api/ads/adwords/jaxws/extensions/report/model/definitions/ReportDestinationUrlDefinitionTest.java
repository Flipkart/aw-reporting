package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportDestinationUrl;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

/**
 * Tests the Ad Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportDestinationUrlDefinitionTest extends AbstractReportDefinitionTest<ReportDestinationUrl> {

  /**
   * C'tor
   */
  public ReportDestinationUrlDefinitionTest() {
    super(ReportDestinationUrl.class, ReportDefinitionReportType.DESTINATION_URL_REPORT,
        "src/test/resources/csv/destination-url.csv");
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportDestinationUrl row) {

	  Assert.assertEquals("(GMT+01:00) Paris", row.getAccountTimeZoneId());
	  Assert.assertEquals(3448007340L, row.getAdGroupId().longValue());
	  Assert.assertEquals("Ad Group #1", row.getAdGroupName());
	  Assert.assertEquals("enabled", row.getAdGroupStatus());
	  Assert.assertEquals(84058260L , row.getCampaignId().longValue());
	  Assert.assertEquals("CAMPAGNE", row.getCampaignName());
	  Assert.assertEquals("active", row.getCampaignStatus());
	  Assert.assertEquals("0.00", row.getConversionRate());
	  Assert.assertEquals("0.00", row.getConversionRateManyPerClick());
	  Assert.assertEquals(0L, row.getConversionsManyPerClick().longValue());
	  Assert.assertEquals(null, row.getConversionValue());
	  Assert.assertEquals("0.00", row.getCostPerConversion());
	  Assert.assertEquals("0.00", row.getCostPerConversionManyPerClick());
	  Assert.assertEquals("" , row.getCriteriaDestinationUrl());
	  Assert.assertEquals("+immo +benodet", row.getCriteriaParameters());
	  Assert.assertEquals("enabled", row.getCriteriaStatus());
	  Assert.assertEquals("Broad", row.getCriteriaTypeName());
	  Assert.assertEquals("Era Rouxelimmo - Plomelin", row.getCustomerDescriptiveName());
	  Assert.assertEquals("Sunday", row.getDayOfWeek());
	  Assert.assertEquals("http://www.era-immobilier-plomelin.fr", row.getEffectiveDestinationUrl());
	  Assert.assertEquals("false" , row.getIsNegative());
	  Assert.assertEquals("September" , row.getMonthOfYear());
	  Assert.assertEquals("", row.getPrimaryCompanyName());
	  Assert.assertEquals("", row.getPrimaryUserLogin());
	  Assert.assertEquals("2013-07-01", row.getQuarter());
	  Assert.assertEquals("0.00" , row.getTotalConvValue());

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportDestinationUrl row) {


	  
	  Assert.assertEquals("(GMT+01:00) Paris", row.getAccountTimeZoneId());
	  Assert.assertEquals(5827855980L, row.getAdGroupId().longValue());
	  Assert.assertEquals("Ad Group #1", row.getAdGroupName());
	  Assert.assertEquals("enabled", row.getAdGroupStatus());
	  Assert.assertEquals(118203540L , row.getCampaignId().longValue());
	  Assert.assertEquals("DISPLAY", row.getCampaignName());
	  Assert.assertEquals("active", row.getCampaignStatus());
	  Assert.assertEquals("0.00", row.getConversionRate());
	  Assert.assertEquals("0.00", row.getConversionRateManyPerClick());
	  Assert.assertEquals(0L, row.getConversionsManyPerClick().longValue());
	  Assert.assertEquals(null, row.getConversionValue());
	  Assert.assertEquals("0.00", row.getCostPerConversion());
	  Assert.assertEquals("0.00", row.getCostPerConversionManyPerClick());
	  Assert.assertEquals("" , row.getCriteriaDestinationUrl());
	  Assert.assertEquals("Content", row.getCriteriaParameters());
	  Assert.assertEquals("enabled", row.getCriteriaStatus());
	  Assert.assertEquals("Broad", row.getCriteriaTypeName());
	  Assert.assertEquals("Era Rouxelimmo - Plomelin", row.getCustomerDescriptiveName());
	  Assert.assertEquals("Sunday", row.getDayOfWeek());
	  Assert.assertEquals("http://www.era-immobilier-plomelin.fr", row.getEffectiveDestinationUrl());
	  Assert.assertEquals("false" , row.getIsNegative());
	  Assert.assertEquals("September" , row.getMonthOfYear());
	  Assert.assertEquals("", row.getPrimaryCompanyName());
	  Assert.assertEquals("", row.getPrimaryUserLogin());
	  Assert.assertEquals("2013-07-01", row.getQuarter());
	  Assert.assertEquals("0.00" , row.getTotalConvValue());

	  Assert.assertEquals(true, true);

/*    Assert.assertEquals(1001270004L, last.getAccountId().longValue());
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
    Assert.assertEquals("approved", last.getCreativeApprovalStatus());*/

  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {
    return 96;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrievePropertiesToBeSelected()
   */
  @Override
  protected String[] retrievePropertiesToBeSelected() {

    return new String[] {
    		"AccountTimeZoneId",
    		"AdGroupId",
    		"AdGroupName",
    		"AdGroupStatus",
    		"CampaignId",
    		"CampaignName",
    		"CampaignStatus",
    		"ConversionRate",
    		"ConversionRateManyPerClick",
    		"ConversionsManyPerClick",
    		"ConversionValue",
    		"CostPerConversion",
    		"CostPerConversionManyPerClick",
    		"CriteriaDestinationUrl",
    		"CriteriaParameters",
    		"CriteriaStatus",
    		"CriteriaTypeName",
    		"CustomerDescriptiveName",
    		"DayOfWeek",
    		"EffectiveDestinationUrl",
    		"IsNegative",
    		"MonthOfYear",
    		"PrimaryCompanyName",
    		"PrimaryUserLogin",
    		"Quarter",
    		"TotalConvValue",
    		"ValuePerConv",
    		"ValuePerConversion",
    		"ValuePerConversionManyPerClick",
    		"ValuePerConvManyPerClick",
    		"ViewThroughConversions",
    		"Week",
    		"Year",
    		"ExternalCustomerId",
    		"Date",
    		"Month",
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
    		"Device",
    		"ClickType",
    		"AdNetworkType1",
    		"AdNetworkType2"};
  }
}