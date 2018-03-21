/*
 * @(#)Blah.java        1.82 99/03/18
 *
 * Copyright (c) 1994-1999 Sun Microsystems, Inc.
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package com.jalasoft.search.model;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 Class description goes here.
 *
 * @version
1.82 18 Mar 1999  * @author
Firstname Lastname  */
public class SearchModel {
    /* A class implementation comment can go here. */
    public void ListFileByPath(String path){ //inputs path, file name, etc
        File files = new File(path);
        File[] listOfFiles = files.listFiles();
        for (File file : listOfFiles){
            if(file.isFile()) {
                /**
                 classVar1 documentation comment */
                //Variables
                SimpleDateFormat lastModifiedDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Long space = file.getTotalSpace();
                double spaceMb = space/1000000;
                double bytes = file.length();
                double fileLength = ((bytes / 1024) / 1024);


                //Print file
                System.out.println("Name: " + file.getName());
                System.out.println("Total Space (Mb):" + spaceMb);
                System.out.println("Is Directory?: " + file.isDirectory());
                System.out.println("Last Modified Date: " + lastModifiedDateFormat.format(file.lastModified()));
                System.out.println("Length (Mb): " + fileLength);
                System.out.println("Extension: " + getFileExtension(file));
                System.out.println("-------------------");
            }
        }
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
