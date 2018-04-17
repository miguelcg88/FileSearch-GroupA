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
package src.com.jalasoft.search.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;

/**
 * Implements the log creation
 * @author Gabriel Rendon
 * @version 0.1
 * @since 04/8/2018
 */
public class LoggerCreator {
    private static LoggerCreator logCreator;
    private static Logger logger;

    private LoggerCreator() {
        FileHandler fileHandler;

        try /*(FileInputStream configFile = new FileInputStream("./logger.properties"))*/ {
            //readConfig(configFile);
            //LogManager.getLogManager().readConfiguration(configFile);
            //logger = LogManager.getLogManager().getLogger("MyLog");

            logger = Logger.getLogger("Test");
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.ALL);
            fileHandler = new FileHandler("..\\..\\FileSearch_GroupA_Log.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            fileHandler.setLevel(Level.ALL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to return instance of the logger
     * @return an instance of LoggerCreator
     */
    public static LoggerCreator getInstance(){
        if(logCreator == null){
            logCreator = new LoggerCreator();
        }
        return logCreator;
    }

    /**
     * getLogger will return the logger set by loggerCreator
     * @return logger
     */
    public static Logger getLogger(){
        return logger;
    }
}
