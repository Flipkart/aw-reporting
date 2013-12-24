package com.google.api.ads.adwords.jaxws.extensions.report.model.csv;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAd;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.ModifiedCsvToBean;

import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;
import junit.framework.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * Test case for the {@link AnnotationBasedMappingStrategy}.
 */
public class AnnotationBasedMappingStrategyTest {

	/**
	 * Tests the basic parse logic of the {@code AnnotationBasedMappingStrategy}
	 * .
	 * 
	 * @throws FileNotFoundException
	 *             not handled, test should fail.
	 * @throws UnsupportedEncodingException
	 *             not handled, test should fail.
	 * 
	 */
	@Test
	public void testAnnotationMapping() throws UnsupportedEncodingException,
			FileNotFoundException {

		Locale.setDefault(Locale.US);

		CSVReader csvReader = new AwReportCsvReader(
				new InputStreamReader(new FileInputStream(
						"src/test/resources/csv/ad-performance.csv"), "UTF-8"),
				',', '\"', 1);

		AnnotationBasedMappingStrategy<ReportAd> mappingStrategy = new AnnotationBasedMappingStrategy<ReportAd>(
				ReportAd.class);

		ModifiedCsvToBean<ReportAd> csvToBean = new ModifiedCsvToBean<ReportAd>();
		List<ReportAd> parsedBeans = csvToBean
				.parse(mappingStrategy, csvReader);

		Assert.assertEquals(20, parsedBeans.size());

		ReportAd reportAd = parsedBeans.get(0);
		Assert.assertEquals(1001270004L, reportAd.getAccountId().longValue());
		Assert.assertEquals("2013-05-01", reportAd.getDay());
		Assert.assertEquals("9.39", reportAd.getCost());
		Assert.assertEquals(32L, reportAd.getClicks().longValue());
		Assert.assertEquals(1258L, reportAd.getImpressions().longValue());
		Assert.assertEquals(0L, reportAd.getConversions().longValue());
		Assert.assertEquals("2.54", reportAd.getCtr());
		Assert.assertEquals("7.46", reportAd.getAvgCpm());
		Assert.assertEquals("0.29", reportAd.getAvgCpc());
		Assert.assertEquals("2.12", reportAd.getAvgPosition());
		Assert.assertEquals(132958027L, reportAd.getCampaignId().longValue());
		Assert.assertEquals(6113972227L, reportAd.getAdGroupId().longValue());
		Assert.assertEquals(20549800987L, reportAd.getAdId().longValue());
		Assert.assertEquals("enabled", reportAd.getAdState());
		Assert.assertEquals("approved", reportAd.getCreativeApprovalStatus());

		reportAd = parsedBeans.get(19);
		Assert.assertEquals(1001270004L, reportAd.getAccountId().longValue());
		Assert.assertEquals("2013-05-10", reportAd.getDay());
		Assert.assertEquals("1.46", reportAd.getCost());
		Assert.assertEquals(2L, reportAd.getClicks().longValue());
		Assert.assertEquals(58L, reportAd.getImpressions().longValue());
		Assert.assertEquals(0L, reportAd.getConversions().longValue());
		Assert.assertEquals("3.45", reportAd.getCtr());
		Assert.assertEquals("25.17", reportAd.getAvgCpm());
		Assert.assertEquals("0.73", reportAd.getAvgCpc());
		Assert.assertEquals("3.29", reportAd.getAvgPosition());
		Assert.assertEquals(132958027L, reportAd.getCampaignId().longValue());
		Assert.assertEquals(6114146707L, reportAd.getAdGroupId().longValue());
		Assert.assertEquals(20551837747L, reportAd.getAdId().longValue());
		Assert.assertEquals("enabled", reportAd.getAdState());
		Assert.assertEquals("approved", reportAd.getCreativeApprovalStatus());

	}

	/**
	 * Tests the lazy parsing logic of the {@link ModifiedCsvToBean}.
	 * 
	 * @throws FileNotFoundException
	 *             not handled, test should fail.
	 * @throws UnsupportedEncodingException
	 *             not handled, test should fail.
	 * 
	 */
	@Test
	public void testLazyParsing() throws UnsupportedEncodingException,
			FileNotFoundException {

		Locale.setDefault(Locale.US);

		CSVReader csvReader = new AwReportCsvReader(
				new InputStreamReader(new FileInputStream(
						"src/test/resources/csv/ad-performance.csv"), "UTF-8"),
				',', '\"', 1);

		AnnotationBasedMappingStrategy<ReportAd> mappingStrategy = new AnnotationBasedMappingStrategy<ReportAd>(
				ReportAd.class);

		ModifiedCsvToBean<ReportAd> csvToBean = new ModifiedCsvToBean<ReportAd>();
		Iterator<ReportAd> parsedBeans = csvToBean.lazyParse(mappingStrategy,
				csvReader);

		int count = 0;

		ReportAd reportAd = parsedBeans.next();
		Assert.assertNotNull(reportAd);
		count++;

		Assert.assertEquals(1001270004L, reportAd.getAccountId().longValue());
		Assert.assertEquals("2013-05-01", reportAd.getDay());
		Assert.assertEquals("9.39", reportAd.getCost());
		Assert.assertEquals(32L, reportAd.getClicks().longValue());
		Assert.assertEquals(1258L, reportAd.getImpressions().longValue());
		Assert.assertEquals(0L, reportAd.getConversions().longValue());
		Assert.assertEquals("2.54", reportAd.getCtr());
		Assert.assertEquals("7.46", reportAd.getAvgCpm());
		Assert.assertEquals("0.29", reportAd.getAvgCpc());
		Assert.assertEquals("2.12", reportAd.getAvgPosition());
		Assert.assertEquals(132958027L, reportAd.getCampaignId().longValue());
		Assert.assertEquals(6113972227L, reportAd.getAdGroupId().longValue());
		Assert.assertEquals(20549800987L, reportAd.getAdId().longValue());
		Assert.assertEquals("enabled", reportAd.getAdState());
		Assert.assertEquals("approved", reportAd.getCreativeApprovalStatus());

		for (int i = 0; i < 18; i++) {
			reportAd = parsedBeans.next();
			Assert.assertNotNull(reportAd);
			count++;
		}

		reportAd = parsedBeans.next();
		Assert.assertNotNull(reportAd);
		count++;

		Assert.assertEquals(20, count);

		Assert.assertEquals(1001270004L, reportAd.getAccountId().longValue());
		Assert.assertEquals("2013-05-10", reportAd.getDay());
		Assert.assertEquals("1.46", reportAd.getCost());
		Assert.assertEquals(2L, reportAd.getClicks().longValue());
		Assert.assertEquals(58L, reportAd.getImpressions().longValue());
		Assert.assertEquals(0L, reportAd.getConversions().longValue());
		Assert.assertEquals("3.45", reportAd.getCtr());
		Assert.assertEquals("25.17", reportAd.getAvgCpm());
		Assert.assertEquals("0.73", reportAd.getAvgCpc());
		Assert.assertEquals("3.29", reportAd.getAvgPosition());
		Assert.assertEquals(132958027L, reportAd.getCampaignId().longValue());
		Assert.assertEquals(6114146707L, reportAd.getAdGroupId().longValue());
		Assert.assertEquals(20551837747L, reportAd.getAdId().longValue());
		Assert.assertEquals("enabled", reportAd.getAdState());
		Assert.assertEquals("approved", reportAd.getCreativeApprovalStatus());

		try {
			parsedBeans.next();
			Assert.fail("Iterator should be empty.");
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}

	}

}
