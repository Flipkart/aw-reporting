package com.google.api.ads.adwords.jaxws.extensions.report.model.util;

import com.google.api.ads.adwords.jaxws.extensions.report.model.util.BigDecimalUtil;

import junit.framework.Assert;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Test for the {@link BigDecimalUtil} class.
 */
public class BigDecimalUtilTest {


  /**
   * Tests the American number format parsing. (##,###,###.00)
   */
  @Test
  public void testAmericanNumberFormat() {

    String sparseString = "1 200 300.10";
    BigDecimal parsed = BigDecimalUtil.parseFromNumberString(sparseString);

    Assert.assertEquals(
        "The parsed value is not the expected.", 0.0000001, 1200300.10, parsed.doubleValue());

    sparseString = "1,200,300.10";
    parsed = BigDecimalUtil.parseFromNumberString(sparseString);

    Assert.assertEquals(
        "The parsed value is not the expected.", 0.0000001, 1200300.10, parsed.doubleValue());

  }

  /**
   * Tests the Brazilian number format parsing (##.###.###,00).
   */
  @Test
  public void testBrazilianNumberFormat() {

    String sparseString = "1 200 300,10";
    BigDecimal parsed = BigDecimalUtil.parseFromNumberString(sparseString);

    Assert.assertEquals(
        "The parsed value is not the expected.", 0.0000001, 1200300.10, parsed.doubleValue());

    sparseString = "1.200.300,10";
    parsed = BigDecimalUtil.parseFromNumberString(sparseString);

    Assert.assertEquals(
        "The parsed value is not the expected.", 0.0000001, 1200300.10, parsed.doubleValue());

  }

}
