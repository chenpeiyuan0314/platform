package org.yuan.project.platform.helper;

import java.util.Date;

import org.junit.Test;

import static org.yuan.project.platform.helper.DateHelper.FMT_DATE;
import static org.yuan.project.platform.helper.DateHelper.FMT_TIME;
import static org.yuan.project.platform.helper.DateHelper.FMT_DATETIME;
import static org.yuan.project.platform.helper.DateHelper.FMT_DATETIMEMS;
import static org.yuan.project.platform.helper.DateHelper.INT_DATETIMEMS;

public class DateHelperTest {

	@Test
	public void testFormat() {
		Date date = new Date();
		System.out.println(DateHelper.format(date ,FMT_DATE));
		System.out.println(DateHelper.format(date ,FMT_TIME));
		System.out.println(DateHelper.format(date ,FMT_DATETIME));
		System.out.println(DateHelper.format(date ,FMT_DATETIMEMS));
		System.out.println(DateHelper.format(date ,INT_DATETIMEMS));
	}
}
