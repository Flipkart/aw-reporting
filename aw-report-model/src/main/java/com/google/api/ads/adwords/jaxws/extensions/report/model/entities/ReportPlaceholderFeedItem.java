/**
 * 
 */
package com.google.api.ads.adwords.jaxws.extensions.report.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionReportType;

/**
 * Specific Report class for PlaceholderFeedItem
 * 
 * @author markbowyer@google.com (Mark R. Bowyer)
 */
@Entity
@Table(name = "AW_ReportPlaceholderFeedItem")
@CsvReport(value = ReportDefinitionReportType.PLACEHOLDER_FEED_ITEM_REPORT)
public class ReportPlaceholderFeedItem extends ReportBase {

	@Column(name = "CAMPAIGN_ID")
	@CsvField(value = "Campaign ID", reportField = "CampaignId")
	private Long campaignId;

	@Column(name = "ADGROUP_ID")
	@CsvField(value = "Ad group ID", reportField = "AdGroupId")
	private Long adGroupId;

	@Column(name = "AD_ID")
	@CsvField(value = "Ad ID", reportField = "AdId")
	private Long adId;

	@Column(name = "FEED_ID")
	@CsvField(value = "Feed ID", reportField = "FeedId")
	private Long feedId;

	@Column(name = "FEED_ITEM_ID")
	@CsvField(value = "Feed item ID", reportField = "FeedItemId")
	private Long feedItemId;

	@Column(name = "FEED_PLACEHOLDER_TYPE")
	@CsvField(value = "Feed placeholder type", reportField = "PlaceholderType")
	private int feedPlaceholderType;

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportPlaceholderFeedItem() {
	}

	public ReportPlaceholderFeedItem(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
	}

	@Override
	public void setId() {

		// Generating unique _id after having date and accountId
		if (this.getAccountId() != null) {
			this._id = this.getAccountId().toString();
		} else {
			this._id = "null";
		}
		if (this.getCampaignId() != null) {
			this._id += "-" + this.getCampaignId().toString();
		} else {
			this._id += "null";
		}
		if (this.getAdGroupId() != null) {
			this._id += "-" + this.getAdGroupId().toString();
		} else {
			this._id += "null";
		}
		if (this.getAdId() != null) {
			this._id += "-" + this.getAdId().toString();
		} else {
			this._id += "null";
		}
		if (this.getFeedItemId() != null) {
			this._id += "-" + this.getFeedItemId().toString();
		} else {
			this._id += "null";
		}
		if (this.getFeedId() != null) {
			this._id += "-" + this.getFeedId().toString();
		} else {
			this._id += "null";
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

	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public Long getAdGroupId() {
		return adGroupId;
	}

	public void setAdGroupId(Long adGroupId) {
		this.adGroupId = adGroupId;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public Long getFeedId() {
		return feedId;
	}

	public void setFeedId(Long feedId) {
		this.feedId = feedId;
	}

	public Long getFeedItemId() {
		return feedItemId;
	}

	public void setFeedItemId(Long feedItemId) {
		this.feedItemId = feedItemId;
	}

	public int getFeedPlaceholderType() {
		return feedPlaceholderType;
	}

	public void setFeedPlaceholderType(int feedPlaceholderType) {
		this.feedPlaceholderType = feedPlaceholderType;
	}
}
