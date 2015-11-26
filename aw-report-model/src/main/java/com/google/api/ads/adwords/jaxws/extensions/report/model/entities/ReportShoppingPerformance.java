package com.google.api.ads.adwords.jaxws.extensions.report.model.entities;

import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvField;
import com.google.api.ads.adwords.jaxws.extensions.report.model.csv.annotation.CsvReport;
import com.google.api.ads.adwords.lib.jaxb.v201506.ReportDefinitionReportType;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: vignesh.raghuraman
 * Date: 23/12/14
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "AW_ReportShoppingPerformance")
@CsvReport(value = ReportDefinitionReportType.SHOPPING_PERFORMANCE_REPORT)
public class ReportShoppingPerformance extends ReportBase {

  @Column(name = "CAMPAIGN_ID")
  @CsvField(value = "Campaign ID", reportField = "CampaignId")
  @SerializedName("cid")

  private Long campaignId;

  @Column(name = "ADGROUP_ID")
  @CsvField(value = "Ad group ID", reportField = "AdGroupId")
  @SerializedName("agid")
  private Long adGroupId;

  @Column(name = "ITEM_ID")
  @CsvField(value = "Item Id", reportField = "OfferId")
  @SerializedName("itid")
  private String itemId;

  @Column(name = "GMC_ACCOUNT_ID")
  @CsvField(value = "MCA Id", reportField = "AggregatorId")
  @SerializedName("mcaid")
  private String mcaId;

  @Column(name = "MERCHANT_ACCOUNT_ID")
  @CsvField(value = "MC Id", reportField = "MerchantId")
  @SerializedName("mcid")
  private String mcId;

  @Column(name = "BRAND")
  @CsvField(value = "Brand", reportField = "Brand")
  @SerializedName("br")
  private String brand;

  @Column(name = "CATEGORY_L1")
  @CsvField(value = "Category (1st level)", reportField = "CategoryL1")
  @SerializedName("catl1")
  private String categoryL1;

  @Column(name = "CATEGORY_L2")
  @CsvField(value = "Category (2nd level)", reportField = "CategoryL2")
  @SerializedName("catl2")
  private String categoryL2;

  @Column(name = "CATEGORY_L3")
  @CsvField(value = "Category (3rd level)", reportField = "CategoryL3")
  @SerializedName("catl3")
  private String categoryL3;

  @Column(name = "CATEGORY_L4")
  @CsvField(value = "Category (4th level)", reportField = "CategoryL4")
  @SerializedName("catl4")
  private String categoryL4;

  @Column(name = "CATEGORY_L5")
  @CsvField(value = "Category (5th level)", reportField = "CategoryL5")
  @SerializedName("catl5")
  private String categoryL5;

  @Column(name = "CUSTOM_ATTRIBUTE_0")
  @CsvField(value = "Custom label 0", reportField = "CustomAttribute0")
  @SerializedName("ca0")
  private String customAttribute0;

  @Column(name = "CUSTOM_ATTRIBUTE_1")
  @CsvField(value = "Custom label 1", reportField = "CustomAttribute1")
  @SerializedName("ca1")
  private String customAttribute1;

  @Column(name = "CUSTOM_ATTRIBUTE_2")
  @CsvField(value = "Custom label 2", reportField = "CustomAttribute2")
  @SerializedName("ca2")
  private String customAttribute2;

  @Column(name = "CUSTOM_ATTRIBUTE_3")
  @CsvField(value = "Custom label 3", reportField = "CustomAttribute3")
  @SerializedName("ca3")
  private String customAttribute3;

  @Column(name = "CUSTOM_ATTRIBUTE_4")
  @CsvField(value = "Custom label 4", reportField = "CustomAttribute4")
  @SerializedName("ca4")
  private String customAttribute4;

  @Column(name = "PRODUCT_TYPE_L1")
  @CsvField(value = "Product type (1st level)", reportField = "ProductTypeL1")
  @SerializedName("pt1")
  private String productTypeL1;

  @Column(name = "PRODUCT_TYPE_L2")
  @CsvField(value = "Product type (2nd level)", reportField = "ProductTypeL2")
  @SerializedName("pt2")
  private String productTypeL2;

  @Column(name = "PRODUCT_TYPE_L3")
  @CsvField(value = "Product type (3rd level)", reportField = "ProductTypeL3")
  @SerializedName("pt3")
  private String productTypeL3;

  @Column(name = "PRODUCT_TYPE_L4")
  @CsvField(value = "Product type (4th level)", reportField = "ProductTypeL4")
  @SerializedName("pt4")
  private String productTypeL4;

  @Column(name = "PRODUCT_TYPE_L5")
  @CsvField(value = "Product type (5th level)", reportField = "ProductTypeL5")
  @SerializedName("pt5")
  private String productTypeL5;

  /**
   * Hibernate needs an empty constructor
   */
  public ReportShoppingPerformance() {}

  public ReportShoppingPerformance(Long topAccountId, Long accountId) {
    this.topAccountId = topAccountId;
    this.accountId = accountId;
  }

  @Override
  public void setId() {
    // Generating unique _id after having accountId, campaignId, adGroupId and date
    if (this.getAccountId() != null && this.getCampaignId() != null &&
            this.getAdGroupId()!=null && this.getItemId()!=null &&
            this.getMcId()!=null && this.getMcaId()!=null) {
      this._id = this.getAccountId() + "-" + this.getCampaignId() +
            "-" + this.getAdGroupId() + "-" + this.getMcId() +
              "-" + this.getMcaId() + "-" + this.getItemId();
    }

    this._id += setIdDates();

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMcaId() {
        return mcaId;
    }

    public void setMcaId(String mcaId) {
        this.mcaId = mcaId;
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategoryL1() {
        return categoryL1;
    }

    public void setCategoryL1(String categoryL1) {
        this.categoryL1 = categoryL1;
    }

    public String getCategoryL2() {
        return categoryL2;
    }

    public void setCategoryL2(String categoryL2) {
        this.categoryL2 = categoryL2;
    }

    public String getCategoryL3() {
        return categoryL3;
    }

    public void setCategoryL3(String categoryL3) {
        this.categoryL3 = categoryL3;
    }

    public String getCategoryL4() {
        return categoryL4;
    }

    public void setCategoryL4(String categoryL4) {
        this.categoryL4 = categoryL4;
    }

    public String getCategoryL5() {
        return categoryL5;
    }

    public void setCategoryL5(String categoryL5) {
        this.categoryL5 = categoryL5;
    }

    public String getCustomAttribute0() {
        return customAttribute0;
    }

    public void setCustomAttribute0(String customAttribute0) {
        this.customAttribute0 = customAttribute0;
    }

    public String getCustomAttribute1() {
        return customAttribute1;
    }

    public void setCustomAttribute1(String customAttribute1) {
        this.customAttribute1 = customAttribute1;
    }

    public String getCustomAttribute2() {
        return customAttribute2;
    }

    public void setCustomAttribute2(String customAttribute2) {
        this.customAttribute2 = customAttribute2;
    }

    public String getCustomAttribute3() {
        return customAttribute3;
    }

    public void setCustomAttribute3(String customAttribute3) {
        this.customAttribute3 = customAttribute3;
    }

    public String getCustomAttribute4() {
        return customAttribute4;
    }

    public void setCustomAttribute4(String customAttribute4) {
        this.customAttribute4 = customAttribute4;
    }

    public String getProductTypeL1() {
        return productTypeL1;
    }

    public void setProductTypeL1(String productTypeL1) {
        this.productTypeL1 = productTypeL1;
    }

    public String getProductTypeL2() {
        return productTypeL2;
    }

    public void setProductTypeL2(String productTypeL2) {
        this.productTypeL2 = productTypeL2;
    }

    public String getProductTypeL3() {
        return productTypeL3;
    }

    public void setProductTypeL3(String productTypeL3) {
        this.productTypeL3 = productTypeL3;
    }

    public String getProductTypeL4() {
        return productTypeL4;
    }

    public void setProductTypeL4(String productTypeL4) {
        this.productTypeL4 = productTypeL4;
    }

    public String getProductTypeL5() {
        return productTypeL5;
    }

    public void setProductTypeL5(String productTypeL5) {
        this.productTypeL5 = productTypeL5;
    }

}

