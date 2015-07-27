//Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.jaxws.extensions.kratu.data;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAccount;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAd;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdGroup;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaign;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaignNegativeKeyword;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportKeyword;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.DateUtil;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kratu
 * 
 * @author jtoledo@google.com (Julian Toledo)
 */
@Entity
@Table(name = "AW_Kratu")
@org.hibernate.annotations.Table(appliesTo = "AW_Kratu", indexes = {
    @org.hibernate.annotations.Index(name = "ID-DAY", columnNames = {"EXTERNAL_CUSTOMER_ID", "DAY"})})
public class Kratu {

  protected static final String _topAccountId = "topAccountId";
  protected static final String _externalCustomerId = "externalCustomerId";
  protected static final String _day = "day";
  protected static final String DISPLAY_NETWORK = "Display Network";
  protected static final String SEARCH_NETWORK = "Search Network";
  protected static final String ACTIVE = "active";
  protected static final String DELETED = "deleted";
  protected static final String ENABLE = "enabled";
  protected static final String BROAD = "Broad";
  protected static final String PHRASE = "Phrase";
  protected static final String EXACT = "Exact";
  protected static final String DISAPPROVED = "disapproved";
  protected static final String ELIGIBLE = "eligible";
  protected static final String LOCATION_EXTENSION = "location extension";
  protected static final String MOBILE_EXTENSION = "mobile extension";
  protected static final String SITE_LINKS_EXTENSION = "site links extension";

  @Id
  @Column(name = "ID")
  protected String _id;

  @Column(name = "EXTERNAL_CUSTOMER_ID")
  protected Long externalCustomerId;
  
  @Column(name = "TOP_ACCOUNT_ID")
  protected Long topAccountId;
  
  @Column(name = "ACCOUNT_NAME")
  protected String accountName;
  
  @Column(name = "CURRENCY_CODE")
  protected String currencyCode;
  
  @Column(name = "DATE_TIME_ZONE")
  protected String dateTimeZone;
  
  @Column(name = "ACCOUNT_ACIVE")
  protected String accountActive = "No";

  @Column(name = "TOTAL_CLICKS_SEARCH")
  protected Long totalClicksSearch = 0l;
  
  @Column(name = "IMPRESSIONS_SEARCH")
  protected Long impressionsSearch = 0l;
  
  @Column(name = "CTR_SEARCH")
  protected BigDecimal ctrSearch = new BigDecimal(0);
  
  @Column(name = "AVERAGE_CPC_SEARCH")
  protected BigDecimal averageCpcSearch = new BigDecimal(0);
  
  @Column(name = "AVERAGE_CPM_SEARCH")
  protected BigDecimal averageCpmSearch = new BigDecimal(0);
  
  @Column(name = "AVERAGE_POSITION_SEARCH")
  protected BigDecimal averagePositionSearch = new BigDecimal(0);
  
  @Column(name = "TOTAL_CLICKS_DISPLAY")
  protected Long totalClicksDisplay = 0l;
  
  @Column(name = "IMPRESSIONS_DISPLAY")
  protected Long impressionsDisplay = 0l;
  
  @Column(name = "CTR_DISPLAY")
  protected BigDecimal ctrDisplay = new BigDecimal(0);
  
  @Column(name = "AVERAGE_CPC_DISPLAY")
  protected BigDecimal averageCpcDisplay = new BigDecimal(0);
  
  @Column(name = "AVERAGE_CPM_DISPLAY")
  protected BigDecimal averageCpmDisplay = new BigDecimal(0);
  
  @Column(name = "AVERAGE_POSITION_DISPLAY")
  protected BigDecimal averagePositionDisplay = new BigDecimal(0);
  
  @Column(name = "DAY")
  protected Date day;
  
  @Column(name = "SPEND")
  protected BigDecimal spend = new BigDecimal(0);
  
  @Column(name = "CONVERSIONS")
  protected Long conversions = 0l;
  
  @Column(name = "LOST_IMPRESSIONS_DUE_TO_BUDGET_SEARCH")
  protected BigDecimal lostImpressionsDueToBudgetSearch = new BigDecimal(0);
  
  @Column(name = "LOST_IMPRESSIONS_DUE_TO_BID_RANK_SEARCH")
  protected BigDecimal lostImpressionsDueToBidAdRankSearch = new BigDecimal(0);
  
  @Column(name = "LOST_IMPRESSIONS_DUE_TO_BUDGET_DISPLAY")
  protected BigDecimal lostImpressionsDueToBudgetDisplay = new BigDecimal(0);
  
  @Column(name = "LOST_IMPRESSIONS_DUE_TO_BID_RANK_DISPLAY")
  protected BigDecimal lostImpressionsDueToBidAdRankDisplay = new BigDecimal(0);

  
  @Column(name = "NUMBER_OF_ACTIVE_CAMPAINGS")
  protected BigDecimal numberOfActiveCampaigns = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_ADGROUPS")
  protected BigDecimal numberOfActiveAdGroups = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_ADS")
  protected BigDecimal numberOfActiveAds = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_POSITIVE_ACTIVE_KEYWORDS")
  protected BigDecimal numberOfPositiveActiveKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_BROAD_MATCHING_KEYWORDS")
  protected BigDecimal numberOfActiveBroadMatchingKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_PHRASE_MATCHING_KEYWORDS")
  protected BigDecimal numberOfActivePhraseMatchingKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_EXACT_MATCHING_KEYWORDS")
  protected BigDecimal numberOfActiveExactMatchingKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_NEGATIVE_ACTIVE_KEYWORDS")
  protected BigDecimal numberOfNegativeActiveKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_CAMPAIGN_NEGATIVE_ACTIVE_KEYWORDS")
  protected BigDecimal numberOfCampaignNegativeActiveKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ADGROUP_NEGATIVE_ACTIVE_KEYWORDS")
  protected BigDecimal numberOfAdGroupNegativeActiveKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_GOOD_QUALITY_SCORE_KEYWORDS")
  protected BigDecimal numberOfActiveGoodQualityScoreKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_AVERAGE_QUALITY_SCORE_KEYWORDS")
  protected BigDecimal numberOfActiveAverageQualityScoreKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ACTIVE_POOR_QUALITY_SCORE_KEYWORDS")
  protected BigDecimal numberOfActivePoorQualityScoreKeywords = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_CAMPAIGNS_WITH_CALL_EXTENSIONS_ENABLE")
  protected BigDecimal numberOfCampaignsWithCallExtensionEnabled = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_CAMPAIGNS_WITH_LOCATION_EXTENSIONS_ENABLE")
  protected BigDecimal numberOfCampaignsWithLocationExtensionEnabled = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_CAMPAIGNS_WITH_SITELINKS_ENABLE")
  protected BigDecimal numberOfCampaignsWithSiteLinksEnabled = new BigDecimal(0);
  
  @Column(name = "WEIHTED_AVERAGE_KEYWORD_POSITION")
  protected BigDecimal weightedAverageKeywordPosition = new BigDecimal(0);
  
  @Column(name = "WEIHTED_AVERAGE_QUALITY_SCORE")
  protected BigDecimal weightedAverageQualityScore = new BigDecimal(0);
  
  @Column(name = "SUM_BUDGET")
  protected BigDecimal sumBudget = new BigDecimal(0);
  
  @Column(name = "ACCOUNT_SUSPENDED")
  protected Boolean accountSuspended = false;
  
  @Column(name = "NUMBER_OF_ADGROUPS_WITH_ONE_ACTIVE_AD")
  protected BigDecimal numberOfAdgroupsWithoneActiveAd = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_ADGROUPS_WITH_TWO_ACTIVE_AD")
  protected BigDecimal numberOfAdgroupsWithTwoActiveAds = new BigDecimal(0);
  
  @Column(name = "NUMBER_OF_DISAPPROVED_ADS")
  protected BigDecimal numberOfDisapprovedAds = new BigDecimal(0);

  /**
   * C'tor to satisfy Hibernate.
   */
  private Kratu() {
  }

  // Creates a Kratu, summarizing for a DateRange and for the same externalCustomerId.
  // Each item on the list is one Day.
  protected static Kratu createKratuSummary(List<Kratu> dailyKratus, Date startDate, Date endDate) {

    Kratu summarizedKratu = new Kratu();

    BigDecimal daysInRange = new BigDecimal(Days.daysBetween(new DateTime(startDate.getTime()), new DateTime(endDate.getTime())).getDays()).add(new BigDecimal(1));

    if (dailyKratus != null && dailyKratus.size() > 0) {
      summarizedKratu.topAccountId = dailyKratus.get(0).topAccountId;
      summarizedKratu.accountName = dailyKratus.get(0).accountName;
      summarizedKratu.externalCustomerId = dailyKratus.get(0).externalCustomerId;
      summarizedKratu.currencyCode = dailyKratus.get(0).currencyCode;
      summarizedKratu.dateTimeZone = dailyKratus.get(0).dateTimeZone;
      summarizedKratu.accountSuspended = dailyKratus.get(0).accountSuspended;
    }

    for (Kratu dailyKratu : dailyKratus) {      
      summarizedKratu.spend = summarizedKratu.spend.add(dailyKratu.spend);
      summarizedKratu.spend = summarizedKratu.spend.setScale(2, RoundingMode.HALF_UP);
      summarizedKratu.conversions += dailyKratu.conversions;

      summarizedKratu.totalClicksSearch += dailyKratu.totalClicksSearch;
      summarizedKratu.impressionsSearch += dailyKratu.impressionsSearch;
      summarizedKratu.lostImpressionsDueToBudgetSearch = summarizedKratu.lostImpressionsDueToBudgetSearch.add(dailyKratu.lostImpressionsDueToBudgetSearch);
      summarizedKratu.lostImpressionsDueToBidAdRankSearch = summarizedKratu.lostImpressionsDueToBidAdRankSearch.add(dailyKratu.lostImpressionsDueToBidAdRankSearch);
      summarizedKratu.ctrSearch = summarizedKratu.ctrSearch.add(dailyKratu.ctrSearch.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.averageCpcSearch = summarizedKratu.averageCpcSearch.add(dailyKratu.ctrSearch.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.averageCpmSearch = summarizedKratu.averageCpmSearch.add(dailyKratu.averageCpmSearch.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.averagePositionSearch = summarizedKratu.averagePositionSearch.add(dailyKratu.averagePositionSearch.divide(daysInRange, 2, RoundingMode.HALF_UP));

      summarizedKratu.totalClicksDisplay += dailyKratu.totalClicksDisplay;
      summarizedKratu.impressionsDisplay += dailyKratu.impressionsDisplay;
      summarizedKratu.lostImpressionsDueToBudgetDisplay = summarizedKratu.lostImpressionsDueToBudgetDisplay.add(dailyKratu.lostImpressionsDueToBudgetDisplay);
      summarizedKratu.lostImpressionsDueToBidAdRankDisplay = summarizedKratu.lostImpressionsDueToBidAdRankDisplay.add(dailyKratu.lostImpressionsDueToBidAdRankDisplay);
      summarizedKratu.ctrDisplay = summarizedKratu.ctrDisplay.add(dailyKratu.ctrDisplay.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.averageCpcDisplay = summarizedKratu.averageCpcDisplay.add(dailyKratu.averageCpcDisplay.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.averageCpmDisplay = summarizedKratu.averageCpmDisplay.add(dailyKratu.averageCpmDisplay.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.averagePositionDisplay = summarizedKratu.averagePositionDisplay.add(dailyKratu.averagePositionDisplay.divide(daysInRange, 2, RoundingMode.HALF_UP));

      summarizedKratu.numberOfActiveCampaigns = summarizedKratu.numberOfActiveCampaigns.add(dailyKratu.numberOfActiveCampaigns.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActiveAdGroups = summarizedKratu.numberOfActiveAdGroups.add(dailyKratu.numberOfActiveAdGroups.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActiveAds = summarizedKratu.numberOfActiveAds.add(dailyKratu.numberOfActiveAds.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfPositiveActiveKeywords = summarizedKratu.numberOfPositiveActiveKeywords.add(dailyKratu.numberOfPositiveActiveKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      
      summarizedKratu.numberOfActiveBroadMatchingKeywords = summarizedKratu.numberOfActiveBroadMatchingKeywords.add(dailyKratu.numberOfActiveBroadMatchingKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActivePhraseMatchingKeywords = summarizedKratu.numberOfActivePhraseMatchingKeywords.add(dailyKratu.numberOfActivePhraseMatchingKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActiveExactMatchingKeywords = summarizedKratu.numberOfActivePhraseMatchingKeywords.add(dailyKratu.numberOfActivePhraseMatchingKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      
      summarizedKratu.numberOfNegativeActiveKeywords = summarizedKratu.numberOfNegativeActiveKeywords.add(dailyKratu.numberOfNegativeActiveKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfCampaignNegativeActiveKeywords = summarizedKratu.numberOfNegativeActiveKeywords.add(dailyKratu.numberOfNegativeActiveKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfAdGroupNegativeActiveKeywords = summarizedKratu.numberOfAdGroupNegativeActiveKeywords.add(dailyKratu.numberOfAdGroupNegativeActiveKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActiveGoodQualityScoreKeywords = summarizedKratu.numberOfActiveGoodQualityScoreKeywords.add(dailyKratu.numberOfActiveGoodQualityScoreKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActiveAverageQualityScoreKeywords = summarizedKratu.numberOfActiveAverageQualityScoreKeywords.add(dailyKratu.numberOfActiveAverageQualityScoreKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfActivePoorQualityScoreKeywords = summarizedKratu.numberOfActivePoorQualityScoreKeywords.add(dailyKratu.numberOfActivePoorQualityScoreKeywords.divide(daysInRange, 2, RoundingMode.HALF_UP));
     
      summarizedKratu.numberOfCampaignsWithCallExtensionEnabled = summarizedKratu.numberOfCampaignsWithCallExtensionEnabled.add(dailyKratu.numberOfCampaignsWithCallExtensionEnabled.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfCampaignsWithLocationExtensionEnabled = summarizedKratu.numberOfCampaignsWithLocationExtensionEnabled.add(dailyKratu.numberOfCampaignsWithLocationExtensionEnabled.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfCampaignsWithSiteLinksEnabled = summarizedKratu.numberOfCampaignsWithSiteLinksEnabled.add(dailyKratu.numberOfCampaignsWithSiteLinksEnabled.divide(daysInRange, 2, RoundingMode.HALF_UP));
      
      summarizedKratu.numberOfAdgroupsWithoneActiveAd = summarizedKratu.numberOfAdgroupsWithoneActiveAd.add(dailyKratu.numberOfAdgroupsWithoneActiveAd.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfAdgroupsWithTwoActiveAds = summarizedKratu.numberOfAdgroupsWithTwoActiveAds.add(dailyKratu.numberOfAdgroupsWithTwoActiveAds.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.numberOfDisapprovedAds = summarizedKratu.numberOfDisapprovedAds.add(dailyKratu.numberOfDisapprovedAds.divide(daysInRange, 2, RoundingMode.HALF_UP));

      summarizedKratu.weightedAverageKeywordPosition = summarizedKratu.weightedAverageKeywordPosition.add(dailyKratu.weightedAverageKeywordPosition.divide(daysInRange, 2, RoundingMode.HALF_UP));
      summarizedKratu.weightedAverageQualityScore = summarizedKratu.weightedAverageQualityScore.add(dailyKratu.weightedAverageQualityScore.divide(daysInRange, 2, RoundingMode.HALF_UP));
      
      summarizedKratu.sumBudget = summarizedKratu.sumBudget.add(dailyKratu.sumBudget);
      System.out.print(".");
    }
    if (summarizedKratu.impressionsDisplay + summarizedKratu.impressionsSearch > 0) {
      summarizedKratu.accountActive = "Yes"; 
    }
    
    return summarizedKratu;
  }

  protected static Kratu createDailyKratuFromDB(
      StorageHelper storageHelper,
      Long topAccountId,
      Account account,
      Date day) {
    
    Long accountId = account.getExternalCustomerId();
    
    List<ReportAccount> reportAccountList = storageHelper.getReportByAccountId(ReportAccount.class, accountId, day, day);
    
    if (reportAccountList.size() == 0) {
      return null;
    } else {

      Kratu kratu = new Kratu();
      kratu.topAccountId = topAccountId;
      kratu.externalCustomerId = account.getExternalCustomerId();
      kratu.accountName = account.getName();
      kratu.currencyCode = account.getCurrencyCode();
      kratu.dateTimeZone = account.getDateTimeZone();
      kratu.day = day;
      kratu._id = accountId + "-" + DateUtil.formatYearMonthDayNoDash(day);
      //kratu.accountName = reportAccountList.get(0).getAccountDescriptiveName();
      kratu.spend = new BigDecimal(0);

      List<ReportCampaign> reportCampaignList = storageHelper.getReportByAccountId(ReportCampaign.class, accountId, day, day);
      List<ReportAdGroup> reportAdGroupList = storageHelper.getReportByAccountId(ReportAdGroup.class, accountId, day, day);
      List<ReportAd> reportAdList = storageHelper.getReportByAccountId(ReportAd.class, accountId, day, day);
      List<ReportKeyword> reportKeywordList = storageHelper.getReportByAccountId(ReportKeyword.class, accountId, day, day);

      List<ReportCampaignNegativeKeyword> reportCampaignNegativeKeywordList =
          storageHelper.getReportCampaignNegativeKeywordByAccountAndEndDateInRange(accountId, day, day);

      for (ReportAccount reportAccount : reportAccountList) {
        // Search
        if (reportAccount.getAdNetwork() != null
            && reportAccount.getAdNetwork().equals(SEARCH_NETWORK)) {
          kratu.spend = kratu.spend.add(reportAccount.getCostBigDecimal());
          kratu.conversions += reportAccount.getConversions();
          kratu.totalClicksSearch = reportAccount.getClicks();
          kratu.impressionsSearch = reportAccount.getImpressions();
          kratu.lostImpressionsDueToBudgetSearch = reportAccount.getSearchLostISBudgetBigDecimal();
          kratu.lostImpressionsDueToBidAdRankSearch = reportAccount.getSearchLostISRankBigDecimal();
          kratu.ctrSearch = reportAccount.getCtrBigDecimal();
          kratu.averageCpcSearch = reportAccount.getAvgCpcBigDecimal();
          kratu.averageCpmSearch = reportAccount.getAvgCpmBigDecimal();
          kratu.averagePositionSearch = reportAccount.getAvgPositionBigDecimal();
        }
        // Display
        if (reportAccount.getAdNetwork() != null
            && reportAccount.getAdNetwork().equals(DISPLAY_NETWORK)) {
          kratu.spend = kratu.spend.add(reportAccount.getCostBigDecimal());
          kratu.conversions += reportAccount.getConversions();
          kratu.totalClicksDisplay = reportAccount.getClicks();
          kratu.impressionsDisplay = reportAccount.getImpressions();
          kratu.lostImpressionsDueToBudgetDisplay = reportAccount.getContentLostISBudgetBigDecimal();
          kratu.lostImpressionsDueToBidAdRankDisplay = reportAccount.getContentLostISRankBigDecimal();
          kratu.ctrDisplay = reportAccount.getCtrBigDecimal();
          kratu.averageCpcDisplay = reportAccount.getAvgCpcBigDecimal();
          kratu.averageCpmDisplay = reportAccount.getAvgCpmBigDecimal();
          kratu.averagePositionDisplay = reportAccount.getAvgPositionBigDecimal();
        }
      }
      reportAccountList = null;

      if (kratu.impressionsDisplay + kratu.impressionsSearch > 0) {
        kratu.accountActive = "Yes"; 
      }

      // Process Campaigns
      for (ReportCampaign reportCampaign : reportCampaignList) {
        if (reportCampaign.getStatus().equals(ACTIVE)) {
          kratu.numberOfActiveCampaigns = kratu.numberOfActiveCampaigns.add(new BigDecimal(1));
        }

        if (reportCampaign.getBudgetBigDecimal() != null) {
          kratu.sumBudget = kratu.sumBudget.add(reportCampaign.getBudgetBigDecimal());
        }
      }
      reportCampaignList = null;

      // Process AdGroups
      for (ReportAdGroup reportAdGroup : reportAdGroupList) {
        if (reportAdGroup.getStatus().equals(ENABLE)) {
          kratu.numberOfActiveAdGroups = kratu.numberOfActiveAdGroups.add(new BigDecimal(1));
        }
      }
      reportAdGroupList = null;
      
      // Process Ads
      Map<Long, Integer> activeAdsPerAdGroup = new HashMap<Long, Integer>();
      for (ReportAd reportAd : reportAdList) {
        if (reportAd.getAdState().equals(ENABLE)) {
          kratu.numberOfActiveAds = kratu.numberOfActiveAds.add(new BigDecimal(1));
          // Adding activeAdsPerAdGroup
          if (activeAdsPerAdGroup.containsKey(reportAd.getAdGroupId())) {
            activeAdsPerAdGroup.put(reportAd.getAdGroupId(),
                activeAdsPerAdGroup.get(reportAd.getAdGroupId()) + 1);
          } else {
            activeAdsPerAdGroup.put(reportAd.getAdGroupId(), 1);
          }
        }
        if (reportAd.getCreativeApprovalStatus().equals(DISAPPROVED)) {
          kratu.numberOfDisapprovedAds = kratu.numberOfDisapprovedAds.add(new BigDecimal(1));
        }
      }
      reportAdList = null;

      // Process activeAdsPerAdGroup
      for (Integer activeAds : activeAdsPerAdGroup.values()) {
        if (activeAds == 1) {
          kratu.numberOfAdgroupsWithoneActiveAd = kratu.numberOfAdgroupsWithoneActiveAd.add(new BigDecimal(1));
        }
        if (activeAds == 2) {
          kratu.numberOfAdgroupsWithTwoActiveAds = kratu.numberOfAdgroupsWithTwoActiveAds.add(new BigDecimal(1));
        }
      }

      // Process Keywords
      Long sumImpressions = 0l;
      BigDecimal totalPositions = new BigDecimal(0);
      BigDecimal totalWeight = new BigDecimal(0);
      for (ReportKeyword reportKeyword : reportKeywordList) {
        if (reportKeyword.getStatus().equals(ENABLE)) {
          if (!reportKeyword.isNegative()) {
            kratu.numberOfPositiveActiveKeywords = kratu.numberOfPositiveActiveKeywords.add(new BigDecimal(1));

            // numberOfActiveGoodQualityScoreKeywords: QS > 7
            if (reportKeyword.getQualityScoreAsBigDecimal().compareTo(BigDecimal.valueOf(7)) == 1) {
              kratu.numberOfActiveGoodQualityScoreKeywords = kratu.numberOfActiveGoodQualityScoreKeywords.add(new BigDecimal(1));
            }
            // numberOfActiveAverageQualityScoreKeywords: QS>4 && <=7
            if (reportKeyword.getQualityScoreAsBigDecimal().compareTo(BigDecimal.valueOf(4)) == 1
                && reportKeyword.getQualityScoreAsBigDecimal().compareTo(BigDecimal.valueOf(7)) < 1) {
              kratu.numberOfActiveAverageQualityScoreKeywords = kratu.numberOfActiveAverageQualityScoreKeywords.add(new BigDecimal(1));
            }
            // numberOfActivePoorQualityScoreKeywords: QS <= 4
            if (reportKeyword.getQualityScoreAsBigDecimal().compareTo(BigDecimal.valueOf(4)) < 1) {
              kratu.numberOfActivePoorQualityScoreKeywords = kratu.numberOfActivePoorQualityScoreKeywords.add(new BigDecimal(1));
            }

            if (reportKeyword.getKeywordMatchType().equals(BROAD))
              kratu.numberOfActiveBroadMatchingKeywords = kratu.numberOfActiveBroadMatchingKeywords.add(new BigDecimal(1));

            if (reportKeyword.getKeywordMatchType().equals(PHRASE))
              kratu.numberOfActivePhraseMatchingKeywords = kratu.numberOfActivePhraseMatchingKeywords.add(new BigDecimal(1));

            if (reportKeyword.getKeywordMatchType().equals(EXACT))
              kratu.numberOfActiveExactMatchingKeywords = kratu.numberOfActiveExactMatchingKeywords.add(new BigDecimal(1));

            sumImpressions += reportKeyword.getImpressions();
            totalPositions = totalPositions.add(reportKeyword.getAvgPositionBigDecimal().multiply(
                BigDecimal.valueOf(reportKeyword.getImpressions())));
            totalWeight = totalWeight.add(reportKeyword.getQualityScoreAsBigDecimal().multiply(
                BigDecimal.valueOf(reportKeyword.getImpressions())));

          } else {
            kratu.numberOfNegativeActiveKeywords = kratu.numberOfNegativeActiveKeywords.add(new BigDecimal(1));
            kratu.numberOfAdGroupNegativeActiveKeywords = kratu.numberOfAdGroupNegativeActiveKeywords.add(new BigDecimal(1));
          }
        }
      }
      if (sumImpressions > 0) {
        kratu.weightedAverageKeywordPosition = totalPositions.divide(BigDecimal.valueOf(sumImpressions), 2,
            RoundingMode.HALF_UP);
        kratu.weightedAverageQualityScore = totalWeight.divide(BigDecimal.valueOf(sumImpressions), 2,
            RoundingMode.HALF_UP);
      }
      reportKeywordList = null;

      // Process CampaignNegativeKeywords    
      kratu.numberOfNegativeActiveKeywords = kratu.numberOfNegativeActiveKeywords.add(new BigDecimal(reportCampaignNegativeKeywordList.size()));
      kratu.numberOfCampaignNegativeActiveKeywords = kratu.numberOfCampaignNegativeActiveKeywords.add(new BigDecimal(reportCampaignNegativeKeywordList.size())); 
      reportCampaignNegativeKeywordList = null;
      
      kratu.spend = kratu.spend.setScale(2, RoundingMode.HALF_UP);

      return kratu;
    }
  } 
}