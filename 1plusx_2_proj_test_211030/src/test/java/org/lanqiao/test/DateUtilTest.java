package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.util.DateUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * DateUtil的测试类
 */
public class DateUtilTest {

	@Test
	public void testConvertFromStringToDate() {
		LocalDateTime localDateTime = LocalDateTime.of(2014, 4, 01, 18, 41, 40);
		assertEquals(localDateTime.atZone(ZoneId.systemDefault()).toInstant(),
				DateUtil.convertFromStringToDate("2014-04-01 18:41:40").toInstant());
	}

	@Test
	public void testConvertFromDateToString() {
		String str = DateUtil.convertFromDateToString(new Date(121, 1, 1, 12, 11, 10));
		assertEquals("2021-02-01 12:11:10",str);
	}
}
