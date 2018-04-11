package src.com.jalasoft.search.DB;

import javax.management.relation.RelationSupport;
import java.sql.*;

public class SearchQuery {
    private static Connection con;

    public SearchQuery(){
        con = DBConnection.getInstance().getConnection();
    }

    public String addCriteria(String String externalJson){
        String query = "Insert Into SearchGroupA Set Values(1,2)";
        PreparedStatement pre = con.prepareStatement(query);
        pre.setString(2,externalJson);
        pre.execute();

        /*
        String sql = "update people set firstname=? , lastname=? where id=?";

PreparedStatement preparedStatement =
        connection.prepareStatement(sql);

preparedStatement.setString(1, "Gary");
preparedStatement.setString(2, "Larson");
preparedStatement.setLong  (3, 123);

int rowsAffected = preparedStatement.executeUpdate();
         */
        return "";
    }

    public ResultSet getAllCriteria(){
        Statement state = null;
        try {
            state = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet result = null;
        try {
            result = state.executeQuery("Select Id,CriteriaName,Json From SearchGroupA");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }
}
