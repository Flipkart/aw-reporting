package com.google.api.ads.adwords.jaxws.extensions.kratu.data;

import com.google.api.ads.adwords.jaxws.extensions.AwReporting;
import com.google.api.ads.adwords.jaxws.extensions.report.model.util.DateUtil;

import java.util.Date;


public class RunnableReport implements Runnable {
 
  String file;
  Date dateStart;
  Date dateEnd;
  
  public RunnableReport(String file, Date dateStart, Date dateEnd) {
    super();
    this.file = file;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
  }

  public void run() {
    try {

      AwReporting.main(new String[]{"-file", file,
          "-startDate", DateUtil.formatYearMonthDayNoDash(dateStart),
          "-endDate", DateUtil.formatYearMonthDayNoDash(dateEnd)});

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
