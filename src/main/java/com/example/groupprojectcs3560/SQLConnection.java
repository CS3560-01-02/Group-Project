package com.example.groupprojectcs3560;

import java.sql.*;

public class SQLConnection {

    final static String DB_URL = "jdbc:mysql://10.110.167.161:3306/timesheet?serverTimezone=UTC";
    final static String USERNAME = "waffles";
    final static String PASSWORD = "ilovelappland";
    static Connection connect = null;

    //Connecting to database
    public static Connection databaseConnect() throws SQLException {

        try {
            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            System.out.println("connected!");
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
        }
        return connect;
    } //end databaseConnect

    public static void databaseDisconnect(Connection connect) throws SQLException {

        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
                System.out.println("Closed connection!");
            }
        } catch (Exception e) {
            System.out.println("Connection couldn't be closed");
        }
    } //end databaseDisconnect
}
