package org.yuan.project.platform.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	
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

	public static final SimpleDateFormat SDF = new SimpleDateFormat();
	public static final String FMT_DATE = "yyyy-MM-dd";
	public static final String FMT_TIME = "HH:mm:ss";
	public static final String FMT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_DATETIMEMS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String INT_DATETIMEMS = "yyyyMMddHHmmssSSS";
}
