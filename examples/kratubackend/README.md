# Kratu Backend

## Overview

KratuBackend is an AdWords account portfolio analysis tool, it analyzes more than 30 key signals to discover and prioritize opportunities for optimizations across large sets of AdWords accounts for all of our managed customers using as a Frontend UI the open source Kratu Project. It offers a Rest backend for the Kratu project over MongoDB/MySql and it reuses the project AwReporting.


## Quick Start 

### Prerequisites

KratuBackend can be compiled using Maven by executing the following on the command line: 

<code>$ mvn compile dependency:copy-dependencies package</code>

The project also needs aw-report-model and aw-reporting jars.


## Usage

<pre>

Download Reports:
<code>java -Xmx4G -jar kratubackend.jar -startDate YYYYMMDD -endDate YYYYMMDD -file &lt;file&gt;</code>
 
Process Kratus:
<code>java -Xmx4G -jar kratubackend.jar -processKratus -startDate YYYYMMDD -endDate YYYYMMDD -file &lt;file&gt;</code>

Start Rest Server:
<code>java -Xmx4G -jar kratubackend.jar -startServer -file -file &lt;file&gt;</code>

<code>Arguments:

 -dateRange <DateRangeType>   ReportDefinitionDateRangeType
 -endDate &lt;YYYMMDD&gt;     End date for CUSTOM_DATE Reports (YYYYMMDD)
 -file <file>                 aw-report-sample.properties file (./aw-report-sample.properties by default if not
                              provided)
 -help                        print this message
 -processKratus               Process Kratus processes the 7 reports peraccount and creates a daily Kratu
 -startDate &lt;YYYMMDD&gt;   Start date for CUSTOM_DATE Reports (YYYYMMDD)
 -startServer                 Starts the Rest Server. No dates required

</code>
</pre>

## Server

Index web page, with more information:
  http://localhost:8081/index.html

Kratu Report:
  http://localhost:8081/kratureport/index.html?dateStart=20130101&dateEnd=20130331

Genereate Reports:
  http://localhost:8081/generatereports/?dateStart=20130101&dateEnd=20130331

Genereate Kratus:
  http://localhost:8081/generatekratus/?dateStart=20130101&dateEnd=20130331

## DB Indexes for better performance

<pre>
<code>
ALTER TABLE  `AW_ReportAccount` ADD INDEX (  `ACCOUNT_ID` ,  `DAY` ) ;
ALTER TABLE  `AW_ReportAd` ADD INDEX (  `ACCOUNT_ID` ,  `DAY` ) ;
ALTER TABLE  `AW_ReportAdExtension` ADD INDEX (  `ACCOUNT_ID` ,  `DAY` ) ;
ALTER TABLE  `AW_ReportAdGroup` ADD INDEX (  `ACCOUNT_ID` ,  `DAY` ) ;
ALTER TABLE  `AW_ReportCampaign` ADD INDEX (  `ACCOUNT_ID` ,  `DAY` ) ;
ALTER TABLE  `AW_ReportKeyword` ADD INDEX (  `ACCOUNT_ID` ,  `DAY` ) ;

ALTER TABLE  `AW_Kratu` ADD INDEX (  `EXTERNAL_CUSTOMER_ID` ,  `DAY` ) ;
</code>
</pre>

### Fine print
Pull requests are very much appreciated. Please sign the [Google Code contributor license agreement](http://code.google.com/legal/individual-cla-v1.0.html) (There is a convenient online form) before submitting.

<dl>
  <dt>Authors</dt><dd><a href="https://plus.google.com/+JulianCToledo/">Julian Toledo (Google Inc.)</a></dd>
  <dt>Copyright</dt><dd>Copyright © 2013 Google, Inc.</dd>
  <dt>License</dt><dd>Apache 2.0</dd>
  <dt>Limitations</dt><dd>This is example software, use with caution under your own risk.</dd>
</dl>
