package com.ezypay.util;

import com.ezypay.util.logs.LogHandler;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManager {

    @Autowired
    private static LogHandler logHandler;

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

    public static Date nextDateOfWeek(Date startDate,DayOfWeek dateOfWeek){
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);

        LocalDate ld = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        ld = ld.with(TemporalAdjusters.nextOrSame(dateOfWeek));
        return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
