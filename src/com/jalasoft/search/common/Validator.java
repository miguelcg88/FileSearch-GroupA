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
package src.com.jalasoft.search.common;

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

    final static String DATE_FORMAT = "MM/dd/yyyy";
    private static Pattern fileExtnPtrn = Pattern.compile("([^\\s]+(\\.(?i)(exe|xls|png|zip|txt|doc|csv|pdf))$)"); //Add here all valid extensions

    /* isValidPath validates if path is valid - input string */

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);

        } catch (InvalidPathException | NullPointerException ex) {
            return false;
        }

        return true;
    }

    /* isFileExist validates if file exist - input string */
    public static boolean isFileExist(String filePathString)
    {
        File f = new File(filePathString);

            if(f.exists()) {
                return true;
            }

            return false;
    }

    /* isDirectory validates if file path is a valid Directory - input string */
    public static boolean isDirectory(String filePathString)
    {
        File f = new File(filePathString);

        if(f.isDirectory()) {
            return true;
        }

        return false;
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

    /* isValidExtension validates if file has a valid extension - input extension file */
    public static boolean isValidExtension(String fileNameWithextension) {
        if(fileNameWithextension==null || fileNameWithextension.isEmpty() || fileNameWithextension.endsWith("All")){
            return true;
        }
        else {
            Matcher mtch = fileExtnPtrn.matcher(fileNameWithextension);
            if (mtch.matches()) {
                return true;
            }
            return false;
        }
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

    public static boolean isValidName(String text)
    {
        if(text==null || text.isEmpty()){
            return true;
        }
        else {
            Pattern pattern = Pattern.compile(
                    "# Match a valid Windows filename (unspecified file system).          \n" +
                            "^                                # Anchor to start of string.        \n" +
                            "(?!                              # Assert filename is not: CON, PRN, \n" +
                            "  (?:                            # AUX, NUL, COM1, COM2, COM3, COM4, \n" +
                            "    CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,     \n" +
                            "    COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,     \n" +
                            "  )                              # LPT6, LPT7, LPT8, and LPT9...     \n" +
                            "  (?:\\.[^.]*)?                  # followed by optional extension    \n" +
                            "  $                              # and end of string                 \n" +
                            ")                                # End negative lookahead assertion. \n" +
                            "[^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.\n" +
                            "[^<>:\"/\\\\|?*\\x00-\\x1F\\ .]  # Last char is not a space or dot.  \n" +
                            "$                                # Anchor to end of string.            ",
                    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
            Matcher matcher = pattern.matcher(text);
            boolean isMatch = matcher.matches();
            return isMatch;
        }
    }
}
