/*
 * Search .java *
 * Copyright (c) 2018 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package src.com.jalasoft.search.model;

/*
 *Description, the Asset.java class is the main class.
 * 1. PATH
 * 2. FILE NAME
 * 4. HIDDEN
 * @version 1.0
 * @author Jonas Aramayo
 */

import java.io.File;

public class Asset {
    private String folderPath;
    private String fileNameToSearch;
    private Boolean isHidden;
    private String owner;
    private String modificationDate;
    private String creationDate;

    /**
     * Set folder/file path
     * @param //owner.
     */
    public Asset(String path, String fileName, Boolean isHidden, String owner) {
        this.folderPath = path;
        this.fileNameToSearch = fileName;
        this.isHidden = isHidden;
        this.owner = owner;

            //setFolderPath(path);
        }
    public void setFolderPath(String path) {
        this.folderPath = path;
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
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileNameToSearch = fileName;
    }

    /**
     * Get file name
     * @return fileName
     */
    public String getFileName() {
        return fileNameToSearch;
    }
    /**
     * Set hidden flag
     * @param hidden
     */
    public void setHiddenFlag(boolean hidden) {
        this.isHidden = hidden;
    }

    /**
     * Get hidden flag
     * @return hidden
     */
    public boolean getHiddenFlag() {
        return isHidden;
    }
    /**
     * Set owner
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get owner
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set Creation Date
     * @param creationDate
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Get Creation Date
     * @return creationDate
     */
    private String getCreationDate() {
        return creationDate;
    }
    /**
     * Set modification Date
     * @param modificationDate
     */
    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Get modification Date
     * @return modificationDate
     */
    private String getModificationDate() {
        return modificationDate;
    }
}
