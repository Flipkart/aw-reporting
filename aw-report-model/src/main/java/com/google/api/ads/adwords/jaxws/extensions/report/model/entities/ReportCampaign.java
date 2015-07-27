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

import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.BigDecimalUtil;
import com.google.api.ads.adwords.lib.jaxb.v201502.ReportDefinitionReportType;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Specific report class for ReportCampaign
 *
 * @author jtoledo@google.com (Julian Toledo)
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
@Entity
@Table(name = "AW_ReportCampaign")
@CsvReport(value = ReportDefinitionReportType.CAMPAIGN_PERFORMANCE_REPORT)
public class ReportCampaign extends ReportBase {

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  @SerializedName("cid")
  private Long campaignId;

  @Column(name = "CAMPAIGN_NAME", length = 255)
  @CsvField(value = "Campaign", reportField = "CampaignName")
  @SerializedName("name")
  private String campaignName;

  @Column(name = "STATUS", length = 32)
  @CsvField(value = "Campaign state", reportField = "CampaignStatus")
  @SerializedName("st")
  private String status;

  @Column(name = "BUDGET")
  @CsvField(value = "Budget", reportField = "Amount")
  @SerializedName("b")
  private BigDecimal budget;

  @Column(name = "SEARCH_IMPRESSION_SHARE")
  @CsvField(value = "Search Impr. share", reportField = "SearchImpressionShare")
  @SerializedName("sis")
  private BigDecimal searchImpressionShare;

  @Column(name = "BOUNCE_RATE")
  @CsvField(value = "Bounce rate", reportField = "BounceRate")
  @SerializedName("br")
  private BigDecimal bounceRate;


  @Column(name = "PERCENT_NEW_VISITORS")
  @CsvField(value = "% new visits", reportField = "PercentNewVisitors")
  @SerializedName("pnr")
  private BigDecimal percentNewVisitors;


  @Column(name = "AVERAGE_VISIT_DURATION")
  @CsvField(value = "Avg. visit duration (seconds)", reportField = "AverageTimeOnSite")
  @SerializedName("avd")
  private BigDecimal averageVisitDuration;


  @Column(name = "ADVERTISING_CHANNEL", length = 32)
  @CsvField(value = "Advertising Channel", reportField = "AdvertisingChannelType")
  @SerializedName("adc")
  private String advertisingChannelType;



  /**
   * Hibernate needs an empty constructor
   */
  public ReportCampaign() {}

  public ReportCampaign(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {
    // Generating unique _id after having accountId, campaignId and date
    if (this.getAccountId() != null && this.getCampaignId() != null) {
      this._id = this.getAccountId() + "-" + this.getCampaignId();
    }

    this._id += setIdDates();

    // Adding extra fields for unique ID
    if (this.getAdNetwork() != null && this.getAdNetwork().length() > 0) {
      this._id += "-" + this.getAdNetwork();
    }
    if (this.getAdNetworkPartners() != null && this.getAdNetworkPartners().length() > 0) {
      this._id += "-" + this.getAdNetworkPartners();
    }
    if (this.getDevice() != null && this.getDevice().length() > 0) {
      this._id += "-" + this.getDevice();
    }
    if (this.getClickType() != null && this.getClickType().length() > 0) {
      this._id += "-" + this.getClickType();
    }
    if (this.getAdvertisingChannelType() != null && this.getAdvertisingChannelType().length() > 0) {
      this._id += "-" + this.getAdvertisingChannelType();
    }
  }

  // campaignId
  public Long getCampaignId() {
    return campaignId;
  }

  public void setCampaignId(Long campaignId) {
    this.campaignId = campaignId;
  }

  // campaignName
  public String getCampaignName() {
    return campaignName;
  }

  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
  }

  // status
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  // budget
  public String getBudget() {
    return BigDecimalUtil.formatAsReadable(budget);
  }

  public BigDecimal getBudgetBigDecimal() {
    return budget;
  }

  public void setBudget(String budget) {
    this.budget = BigDecimalUtil.parseFromNumberString(budget);
  }

  public BigDecimal getSearchImpressionShareBigDecimal() {
        return this.searchImpressionShare;
    }

     public String getSearchImpressionShare() {
        return BigDecimalUtil.formatAsReadable(this.searchImpressionShare);
    }

    public void setSearchImpressionShare(String searchImpressionShare) {
        searchImpressionShare = searchImpressionShare.replaceAll("--", "0");
        this.searchImpressionShare = new BigDecimal(searchImpressionShare.replaceAll(
				"\\s|%|>|<", ""));;
    }


    public BigDecimal getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(BigDecimal bounceRate) {
        this.bounceRate = bounceRate;
    }

    public BigDecimal getPercentNewVisitors() {
        return percentNewVisitors;
    }

    public void setPercentNewVisitors(BigDecimal percentNewVisitors) {
        this.percentNewVisitors = percentNewVisitors;
    }


     public BigDecimal getAverageVisitDuration() {
        return averageVisitDuration;
    }

    public void setAverageVisitDuration(BigDecimal averageVisitDuration) {
        this.averageVisitDuration = averageVisitDuration;
    }

    public String getAdvertisingChannelType() {
        return advertisingChannelType;
    }

    public void setAdvertisingChannelType(String advertisingChannelType) {
        this.advertisingChannelType = advertisingChannelType;
    }

}
