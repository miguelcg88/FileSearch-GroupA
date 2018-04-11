package src.com.jalasoft.search.DB;

import java.sql.*;

public class DBConnection {
    private static DBConnection dbConnection;
    private static Connection con;

    private DBConnection(){
        init();
    }

    private void init(){
        try {

            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:SearchGroupA.db");
            Statement state = con.createStatement();
            state.execute("CREATE TABLE [IF NOT EXISTS] SearchTable " +
                    "(Id Integer PRIMARY KEY, CriteriaName String NOT NULL, Json String)");

        } catch(ClassNotFoundException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Opened database successfully");
    }

    public static DBConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public static Connection getConnection(){
        return con;
    }
}
