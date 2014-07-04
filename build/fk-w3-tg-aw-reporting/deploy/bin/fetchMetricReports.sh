#!/bin/bash

LOG_DIR=/var/log/flipkart/w3/_PACKAGE_
CONF_FILE=/etc/_PACKAGE_/conf/aw-report-metric.properties
JAR_FILE=/usr/share/_PACKAGE_/lib/aw-reporting.jar
ACCOUNTS_FILE=/etc/_PACKAGE_/conf/accounts

JAVA_OPTS=""

## GC settings
JAVA_OPTS="$JAVA_OPTS -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+CMSClassUnloadingEnabled -XX:SoftRefLRUPolicyMSPerMB=300"

## GC logging
JAVA_OPTS="$JAVA_OPTS -XX:+PrintCommandLineFlags -verbose:gc -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -Xloggc:$LOG_DIR/gc.log"

## Memory settings
JAVA_OPTS="$JAVA_OPTS -Xmn512M -Xms2048M -Xmx4096M -XX:PermSize=256M -XX:MaxPermSize=512M -XX:NewSize=1024M -XX:MaxNewSize=1024M -XX:SurvivorRatio=6"

## Encoding
JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF-8"

##JMX
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=8896 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote=true"

exec java -jar $JAVA_OPTS $JAR_FILE -dateRange LAST_14_DAYS -file $CONF_FILE -accountIdsFile $ACCOUNTS_FILE
