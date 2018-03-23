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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Convertor
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class Convertor {
    /**
     MEGABYTE divides bytes (2 times 2014)*/
    private static final long MEGABYTE = 1024L * 1024L;

    /* ConvertBytesToMegabytes converts bytes to Mb - input bytes */
    public static long ConvertBytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    /* ConvertToReadableDate converts date to desired format - input date */
    public String ConvertToReadableDate(Date date){
        SimpleDateFormat lastModifiedDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        return lastModifiedDateFormat.format(date);
    }
}
