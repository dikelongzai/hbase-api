package com.howard.hbase.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PlatformUtil {

	/**
	 * 日期格式字符串转换成时间戳
	 * 精确到秒
	 *            字符串日期
	 * @param format
	 *            如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static long date2Timestamp(String date_str, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			//设置时区，不然linux服务器时间如果是其他时区，就会转错
			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			return sdf.parse(date_str).getTime() / 1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 日期格式字符串转换成时间戳
	 * 精确到毫秒
	 * 默认转换为CommonConstant.DATE_FORMAT_XXX格式
	 *            字符串日期   精确到毫秒
	 * @return
	 */
	public static long date2Timestamp(String date_str) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatEnum.YYYY_MM_DD_BLANK_HH_MM_SS_sss.toString());
		try {
			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			return sdf.parse(date_str).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 时间戳转换成日期格式字符串
	 * 精确到秒
	 * @param seconds
	 *            精确到秒的字符串
	 * @return
	 */
	public static String timestamp2Date(long seconds, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/**
	 * 时间戳转换成日期格式字符串
	 * 精确到毫秒
	 * 默认转换为CommonConstant.DATE_FORMAT_XXX格式
	 * @param seconds
	 *            精确到秒的字符串 精确到毫秒
	 * @return
	 */
	public static String timestamp2Date(long seconds) {
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatEnum.YYYY_MM_DD_BLANK_HH_MM_SS_sss.toString());
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdf.format(new Date(Long.valueOf(seconds)));
	}




	public static String[] sortByAscII(String s1,String s2){
		String[] result = null;
		if (s1 != null && s2 != null){
			if(s1.compareTo(s2)<0){
				result = new String[]{s1,s2};
			}else{
				result = new String[]{s2,s1};
			}
		}
		return result;
	}

	/**
	 *
	 * @param fromDate
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String plusDay(String fromDate,int day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatEnum.YYYYMMDD.toString()); // 日期格式
		Date date = dateFormat.parse(fromDate);
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DATE, day);
		String temp = "";
		temp = dateFormat.format(cl.getTime());
		System.out.println(temp);
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(date2Timestamp("2017-01-18 12:12:24.777"));
	}
}
