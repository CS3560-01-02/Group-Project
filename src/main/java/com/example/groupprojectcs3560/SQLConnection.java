package com.example.groupprojectcs3560;

import java.sql.*;

public class SQLConnection {

    final static String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    final static String USERNAME = "gamers";
    final static String PASSWORD = "poggers123!";
    static Connection connect = null;

    //Connecting to database
    public static Connection databaseConnect() throws SQLException {

        try {
            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            System.out.println("connected!");
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
            throw e;
        }
        return connect;
    } //end databaseConnect

    public static void databaseDisconnect(Connection connect) throws SQLException {

        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
                System.out.println("Closed connection!");
            }
        } catch (SQLException e) {
            System.out.println("Connection couldn't be closed");
            throw e;
        }
    } //end databaseDisconnect
}
