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
import com.google.api.ads.adwords.lib.jaxb.v201509.ReportDefinitionReportType;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Specific report class for ReportKeyword
 * 
 * @author jtoledo@google.com (Julian Toledo)
 * @author gustavomoreira
 */
@Entity
@Table(name = "AW_ReportKeyword")
@CsvReport(value = ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT, reportExclusions = { "HourOfDay" })
public class ReportKeyword extends ReportBase {

	@Column(name = "KEYWORD_ID")
	@CsvField(value = "Keyword ID", reportField = "Id")
    @SerializedName("kid")
	private Long keywordId;

	@Column(name = "QUALITY_SCORE")
	@CsvField(value = "Quality score", reportField = "QualityScore")
    @SerializedName("qs")
	private BigDecimal qualityScore;

	@Column(name = "KEYWORD_MATCH_TYPE", length = 32)
	@CsvField(value = "Match type", reportField = "KeywordMatchType")
    @SerializedName("kmt")
	private String keywordMatchType;

	@Column(name = "KEYWORD_TEXT", length = 255)
	@CsvField(value = "Keyword", reportField = "Criteria")
    @SerializedName("kt")
	private String keywordText;

    @Lob
    @Column(name = "FINAL_URL", length = 2048)
    @CsvField(value = "Final URL", reportField = "FinalUrls")
    @SerializedName("furl")
    private String finalUrl;

    @Lob
    @Column(name = "TRACKING_TEMPLATE", length = 2048)
    @CsvField(value = "Tracking template", reportField = "TrackingUrlTemplate")
    @SerializedName("tt")
    private String trackingTemplate;

	@Column(name = "ADGROUP_ID")
	@CsvField(value = "Ad group ID", reportField = "AdGroupId")
    @SerializedName("agid")
	private Long adGroupId;

	@Column(name = "CAMPAIGN_ID")
	@CsvField(value = "Campaign ID", reportField = "CampaignId")
    @SerializedName("cid")
	private Long campaignId;

	@Column(name = "STATUS", length = 32)
	@CsvField(value = "Keyword state", reportField = "Status")
    @SerializedName("st")
	private String status;

	@Column(name = "IS_NEGATIVE")
	@CsvField(value = "Is negative", reportField = "IsNegative")
    @SerializedName("neg")
	private Boolean negative;

    @Column(name = "MAX_CPC")
    @CsvField(value = "Max. CPC", reportField = "CpcBid")
    @SerializedName("mcpc")
    private String maxCPC;

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportKeyword() {
	}

	public ReportKeyword(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
	}

	@Override
	public void setId() {
		// Generating unique _id after having accountId, campaignId, adGroupId
		// and date
		if (this.getAccountId() != null && this.getCampaignId() != null
				&& this.getAdGroupId() != null && this.getKeywordId() != null) {
			this._id = this.getAccountId() + "-" + this.getCampaignId() + "-"
					+ this.getAdGroupId() + "-" + this.getKeywordId();
		}

		this._id += setIdDates();

		// Adding extra fields for unique ID
		if (this.getAdNetwork() != null && this.getAdNetwork().length() > 0) {
			this._id += "-" + this.getAdNetwork();
		}
		if (this.getAdNetworkPartners() != null
				&& this.getAdNetworkPartners().length() > 0) {
			this._id += "-" + this.getAdNetworkPartners();
		}
		if (this.getDevice() != null && this.getDevice().length() > 0) {
			this._id += "-" + this.getDevice();
		}
		if (this.getClickType() != null && this.getClickType().length() > 0) {
			this._id += "-" + this.getClickType();
		}
	}

	// adGroupId
	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	// qualityScore
	public BigDecimal getQualityScoreAsBigDecimal() {
		return qualityScore;
	}

	public String getQualityScore() {
		return BigDecimalUtil.formatAsReadable(qualityScore);
	}

	public void setQualityScore(BigDecimal qualityScore) {
		this.qualityScore = qualityScore;
	}

	public void setQualityScore(String qualityScore) {
		this.qualityScore = BigDecimalUtil.parseFromNumberString(qualityScore);
	}

	// keywordMatchType
	public String getKeywordMatchType() {
		return keywordMatchType;
	}

	public void setKeywordMatchType(String keywordMatchType) {
		this.keywordMatchType = keywordMatchType;
	}

	// keywordText
	public String getKeywordText() {
		return keywordText;
	}

	public void setKeywordText(String keywordText) {
		this.keywordText = keywordText;
	}

    // finalUrl
    public String getFinalUrl() {
        return finalUrl;
    }

    public void setFinalUrl(String finalUrl) {
        this.finalUrl = finalUrl;
    }

    // trackingTemplate
    public String getTrackingTemplate() {
        return trackingTemplate;
    }

    public void setTrackingTemplate(String trackingTemplate) {
        this.trackingTemplate = trackingTemplate;
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

	// status
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// negative
	public boolean isNegative() {
		return negative;
	}

	public void setNegative(String negative) {
		this.negative = Boolean.parseBoolean(negative);
	}

	public void setNegative(boolean negative) {
		this.negative = negative;
	}

        public String getMaxCPC() {
        return maxCPC;
    }

    public void setMaxCPC(String maxCPC) {
        this.maxCPC = maxCPC;
    }
}
