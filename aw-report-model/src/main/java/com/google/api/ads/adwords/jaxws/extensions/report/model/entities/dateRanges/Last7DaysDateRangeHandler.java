package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Handles the date range for the LAST_7_DAYS type.
 * 
 * @author gustavomoreira
 */
public class Last7DaysDateRangeHandler implements DateRangeHandler {

	@Override
	public DateTime retrieveDateStart(DateTime date) {
		return date.minusDays(7);
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
