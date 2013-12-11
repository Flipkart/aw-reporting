package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Handles the date range for the LAST_WEEK type.
 * 
 * @author gustavomoreira
 */
public class LastWeekDateRangeHandler implements DateRangeHandler {

	@Override
	public DateTime retrieveDateStart(DateTime date) {
		return date.minusWeeks(1).minusDays(date.getDayOfWeek() - 1);
	}

	@Override
	public DateTime retrieveDateEnd(DateTime date) {
		return date.minusWeeks(1).plusDays(7 - date.getDayOfWeek());
	}

	@Override
	public DateTime retrieveMonth(DateTime date) {
		return null;
	}

}
