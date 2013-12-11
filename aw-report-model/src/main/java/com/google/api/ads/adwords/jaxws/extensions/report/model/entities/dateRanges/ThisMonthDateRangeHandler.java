package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Handles the date range for the THIS_MONTH type.
 * 
 * @author gustavomoreira
 */
public class ThisMonthDateRangeHandler implements DateRangeHandler {

	@Override
	public DateTime retrieveDateStart(DateTime date) {
		return new DateTime(date.getYear(), date.getMonthOfYear(), 1, 12, 0);
	}

	@Override
	public DateTime retrieveDateEnd(DateTime date) {
		DateTime plusMonth = date.plusMonths(1);
		plusMonth = new DateTime(plusMonth.getYear(),
				plusMonth.getMonthOfYear(), 1, 12, 0);
		return plusMonth.minusDays(1);
	}

	@Override
	public DateTime retrieveMonth(DateTime date) {
		return date;
	}

}
