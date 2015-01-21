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
 * Created by IntelliJ IDEA.
 * User: vignesh.raghuraman
 * Date: 23/12/14
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "AW_ReportProductPartition")
@CsvReport(value = ReportDefinitionReportType.PRODUCT_PARTITION_REPORT)
public class ReportProductPartition extends ReportBase {

  @Column(name = "PRODUCT_PARTITION_ID")
  @CsvField(value = "Criterion ID", reportField = "Id")
  @SerializedName("pid")
  private Long productPartitionId;

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  @SerializedName("cid")
  private Long campaignId;

  @Column(name = "ADGROUP_ID")
  @CsvField(value = "Ad group ID", reportField = "AdGroupId")
  @SerializedName("agid")
  private Long adGroupId;

  @Column(name = "PARENT_PARTITION_ID")
  @CsvField(value = "Parent Criterion ID", reportField = "ParentCriterionId")
  @SerializedName("ppid")
  private Long parentPartitionId;

  @Column(name = "MAX_CPC")
  @CsvField(value = "Max. CPC", reportField = "CpcBid")
  @SerializedName("mcpc")
  private BigDecimal maxCPC;

  @Column(name = "PARTITION_TYPE")
  @CsvField(value = "Partition Type", reportField = "PartitionType")
  @SerializedName("pt")
  private String partitionType;

  @Column(name = "BENCHMARK_AVG_MAX_CPC")
  @CsvField(value = "Benchmark Max. CPC", reportField = "BenchmarkAverageMaxCpc")
  @SerializedName("bcpc")
  private BigDecimal benchmarkAverageMaxCpc;

  @Column(name = "BENCHMARK_CTR")
  @CsvField(value = "Benchmark CTR", reportField = "BenchmarkCtr")
  @SerializedName("bctr")
  private BigDecimal benchmarkCtr;

  @Column(name = "SEARCH_IMPRESSION_SHARE")
  @CsvField(value = "Search Impr. share", reportField = "SearchImpressionShare")
  @SerializedName("sis")
  private BigDecimal searchImpressionShare;



  /**
   * Hibernate needs an empty constructor
   */
  public ReportProductPartition() {}

  public ReportProductPartition(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {
    // Generating unique _id after having accountId, campaignId, adGroupId and date
    if (this.getAccountId() != null && this.getCampaignId() != null &&
            this.getAdGroupId()!=null && this.getProductPartitionId()!=null) {
      this._id = this.getAccountId() + "-" + this.getCampaignId() +
            "-" + this.getAdGroupId() + "-" + this.getProductPartitionId();
    }

    this._id += setIdDates();

    if (this.getDevice() != null && this.getDevice().length() > 0) {
      this._id += "-" + this.getDevice();
    }

    if (this.getClickType() != null && this.getClickType().length() > 0) {
      this._id += "-" + this.getClickType();
    }

  }

    public Long getProductPartitionId() {
        return productPartitionId;
    }

    public void setProductPartitionId(Long productPartitionId) {
        this.productPartitionId = productPartitionId;
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

    public Long getParentPartitionId() {
        return parentPartitionId;
    }

    public void setParentPartitionId(Long parentPartitionId) {
        this.parentPartitionId = parentPartitionId;
    }

    public String getMaxCPC() {
		return BigDecimalUtil.formatAsReadable(maxCPC);
	}

    public BigDecimal getMaxCPCBigDecimal() {
        return maxCPC;
    }

    public void setMaxCPC(String maxCPC) {
		this.maxCPC = BigDecimalUtil.parseFromNumberString(maxCPC);
	}

    public void setMaxCPC(BigDecimal maxCPC) {
        this.maxCPC = maxCPC;
    }

    public String getPartitionType() {
        return partitionType;
    }

    public void setPartitionType(String partitionType) {
        this.partitionType = partitionType;
    }

    public String getBenchmarkAverageMaxCpc() {
		return BigDecimalUtil.formatAsReadable(benchmarkAverageMaxCpc);
	}

    public BigDecimal getBenchmarkAverageMaxCpcBigDecimal() {
        return benchmarkAverageMaxCpc;
    }

    public void setBenchmarkAverageMaxCpc(String benchmarkAverageMaxCpc) {
		this.benchmarkAverageMaxCpc = BigDecimalUtil.parseFromNumberString(benchmarkAverageMaxCpc);
	}

    public void setBenchmarkAverageMaxCpc(BigDecimal benchmarkAverageMaxCpc) {
        this.benchmarkAverageMaxCpc = benchmarkAverageMaxCpc;
    }

    public BigDecimal getBenchmarkCtrBigDecimal() {
        return benchmarkCtr;
    }

    public String getBenchmarkCtr() {
        return BigDecimalUtil.formatAsReadable(benchmarkCtr);
    }

    public void setBenchmarkCtr(String benchmarkCtr) {
        benchmarkCtr = benchmarkCtr.replaceAll("--","0");
        this.benchmarkCtr = new BigDecimal(benchmarkCtr.replaceAll(
        "\\s|%|>|<", ""));
    }

    public void setBenchmarkCtr(BigDecimal benchmarkCtr) {
        this.benchmarkCtr = benchmarkCtr;
    }

    public BigDecimal getSearchImpressionShareBigDecimal() {
        return searchImpressionShare;
    }

    public String getSearchImpressionShare() {
        return BigDecimalUtil.formatAsReadable(this.searchImpressionShare);
    }

    public void setSearchImpressionShare(String searchImpressionShare) {
        searchImpressionShare = searchImpressionShare.replaceAll("--", "0");
        this.searchImpressionShare = new BigDecimal(searchImpressionShare.replaceAll(
				"\\s|%|>|<", ""));
    }

    public void setSearchImpressionShare(BigDecimal searchImpressionShare) {
        this.searchImpressionShare = searchImpressionShare;
    }

}

