package com.google.api.ads.adwords.jaxws.extensions.report.Services;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.ReportMode;

/**
 * Created by IntelliJ IDEA.
 * User: anurag.laddha
 * Date: 20/05/14
 * Time: 7:27 AM
 * To change this template use File | Settings | File Templates.
 */

public class ReportModeService {

    public static final String TABLENAMEPREFIX_ATTRIBUTE = "Attrib";
    public static final String TABLENAMEPREFIX_METRIC = "";

    private static ReportMode reportMode = ReportMode.METRIC;

    public static void setReportMode(String mode){

        if (mode != null){
            if (mode.equals(ReportMode.ATTRIBUTE.name())){
                reportMode = ReportMode.ATTRIBUTE;
            }
            else if (mode.equals(ReportMode.METRIC.name())){
                 reportMode = ReportMode.METRIC;
            }
        }
    }

    public static ReportMode getReportMode(){
        return reportMode;
    }

    public static String getTableNamePrefix(){
        String tableNamePrefix = "";

        if (reportMode != null){
            if (reportMode.equals(ReportMode.METRIC)){
                tableNamePrefix = TABLENAMEPREFIX_METRIC;
            }
            else if (reportMode.equals(ReportMode.ATTRIBUTE)){
                tableNamePrefix = TABLENAMEPREFIX_ATTRIBUTE;
            }
        }

        return tableNamePrefix;
    }

    public static boolean getIncludeZeroImpressions(){
        boolean includeZeroImpressions = false;

        if (reportMode != null){
            if (reportMode.equals(ReportMode.METRIC)){
                includeZeroImpressions = false;
            }
            else if (reportMode.equals(ReportMode.ATTRIBUTE)){
                includeZeroImpressions = true;
            }
        }
        return includeZeroImpressions;
    }

}
