package org.yuan.project.platform.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static final String FMT_DATE = "yyyy-MM-dd";
	public static final String FMT_TIME = "HH:mm:ss";
	public static final String FMT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_DATETIMEMS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String INT_DATETIMEMS = "yyyyMMddHHmmssSSS";
	
	/**
	 * 将日期转化成特定格式的字符串
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String format(Date date, String fmt) {
		SDF.applyPattern(fmt);
		String str = SDF.format(date);
		return str;
	}
	
	/**
	 * 增加或者减少日期值
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date alertDay(Date date, int num) {
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, num);
		return calendar.getTime();
	}
	
	private static final Calendar calendar = Calendar.getInstance();
	private static final SimpleDateFormat SDF = new SimpleDateFormat();
}
