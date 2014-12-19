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
import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.*;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.BigDecimalUtil;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.DateUtil;
import com.google.api.ads.adwords.lib.jaxb.v201406.ReportDefinitionDateRangeType;
import com.google.api.client.util.Maps;
import com.google.gson.annotations.SerializedName;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

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

    private static final String REPORT_TYPE_METRIC ="M";
    private static final String REPORT_TYPE_ATTRIBUTE ="A";

	@Column(name = "DAY")
	@CsvField(value = "Day", reportField = "Date")
	@SerializedName("d")
	protected Date day;

	@Column(name = "HOUR_OF_DAY")
	@CsvField(value = "Hour of day", reportField = "HourOfDay")
	@SerializedName("hr")
	protected String hourOfDay;

	@Column(name = "COST")
	@CsvField(value = "Cost", reportField = "Cost")
	@SerializedName("c")
	protected BigDecimal cost;

	@Column(name = "CLICKS")
	@CsvField(value = "Clicks", reportField = "Clicks")
	@SerializedName("cl")
	protected Long clicks;

	@Column(name = "IMPRESSIONS")
	@CsvField(value = "Impressions", reportField = "Impressions")
	@SerializedName("i")
	protected Long impressions;

	@Column(name = "CTR")
	@CsvField(value = "CTR", reportField = "Ctr")
	@SerializedName("ctr")
	protected BigDecimal ctr;

	@Column(name = "AVERAGE_CPM")
	@CsvField(value = "Avg. CPM", reportField = "AverageCpm")
	@SerializedName("acpm")
	protected BigDecimal avgCpm;

	@Column(name = "AVERAGE_CPC")
	@CsvField(value = "Avg. CPC", reportField = "AverageCpc")
	@SerializedName("acpc")
	protected BigDecimal avgCpc;

	@Column(name = "AVERAGE_POSITION")
	@CsvField(value = "Avg. position", reportField = "AveragePosition")
	@SerializedName("apos")
	protected BigDecimal avgPosition;

	@Column(name = "DEVICE", length = 64)
	@CsvField(value = "Device", reportField = "Device")
	@SerializedName("dev")
	protected String device;

	@Column(name = "CLICK_TYPE", length = 64)
	@CsvField(value = "Click type", reportField = "ClickType")
	@SerializedName("ct")
	protected String clickType;

	@Column(name = "NETWORK", length = 32)
	@CsvField(value = "Network", reportField = "AdNetworkType1")
	@SerializedName("nw")
	protected String adNetwork;

	@Column(name = "NETWORK_PARTNERS", length = 32)
	@CsvField(value = "Network (with search partners)", reportField = "AdNetworkType2")
	@SerializedName("np")
	protected String adNetworkPartners;

    // One Per Click
    @Column(name = "CONVERSIONS")
	@CsvField(value = "Converted clicks", reportField = "Conversions")
	@SerializedName("conv")
	protected Long conversions = 0L;

    // Many Per Click
	@Column(name = "CONVERSIONSMANYPERCLICK")
    @CsvField(value = "Conversions", reportField = "ConversionsManyPerClick")
	@SerializedName("convm")
	protected Long conversionsManyPerClick = 0L;

	@Column(name = "CONVERSION_VALUE")
	@CsvField(value = "Total conv. value", reportField = "ConversionValue")
	@SerializedName("cv")
	protected BigDecimal conversionValue;

	@Column(name = "VIEWTHROUGHCONVERSIONS")
	@CsvField(value = "View-through conv.", reportField = "ViewThroughConversions")
	@SerializedName("vtc")
	protected Long viewThroughConversions = 0L;

    @Column(name = "REPORT_TYPE", length=1)
    @SerializedName("rt")
    protected String reportType = REPORT_TYPE_METRIC;

    @Column(name = "PROCESSING_STATUS", length=1)
    @SerializedName("pst")
    protected String ingestionStatus = null;

    @Column(name = "PROCESSING_TIME")
    @SerializedName("pt")
    protected Date ingestionProcessingTime;

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
        setReportType();
	}

	public ReportBase(Long topAccountId, Long accountId) {
		this.topAccountId = topAccountId;
		this.accountId = accountId;
		timestamp = new DateTime().toDate();
        setReportType();
	}

    private void setReportType(){
        ReportMode mode = ReportModeService.getReportMode();

        if (mode.equals(ReportMode.ATTRIBUTE)){
            reportType = REPORT_TYPE_ATTRIBUTE;
        }
        else if (mode.equals(ReportMode.METRIC)){
            reportType = REPORT_TYPE_METRIC;
        }
    }

	@Override
	public abstract void setId();

	@Override
	public String setIdDates() {

        ReportMode mode = ReportModeService.getReportMode();

        //this is for ATTRIBUTE reports
        if(mode.equals(ReportMode.ATTRIBUTE) && this.getLastUpdatedTimeStamp() != null){
            return "-" + this.getLastUpdatedTimeStamp().toString();
        }

		// Day or Month
		String reportDay = this.getDay();
        if (reportDay != null) {
			return "-"
					+ reportDay.replaceAll("-", "")
					+ (this.getHourOfDay() != null ? ("-" + this.getHourOfDay())
							: "")
                    + (this.getSnapshotDay() != null ? ("-" + this.getSnapshotDay())
							: "");
		}

		if (this.getDateRangeType() != null) {

			DateRangeHandler handler = dateRangeHandlers.get(this
					.getDateRangeType());
			if (handler != null) {
				this.setDateStart(DateUtil.formatYearMonthDay(handler
						.retrieveDateStart(DateTime.now())));
				this.setDateEnd(DateUtil.formatYearMonthDay(handler
						.retrieveDateEnd(DateTime.now())));
			}
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

	public String getHourOfDay() {
		return hourOfDay;
	}

	public void setHourOfDay(String hourOfDay) {
		this.hourOfDay = hourOfDay;
	}

	@Override
	public String getDateRangeType() {
		return dateRangeType;
	}

	@Override
	public void setDateRangeType(String dateRangeType) {
		//If report is segmented by day then dateRangeType is not significant
        if(this.getDay() != null)
        {
			this.dateRangeType = null;
        } else {
			this.dateRangeType = dateRangeType;
        }
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

	public String getConversionValue() {
		return BigDecimalUtil.formatAsReadable(conversionValue);
	}

	public void setConversionValue(String conversionValue) {
		this.conversionValue = BigDecimalUtil
				.parseFromNumberString(conversionValue);
	}

	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}

	public Long getConversionsManyPerClick() {
		return conversionsManyPerClick;
	}

	public void setConversionsManyPerClick(Long conversionsManyPerClick) {
		this.conversionsManyPerClick = conversionsManyPerClick;
	}

	public Long getViewThroughConversions() {
		return viewThroughConversions;
	}

	public void setViewThroughConversions(Long viewThroughConversions) {
		this.viewThroughConversions = viewThroughConversions;
	}

    public String getReportType() {
        return reportType;
    }
}
