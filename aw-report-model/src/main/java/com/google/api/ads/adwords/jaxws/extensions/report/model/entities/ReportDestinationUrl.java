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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

/**
 * Specific report class for ReportDestinationUrl
 * 
 * @author marcwan@google.com (Marc Wandschneider)
 */
@Entity
@Table(name = "AW_ReportDestinationUrl")
@CsvReport(value = ReportDefinitionReportType.DESTINATION_URL_REPORT, reportExclusions = { "HourOfDay" })
public class ReportDestinationUrl extends ReportBase {

	@Column(name = "ADGROUPID")
	@CsvField(value = "Ad group ID", reportField = "AdGroupId")
	private Long adGroupId;

	@Column(name = "CAMPAIGNID")
	@CsvField(value = "Campaign ID", reportField = "CampaignId")
	private Long campaignId;

	@Column(name = "CRITERIADESTINATIONURL")
	@CsvField(value = "Keyword/Placement destination URL", reportField = "CriteriaDestinationUrl")
	private String criteriaDestinationUrl;

	@Column(name = "CRITERIAPARAMETERS")
	@CsvField(value = "Keyword / Placement", reportField = "CriteriaParameters")
	private String criteriaParameters;

	@Column(name = "CRITERIATYPENAME")
	@CsvField(value = "Match type", reportField = "CriteriaTypeName")
	private String criteriaTypeName;

	@Column(name = "EFFECTIVEDESTINATIONURL")
	@CsvField(value = "Destination URL", reportField = "EffectiveDestinationUrl")
	private String effectiveDestinationUrl;

	@Column(name = "ISNEGATIVE")
	@CsvField(value = "Is negative", reportField = "IsNegative")
	private String isNegative;

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportDestinationUrl() {
	}

	public ReportDestinationUrl(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
	}

	@Override
	public void setId() {

		// Generating unique _id after having accountId, campaignId, adGroupId
		// and date
		this._id = "";
		if (this.getAccountId() != null) {
			this._id += this.getAccountId() + "-";
		}
		if (this.getCampaignId() != null) {
			this._id += this.getCampaignId() + "-";
		}
		if (this.getAdGroupId() != null) {
			this._id += this.getAdGroupId() + "-";
		}
		if (this.getAdNetwork() != null) {
			this._id += this.getAdNetwork() + "-";
		}
		if (this.getAdNetworkPartners() != null) {
			this._id += this.getAdNetworkPartners() + "-";
		}
		if (this.getClickType() != null) {
			this._id += this.getClickType() + "-";
		}
		if (this.getCriteriaParameters() != null) {
			this._id += this.getCriteriaParameters() + "-";
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

	public Long getAdGroupId() {
		return adGroupId;
	}

	public void setAdGroupId(Long adGroupId) {
		this.adGroupId = adGroupId;
	}

	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public String getCriteriaDestinationUrl() {
		return criteriaDestinationUrl;
	}

	public void setCriteriaDestinationUrl(String criteriaDestinationUrl) {
		this.criteriaDestinationUrl = criteriaDestinationUrl;
	}

	public String getCriteriaParameters() {
		return criteriaParameters;
	}

	public void setCriteriaParameters(String criteriaParameters) {
		this.criteriaParameters = criteriaParameters;
	}

	public String getCriteriaTypeName() {
		return criteriaTypeName;
	}

	public void setCriteriaTypeName(String criteriaTypeName) {
		this.criteriaTypeName = criteriaTypeName;
	}

	public String getEffectiveDestinationUrl() {
		return effectiveDestinationUrl;
	}

	public void setEffectiveDestinationUrl(String effectiveDestinationUrl) {
		this.effectiveDestinationUrl = effectiveDestinationUrl;
	}

	public String getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(String isNegative) {
		this.isNegative = isNegative;
	}
}