// Copyright 2013 Google Inc. All Rights Reserved.
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

package com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.sql;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report;
import com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the basic implementation of the persistence layer to communicate with a SQL data base.
 *
 * The communication is done using a generic {@link SessionFactory}, which allows this
 * implementation to talk to other data bases easily, but the intention is to specialize this class
 * to communicate in the best way possible to a SQL data base, so don't count in the use of the
 * {@code SessionFactory} when implementing your client class.
 *
 * @author gustavomoreira@google.com (Gustavo Moreira)
 */
@Component
@Qualifier("sqlEntitiesPersister")
public class SqlReportEntitiesPersister implements EntityPersister {

  private static final int BATCH_SIZE = 50;

  private SessionFactory sessionFactory;

  /**
   * C'tor
   *
   * @param sessionFactory the session factory to communicate with the DB
   */
  @Autowired
  public SqlReportEntitiesPersister(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * Persists all the given entities into the DB configured in the {@code SessionFactory}
   */
  @Override
  @Transactional
  public void persistReportEntities(List<? extends Report> reportEntities) {

    int batchFlush = 0;

    Session session = this.sessionFactory.getCurrentSession();

    for (Report report : reportEntities) {
      report.setId();
      session.saveOrUpdate(report);
      batchFlush++;

      if (batchFlush == BATCH_SIZE) {
        session.flush();
        session.clear();
      }
    }
  }

  /**
   * Lists all the report entities persisted so far.
   *
   * Note that there is no pagination, so be careful when invoking this method.
   */
  @Override
  @Transactional
  @SuppressWarnings("unchecked")
  public <T extends Report> List<T> listReports(Class<T> clazz) {

    Criteria criteria = createCriteria(clazz);

    return criteria.list();
  }

  /**
   * Creates a new criteria for the current session
   *
   * @param clazz the class of the entity
   * @return the criteria for the current session
   */
  private <T> Criteria createCriteria(Class<T> clazz) {

    Session session = this.sessionFactory.getCurrentSession();
    return session.createCriteria(clazz);
  }

  /**
   * Remove all the entities given in the {@code Collection}, that will be found in the DB.
   */
  @Override
  @Transactional
  public void removeReportEntities(Collection<? extends Report> reportEntities) {

    Session session = this.sessionFactory.getCurrentSession();

    for (Report report : reportEntities) {
      session.delete(report);
    }
  }

  /**
   * Create a paginated query
   *
   * @param clazz the entity class
   * @param numToSkip the first result
   * @param limit the max number of results
   * @return the list of results
   */
  private <T> Criteria createPaginatedCriteria(Class<T> clazz, int numToSkip, int limit) {

    Criteria criteria = this.createCriteria(clazz);
    criteria.setFirstResult(numToSkip);
    criteria.setMaxResults(limit);
    return criteria;
  }

  /**
   * Gets the entity list for the given report class.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T> List<T> get(Class<T> clazz) {

    Criteria criteria = this.createCriteria(clazz);
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class.
   *
   * @param clazz the report class
   * @param numToSkip the number to begin pagination
   * @param limit the number to limit the pagination
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T> List<T> get(Class<T> clazz, int numToSkip, int limit) {

    Criteria criteria = this.createPaginatedCriteria(clazz, numToSkip, limit);
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and with the given value.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T, V> List<T> get(Class<T> clazz, String key, V value) {

    Criteria criteria = this.createCriteria(clazz);
    criteria.add(Restrictions.eq(key, value));
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and with the given value.
   *
   * @param clazz the report class
   * @param key the name of the property
   * @param value the value for the property
   * @param numToSkip the number to begin pagination
   * @param limit the number to be paginated
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T, V> List<T> get(Class<T> clazz, String key, V value, int numToSkip, int limit) {

    Criteria criteria = this.createPaginatedCriteria(clazz, numToSkip, limit);
    criteria.add(Restrictions.eq(key, value));
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and with the given date range.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T> List<T> get(Class<T> clazz,
      String key,
      Object value,
      String dateKey,
      Date dateStart,
      Date dateEnd) {

    Criteria criteria = this.createCriteria(clazz);
    if (key != null) {
      criteria.add(Restrictions.eq(key, value));
    }
    criteria.add(Restrictions.ge(dateKey, dateStart));
    criteria.add(Restrictions.le(dateKey, dateEnd));
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and key the given range.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T> List<T> get(Class<T> clazz,
      String key,
      Object value,
      String dateKey,
      String dateStart,
      String dateEnd) {

    Criteria criteria = this.createCriteria(clazz);
    if (key != null) {
      criteria.add(Restrictions.eq(key, value));
    }
    criteria.add(Restrictions.ge(dateKey, dateStart));
    criteria.add(Restrictions.le(dateKey, dateEnd));
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and with the given date range.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T> List<T> get(Class<T> clazz,
      String key,
      Object value,
      String dateKey,
      Date dateStart,
      Date dateEnd,
      int numToSkip,
      int limit) {

    Criteria criteria = this.createPaginatedCriteria(clazz, numToSkip, limit);
    criteria.add(Restrictions.eq(key, value));
    criteria.add(Restrictions.ge(dateKey, dateStart));
    criteria.add(Restrictions.le(dateKey, dateEnd));
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and with the given map of values.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T, V> List<T> get(Class<T> clazz, Map<String, V> keyValueList) {

    Criteria criteria = this.createCriteria(clazz);
    for (Entry<String, V> entry : keyValueList.entrySet()) {
      criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
    }
    return criteria.list();
  }

  /**
   * Gets the entity list for the given report class and with the given map of values.
   */
  @Override
  @Transactional(readOnly = true)
  @SuppressWarnings("unchecked")
  public <T, V> List<T> get(Class<T> clazz, Map<String, V> keyValueList, int numToSkip, int limit) {

    Criteria criteria = this.createPaginatedCriteria(clazz, numToSkip, limit);
    for (Entry<String, V> entry : keyValueList.entrySet()) {
      criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
    }
    return criteria.list();
  }

  /**
   * Removes the report entity.
   */
  @Override
  @Transactional
  public <T> void remove(T t) {

    Session session = this.sessionFactory.getCurrentSession();
    session.delete(t);
  }

  /**
   * Removes the report entity list.
   */
  @Override
  @Transactional
  public <T> void remove(Collection<T> listT) {

    Session session = this.sessionFactory.getCurrentSession();
    for (T t : listT) {
      session.delete(t);
    }
  }

  /**
   * No effect on SQL.
   */
  @Override
  public <T> void createIndex(Class<T> t, String key) {
    // does nothing
  }

  /**
   * No effect on SQL.
   */
  @Override
  public <T> void createIndex(Class<T> t, List<String> keys) {
    // does nothing
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #save(com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report)
   */
  @Override
  @Transactional
  public <T> T save(T t) {

    Session session = this.sessionFactory.getCurrentSession();
    session.saveOrUpdate(t);
    return t;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #save(java.util.List)
   */
  @Override
  @Transactional
  public <T> void save(List<T> reports) {

    Session session = this.sessionFactory.getCurrentSession();
    for (T report : reports) {
      session.saveOrUpdate(report);
    }
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #listMonthReports(Class, long, DateTime, DateTime)
   */
  @Override
  @Transactional
  public List<? extends Report> listMonthReports(
      Class<? extends Report> clazz, long accountId, DateTime startDate, DateTime endDate) {

    Criteria criteria = this.createCriteria(clazz);

    return this.listMonthReportsForCriteria(accountId, startDate, endDate, criteria);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.
   *      EntityPersister#listMonthReports(Class, long, DateTime, DateTime, int, int)
   */
  @Override
  @Transactional
  public List<? extends Report> listMonthReports(Class<? extends Report> clazz,
      long accountId,
      DateTime startDate,
      DateTime endDate,
      int page,
      int amount) {

    Criteria criteria = this.createPaginatedCriteria(clazz, page, amount);

    return this.listMonthReportsForCriteria(accountId, startDate, endDate, criteria);
  }

  /**
   * @param startDate the start date
   * @param endDate the end date
   * @param criteria the criteria
   * @return the list of reports grouped by month
   */
  @SuppressWarnings("unchecked")
  private List<? extends Report> listMonthReportsForCriteria(
      long accountId, DateTime startDate, DateTime endDate, Criteria criteria) {
    criteria.add(Restrictions.isNull("day"));
    criteria.add(Restrictions.isNotNull("month"));
    criteria.add(Restrictions.eq("accountId", accountId));
    criteria.addOrder(Order.asc("month"));
    if (startDate != null) {
      criteria.add(Restrictions.ge("month", startDate.toDate()));
    }
    if (endDate != null) {
      criteria.add(Restrictions.le("month", endDate.toDate()));
    }
    return criteria.list();
  }
}
