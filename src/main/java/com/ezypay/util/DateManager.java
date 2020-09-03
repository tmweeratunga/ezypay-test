package com.ezypay.util;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManager {

    public static Date addDate(Date date, int years, int months, int days) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        cal.add(Calendar.MONTH, months);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    public static boolean isDateAfter(Date fromDate,Date toDate,int NumOfMonth){
        Date dateAfter = DateUtils.addMonths(fromDate,NumOfMonth);
        return toDate.compareTo(dateAfter) > 0;
    }
}
