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
package src.com.jalasoft.search.model;
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
    private String dateAddedFrom;
    private String dateAddedTo;
    private String dateModifiedFrom;
    private String dateModifiedTo;
    private String contains;
    private String createdBy;
    private String owner;

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

    /**
     * Set date limit Added From
     * @param dateAddedFrom
     */
    public void setDateAddedFrom(String dateAddedFrom) {
        this.dateAddedFrom = dateAddedFrom;
    }

    /**
     * get date limit Added From
     * @return dateAddedFrom
     */
    public String getDateAddedFrom() {
        return this.dateAddedFrom;
    }

    /**
     * Set date limit Added To
     * @param dateAddedTo
     */
    public void setDateAddedTo(String dateAddedTo) {
        this.dateAddedTo = dateAddedTo;
    }

    /**
     * get date limit Added To
     * @return dateAddedTo
     */
    public String getDateAddedTo() {
        return this.dateAddedTo;
    }

    /**
     * Set date limit Modified From
     * @param dateModifiedFrom
     */
    public void setDateModifiedFrom(String dateModifiedFrom) {
        this.dateModifiedFrom = dateModifiedFrom;
    }

    /**
     * get date limit Modified From
     * @return dateModifiedFrom
     */
    public String getDateModifiedFrom() {
        return this.dateModifiedFrom;
    }

    /**
     * Set date limit Modified To
     * @param dateModifiedTo
     */
    public void setDateModifiedTo(String dateModifiedTo) {
        this.dateModifiedTo = dateModifiedTo;
    }

    /**
     * get date limit Modified To
     * @return dateModifiedTo
     */
    public String getDateModifiedTo() {
        return this.dateModifiedTo;
    }

    /**
     * Set contains text
     * @param contains
     */
    public void setContains(String contains) {
        this.contains = contains;
    }

    /**
     * get contains text
     * @return contains
     */
    public String getContains() {
        return this.contains;
    }

    /**
     * Set created By user field
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * get created By user field
     * @return createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setOwner(String owner){this.owner = owner;}

    public String getOwner(){return this.owner;}
}