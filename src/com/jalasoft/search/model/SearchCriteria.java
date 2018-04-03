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
package com.jalasoft.search.model;
/**
 * Search Criteria
 *
 * @version 1.00 26 Mar 2018
 * @author Gabriel Rendon  */
public class SearchCriteria {
    /**
     private variables */
    //private Assets asset;
    private String folderPath;
    private String name;
    private boolean hidden;
    private String extension;

    /**
     * Set folder/file path
     * @param folderPath
     */
    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
        //this.asset.folderPath = folderPath;
    }

    /**
     * Get folder/file path
     * @return folderPath
     */
    public String getFilePath() {
        return folderPath;
    }

    /**
     * Set file name
     * @param name
     */
    public void setFileName(String name) {
        this.name = name;
    }

    /**
     * Get file name
     * @return name
     */
    public String getFileName() {
        return name;
    }

    /**
     * Set hidden flag
     * @param hidden
     */
    public void setHiddenFlag(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Get hidden flag
     * @return hidden
     */
    public boolean getHiddenFlag() {
        return hidden;
    }

    /**
     * Set file extension
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get file extension
     * @return extension
     */
    public String getExtension() {
        return extension;
    }


}
