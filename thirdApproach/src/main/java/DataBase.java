/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johns
 */
public class DataBase {

    public static Connection connectDatabase(String database_name) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

//        FileReader reader = new FileReader("portNumbers.properties");
//        Properties p = new Properties();
//        p.load(reader);
        final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;Database=Archi;portNumber=1433";
        final String USER = "root";
        final String PASS = "root";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        return connection;
    }

    public static Statement createStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        return statement;
    }

    public static List createMultipleResultSet(String sql) throws SQLException, ClassNotFoundException, IOException {

        List<ArrayList<String>> wholeList = new ArrayList<>();
        ArrayList<String> columnName = new ArrayList<String>();

        Connection connection = DataBase.connectDatabase("Archi");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        ResultSetMetaData rsmd = result.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        for (int i = 1; i <= numberOfColumns; i++) {
            String colName = rsmd.getColumnName(i);
            columnName.add(colName);
        }
        wholeList.add(columnName);
        while (result.next()) {

            ArrayList<String> individualRecord = new ArrayList<String>();
            for (int j = 0; j < numberOfColumns; j++) {

                individualRecord.add(result.getString(columnName.get(j)));

            }
            wholeList.add(individualRecord);

        }
        DataBase.closeConnectionAfterGET(connection, statement, result);
        for (ArrayList obj : wholeList) {
            ArrayList<String> temp = obj;
            for (String string : temp) {
                System.out.print(string + "\t|\t");
            }
            System.out.println();
        }
        return wholeList;
    }

    public static Integer getIntegerFromDB(String sql) throws SQLException, ClassNotFoundException, IOException {
        Integer intResult = null;
        Connection connection = DataBase.connectDatabase("Archi");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            intResult = result.getInt(1);
        }
        DataBase.closeConnectionAfterGET(connection, statement, result);

        return intResult;
    }
     public static Long getIntegerFromDB_(String sql) throws SQLException, ClassNotFoundException, IOException {
        Long intResult = null;
        Connection connection = DataBase.connectDatabase("Archi");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            intResult = result.getLong(1);
        }
        DataBase.closeConnectionAfterGET(connection, statement, result);

        return intResult;
    }

    public static String getStringFromDB(String sql) throws SQLException, ClassNotFoundException, IOException {
        String intResult = null;
        Connection connection = DataBase.connectDatabase("Archi");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            intResult = result.getString(1);
        }
        DataBase.closeConnectionAfterGET(connection, statement, result);

        return intResult;
    }

    public static Timestamp getTimeStampFromDB(String sql) throws SQLException, ClassNotFoundException, IOException {
        Timestamp bool = null;
        Connection connection = DataBase.connectDatabase("Archi");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            bool = result.getTimestamp(1);
        }

        DataBase.closeConnectionAfterGET(connection, statement, result);

        return bool;
    }

    public static void updateSession(String SessID, Integer e_id, Timestamp time, String browser) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = DataBase.connectDatabase("master");
        Statement statement = connection.createStatement();
        String sql = "update thirdApproachSession set s_id_Created = '" + SessID + "' where e_id=" + e_id + "";
        statement.executeUpdate(sql);
        sql = "update thirdApproachSession set login_time = '" + time + "' where e_id=" + e_id + "";
        statement.executeUpdate(sql);
        sql = "update thirdApproachSession set User_Agent = '" + browser + "' where e_id=" + e_id + "";
        statement.executeUpdate(sql);
        sql = "update thirdApproachSession set logout_time = NULL where e_id=" + e_id + "";
        statement.executeUpdate(sql);
        DataBase.closeConnectionAfterPOST(connection, statement);
    }

    public static void insertSession(String SessID, Integer e_id, Timestamp time, String browser) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = DataBase.connectDatabase("master");
        Statement statement = connection.createStatement();
        String sql = "insert into thirdApproachSession (s_id_Created,e_id,login_time,User_Agent) values('" + SessID + "'," + e_id + ",'" + time + "','" + browser + "')";
        statement.executeUpdate(sql);
        DataBase.closeConnectionAfterPOST(connection, statement);
    }

    public static void postintoDB_Query(String sql) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = DataBase.connectDatabase("master");
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        DataBase.closeConnectionAfterPOST(connection, statement);
    }

    public static void updateDB(String sql) throws ClassNotFoundException, SQLException, IOException {
        Connection connection = DataBase.connectDatabase("master");
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        DataBase.closeConnectionAfterPOST(connection, statement);
    }

    public static void closeConnectionAfterGET(Connection connection, Statement statement, ResultSet resultset) throws SQLException {
        connection.close();
        statement.close();
        resultset.close();
    }

    public static void closeConnectionAfterPOST(Connection connection, Statement statement) throws SQLException {
        connection.close();
        statement.close();
    }

}
