package com.yintro.lazyandroid.app.helper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public class DateTimeHelper {


    public static final String FORMAT_YEAR_MONTH_DAY_1 = "yyyy-MM-dd";
    public static final String FORMAT_YEAR_MONTH_DAY_2 = "yyyy'年'M'月'dd'日'";

    public static final String FORMAT_YEAR_MONTH_1 = "yyyy-MM";

    public static String getDisplayDate(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        return formatter.format(date);
    }

    public static String getCurrentDateYearMonthDateHourMinuteSecond() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat toDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return toDateFormat.format(calendar.getTime());
    }


    public static Calendar getCalendarInUTC(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat fromDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(fromDateFormat.parse(date));
        return calendar;
    }

    public static Date getDateInUTC(String date) throws ParseException {
        return getCalendarInUTC(date).getTime();
    }


}
