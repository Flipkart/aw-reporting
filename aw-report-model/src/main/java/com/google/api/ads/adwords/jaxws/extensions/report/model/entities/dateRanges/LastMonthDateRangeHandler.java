package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Handles the date range for the LAST_MONTH type.
 * 
 * @author gustavomoreira
 */
public class LastMonthDateRangeHandler implements DateRangeHandler {

	@Override
	public DateTime retrieveDateStart(DateTime date) {
		DateTime minusMonth = date.minusMonths(1);
		return new DateTime(minusMonth.getYear(), minusMonth.getMonthOfYear(),
				1, 12, 0);
	}

	@Override
	public DateTime retrieveDateEnd(DateTime date) {
		DateTime sameDate = new DateTime(date.getYear(), date.getMonthOfYear(),
				1, 12, 0);
		return sameDate.minusDays(1);
	}

	@Override
	public DateTime retrieveMonth(DateTime date) {
		return date.minusMonths(1);
	}

}
