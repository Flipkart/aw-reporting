package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.dateRanges;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.ThisMonthDateRangeHandler;

/**
 * @author gustavomoreira
 */
public class ThisMonthDateRangeHandlerTest {

	@Test
	public void testDateRetrieving() {

		DateTime date = new DateTime(2013, 10, 2, 12, 0);

		ThisMonthDateRangeHandler handler = new ThisMonthDateRangeHandler();

		DateTime dateStart = handler.retrieveDateStart(date);
		Assert.assertEquals(2013, dateStart.getYear());
		Assert.assertEquals(10, dateStart.getMonthOfYear());
		Assert.assertEquals(1, dateStart.getDayOfMonth());

		DateTime dateEnd = handler.retrieveDateEnd(date);
		Assert.assertEquals(2013, dateEnd.getYear());
		Assert.assertEquals(10, dateEnd.getMonthOfYear());
		Assert.assertEquals(31, dateEnd.getDayOfMonth());

		DateTime dateMonth = handler.retrieveMonth(date);
		Assert.assertEquals(2013, dateMonth.getYear());
		Assert.assertEquals(10, dateMonth.getMonthOfYear());
	}

}
