// Copyright 2013 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.jaxws.extensions.kratu.data;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAccount;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAd;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdExtension;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportAdGroup;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaign;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportCampaignNegativeKeyword;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportKeyword;
import com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.DateUtil;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * StorageHelper
 * 
 * @author jtoledo@google.com (Julian Toledo)
 */
@Component
public class StorageHelper {

  private EntityPersister entityPersister;

  public StorageHelper() {
  }
  
  public StorageHelper(EntityPersister entityPersister) {
    this.entityPersister = entityPersister;
  }

  public EntityPersister getEntityPersister() {
    return entityPersister;
  }
  
  /**
   * @param persister the persister to set
   */
  @Autowired
  public void setPersister(EntityPersister persister) {
    this.entityPersister = persister;
  }

  // Report (Generic for all kinds)
  public <R extends Report> List<R> getReportById(Class<R> classR, String id) {
    return entityPersister.get(classR, Report.__id, id);
  }

  public <R extends Report> List<R> getReportByAccountId(Class<R> classR, Long accountId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(classR, Report._accountId, accountId, Report._day, dateStart, dateEnd);
  }

  public <R extends Report> List<R> getReportByTopAccountId(Class<R> classR, Long topAccountId,
      Date dateStart, Date dateEnd) {
    
    return entityPersister.get(
        classR, ReportAccount._topAccountId, topAccountId, Report._day, dateStart, dateEnd);
  }

  public <R extends Report> List<R> getReportByDates(Class<R> classR, Date dateStart,
      Date dateEnd) {
    
    return entityPersister.get(classR, null, null, Report._day, dateStart, dateEnd);
  }

  // ReportCampaign
  public List<ReportCampaign> getReportCampaignByCampaignId(Long campaignId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportCampaign.class, ReportCampaign._campaignId, campaignId,
        Report._day, dateStart, dateEnd);
  }

  // ReportAdGroup
  public List<ReportAdGroup> getReportAdGroupByCampaignId(Long campaignId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportAdGroup.class, ReportAdGroup._campaignId, campaignId,
        Report._day, dateStart, dateEnd);
  }

  public List<ReportAdGroup> getReportAdGroupByAdGroupId(Long adGroupId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportAdGroup.class, ReportAdGroup._adGroupId, adGroupId, Report._day,
        dateStart, dateEnd);
  }

  // ReportAd
  public List<ReportAd> getReportAdByCampaignId(Long campaignId, Date dateStart, Date dateEnd) {
    return entityPersister.get(ReportAd.class, ReportAd._campaignId, campaignId, Report._day,
        dateStart, dateEnd);
  }

  public List<ReportAd> getReportAdByAdGroupId(Long adGroupId, Date dateStart, Date dateEnd) {
    return entityPersister.get(ReportAd.class, ReportAd._adGroupId, adGroupId, Report._day, dateStart,
        dateEnd);
  }

  public List<ReportAd> getReportAdByAdId(Long adId, Date dateStart, Date dateEnd) {
    return entityPersister.get(ReportAd.class, ReportAd._adId, adId, Report._day, dateStart, dateEnd);
  }

  // ReportKeyword
  public List<ReportKeyword> getReportKeywordByCampaignId(Long campaignId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportKeyword.class, ReportKeyword._campaignId, campaignId,
        Report._day, dateStart, dateEnd);
  }

  public List<ReportKeyword> getReportKeywordByAdGroupId(Long adGroupId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportKeyword.class, ReportKeyword._adGroupId, adGroupId, Report._day,
        dateStart, dateEnd);
  }

  public List<ReportKeyword> getReportKeywordByKeywordId(Long keywordId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportKeyword.class, ReportKeyword._keywordId, keywordId, Report._day,
        dateStart, dateEnd);
  }

  // ReportAdExtension
  public List<ReportAdExtension> getReportAdExtensionByCampaignId(Long campaignId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportAdExtension.class, ReportAdExtension._campaignId, campaignId,
        Report._day, dateStart, dateEnd);
  }

  public List<ReportAdExtension> getReportAdExtensionByAdExtensionId(Long adExtensionId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportAdExtension.class, ReportAdExtension._adExtensionId, adExtensionId, Report._day,
        dateStart, dateEnd);
  }

  // ReportCampaignNegativeKeyword
  public List<ReportCampaignNegativeKeyword> getReportCampaignNegativeKeywordByCampaignId(Long keywordId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportCampaignNegativeKeyword.class, ReportCampaignNegativeKeyword._campaignId, keywordId, Report._day,
        dateStart, dateEnd);
  }

  public List<ReportCampaignNegativeKeyword> getReportCampaignNegativeKeywordByKeywordId(Long keywordId, Date dateStart,
      Date dateEnd) {
    return entityPersister.get(ReportCampaignNegativeKeyword.class, ReportCampaignNegativeKeyword._keywordId, keywordId, Report._day,
        dateStart, dateEnd);
  }

  public List<ReportCampaignNegativeKeyword> getReportCampaignNegativeKeywordByEndDateInRange(
      Date dateStart, Date dateEnd) {

    return entityPersister.get(ReportCampaignNegativeKeyword.class, null, null, Report._dateEnd,
        DateUtil.formatYearMonthDayNoDash(dateStart), DateUtil.formatYearMonthDayNoDash(dateEnd));
  }
  
  public List<ReportCampaignNegativeKeyword> getReportCampaignNegativeKeywordByAccountAndEndDateInRange(
      Long accountId, Date dateStart, Date dateEnd) {

    return entityPersister.get(ReportCampaignNegativeKeyword.class, Report._accountId, accountId, Report._dateEnd,
        DateUtil.formatYearMonthDayNoDash(dateStart), DateUtil.formatYearMonthDayNoDash(dateEnd));
  }

  // Kratu
  public Kratu saveKratu(Kratu kratu) {
    return entityPersister.save(kratu);
  }

  public List<Kratu> getKratus() {
    return entityPersister.get(Kratu.class);
  }

  public List<Kratu> getKratus(Long accountId) {
    return entityPersister.get(Kratu.class, Kratu._externalCustomerId, accountId);
  }

  public List<Kratu> getKratus(Date day) {
    return entityPersister.get(Kratu.class, Kratu._day, DateUtil.formatYearMonthDayNoDash(day));
  }

  public List<Kratu> getKratus(Date startDate, Date endDate) {
    List<Kratu> kratusSummary = Lists.newArrayList();
    List<Account> listAccounts = entityPersister.get(Account.class);

    System.out.println("\n ** Summary Kratus (for: " + listAccounts.size() + ") **");
    long start = System.currentTimeMillis();

    // Get all the (not-MCC) Accounts under TopAccount
    int i = 0;
    for (Account account : listAccounts) {
      System.out.println();
      System.out.print(i++ + " ");
      List<Kratu> accountDailyKratus = entityPersister.get(Kratu.class, Kratu._externalCustomerId, account.getExternalCustomerId(), Kratu._day, startDate, endDate);
      if (accountDailyKratus != null && accountDailyKratus.size() > 0) {
        kratusSummary.add(Kratu.createKratuSummary(accountDailyKratus, startDate, endDate));
      }
    }

    System.out.println("\n*** Finished Summary Kratus in "
        + ((System.currentTimeMillis() - start) / 1000) + " seconds ***");
    System.out.println();
    
    return kratusSummary;
  }

  public void createReportIndexes() {
    // Crete Indexes
    List<String> indexes = Lists.newArrayList();
    indexes.add(Report._accountId);
    indexes.add(Report._day);
    entityPersister.createIndex(ReportAccount.class, indexes);
    entityPersister.createIndex(ReportCampaign.class, indexes);
    entityPersister.createIndex(ReportAdGroup.class, indexes);
    entityPersister.createIndex(ReportAd.class, indexes);
    entityPersister.createIndex(ReportKeyword.class, indexes);
    entityPersister.createIndex(ReportAdExtension.class, indexes);
  }
}