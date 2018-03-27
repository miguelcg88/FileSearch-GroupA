/*
 * @(#)SearchController.java        1.00 3/22/18
 *
 * Copyright (c) Jalasoft
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Convertor
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class Convertor {
    /**
     MEGABYTE divides bytes (2 times 2014)*/
    private static final long megabyte = 1024L * 1024L;

    /* ConvertBytesToMegabytes converts bytes to Mb - input bytes */
    public static long ConvertBytesToMegabytes(long bytes) {
        return bytes / megabyte;
    }

    /* ConvertToReadableDate converts date to desired format - input date */
    public String ConvertToReadableDate(Date date){
        SimpleDateFormat lastModifiedDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        return lastModifiedDateFormat.format(date);
    }

    /* convertStringToTimestamp converts date in string to timeStampDate - input string*/
    public static Timestamp convertStringToTimestamp(String stringDate) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = formatter.parse(stringDate);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
}
