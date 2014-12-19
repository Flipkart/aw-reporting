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
import com.google.api.ads.adwords.lib.jaxb.v201406.ReportDefinitionReportType;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Specific report class for ReportAd
 *
 * @author jtoledo@google.com (Julian Toledo)
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
@Entity
@Table(name = "AW_ReportAd")
@CsvReport(value = ReportDefinitionReportType.AD_PERFORMANCE_REPORT, reportExclusions = { "HourOfDay" })
public class ReportAd extends ReportBase {

  @Column(name = "AD_ID")
  @CsvField(value = "Ad ID", reportField = "Id")
  @SerializedName("aid")
  private Long adId;

  @Lob
  @Column(name = "DISPLAY_URL", length = 1024)
  @CsvField(value = "Display URL", reportField = "DisplayUrl")
  @SerializedName("durl")
  private String displayUrl;

  @Lob
  @Column(name = "DESTINATION_URL", length = 2048)
  @CsvField(value = "Destination URL", reportField = "Url")
  @SerializedName("url")
  private String destinationUrl;

  @Column(name = "HEADLINE", length = 500)
  @CsvField(value = "Ad", reportField = "Headline")
  @SerializedName("hl")
  private String headline;

  @Column(name = "DESCRIPTION_1", length = 500)
  @CsvField(value = "Description line 1", reportField = "Description1")
  @SerializedName("d1")
  private String line1;

  @Column(name = "DESCRIPTION_2", length = 500)
  @CsvField(value = "Description line 2", reportField = "Description2")
  @SerializedName("d2")
  private String line2;

  @Column(name = "ADGROUP_ID")
  @CsvField(value = "Ad group ID", reportField = "AdGroupId")
  @SerializedName("agid")
  private Long adGroupId;

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  @SerializedName("cid")
  private Long campaignId;

  @Column(name = "STATUS", length = 32)
  @CsvField(value = "Ad state", reportField = "Status")
  @SerializedName("st")
  private String adState;

  @Column(name = "CREATIVE_APPROVAL_STATUS", length = 32)
  @CsvField(value = "Ad Approval Status", reportField = "CreativeApprovalStatus")
  @SerializedName("cas")
  private String creativeApprovalStatus;

    @Column(name = "AD_TYPE", length = 50)
    @CsvField(value = "Ad type", reportField = "AdType")
    @SerializedName("adt")
    private String adType;

  /**
   * Hibernate needs an empty constructor
   */
  public ReportAd() {
  }

  public ReportAd(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {
    // Generating unique _id after having accountId, campaignId, adGroupId and date
    if (this.getAccountId() != null && this.getCampaignId() != null && this.getAdGroupId() != null
        && this.getAdId() != null) this._id = this.getAccountId() + "-" + this.getCampaignId() + "-"
        + this.getAdGroupId() + "-" + this.getAdId();

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
  }

  // adId
  public Long getAdId() {
    return adId;
  }

  public void setAdId(Long adId) {
    this.adId = adId;
  }

  // adGroupId
  public Long getAdGroupId() {
    return adGroupId;
  }

  public void setAdGroupId(Long adGroupId) {
    this.adGroupId = adGroupId;
  }

  // campaignId
  public Long getCampaignId() {
    return campaignId;
  }

  public void setCampaignId(Long campaignId) {
    this.campaignId = campaignId;
  }

  // displayUrl
  public String getDisplayUrl() {
    return displayUrl;
  }

  public void setDisplayUrl(String displayUrl) {
    this.displayUrl = displayUrl;
  }

  // destinationUrl
  public String getDestinationUrl() {
    return destinationUrl;
  }

  public void setDestinationUrl(String destinationUrl) {
    this.destinationUrl = destinationUrl;
  }

  // headline
  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  // line1
  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getAdState() {
    return adState;
  }

  public void setAdState(String adState) {
    this.adState = adState;
  }

  // line2
  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  // creativeApprovalStatus
  public String getCreativeApprovalStatus() {
    return creativeApprovalStatus;
  }

  public void setCreativeApprovalStatus(String creativeApprovalStatus) {
    this.creativeApprovalStatus = creativeApprovalStatus;
  }

    //Ad type
    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }
}