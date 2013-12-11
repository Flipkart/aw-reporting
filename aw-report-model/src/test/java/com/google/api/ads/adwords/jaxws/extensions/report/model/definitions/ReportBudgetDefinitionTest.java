package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportBudget;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the Budget Performance report definition.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-model-test-beans.xml")
public class ReportBudgetDefinitionTest extends AbstractReportDefinitionTest<ReportBudget> {

  /**
   * C'tor
   */
  public ReportBudgetDefinitionTest() {
    super(ReportBudget.class, ReportDefinitionReportType.BUDGET_PERFORMANCE_REPORT,
        "src/test/resources/csv/budget.csv");
  }

  /**
   * @return the properties for the Budget Performance report.
   */
  @Override
  protected String[] retrievePropertiesToBeSelected() {
    return new String[] {
        // Inherit from Report
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
        "Date",
        "Month",
        "Device",
        "ClickType",
        "AdNetworkType1",
        "AdNetworkType2",
        // Specific to ReportBudget
        "Amount",
        "BudgetId",
        "BudgetName",
        "BudgetStatus",
        "BudgetReferenceCount",
        "IsBudgetExplicitlyShared",
        "Period"
    };
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testFirstEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testFirstEntry(ReportBudget first) {
    Assert.assertEquals("4.37", first.getAmount());
    Assert.assertEquals(963487963L, first.getBudgetId().longValue());
    Assert.assertEquals("Xvg", first.getBudgetName());
    Assert.assertEquals("Active", first.getBudgetStatus());
    Assert.assertEquals(1L, first.getBudgetReferenceCount().longValue());
    Assert.assertEquals(false, first.isBudgetExplicitlyShared());
    Assert.assertEquals("day", first.getPeriod());
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #testLastEntry(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  protected void testLastEntry(ReportBudget last) {
    Assert.assertEquals("1.00", last.getAmount());
    Assert.assertEquals(323491323L, last.getBudgetId().longValue());
    Assert.assertEquals("Zngevk", last.getBudgetName());
    Assert.assertEquals("Deleted", last.getBudgetStatus());
    Assert.assertEquals(0L, last.getBudgetReferenceCount().longValue());
    Assert.assertEquals(false, last.isBudgetExplicitlyShared());
    Assert.assertEquals("day", last.getPeriod());
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.AbstractReportDefinitionTest
   *      #retrieveCsvEntries()
   */
  @Override
  protected int retrieveCsvEntries() {
    return 29;
  }
}
