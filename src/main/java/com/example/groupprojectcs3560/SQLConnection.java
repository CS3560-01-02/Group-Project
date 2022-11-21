package com.example.groupprojectcs3560;

import java.sql.*;

public class SQLConnection {

    final static String url = "jdbc:mysql://10.110.167.161:3306:3306/timesheet?serverTimezone=UTC";
    final static String username = "ender";
    final static String password = "Poggers1118!";
    static Connection connect = null;

    //Connecting to database
    public static Connection databaseConnect() throws SQLException {

        try {
            connect = DriverManager.getConnection(url, username, password);

            System.out.println("connected!");
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
        }
        return connect;
    } //end databaseConnect
}
