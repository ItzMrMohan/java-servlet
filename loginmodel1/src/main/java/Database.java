
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohan
 */
public class Database {
    static String databaseName ="login";
    
    public static Connection connectDatabase(String databaseName) throws SQLException, ClassNotFoundException{
        
        final String DB_URL="jdbc:mysql://localhost:3306/"+databaseName+"?autoReconnect=true&useSSL=false";
        final String USER = "root";
        final String PASS = "root";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }
     
    public static Statement createStatement(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        return statement;
    }
    
    public static ResultSet createResultSet(Connection connection,Statement statement,String sql) throws SQLException{
        ResultSet result=statement.executeQuery(sql);
        return result;
    }
    
    
    public static String createSingleResultSet(String sql) throws SQLException, ClassNotFoundException{
        String res = " ";
        Connection connection = Database.connectDatabase(databaseName);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while(result.next()){
        res = result.getString(1);
        }
        return res;
        
        
       

    }
    public static void closeConnection (Connection connection, Statement statement, ResultSet result) throws SQLException{
        connection.close();
        statement.close();
        result.close();
    }
    
    
    
}
