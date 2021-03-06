// Copyright 2011 Google Inc. All Rights Reserved.
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

package com.google.api.ads.adwords.jaxws.extensions.report.model.entities;

import com.google.api.ads.adwords.jaxws.extensions.report.Services.ReportModeService;
import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvField;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * The base abstract class for all Reports
 *
 *  Fields from http://code.google.com/apis/adwords/docs/appendix/reports.html Fields from
 * http://code.google.com/apis/adwords/docs/reportguide.html
 *
 * @author jtoledo@google.com (Julian Toledo)
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
@MappedSuperclass
public abstract class Report {

  // Variables for Persistence queries
  public static final String __id = "_id";
  public static final String _partnerId = "partnerId";
  public static final String _topAccountId = "topAccountId";
  public static final String _accountId = "accountId";
  public static final String _campaignId = "campaignId";
  public static final String _adGroupId = "adGroupId";
  public static final String _keywordId = "keywordId";
  public static final String _adId = "adId";
  public static final String _day = "day";
  public static final String _dateStart = "dateStart";
  public static final String _dateEnd = "dateEnd";

  @Id
  @Column(name = "ROW_ID")
  protected String _id;

  @Column(name = "PARTNER_ID")
  @SerializedName("pId")
  protected Long partnerId;

  @Column(name = "TOP_ACCOUNT_ID")
  @SerializedName("tid")
  protected Long topAccountId;

  @Column(name = "TIMESTAMP")
  @SerializedName("ts")
  protected Date timestamp;

  @Column(name = "DATE_START")
  @SerializedName("ds")
  protected String dateStart;

  @Column(name = "DATE_END")
  @SerializedName("de")
  protected String dateEnd;

  @Column(name = "DATE_RANGE_TYPE")
  @SerializedName("drt")
  protected String dateRangeType;

  @Column(name = "ACCOUNT_ID")
  @CsvField(value = "Customer ID", reportField = "ExternalCustomerId")
  @SerializedName("acid")
  protected Long accountId;

  @Column(name = "SNAPSHOT_DAY")
  @SerializedName("sd")
  protected String snapshotDay;

  @Column(name = "LAST_UPDATED")
  @SerializedName("lu")
  protected Long lastUpdatedTimeStamp;

  public Report() {
    timestamp = new DateTime().toDate();
  }

  public Report(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
    timestamp = new DateTime().toDate();
  }


  public abstract void setId();

  public String setIdDates() {

      ReportMode mode = ReportModeService.getReportMode();

      //this is for ATTRIBUTE reports
      if(mode.equals(ReportMode.ATTRIBUTE) && this.getLastUpdatedTimeStamp() != null){
          return "-" + this.getLastUpdatedTimeStamp().toString();
      }

      if (this.getDateStart() != null && this.getDateEnd() != null) {
          return "-"
              + this.getDateStart()
              + "-"
              + this.getDateEnd()
              + (this.getSnapshotDay() != null ? ("-" + this
              .getSnapshotDay()) : "");
      }
      return "";
  }

  public String get_id() {
    return _id;
  }

  public Long getPartnerId() {
    return partnerId;
  }

  public void setPartnerId(Long partnerId) {
    this.partnerId = partnerId;
  }

  public Long getTopAccountId() {
    return topAccountId;
  }

  public void setTopAccountId(Long topAccountId) {
    this.topAccountId = topAccountId;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public String getDateRangeType() {
    return dateRangeType;
  }

  public void setDateRangeType(String dateRangeType) {
    this.dateRangeType = dateRangeType;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public String getDateStart() {
    return dateStart;
  }

  public void setDateStart(String dateStart) {
    this.dateStart = dateStart;
  }

  public String getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(String dateEnd) {
    this.dateEnd = dateEnd;
  }

  public String getSnapshotDay() {
    return snapshotDay;
  }

  public void setSnapshotDay(String snapshotDay) {
    this.snapshotDay = snapshotDay;
  }

  public Long getLastUpdatedTimeStamp() {
    return lastUpdatedTimeStamp;
  }

  public void setLastUpdatedTimeStamp(Long lastUpdatedTimeStamp) {
    this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
  }
}
