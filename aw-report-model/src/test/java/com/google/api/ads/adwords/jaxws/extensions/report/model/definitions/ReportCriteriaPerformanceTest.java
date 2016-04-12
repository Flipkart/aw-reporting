package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCriteriaPerformance;
import com.google.api.ads.adwords.lib.jaxb.v201509.ReportDefinitionReportType;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Campaign Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportCriteriaPerformanceTest extends
		AbstractReportDefinitionTest<ReportCriteriaPerformance> {

	/**
	 * C'tor
	 */
	public ReportCriteriaPerformanceTest() {

		super(ReportCriteriaPerformance.class,
				ReportDefinitionReportType.CRITERIA_PERFORMANCE_REPORT,
				"src/test/resources/csv/criteria.csv");
	}

	/**
	 * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
	 *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
	 */
	@Override
	protected void testFirstEntry(ReportCriteriaPerformance first) {

		// Assert.assertEquals(1252422563L, first.getAccountId().longValue());
		// TODO
	}

	/**
	 * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
	 *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
	 */
	@Override
	protected void testLastEntry(ReportCriteriaPerformance last) {
		// Assert.assertEquals(1252422563L, last.getAccountId().longValue());
		// TODO
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

		return new String[] { "AdGroupId",
				"AdvertiserExperimentSegmentationBin", "ApprovalStatus",
				"BidModifier", "CampaignId", "ClickSignificance",
				"ConversionManyPerClickSignificance",
				"ConversionRateManyPerClickSignificance",
				"ClickConversionRateSignificance", "ConvertedClicksSignificance",
				"ConversionValue",
				"CostPerConversionManyPerClickSignificance",
				"CostPerConvertedClickSignificance", "CostSignificance",
				"CpcBidSource", "CpcSignificance", "CpmSignificance",
				"Criteria", "CriteriaDestinationUrl", "CriteriaType",
				"CtrSignificance", "CustomerDescriptiveName", "DisplayName",
				"FirstPageCpc", "Id", "ImpressionSignificance", "IsNegative",
				"CpcBid", "CpmBid", "Parameter", "PercentCpa",
				"PositionSignificance", "QualityScore", "Slot", "Status",
				"TopOfPageCpc", "ViewThroughConversions",
				"ViewThroughConversionsSignificance", "ExternalCustomerId",
				"Date", "AccountDescriptiveName", "Cost", "Clicks",
				"Impressions", "ConvertedClicks", "Ctr", "AverageCpm",
				"AverageCpc", "AveragePosition", "AccountCurrencyCode",
				"Device", "ClickType", "AdNetworkType1", "AdNetworkType2" };
	}
}