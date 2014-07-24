package com.google.api.ads.adwords.jaxws.extensions.report.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.lib.jaxb.v201402.ReportDefinitionReportType;

/**
 * Specific report class for ReportKeyword
 * 
 * @author jtoledo@google.com (Julian Toledo)
 * @author gustavomoreira@google.com (Gustavo Moreira)
 * @author nafis@google.com (Nafis Zebarjadi)
 */
@Entity
@Table(name = "AW_ReportURL")
@CsvReport(value = ReportDefinitionReportType.URL_PERFORMANCE_REPORT, reportExclusions = {
		"HourOfDay", "AveragePosition", "Device", "ClickType" })
public class ReportUrl extends ReportBase {

	@Column(name = "AD_FORMAT")
	@CsvField(value = "Ad type", reportField = "AdFormat")
	private String adFormat;

	@Column(name = "AD_GROUP_ID")
	@CsvField(value = "Ad group ID", reportField = "AdGroupId")
	private Long adGroupId;

	@Column(name = "CAMPAIGN_ID")
	@CsvField(value = "Campaign ID", reportField = "CampaignId")
	private Long campaignId;

	@Column(name = "CRITERIA_PARAMETERS")
	@CsvField(value = "Keyword / Placement", reportField = "CriteriaParameters")
	public String criteriaParameters;

	@Column(name = "DISPLAY_NAME")
	@CsvField(value = "Criteria Display Name", reportField = "DisplayName")
	private String displayName;

	@Column(name = "DOMAIN")
	@CsvField(value = "Domain", reportField = "Domain")
	private String domain;

	@Column(name = "IS_AUTO_OPTIMIZED")
	@CsvField(value = "Targeting Mode", reportField = "IsAutoOptimized")
	private String isAutoOptimized;

	@Column(name = "IS_BID_ON_PATH")
	@CsvField(value = "Added", reportField = "IsBidOnPath")
	private String isBidOnPath;

	@Column(name = "IS_PATH_EXCLUDED")
	@CsvField(value = "Excluded", reportField = "IsPathExcluded")
	private String isPathExcluded;

	@Column(name = "URL")
	@CsvField(value = "URL", reportField = "Url")
	private String url;

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportUrl() {
	}

	public ReportUrl(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
	}

	@Override
	public void setId() {
		// Generating unique _id after having accountId, campaignId, adGroupId
		// and
		// url
		if (this.getAccountId() != null && this.getCampaignId() != null
				&& this.getAdGroupId() != null && this.getUrl() != null) {
			this._id = this.getAccountId() + "-" + this.getCampaignId() + "-"
					+ this.getAdGroupId() + "-" + this.getUrl();
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

	public String getAdFormat() {
		return adFormat;
	}

	public void setAdFormat(String adFormat) {
		this.adFormat = adFormat;
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

	public String getCriteriaParameters() {
		return criteriaParameters;
	}

	public void setCriteriaParameters(String criteriaParameters) {
		this.criteriaParameters = criteriaParameters;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIsAutoOptimized() {
		return isAutoOptimized;
	}

	public void setIsAutoOptimized(String isAutoOptimized) {
		this.isAutoOptimized = isAutoOptimized;
	}

	public String getIsBidOnPath() {
		return isBidOnPath;
	}

	public void setIsBidOnPath(String isBidOnPath) {
		this.isBidOnPath = isBidOnPath;
	}

	public String getIsPathExcluded() {
		return isPathExcluded;
	}

	public void setIsPathExcluded(String isPathExcluded) {
		this.isPathExcluded = isPathExcluded;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
