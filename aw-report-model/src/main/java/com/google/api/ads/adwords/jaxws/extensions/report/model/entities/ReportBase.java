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
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.DateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.Last14DaysDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.Last30DaysDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.Last7DaysDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.LastMonthDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.LastWeekDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.ThisMonthDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.TodayDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.YesterdayDateRangeHandler;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.BigDecimalUtil;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.DateUtil;
import com.google.api.ads.adwords.lib.jaxb.v201309.ReportDefinitionDateRangeType;
import com.google.api.client.util.Maps;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * The base abstract class with base report fields
 * 
 * Fields from http://code.google.com/apis/adwords/docs/appendix/reports.html
 * Fields from http://code.google.com/apis/adwords/docs/reportguide.html
 * 
 * @author jtoledo@google.com (Julian Toledo)
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
@MappedSuperclass
public abstract class ReportBase extends Report {

	@Column(name = "DAY")
	@CsvField(value = "Day", reportField = "Date")
	protected Date day;

	@Column(name = "MONTH")
	@CsvField(value = "Month", reportField = "Month")
	protected Date month;

	@Column(name = "ACCOUNT_DESCRIPTIVE_NAME", length = 255)
	@CsvField(value = "Account", reportField = "AccountDescriptiveName")
	protected String accountDescriptiveName;

	@Column(name = "COST")
	@CsvField(value = "Cost", reportField = "Cost")
	protected BigDecimal cost;

	@Column(name = "CLICKS")
	@CsvField(value = "Clicks", reportField = "Clicks")
	protected Long clicks;

	@Column(name = "IMPRESSIONS")
	@CsvField(value = "Impressions", reportField = "Impressions")
	protected Long impressions;

	@Column(name = "CONVERSIONS")
	@CsvField(value = "Conv. (1-per-click)", reportField = "Conversions")
	protected Long conversions = 0l;

	@Column(name = "CTR")
	@CsvField(value = "CTR", reportField = "Ctr")
	protected BigDecimal ctr;

	@Column(name = "AVERAGE_CPM")
	@CsvField(value = "Avg. CPM", reportField = "AverageCpm")
	protected BigDecimal avgCpm;

	@Column(name = "AVERAGE_CPC")
	@CsvField(value = "Avg. CPC", reportField = "AverageCpc")
	protected BigDecimal avgCpc;

	@Column(name = "AVERAGE_POSITION")
	@CsvField(value = "Avg. position", reportField = "AveragePosition")
	protected BigDecimal avgPosition;

	@Column(name = "CURRENCY_CODE", length = 6)
	@CsvField(value = "Currency", reportField = "AccountCurrencyCode")
	protected String currencyCode;

	@Column(name = "DEVICE", length = 64)
	@CsvField(value = "Device", reportField = "Device")
	protected String device;

	@Column(name = "CLICK_TYPE", length = 64)
	@CsvField(value = "Click type", reportField = "ClickType")
	protected String clickType;

	@Column(name = "NETWORK", length = 32)
	@CsvField(value = "Network", reportField = "AdNetworkType1")
	protected String adNetwork;

	@Column(name = "NETWORK_PARTNERS", length = 32)
	@CsvField(value = "Network (with search partners)", reportField = "AdNetworkType2")
	protected String adNetworkPartners;

	@Column(name = "CONVERSIONSMANYPERCLICK")
	@CsvField(value = "Conv. (many-per-click)", reportField = "ConversionsManyPerClick")
	protected Long conversionsManyPerClick;

	@Column(name = "VALUE_PER_CONVERSION_1")
	@CsvField(value = "Value / conv. (1-per-click)", reportField = "ValuePerConv")
	protected BigDecimal valuePerConversion1;

	@Column(name = "VALUE_PER_CONVERSION_MANY")
	@CsvField(value = "Value / conv. (many-per-click)", reportField = "ValuePerConvManyPerClick")
	protected BigDecimal valuePerConversionMany;

	@Column(name = "CONVERSION_VALUE")
	@CsvField(value = "Total conv. value", reportField = "ConversionValue")
	protected Long conversionValue;

	@Column(name = "CONVERSION_RATE_1")
	@CsvField(value = "Conv. rate (1-per-click)", reportField = "ConversionRate")
	protected BigDecimal conversionRate1;

	@Column(name = "CONVERSION_RATE_MANY")
	@CsvField(value = "Conv. rate (many-per-click)", reportField = "ConversionRateManyPerClick")
	protected BigDecimal conversionRateMany;

	@Column(name = "COST_PER_CONVERSION_1")
	@CsvField(value = "Cost / conv. (1-per-click)", reportField = "CostPerConversion")
	protected BigDecimal costPerConversion1;

	@Column(name = "COST_PER_CONVERSION_MANY")
	@CsvField(value = "Cost / conv. (many-per-click)", reportField = "CostPerConversionManyPerClick")
	protected BigDecimal costPerConversionMany;

	@Column(name = "VIEWTHROUGHCONVERSIONS")
	@CsvField(value = "View-through conv.", reportField = "ViewThroughConversions")
	protected Long viewThroughConversions;

	private static final Map<String, DateRangeHandler> dateRangeHandlers = Maps
			.newHashMap();

	static {
		dateRangeHandlers.put(
				ReportDefinitionDateRangeType.LAST_14_DAYS.name(),
				new Last14DaysDateRangeHandler());
		dateRangeHandlers.put(
				ReportDefinitionDateRangeType.LAST_30_DAYS.name(),
				new Last30DaysDateRangeHandler());
		dateRangeHandlers.put(ReportDefinitionDateRangeType.LAST_7_DAYS.name(),
				new Last7DaysDateRangeHandler());
		dateRangeHandlers.put(ReportDefinitionDateRangeType.LAST_MONTH.name(),
				new LastMonthDateRangeHandler());
		dateRangeHandlers.put(ReportDefinitionDateRangeType.LAST_WEEK.name(),
				new LastWeekDateRangeHandler());
		dateRangeHandlers.put(ReportDefinitionDateRangeType.THIS_MONTH.name(),
				new ThisMonthDateRangeHandler());
		dateRangeHandlers.put(ReportDefinitionDateRangeType.TODAY.name(),
				new TodayDateRangeHandler());
		dateRangeHandlers.put(ReportDefinitionDateRangeType.YESTERDAY.name(),
				new YesterdayDateRangeHandler());
	}

	/**
	 * Hibernate needs an empty constructor
	 */
	public ReportBase() {
		timestamp = new DateTime().toDate();
	}

	public ReportBase(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
		timestamp = new DateTime().toDate();
	}

	@Override
	public abstract void setId();

	@Override
	public String setIdDates() {
		// Day or Month
		if (this.getDay() != null) {
			return "-" + this.getDay();
		}
		if (this.getMonth() != null) {
			return "-" + DateUtil.formatYearMonth(this.getMonthDateTime());
		}
		if (this.getDateRangeType() != null) {

			DateRangeHandler handler = dateRangeHandlers.get(this
					.getDateRangeType());
			if (handler != null) {
				this.setMonth(handler.retrieveMonth(DateTime.now()));
				this.setDateStart(DateUtil.formatYearMonthDay(handler
						.retrieveDateStart(DateTime.now())));
				this.setDateEnd(DateUtil.formatYearMonthDay(handler
						.retrieveDateEnd(DateTime.now())));
			}
		}
		if (this.getDateStart() != null && this.getDateEnd() != null) {
			return "-" + this.getDateStart() + "-" + this.getDateEnd();
		}
		return "";
	}

	@Override
	public String get_id() {
		return _id;
	}

	@Override
	public Long getPartnerId() {
		return partnerId;
	}

	@Override
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	@Override
	public Long getTopAccountId() {
		return topAccountId;
	}

	@Override
	public void setTopAccountId(Long topAccountId) {
		this.topAccountId = topAccountId;
	}

	@Override
	public Long getAccountId() {
		return accountId;
	}

	@Override
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getDay() {
		if (day != null) {
			return DateUtil.formatYearMonthDay(day);
		} else {
			return null;
		}
	}

	public void setDay(DateTime day) {
		this.day = new DateTime(day).toDate();
	}

	public void setDay(String day) {
		try {
			this.day = DateUtil.parseDateTime(day).toDate();
		} catch (IllegalArgumentException e) {
			this.day = null;
		}
	}

	public String getMonth() {
		if (month != null) {
			return DateUtil.formatYearMonthDay(month);
		} else {
			return null;
		}
	}

	public DateTime getMonthDateTime() {
		return new DateTime(month);
	}

	public void setMonth(DateTime month) {
		this.month = new DateTime(month).toDate();
	}

	public void setMonth(String month) {
		try {
			this.month = DateUtil.parseDateTime(month).toDate();
		} catch (IllegalArgumentException e) {
			this.month = null;
		}
	}

	@Override
	public String getDateRangeType() {
		return dateRangeType;
	}

	@Override
	public void setDateRangeType(String dateRangeType) {
		this.dateRangeType = dateRangeType;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public void setCtr(BigDecimal ctr) {
		this.ctr = ctr;
	}

	public void setAvgCpm(BigDecimal avgCpm) {
		this.avgCpm = avgCpm;
	}

	public void setAvgCpc(BigDecimal avgCpc) {
		this.avgCpc = avgCpc;
	}

	public void setAvgPosition(BigDecimal avgPosition) {
		this.avgPosition = avgPosition;
	}

	public String getAccountDescriptiveName() {
		return accountDescriptiveName;
	}

	public void setAccountDescriptiveName(String accountDescriptiveName) {
		this.accountDescriptiveName = accountDescriptiveName;
	}

	public String getCost() {
		return BigDecimalUtil.formatAsReadable(cost);
	}

	public BigDecimal getCostBigDecimal() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = BigDecimalUtil.parseFromNumberString(cost);
	}

	public Long getClicks() {
		return clicks;
	}

	public void setClicks(Long clicks) {
		this.clicks = clicks;
	}

	public Long getImpressions() {
		return impressions;
	}

	public void setImpressions(Long impressions) {
		this.impressions = impressions;
	}

	public Long getConversions() {
		return conversions;
	}

	public void setConversions(Long conversions) {
		this.conversions = conversions;
	}

	public String getCtr() {
		return BigDecimalUtil.formatAsReadable(ctr);
	}

	public BigDecimal getCtrBigDecimal() {
		return ctr;
	}

	public void setCtr(String ctr) {

		// removing percentage symbol from the string
		if (ctr != null) {
			String replace = ctr.replace("%", "");
			this.ctr = BigDecimalUtil.parseFromNumberString(replace);
		}
	}

	public String getAvgCpm() {
		return BigDecimalUtil.formatAsReadable(avgCpm);
	}

	public BigDecimal getAvgCpmBigDecimal() {
		return avgCpm;
	}

	public void setAvgCpm(String avgCpm) {
		this.avgCpm = BigDecimalUtil.parseFromNumberString(avgCpm);
	}

	public String getAvgCpc() {
		return BigDecimalUtil.formatAsReadable(avgCpc);
	}

	public BigDecimal getAvgCpcBigDecimal() {
		return avgCpc;
	}

	public void setAvgCpc(String avgCpc) {
		this.avgCpc = new BigDecimal(avgCpc);
	}

	public String getAvgPosition() {
		return BigDecimalUtil.formatAsReadable(avgPosition);
	}

	public BigDecimal getAvgPositionBigDecimal() {
		return avgPosition;
	}

	public void setAvgPosition(String avgPosition) {
		this.avgPosition = new BigDecimal(avgPosition);
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getClickType() {
		return clickType;
	}

	public void setClickType(String clickType) {
		this.clickType = clickType;
	}

	public String getAdNetwork() {
		return adNetwork;
	}

	public void setAdNetwork(String adNetwork) {
		this.adNetwork = adNetwork;
	}

	public String getAdNetworkPartners() {
		return adNetworkPartners;
	}

	public void setAdNetworkPartners(String adNetworkPartners) {
		this.adNetworkPartners = adNetworkPartners;
	}

	@Override
	public String getDateStart() {
		return dateStart;
	}

	@Override
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	@Override
	public String getDateEnd() {
		return dateEnd;
	}

	@Override
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(Long conversionValue) {
		this.conversionValue = conversionValue;
	}

	public String getCostPerConversion1() {
		return costPerConversion1.toString();
	}

	public void setCostPerConversion1(BigDecimal costPerConversion1) {
		this.costPerConversion1 = costPerConversion1;
	}

	public void setCostPerConversion1(String costPerConversion1) {
		this.costPerConversion1 = BigDecimalUtil
				.parseFromNumberString(costPerConversion1);
	}

	public String getCostPerConversionMany() {
		return costPerConversionMany.toString();
	}

	public void setCostPerConversionMany(BigDecimal costPerConversionMany) {
		this.costPerConversionMany = costPerConversionMany;
	}

	public void setCostPerConversionMany(String costPerConversionMany) {
		this.costPerConversionMany = BigDecimalUtil
				.parseFromNumberString(costPerConversionMany);
	}

	public String getValuePerConversion1() {
		return BigDecimalUtil.formatAsReadable(valuePerConversion1);
	}

	public void setValuePerConversion1(BigDecimal valuePerConversion1) {
		this.valuePerConversion1 = valuePerConversion1;
	}

	public void setValuePerConversion1(String valuePerConversion1) {
		this.valuePerConversion1 = BigDecimalUtil
				.parseFromNumberString(valuePerConversion1);
	}

	public String getValuePerConversionMany() {
		return BigDecimalUtil.formatAsReadable(valuePerConversionMany);
	}

	public void setValuePerConversionMany(BigDecimal valuePerConversionMany) {
		this.valuePerConversionMany = valuePerConversionMany;
	}

	public void setValuePerConversionMany(String valuePerConversionMany) {
		this.valuePerConversionMany = BigDecimalUtil
				.parseFromNumberString(valuePerConversionMany);
	}

	public String getConversionRate1() {
		return BigDecimalUtil.formatAsReadable(conversionRate1);
	}

	public String getConversionRateMany() {
		return BigDecimalUtil.formatAsReadable(conversionRateMany);
	}

	public void setConversionRateMany(BigDecimal conversionRateMany) {
		this.conversionRateMany = conversionRateMany;
	}

	public void setConversionRateMany(String conversionRateMany) {
		this.conversionRateMany = BigDecimalUtil
				.parseFromNumberString(conversionRateMany);
	}

	public void setConversionRate1(BigDecimal conversionRate1) {
		this.conversionRate1 = conversionRate1;
	}

	public void setConversionRate1(String conversionRate1) {
		this.conversionRate1 = BigDecimalUtil
				.parseFromNumberString(conversionRate1);
	}

	public Long getConversionsManyPerClick() {
		return conversionsManyPerClick;
	}

	public void setConversionsManyPerClick(Long conversionsManyPerClick) {
		this.conversionsManyPerClick = conversionsManyPerClick;
	}
}
