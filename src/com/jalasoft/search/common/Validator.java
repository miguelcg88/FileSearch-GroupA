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
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator - Validates inputs
 *
 * @version 1.00 23 Mar 2018
 * @author Gabriel Rendon  */
public class Validator {
    /**
     DATE_FORMAT has the format wanted
     Petterm fileExtnPtrn has the valid format*/

    final static String DATE_FORMAT = "MM-dd-yyyy";
    private static Pattern fileExtnPtrn = Pattern.compile("([^\\s]+(\\.(?i)(txt|doc|csv|pdf))$)"); //Add here all valid extensions

    /* isValidPath validates if path is valid - input string */

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);

        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }

        return true;
    }

    /* isValidDate validates if date is valid - input string */
    public static boolean isValidDate(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /* isValidExtension validates if file has a valid extension - input file */
    public static boolean isValidExtension(File file) {
        String extension = getFileExtension(file);
        Matcher mtch = fileExtnPtrn.matcher(extension);
        if (mtch.matches()) {
            return true;
        }
        return false;
    }

    /* private getFileExtension return file extension - input file */
    private static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
