package com.sc.dmh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.FastDateFormat;



/**
 * java日期操作工具类
 * 
 */
public class DateUtils {
	private static SimpleDateFormat monthNumberFormate = new SimpleDateFormat("yyyyMM");

	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 获取当前日期18点
	 * @return
	 * 18点加日期
	 * 错误返回null
	 */
	public static Date getNowDate18D(){
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
		
		String d = DateUtils.splitDate(new Date());
//		String d = "2017-12-02";
		d=d+" 18:00:00";
		
		Date date;
		try {
			date = fdf.parse(d);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getMonthNo(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		if (now.get(Calendar.DAY_OF_MONTH) >= 27) {
			now.add(Calendar.MONTH, 1);
		}
		return Integer.parseInt(monthNumberFormate.format(now.getTime()));
	}

	/**
	 * 
	 * @param month
	 * @return
	 */
	public static Date getStartDate(int month) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.YEAR, (int) (month / 100));
		now.set(Calendar.MONTH, (int) (month % 100) - 2);
		now.set(Calendar.DAY_OF_MONTH, 27);
		return now.getTime();
	}

	/**
	 * 获取开始时间yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @author ztb 2014年8月26日 下午2:31:14
	 * @param month
	 * @return
	 */
	public static String getStartDateStr(int month) {
		return dateTimeFormat.format(getStartDate(month));
	}

	public static Date getEndDate(int month) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.YEAR, (int) (month / 100));
		now.set(Calendar.MONTH, (int) (month % 100) - 1);
		now.set(Calendar.DAY_OF_MONTH, 27);
		return now.getTime();
	}

	/**
	 * 获取结束时间yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @author ztb 2014年8月26日 下午2:31:55
	 * @param month
	 * @return
	 */
	public static String getEndDateStr(int month) {
		return dateTimeFormat.format(getEndDate(month));
	}

	public static Date str2Date(String dateStr, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getChineseMonth(int month) {
		if (month == 1) {
			return "一月份";
		} else if (month == 2) {
			return "二月份";
		} else if (month == 3) {
			return "三月份";
		} else if (month == 4) {
			return "四月份";
		} else if (month == 5) {
			return "五月份";
		} else if (month == 6) {
			return "六月份";
		} else if (month == 7) {
			return "七月份";
		} else if (month == 8) {
			return "八月份";
		} else if (month == 9) {
			return "九月份";
		} else if (month == 10) {
			return "十月份";
		} else if (month == 11) {
			return "十一月份";
		} else if (month == 12) {
			return "十二月份";
		} else {
			return "";
		}
	}

	/**
	 * * 闰年识别<br>
	 * 
	 * 闰年计算标准是：<br>
	 * 1.能被4整除而不能被100整除;<br>
	 * 2.能被100整除也能被400整除;<br>
	 * 3.能被400整除，不能被3200整除；<br>
	 * 4.能被3200整除，不能被172800整除；<br>
	 * 
	 * @param year
	 *            年份
	 * @return boolean
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年12月10日下午6:14:59
	 */
	public static boolean isLeapYear(int year) {
		// 为什么不验证后两个条件？因为在一千年以后世界早已没有我
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * 计算年份天数
	 * 
	 * @param year
	 *            年份
	 * @return int
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年12月10日下午6:26:01
	 */
	public static int getYearInDayNum(int year) {
		if (isLeapYear(year)) {
			return 366;
		} else {
			return 365;
		}
	}

	/**
	 * 计算月份天数
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return int
	 * 
	 * @author 刘旭
	 * 
	 *         The latest modified time: 2016年12月10日下午6:41:28
	 * @throws IllegalArgumentException
	 */
	public static int getMonthInDayNum(int year, int month) throws IllegalArgumentException {
		if (month >= 1 && month <= 12) {
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				return 30;
			} else if (month == 2) {
				if (isLeapYear(year)) {
					return 29;
				} else {
					return 28;
				}
			} else {
				return 31;
			}
		} else {
			throw new IllegalArgumentException("请输入月份：1~12之间");
		}
	}

	/**
	 * 将一个时间段按天拆分（结果包括起始日期和结束日期）
	 * 
	 * @param startDate
	 * 
	 * @param endDate
	 * 
	 * @return
	 * 
	 *         current time:2016-12-14
	 * 
	 * @author 李明俊
	 */
	public static List<Date> splitDate(Date startDate, Date endDate) {
		Calendar canlandar1 = Calendar.getInstance();// 开始时间
		Calendar canlandar2 = Calendar.getInstance();// 结束时间
		canlandar1.setTime(startDate);// 2009-6-1
		canlandar2.setTime(endDate);// 2009-6-5
		List<Date> returnList = new ArrayList<Date>();
		while (canlandar1.compareTo(canlandar2) < 1) {
			returnList.add(canlandar1.getTime());
			canlandar1.add(canlandar1.DATE, 1);// 每次循环增加一天
		}
		return returnList;
	}

	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param smdate
	 *            较小的日期
	 * 
	 * @param bdate
	 *            较大的日期
	 * 
	 * @return
	 * 
	 *         current time:2016-12-14
	 * 
	 * @author 李明俊
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		Long between_days = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (Exception e) {
			e.printStackTrace();
			between_days = new Long(0);
		}
		return between_days.intValue();
	}

	/**
	 * 计算两个日期相差的天数（String类型的日期）
	 * 
	 * @param smdate
	 *            较小的日期
	 * 
	 * @param bdate
	 *            较大的日期
	 * 
	 * @return
	 * 
	 *         current time:2016-12-14
	 * 
	 * @author 李明俊
	 */
	public static int daysBetween(String smdate, String bdate) {
		Long between_days = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (Exception e) {
			e.printStackTrace();
			between_days = new Long(0);
		}
		return between_days.intValue();
	}

	/**
	 * 获取年已过天数
	 * 
	 * @param year
	 * @return int
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 * @CreateTime 2017年6月9日上午10:44:08
	 */
	public static int getYearElapsedDays(int year) {
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd");
		// 获取年天数
		int totalDays = getYearInDayNum(year);
		try {
			int elapsed = daysBetween(fdf.parse(year + "-01" + "-01"), new Date());
			if (elapsed > totalDays) {
				return totalDays;
			} else {
				return elapsed;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getWeekDayByDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);
		int week = 0;
		int weekIndex = c.get(Calendar.DAY_OF_WEEK);

		switch (weekIndex) {
		case 1:
			week = 7;
			break;
		case 2:
			week = 1;
			break;
		case 3:
			week = 2;
			break;
		case 4:
			week = 3;
			break;
		case 5:
			week = 4;
			break;
		case 6:
			week = 5;
			break;
		case 7:
			week = 6;
			break;
		}
		return week;

	}

	/**
	 * 根据日期计算星期（依据蔡勒公式计算）
	 * 
	 * 蔡勒公式只适合于1582年（中国明朝万历十年）10月15日之后的情形
	 * 
	 * @param y
	 * @param m
	 * @param d
	 * 
	 * @return int<br>
	 *         返回值为0~6,0代表星期日
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         Create time: 2017年2月13日下午1:34:05
	 */
	public static int calculateWeekByDate(int y, int m, int d) {
		// 蔡勒公式：w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
		// 公式中的符号含义如下，
		// w：星期；
		// c：世纪-1；
		// y：年（两位数）；
		// m：月（m大于等于3，小于等于14，即在蔡勒公式中，某年的1、2月要看作上一年的13、14月来计算，比如2003年1月1日要看作2002年的13月1日来计算）；
		// d：日；[ ]代表取整，即只要整数部分。(C是世纪数减一，y是年份后两位，M是月份，d是日数。1月和2月要按上一年的13月和
		// 14月来算，这时C和y均按上一年取值。)
		y = y % 100;
		if (m < 3) {
			y -= 1;
			m += 12;
		}
		// c计算
		int c = 0;
		if (y / 100.00 > 0) {
			c = c / 100;
		} else {
			c = c / 100 - 1;
		}
		// W%7，余数是几就是星期几,0代表星期日
		int w = y + (y / 4) + (c / 4) - (2 * c) + (26 * (m + 1) / 10) + d - 1;
		return w % 7;
	}

	/**
	 * 根据日期计算星期（依据蔡勒公式计算）
	 * 
	 * 蔡勒公式只适合于1582年（中国明朝万历十年）10月15日之后的情形
	 * 
	 * @param date
	 * @return int<br>
	 *         返回值为0~6,0代表星期日
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         Create time: 2017年2月19日上午11:12:03
	 */
	public static int calculateWeekByDate(Date date) {
		int[] intArray = formatDateToIntArray(date);
		return calculateWeekByDate(intArray[0], intArray[1], intArray[2]);
	}

	/**
	 * 日期格式化为int型数组
	 * 
	 * @param date
	 * @return int[]
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         Create time: 2017年2月19日上午9:19:08
	 */
	public static int[] formatDateToIntArray(Date date) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		int[] dateArray = new int[6];
		dateArray[0] = cale.get(Calendar.YEAR);
		dateArray[1] = cale.get(Calendar.MONTH) + 1;
		dateArray[2] = cale.get(Calendar.DAY_OF_MONTH);
		dateArray[3] = cale.get(Calendar.HOUR_OF_DAY);
		dateArray[4] = cale.get(Calendar.MINUTE);
		dateArray[5] = cale.get(Calendar.SECOND);
		return dateArray;
	}

	/**
	 * 计算周内任意星期的日期
	 * 
	 * @param referenceDate
	 *            参考日期
	 * @param startWeek
	 *            周起始设置（通常周日or周一）<br>
	 *            [参数值0~6,0代表星期日]
	 * @param tagetWeek
	 *            [参数值0~6,0代表星期日]
	 * @return Date
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         Create time: 2017年2月19日上午11:13:25
	 */
	public static Date calculateWeekInnerDate(Date referenceDate, int weekStart, int tagetWeek) {
		// 计算出参考日期星期
		int referenceWeek = calculateWeekByDate(referenceDate);
		// 计算出对应星期为一周的第几天
		int[] dayOfWeek = new int[2];
		for (int i = 0; i < 7 && (dayOfWeek[0] == 0 || dayOfWeek[1] == 0); i++) {
			if (weekStart > 6) {
				weekStart = 0;
			}
			// 参考星期在一周的第几天
			if ((weekStart++) == referenceWeek) {
				dayOfWeek[0] = i + 1;
			}
			// 目标星期在一周的第几天
			if ((weekStart - 1) == tagetWeek) {
				dayOfWeek[1] = i + 1;
			}
		}
		// 根据参考日期计算出本周内任意日期
		return calculateDates(referenceDate, dayOfWeek[1] - dayOfWeek[0]);
	}

	/**
	 * 计算日期
	 * 
	 * @param initialDate
	 *            初始日期
	 * @param span
	 *            日期跨度（单位：天，可以为负）
	 * @return Date
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         Create time: 2017年2月19日下午3:21:17
	 */
	public static Date calculateDates(Date initialDate, int span) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(initialDate);
		cale.add(Calendar.DATE, span);
		return cale.getTime();
	}

	/**
	 * 计算日期 月
	 * 
	 * @param initialDate
	 *            初始日期
	 * @param span
	 *            日期跨度（单位：月，可以为负）
	 * @return Date
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 *         Create time: 2017年2月19日下午3:21:17
	 */
	public static Date calculateMonth(Date initialDate, int span) {
		Calendar cale = Calendar.getInstance();
		cale.setTime(initialDate);
		cale.add(Calendar.MONTH, span);
		return cale.getTime();
	}
	
	/**
	 * 去掉日期的时分秒
	 * 
	 * @param toDate
	 * @return String
	 * 
	 * 
	 *         lmj
	 */
	public static String splitDate(Date toDate) {
		FastDateFormat sdf = FastDateFormat.getInstance("yyyy-MM-dd");
		return sdf.format(toDate);
	}
	
	/**
	 * 去掉日期的时分秒2
	 * 
	 * @param toDate
	 * @return String
	 * 
	 * 
	 *         lmj
	 */
	public static String splitDateShort(Date toDate) {
		FastDateFormat sdf = FastDateFormat.getInstance("yyyyMMdd");
		return sdf.format(toDate);
	}

	/**
	 * 计算两个日期相差分钟数
	 * 
	 * @param ymdhm1
	 * @param ymdhm2
	 * @return double
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 * @CreateTime 2017年7月17日下午9:32:34
	 */
	public static long minuteBetween(String ymdhm1, String ymdhm2) {
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm");
		long time1 = 0;
		long time2 = 0;
		try {
			time1 = fdf.parse(ymdhm1).getTime();
			time2 = fdf.parse(ymdhm2).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (time2 - time1) / 1000 / 60;
	}

	/**
	 * 获取月剩余天
	 * 
	 * @param currDate
	 * @return String[]
	 * 
	 * @author 刘旭 (LiuXu)
	 * 
	 * @CreateTime 2017年7月24日下午4:17:47
	 */
	public static String[] getMonthSurplusDays(Date currDate) {
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd");
		String[] dateStr = fdf.format(currDate).split("-");
		int surplusDays = 0;
		try {
			surplusDays = getMonthInDayNum(Integer.valueOf(dateStr[0]), Integer.valueOf(dateStr[1]))
					- Integer.valueOf(dateStr[2]) + 1;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		// 生成剩余天数
		String[] dates = new String[surplusDays];
		for (int i = 0; i < surplusDays; i++) {
			dates[i] = fdf.format(calculateDates(currDate, i));
		}
		return dates;
	}
	
	/**
	 * 根据date格式和传入想要位置，返回int
	 * @param date
	 * @param str
	 * @return
	 */
	public static int getDate2Int(Date date,String str){
		int idate = 0;
		str = str.toLowerCase();
		Calendar cal=Calendar.getInstance();  
		cal.setTime(date); 
		switch (str) {
		case "year":
			idate = cal.get(Calendar.YEAR);
			break;
		case "month":
			idate = cal.get(Calendar.MONTH)+1;
			break;
		case "day":
			idate = cal.get(Calendar.DAY_OF_MONTH);
			break;
		case "hour":
			idate = cal.get(Calendar.HOUR_OF_DAY);
			break;
		case "minutes":
			idate = cal.get(Calendar.MINUTE);
			break;
		case "second":
			idate = cal.get(Calendar.SECOND);
			break;
		case "week":
			idate = cal.get(Calendar.DAY_OF_WEEK);
			break;
		default:
			break;
		}
		return idate;
	}
	
	
	
	
	
	
}