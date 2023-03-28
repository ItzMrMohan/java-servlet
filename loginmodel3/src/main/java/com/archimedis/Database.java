package com.archimedis;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohan
 */
public class Database {

   public static Connection connectDatabse () throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/newlogin";
        String username="root";
        String password ="root";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    public static Statement createStatement(Connection conn)throws ClassNotFoundException,SQLException{
        Statement state = conn.createStatement();
        return state;
    }
    public static ResultSet createResult( Connection connection, Statement state, String sql)throws ClassNotFoundException,SQLException{
        ResultSet result = state.executeQuery(sql);
        return result;
    }
    public static String createSingleResult(String sql) throws ClassNotFoundException, SQLException{
        String output="";
        Connection conn = Database.connectDatabse();
        Statement state= conn.createStatement();
        ResultSet result =state.executeQuery(sql);
        while(result.next()){
            output = result.getString(1);
        }
        return output;
        
    }
    public static void postintoDB(String sql) throws ClassNotFoundException, SQLException{
        Connection conn = Database.connectDatabse();
        Statement state= conn.createStatement();
        state.executeUpdate(sql);
        Database.closeAfterPostConnection(conn, state);
    }
    public static void closeConnection(Connection conn, Statement state, ResultSet result)throws SQLException{
        conn.close();
        state.close();
        result.close();
    }
    public static void closeAfterPostConnection(Connection conn, Statement state)throws SQLException{
        conn.close();
        state.close();
    }
}
