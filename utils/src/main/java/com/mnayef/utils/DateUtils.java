package com.mnayef.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mohamed Hamdan on 2017-Jun-05.
 * mohamed.nayef95@gmail.com
 */
public class DateUtils {

    private static DateUtils mInstance;

    public static synchronized DateUtils getInstance() {
        if (mInstance == null)
            mInstance = new DateUtils();
        return mInstance;
    }

    private DateUtils() {
    }

    public String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }

    public String getCurrentDate(String format) {
        try {
            return new SimpleDateFormat(format, Locale.getDefault()).format(new Date());
        } catch (Exception ignored) {
            return null;
        }
    }

    public Date getDateAfter(int day) {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    public int getWeekOfMonth() {
        return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
    }

    public int getDayOfWeek() {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }
}