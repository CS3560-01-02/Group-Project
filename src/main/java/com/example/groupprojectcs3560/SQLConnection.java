package com.example.groupprojectcs3560;

import java.sql.*;

public class SQLConnection {

    static String url = "database URL here";
    static String username = "username";
    static String password = "password";
    static Connection connect = null;

    //Connecting to database
    public static void databaseConnect() throws SQLException {

        try {
            connect = DriverManager.getConnection(url, username, password);

            System.out.println("connected!");
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
        }
    } //end databaseConnect

    //Closing connection to database
    public static void databaseDisconnect() throws SQLException {

        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection to database");
        }
    } //end databaseDisconnect

}
