package com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges;

import org.joda.time.DateTime;

/**
 * Interface to handle the different types of date range.
 * 
 * @author gustavomoreira
 */
public interface DateRangeHandler {

	/**
	 * Retrieves the starting date for the type of date range
	 * 
	 * @param date
	 *            the date to convert
	 * @return the starting date
	 */
	DateTime retrieveDateStart(DateTime date);

	/**
	 * Retrieves the ending date for the type of date range
	 * 
	 * @param date
	 *            the date to convert
	 * @return the ending date
	 */
	DateTime retrieveDateEnd(DateTime date);

	/**
	 * Retrieves the month (if applicable) for the date range type
	 * 
	 * @param date
	 *            the date to convert
	 * @return the month
	 */
	DateTime retrieveMonth(DateTime date);

}
