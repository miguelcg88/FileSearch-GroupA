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
package src.com.jalasoft.search.DB;

import java.sql.*;
/**
 * Search Criteria
 *
 * @version 1.00 26 Mar 2018
 * @author Gabriel Rendon  */
public class DBConnection {
    private static DBConnection dbConnection;
    private static Connection con;

    private DBConnection() throws SQLException, ClassNotFoundException {
        init();
    }

    private void init() throws ClassNotFoundException, SQLException {
        //try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SearchGroupA.db");
            Statement state = con.createStatement();
            state.execute("CREATE TABLE [IF NOT EXISTS] SearchTable (Id Integer PRIMARY KEY, CriteriaName String NOT NULL, Json String)");

        //} catch(ClassNotFoundException e) {
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
        System.out.println("Opened database successfully");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public static Connection getConnection(){
        return con;
    }
}
