package com.maxc.rest.common;

import java.text.SimpleDateFormat;



public class Constants {

	public static int TWO_DAYS_MILLISECOND = 48 * 60 * 60 * 1000;
	public static int THREE_DAYS_MILLISECOND = 72 * 60 * 60 * 1000;

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_HOURE_MINUTE_SENCOND = "yyyy-MM-dd HH:mm:ss";
	public static final String MONTH_FORMAT = "yyyy-MM";

	public static final SimpleDateFormat DATE_FORMAT_HOURE_MINUTE_SENCOND_FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT_HOURE_MINUTE_SENCOND);
	public static final SimpleDateFormat DATE_PARSE_FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT);

}
