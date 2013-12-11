package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Handles the date range for the TODAY type.
 * 
 * @author gustavomoreira
 */
public class TodayDateRangeHandler implements DateRangeHandler {

	@Override
	public DateTime retrieveDateStart(DateTime date) {
		return date;
	}

	@Override
	public DateTime retrieveDateEnd(DateTime date) {
		return date;
	}

	@Override
	public DateTime retrieveMonth(DateTime date) {
		return null;
	}

}
