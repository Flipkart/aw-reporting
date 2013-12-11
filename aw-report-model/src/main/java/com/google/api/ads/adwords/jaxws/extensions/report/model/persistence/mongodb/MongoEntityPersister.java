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

package com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.mongodb;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.Report;
import com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.DateUtil;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.GsonUtil;
import com.google.gson.Gson;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

/**
 * MongoDB implementation of NoSqlStorage
 *
 * @author jtoledo@google.com (Julian Toledo)
 */
public class MongoEntityPersister implements EntityPersister {

  private MongoClient mongoClient;
  private DB db;
  private Gson gson = GsonUtil.getGsonBuilder().create();

  protected MongoEntityPersister(String mongoConnectionUrl, String mongoDataBaseName)
      throws UnknownHostException, MongoException {
    mongoClient = new MongoClient(new MongoClientURI(mongoConnectionUrl));
    db = mongoClient.getDB(mongoDataBaseName);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, java.util.Map, int, int)
   */
  @Override
  public <T, V> List<T> get(Class<T> t, Map<String, V> keyValueList, int numToSkip, int limit) {
    DBCollection dbcollection;
    dbcollection = db.getCollection(t.getCanonicalName());

    BasicDBObject query = new BasicDBObject();
    if (keyValueList != null) {
      for (String key : keyValueList.keySet()) {
        query.put(key, keyValueList.get(key));
      }
    }
    DBCursor cur = dbcollection.find(query);

    if (limit > 0) {
      cur.limit(limit);
    }
    if (numToSkip > 0) {
      cur.skip(numToSkip);
    }

    List<T> list = new ArrayList<T>();
    while (cur.hasNext()) {
      DBObject dbObject = cur.next();
      list.add(gson.fromJson(com.mongodb.util.JSON.serialize(dbObject), t));
    }
    return list;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, java.util.Map)
   */
  @Override
  public <T, V> List<T> get(Class<T> t, Map<String, V> keyValueList) {
    return get(t, keyValueList, 0, 0);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, java.lang.String, java.lang.Object, int, int)
   */
  @Override
  public <T, V> List<T> get(Class<T> t, String key, V value, int numToSkip, int limit) {
    Map<String, V> keyValueList = new HashMap<String, V>();
    if (key != null && value != null) {
      keyValueList.put(key, value);
    }
    return get(t, keyValueList, numToSkip, limit);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, java.lang.String, java.lang.Object)
   */
  @Override
  public <T, V> List<T> get(Class<T> t, String key, V value) {
    return get(t, key, value, 0, 0);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class)
   */
  @Override
  public <T> List<T> get(Class<T> t) {
    return get(t, null, 0, 0);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, int, int)
   */
  @Override
  public <T> List<T> get(Class<T> t, int numToSkip, int limit) {
    return get(t, null, numToSkip, limit);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, java.lang.String, java.lang.Object, java.lang.String,
   *      java.util.Date, java.util.Date)
   */
  @Override
  public <T> List<T> get(Class<T> t,
      String key,
      Object value,
      String dateKey,
      Date dateStart,
      Date dateEnd) {
    return get(t, key, value, dateKey, dateStart, dateEnd, 0, 0);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #get(java.lang.Class, java.lang.String, java.lang.Object, java.lang.String,
   *      java.util.Date, java.util.Date, int, int)
   */
  @Override
  public <T> List<T> get(Class<T> t,
      String key,
      Object value,
      String dateKey,
      Date dateStart,
      Date dateEnd,
      int numToSkip,
      int limit) {
    Map<String, Object> keyValueList = new HashMap<String, Object>();
    if (key != null) {
      keyValueList.put(key, value);
    }
    if (dateKey != null && dateStart != null) {

      if (dateEnd == null) { // One day only
        keyValueList.put(dateKey, DateUtil.formatYearMonthDayNoDash(dateStart));
      } else { // All within the date range
        keyValueList.put(dateKey, BasicDBObjectBuilder.start(
            "$gte", DateUtil.formatYearMonthDayNoDash(dateStart))
            .add("$lte", DateUtil.formatYearMonthDayNoDash(dateEnd)).get());
      }
    }
    return get(t, keyValueList, numToSkip, limit);
  }


  @Override
  public <T> List<T> get(Class<T> t,
      String key,
      Object value,
      String dateKey,
      String dateStart,
      String dateEnd) {
    Map<String, Object> keyValueList = new HashMap<String, Object>();
    if (key != null) {
      keyValueList.put(key, value);
    }
    keyValueList.put(
        dateKey, BasicDBObjectBuilder.start("$gte", dateStart).add("$lte", dateEnd).get());
    return get(t, keyValueList);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #save(java.lang.Object)
   */
  @Override
  public <T> T save(T t) {
    T newT = null;
    if (t != null) {

      DBCollection dbcollection;
      if (db.collectionExists(t.getClass().getCanonicalName())) {
        dbcollection = db.getCollection(t.getClass().getCanonicalName());
      } else {
        dbcollection = db.createCollection(t.getClass().getCanonicalName(), new BasicDBObject());
      }

      String jsonObject;
      jsonObject = gson.toJson(t);
      DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(jsonObject.toString());
      dbObject.put("safe", "true");
      dbcollection.save(dbObject, WriteConcern.SAFE);
    }
    return newT;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #save(java.util.List)
   */
  @Override
  public <T> void save(List<T> listT) {
    if (listT != null && listT.size() > 0) {
      DBCollection dbcollection;
      for (T t : listT) {
        String classTName = t.getClass().getCanonicalName();

        if (db.collectionExists(classTName)) {
          dbcollection = db.getCollection(classTName);
        } else {
          dbcollection = db.createCollection(classTName, new BasicDBObject());
        }

        if (classTName.equals("model.adwords.ModelCampaign")) {
          System.out.println(classTName);
        }
        String jsonObject = gson.toJson(t);

        DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(jsonObject.toString());
        dbcollection.save(dbObject);
      }
    }
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #remove(java.lang.Object)
   */
  @Override
  public <T> void remove(T t) {
    if (t != null) {
      DBCollection dbcollection;
      if (db.collectionExists(t.getClass().getCanonicalName())) {
        dbcollection = db.getCollection(t.getClass().getCanonicalName());
      } else {
        dbcollection = db.createCollection(t.getClass().getCanonicalName(), new BasicDBObject());
      }

      String jsonObject = gson.toJson(t);
      DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(jsonObject.toString());
      dbcollection.remove(dbObject);
    }
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister
   *      #remove(java.util.Collection)
   */
  @Override
  public <T> void remove(Collection<T> listT) {
    if (listT != null && listT.size() > 0) {
      DBCollection dbcollection;
      for (T t : listT) {

        String classTName = t.getClass().getCanonicalName();
        if (db.collectionExists(classTName)) {
          dbcollection = db.getCollection(classTName);
        } else {
          dbcollection = db.createCollection(classTName, new BasicDBObject());
        }

        String jsonObject = gson.toJson(t);
        DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(jsonObject.toString());
        dbcollection.remove(dbObject);
      }
    }
  }

  /**
   * Adds a field as a DB index
   *
   * @param classT the entity T class
   */
  @Override
  public <T> void createIndex(Class<T> classT, String key) {
    DBCollection dbcollection = db.getCollection(classT.getCanonicalName());
    dbcollection.ensureIndex(new BasicDBObject(key, 1));
  }

  /**
   * Adds a list of fields as DB indexes
   *
   * @param classT the entity T class
   */
  @Override
  public <T> void createIndex(Class<T> classT, List<String> keys) {
    BasicDBObject dbObject = new BasicDBObject();
    if (keys != null) {
      for (String key : keys) {
        dbObject.put(key, 1);
      }
    }
    DBCollection dbcollection = db.getCollection(classT.getCanonicalName());
    dbcollection.ensureIndex(dbObject);
    List<DBObject> list = dbcollection.getIndexInfo();
    for (DBObject o : list) {
      System.out.println("index: " + o);
    }
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister#persistReportEntities(java.util.List)
   */
  @Override
  public void persistReportEntities(List<? extends Report> reportEntities) {

    this.save(reportEntities);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister#listReports(java.lang.Class)
   */
  @Override
  public <T extends Report> List<T> listReports(Class<T> clazz) {

    return this.get(clazz);
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.EntityPersister#removeReportEntities(java.util.Collection)
   */
  @Override
  public void removeReportEntities(Collection<? extends Report> reportEntities) {

    this.remove(reportEntities);
  }

  /**
   *
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.
   *      EntityPersister#listMonthReports(Class, long, DateTime, DateTime)
   */
  @Override
  public List<? extends Report> listMonthReports(
      Class<? extends Report> clazz, long accountId, DateTime startDate, DateTime endDate) {
    return null;
  }

  /**
   * @see com.google.api.ads.adwords.jaxws.extensions.report.model.persistence.
   *      EntityPersister#listMonthReports(Class, long, DateTime, DateTime, int, int)
   */
  @Override
  public List<? extends Report> listMonthReports(Class<? extends Report> clazz,
      long accountId,
      DateTime startDate,
      DateTime endDate,
      int page,
      int amount) {
    return null;
  }
}
