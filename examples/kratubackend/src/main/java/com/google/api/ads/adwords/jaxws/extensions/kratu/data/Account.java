//Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.jaxws.extensions.kratu.data;

import com.google.api.ads.adwords.jaxws.v201309.mcm.ManagedCustomer;
import com.google.common.collect.Lists;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account
 * 
 * @author jtoledo@google.com (Julian Toledo)
 */
@Entity
@Table(name = "AW_Account")
public class Account {

  public static final String __id = "_id";

  @Id
  @Column(name = "ID")
  private String _id;

  @Column(name = "EXTERNAL_CUSTOMER_ID")
  private Long externalCustomerId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CURRENCY_CODE")
  private String currencyCode;

  @Column(name = "DATE_TIME_ZONE")
  private String dateTimeZone;

  @Column(name = "IS_CAN_MANAGE_CLIENTS")
  private Boolean isCanManageClients;
  
  /**
   * C'tor to satisfy Hibernate.
   */
  public Account() {
  }

  Account(ManagedCustomer managedCustomer) {
    _id = String.valueOf(managedCustomer.getCustomerId());
    externalCustomerId = managedCustomer.getCustomerId();
    name = managedCustomer.getName();
    currencyCode = managedCustomer.getCurrencyCode();
    dateTimeZone = managedCustomer.getDateTimeZone();
    isCanManageClients = managedCustomer.isCanManageClients();
  }

  public static List<Account> fromList(List<ManagedCustomer> list) {
    List<Account> returnList = Lists.newArrayList();
    for (ManagedCustomer managedCustomer : list) {
      returnList.add(new Account(managedCustomer));
    }
    return returnList;
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public Long getExternalCustomerId() {
    return externalCustomerId;
  }

  public void setExternalCustomerId(Long externalCustomerId) {
    this.externalCustomerId = externalCustomerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public String getDateTimeZone() {
    return dateTimeZone;
  }

  public void setDateTimeZone(String dateTimeZone) {
    this.dateTimeZone = dateTimeZone;
  }

  public Boolean getIsCanManageClients() {
    return isCanManageClients;
  }

  public void setIsCanManageClients(Boolean isCanManageClients) {
    this.isCanManageClients = isCanManageClients;
  }
}