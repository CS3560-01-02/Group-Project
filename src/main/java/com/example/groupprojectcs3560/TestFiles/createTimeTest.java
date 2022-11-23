package com.example.groupprojectcs3560.TestFiles;

import com.example.groupprojectcs3560.SQLConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createTimeTest {

    @FXML
    Button clockInButtonTEST;

    @FXML
    Label displayClockInTime;

    public void createTimeRecord() throws SQLException {

        Connection conn = SQLConnection.databaseConnect();

        Date currentDate = null;
        String Time_ID = "1111";
        String Emp_ID = "1";
        String workedDate = "2022-11-23";
        String ShiftIn = "22:33:22";
        String ShiftOut = "82:33:22";
        String MealIn = "43:33:22";
        String MealOut = "20:33:22";

        Statement stat = conn.createStatement();
        String sql = "INSERT INTO TimeWorked (time_id, emp_id, workedDate, shiftIn, shiftOut, mealIn, mealOut)" + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        if (clockInButtonTEST.getText().equals("Clock Out")) {
            currentDate = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

            displayClockInTime.setText("Clocked out at " + timeFormat.format(currentDate));
            clockInButtonTEST.setText("Clock In");
        } else {

            currentDate = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

            displayClockInTime.setText("Clocked in at " + timeFormat.format(currentDate));
            clockInButtonTEST.setText("Clock Out");
        }

        preparedStatement.setInt(1, Integer.parseInt(Time_ID));
        preparedStatement.setInt(2, Integer.parseInt(Emp_ID));
        preparedStatement.setString(3, workedDate);
        preparedStatement.setString(4, ShiftIn);
        preparedStatement.setString(5, ShiftOut);
        preparedStatement.setString(6, MealIn);
        preparedStatement.setString(7, MealOut);


        preparedStatement.executeUpdate();
        SQLConnection.databaseDisconnect(conn);

    }

}
