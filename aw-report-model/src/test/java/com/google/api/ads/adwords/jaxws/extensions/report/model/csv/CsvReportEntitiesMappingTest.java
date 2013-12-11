package com.google.api.ads.adwords.jaxws.extensions.report.model.csv;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAccount;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAd;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdExtension;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdGroup;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaign;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaignNegativeKeyword;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportKeyword;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Test case for the dynamic report bean class mapping.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class CsvReportEntitiesMappingTest {

  @Autowired
  private CsvReportEntitiesMapping csvReportEntitiesMapping;

  /**
   * Tests the mapping of the bean classes that was done in the context initialization.
   */
  @Test
  public void testProperReportBeanMapping() {

    this.assertBeanClassisCorrectForType(
        ReportAccount.class, ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT);

    this.assertBeanClassisCorrectForType(
        ReportCampaign.class, ReportDefinitionReportType.CAMPAIGN_PERFORMANCE_REPORT);

    this.assertBeanClassisCorrectForType(
        ReportAdGroup.class, ReportDefinitionReportType.ADGROUP_PERFORMANCE_REPORT);

    this.assertBeanClassisCorrectForType(
        ReportAd.class, ReportDefinitionReportType.AD_PERFORMANCE_REPORT);

    this.assertBeanClassisCorrectForType(
        ReportKeyword.class, ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT);

    this.assertBeanClassisCorrectForType(ReportCampaignNegativeKeyword.class,
        ReportDefinitionReportType.CAMPAIGN_NEGATIVE_KEYWORDS_PERFORMANCE_REPORT);

    this.assertBeanClassisCorrectForType(
        ReportAdExtension.class, ReportDefinitionReportType.AD_EXTENSIONS_PERFORMANCE_REPORT);

  }

  /**
   * Tests that the bean classes for the reports were properly found.
   */
  @Test
  public void testMappedReports() {

    Set<ReportDefinitionReportType> reports = this.csvReportEntitiesMapping.getDefinedReports();

    Assert.assertTrue(reports.contains(ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.CAMPAIGN_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.ADGROUP_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.AD_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT));
    Assert.assertTrue(
        reports.contains(ReportDefinitionReportType.CAMPAIGN_NEGATIVE_KEYWORDS_PERFORMANCE_REPORT));
    Assert.assertTrue(
        reports.contains(ReportDefinitionReportType.AD_EXTENSIONS_PERFORMANCE_REPORT));

  }

  /**
   * Tests that the properties to be selected are correctly mapped.
   */
  @Test
  public void testReportSelectionProperties() {

    List<String> propertiesToSelect = this.csvReportEntitiesMapping.retrievePropertiesToSelect(
        ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT);

    Assert.assertNotNull(propertiesToSelect);

    Assert.assertTrue(propertiesToSelect.contains("ExternalCustomerId"));
    Assert.assertTrue(propertiesToSelect.contains("AccountDescriptiveName"));
    Assert.assertTrue(propertiesToSelect.contains("Cost"));
    Assert.assertTrue(propertiesToSelect.contains("Clicks"));
    Assert.assertTrue(propertiesToSelect.contains("Impressions"));
    Assert.assertTrue(propertiesToSelect.contains("Conversions"));
    Assert.assertTrue(propertiesToSelect.contains("Ctr"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCpm"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCpc"));
    Assert.assertTrue(propertiesToSelect.contains("AveragePosition"));
    Assert.assertTrue(propertiesToSelect.contains("AccountCurrencyCode"));
    Assert.assertTrue(propertiesToSelect.contains("SearchBudgetLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("SearchRankLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("ContentBudgetLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("ContentRankLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("Date"));
    Assert.assertTrue(propertiesToSelect.contains("Month"));
    Assert.assertTrue(propertiesToSelect.contains("Device"));
    Assert.assertTrue(propertiesToSelect.contains("ClickType"));
    Assert.assertTrue(propertiesToSelect.contains("AdNetworkType1"));
    Assert.assertTrue(propertiesToSelect.contains("AdNetworkType2"));

    Assert.assertEquals(21, propertiesToSelect.size());
  }

  /**
   * Recovers the class from the mapping, and test against the proper bean class.
   *
   * @param reportBeanClass the correct bean class.
   * @param type the report type
   */
  private void assertBeanClassisCorrectForType(
      Class<? extends Report> reportBeanClass, ReportDefinitionReportType type) {

    Class<? extends Report> mappedBeanClass =
        this.csvReportEntitiesMapping.getReportBeanClass(type);
    Assert.assertEquals(reportBeanClass, mappedBeanClass);
  }
}
