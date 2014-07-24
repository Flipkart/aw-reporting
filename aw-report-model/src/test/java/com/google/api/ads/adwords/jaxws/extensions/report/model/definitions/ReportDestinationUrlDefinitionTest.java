package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportDestinationUrl;
import com.google.api.ads.adwords.lib.jaxb.v201402.ReportDefinitionReportType;

/**
 * Tests the Ad Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportDestinationUrlDefinitionTest extends
		AbstractReportDefinitionTest<ReportDestinationUrl> {

	/**
	 * C'tor
	 */
	public ReportDestinationUrlDefinitionTest() {
		super(ReportDestinationUrl.class,
				ReportDefinitionReportType.DESTINATION_URL_REPORT,
				"src/test/resources/csv/destination-url.csv");
	}

	/**
	 * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
	 *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
	 */
	@Override
	protected void testFirstEntry(ReportDestinationUrl row) {

		Assert.assertEquals(3448007340L, row.getAdGroupId().longValue());
		Assert.assertEquals(84058260L, row.getCampaignId().longValue());
		Assert.assertEquals(0L, row.getConversionsManyPerClick().longValue());
		Assert.assertEquals(null, row.getConversionValue());
		Assert.assertEquals("", row.getCriteriaDestinationUrl());
		Assert.assertEquals("+immo +benodet", row.getCriteriaParameters());
		Assert.assertEquals("Broad", row.getCriteriaTypeName());
		Assert.assertEquals("http://www.era-immobilier-plomelin.fr",
				row.getEffectiveDestinationUrl());
		Assert.assertEquals("false", row.getIsNegative());
	}

	/**
	 * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
	 *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
	 */
	@Override
	protected void testLastEntry(ReportDestinationUrl row) {

		Assert.assertEquals(5827855980L, row.getAdGroupId().longValue());
		Assert.assertEquals(118203540L, row.getCampaignId().longValue());
		Assert.assertEquals(0L, row.getConversionsManyPerClick().longValue());
		Assert.assertEquals(null, row.getConversionValue());
		Assert.assertEquals("", row.getCriteriaDestinationUrl());
		Assert.assertEquals("Content", row.getCriteriaParameters());
		Assert.assertEquals("Broad", row.getCriteriaTypeName());
		Assert.assertEquals("http://www.era-immobilier-plomelin.fr",
				row.getEffectiveDestinationUrl());
		Assert.assertEquals("false", row.getIsNegative());

		Assert.assertEquals(true, true);

		/*
		 * Assert.assertEquals(1001270004L, last.getAccountId().longValue());
		 * Assert.assertEquals("2013-05-10", last.getDay());
		 * Assert.assertEquals("1.46", last.getCost()); Assert.assertEquals(2L,
		 * last.getClicks().longValue()); Assert.assertEquals(58L,
		 * last.getImpressions().longValue()); Assert.assertEquals(0L,
		 * last.getConversions().longValue()); Assert.assertEquals("3.45",
		 * last.getCtr()); Assert.assertEquals("25.17", last.getAvgCpm());
		 * Assert.assertEquals("0.73", last.getAvgCpc());
		 * Assert.assertEquals("3.29", last.getAvgPosition());
		 * Assert.assertEquals("EUR", last.getCurrencyCode());
		 * 
		 * Assert.assertEquals(132958027L, last.getCampaignId().longValue());
		 * Assert.assertEquals(6114146707L, last.getAdGroupId().longValue());
		 * Assert.assertEquals(20551837747L, last.getAdId().longValue());
		 * Assert.assertEquals("enabled", last.getAdState());
		 * Assert.assertEquals("approved", last.getCreativeApprovalStatus());
		 */

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

		return new String[] { "AdGroupId", "CampaignId",
				"ConversionsManyPerClick", "ConversionValue",
				"CriteriaDestinationUrl", "CriteriaParameters",
				"EffectiveDestinationUrl", "IsNegative",
				"ViewThroughConversions", "Date", "Cost", "Clicks",
				"Impressions", "Conversions", "Ctr", "AverageCpm",
				"AverageCpc", "AveragePosition", "Device", "ClickType",
				"AdNetworkType1", "AdNetworkType2" };
	}
}