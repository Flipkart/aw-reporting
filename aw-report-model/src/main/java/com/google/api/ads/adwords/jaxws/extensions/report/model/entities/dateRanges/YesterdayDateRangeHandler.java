package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Handles the date range for the YESTERDAY type.
 * 
 * @author gustavomoreira
 */
public class YesterdayDateRangeHandler implements DateRangeHandler {

	@Override
	public DateTime retrieveDateStart(DateTime date) {
		return date.minusDays(1);
	}

	@Override
	public DateTime retrieveDateEnd(DateTime date) {
		return date.minusDays(1);
	}

	@Override
	public DateTime retrieveMonth(DateTime date) {
		return null;
	}

}
