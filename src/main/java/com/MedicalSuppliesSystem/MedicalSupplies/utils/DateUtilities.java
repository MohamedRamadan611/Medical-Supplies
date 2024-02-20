package com.MedicalSuppliesSystem.MedicalSupplies.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.ConstantStrings;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Rawan.Ahmed
 */
public abstract class DateUtilities {

    public static Date convertLocalDateTime(Object localDateTime, String pattern) {

        Date convertedDate = null;

        if ((localDateTime instanceof LocalDate) || (localDateTime instanceof LocalDateTime)) {

            String datePattern = (pattern != null && !pattern.equals("")) ? pattern : ConstantStrings.DATE_FORMATE;
            SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

            try {

                dateFormatter.parse(localDateTime.toString());

                convertedDate = dateFormatter.parse(localDateTime.toString());
            } catch (ParseException ex) {
                Logger.getLogger(DateUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return convertedDate;
    }

    public static Date convertLocalDateTime(Object localDateTime) {
        return convertLocalDateTime(localDateTime, null);
    }

    public static Date getCurrentLocalDateTime(LocalDateTime localDateTime) {
        Date dateTime = null;
        try {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            String DateTimeStrring = localDateTime
                    .format(DateTimeFormatter.ofPattern(pattern));
            dateTime = new SimpleDateFormat(pattern).parse(DateTimeStrring);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateTime;
    }

    public static LocalDate convertDateToLocalDate(Date date) {
        return LocalDate.parse(new SimpleDateFormat(ConstantStrings.DATE_FORMATE).format(date));

    }

    public static Date convertStringToDate(String datePattern, String dateStr) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        Date date = new Date();
        try {
            date = dateFormatter.parse(dateStr);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtilities.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException("Invalide Date " + dateStr);
        }
        return date;

    }

    public static Date setZeroTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDateWithoutTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        Date currentDatePlus = c.getTime();
        return setZeroTime(currentDatePlus);
    }

    public static String getDateString(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstantStrings.DATE_FORMATE);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

    public static Date getStartMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date date = calendar.getTime();
        return date;
    }

    public static String getDateTime(Timestamp ts) {
        String df = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(ts);
        return df;
    }

    ////check if date befor system date...
    public static boolean checkDateIsBeforToday(Date date) {
        LocalDate localDate = convertDateToLocalDate(date);
        LocalDate currentDate = LocalDate.now();
        return localDate.isBefore(currentDate);
    }

    public static boolean checkDateIsAfterAnother(Date fromDate, Date toDate) {
        LocalDate localfromDate = convertDateToLocalDate(fromDate);
        LocalDate localToDate = convertDateToLocalDate(toDate);
        return localfromDate.isAfter(localToDate);
    }

    public static boolean checkDateAfterToday(Date date) {
        LocalDate checkingDate = convertDateToLocalDate(date);
        LocalDate toDateLocal = convertDateToLocalDate(new Date());
        return checkingDate.isAfter(toDateLocal);
    }

    public static Date getPreviousDateByNoDays(int numOfDays) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, numOfDays * -1);
        Date date = calendar.getTime();
        return date;
    }

    public static Date unifyTimeOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 12, 0, 0);
        Date unifiedTimeDate = calendar.getTime();
        return unifiedTimeDate;
    }
}
