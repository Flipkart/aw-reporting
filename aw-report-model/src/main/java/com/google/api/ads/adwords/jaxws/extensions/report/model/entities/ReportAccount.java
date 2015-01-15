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
import com.google.api.ads.adwords.lib.jaxb.v201409.ReportDefinitionReportType;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Specific report class for ReportAccount
 * 
 * @author jtoledo@google.com (Julian Toledo)
 */
@Entity
@Table(name = "AW_ReportAccount")
@CsvReport(value = ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT, reportExclusions = { "ClickType" })
public class ReportAccount extends ReportBase {

	@Column(name = "ACCOUNT_DESCRIPTIVE_NAME", length = 255)
	@CsvField(value = "Account", reportField = "AccountDescriptiveName")
    @SerializedName("adn")
	private String accountDescriptiveName;

	@Column(name = "CURRENCY_CODE", length = 6)
	@CsvField(value = "Currency", reportField = "AccountCurrencyCode")
    @SerializedName("currc")
	private String currencyCode;

	@Column(name = "SEARCH_LOST_IS_BUDGET")
	@CsvField(value = "Search Lost IS (budget)", reportField = "SearchBudgetLostImpressionShare")
    @SerializedName("slisb")
	private BigDecimal searchLostISBudget;

	@Column(name = "SEARCH_LOST_IS_RANK")
	@CsvField(value = "Search Lost IS (rank)", reportField = "SearchRankLostImpressionShare")
    @SerializedName("slisr")
	private BigDecimal searchLostISRank;

	@Column(name = "CONTENT_LOST_IS_BUDGET")
	@CsvField(value = "Content Lost IS (budget)", reportField = "ContentBudgetLostImpressionShare")
    @SerializedName("clisb")
	private BigDecimal contentLostISBudget;

	@Column(name = "CONTENT_LOST_IS_RANK")
	@CsvField(value = "Content Lost IS (rank)", reportField = "ContentRankLostImpressionShare")
    @SerializedName("clisr")
	private BigDecimal contentLostISRank;

    @Column(name = "SEARCH_IMPRESSION_SHARE")
	@CsvField(value = "Search Impr. share", reportField = "SearchImpressionShare")
    @SerializedName("sis")
	private BigDecimal searchImpressionShare;

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportAccount() {
	}

	public ReportAccount(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
	}

	@Override
	public void setId() {
		// Generating unique _id after having date and accountId
		this._id = this.getAccountId().toString();

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

	public String getSearchLostISBudget() {
		return BigDecimalUtil.formatAsReadable(this.searchLostISBudget);
	}

	public BigDecimal getSearchLostISBudgetBigDecimal() {
		return searchLostISBudget;
	}

	public void setSearchLostISBudget(String lostISBudget) {
		lostISBudget = lostISBudget.replaceAll("--", "0");
		this.searchLostISBudget = new BigDecimal(lostISBudget.replaceAll(
				"\\s|%|>|<", ""));
	}

	public String getSearchLostISRank() {
		return BigDecimalUtil.formatAsReadable(this.searchLostISRank);
	}

	public BigDecimal getSearchLostISRankBigDecimal() {
		return searchLostISRank;
	}

	public void setSearchLostISRank(String lostISRank) {
		lostISRank = lostISRank.replaceAll("--", "0");
		this.searchLostISRank = new BigDecimal(lostISRank.replaceAll(
				"\\s|%|>|<", ""));
	}

	public String getContentLostISBudget() {
		return BigDecimalUtil.formatAsReadable(this.contentLostISBudget);
	}

	public BigDecimal getContentLostISBudgetBigDecimal() {
		return contentLostISBudget;
	}

	public void setContentLostISBudget(String lostISBudget) {
		lostISBudget = lostISBudget.replaceAll("--", "0");
		this.contentLostISBudget = new BigDecimal(lostISBudget.replaceAll(
				"\\s|%|>|<", ""));
	}

	public String getContentLostISRank() {
		return BigDecimalUtil.formatAsReadable(this.contentLostISRank);
	}

	public BigDecimal getContentLostISRankBigDecimal() {
		return contentLostISRank;
	}

	public void setContentLostISRank(String lostISRank) {
		lostISRank = lostISRank.replaceAll("--", "0");
		this.contentLostISRank = new BigDecimal(lostISRank.replaceAll(
				"\\s|%|>|<", ""));
	}

	public String getAccountDescriptiveName() {
		return accountDescriptiveName;
	}

	public void setAccountDescriptiveName(String accountDescriptiveName) {
		this.accountDescriptiveName = accountDescriptiveName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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

}
