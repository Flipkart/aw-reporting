package com.google.api.ads.adwords.jaxws.extensions.report.model.definitions.dateRanges;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.api.ads.adwords.jaxws.extensions.report.model.entities.dateRanges.YesterdayDateRangeHandler;

/**
 * @author gustavomoreira
 */
public class YesterdayDateRangeHandlerTest {

	@Test
	public void testDateRetrieving() {

		DateTime date = new DateTime(2013, 10, 2, 12, 0);

		YesterdayDateRangeHandler handler = new YesterdayDateRangeHandler();

		DateTime dateStart = handler.retrieveDateStart(date);
		Assert.assertEquals(2013, dateStart.getYear());
		Assert.assertEquals(10, dateStart.getMonthOfYear());
		Assert.assertEquals(1, dateStart.getDayOfMonth());

		DateTime dateEnd = handler.retrieveDateEnd(date);
		Assert.assertEquals(2013, dateEnd.getYear());
		Assert.assertEquals(10, dateEnd.getMonthOfYear());
		Assert.assertEquals(1, dateEnd.getDayOfMonth());

		DateTime dateMonth = handler.retrieveMonth(date);
		Assert.assertNull(dateMonth);
	}

}
