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
import java.util.Calendar;
import java.util.Date;

public class createTimeTest {

    @FXML
    Button clockInButtonTEST;

    @FXML
    Label displayClockInTime;

    public void createTimeRecord() throws SQLException {

        Connection conn = SQLConnection.databaseConnect();

        int empID = 001;
        Date date = new Date();
        SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
        String todayDate = currentDate.format(date);
        String shiftIn = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String shiftOut = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String mealIn = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String mealOut = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        Statement stat = conn.createStatement();
        String sql = "INSERT INTO TimeWorked (emp_id, workedDate, shiftIn, shiftOut, mealIn, mealOut)" + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, empID);
        preparedStatement.setString(2, todayDate);
        preparedStatement.setString(3, shiftIn);
        preparedStatement.setString(4, shiftOut);
        preparedStatement.setString(5, mealIn);
        preparedStatement.setString(6, mealOut);

        preparedStatement.executeUpdate();

        SQLConnection.databaseDisconnect(conn);

//        Statement stat = conn.createStatement();
//        String sql = "INSERT INTO TimeWorked (time_id, emp_id, workedDate, shiftIn, shiftOut, mealIn, mealOut)" + "VALUES(?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement preparedStatement = conn.prepareStatement(sql);
//
//        if (clockInButtonTEST.getText().equals("Clock Out")) {
//            currentDate = new Date();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//
//            displayClockInTime.setText("Clocked out at " + timeFormat.format(currentDate));
//            clockInButtonTEST.setText("Clock In");
//        } else {
//
//            currentDate = new Date();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//
//            displayClockInTime.setText("Clocked in at " + timeFormat.format(currentDate));
//            clockInButtonTEST.setText("Clock Out");
//        }
//
//        preparedStatement.setInt(1, Integer.parseInt(Time_ID));
//        preparedStatement.setInt(2, Integer.parseInt(Emp_ID));
//        preparedStatement.setString(3, workedDate);
//        preparedStatement.setString(4, ShiftIn);
//        preparedStatement.setString(5, ShiftOut);
//        preparedStatement.setString(6, MealIn);
//        preparedStatement.setString(7, MealOut);
//
//
//        preparedStatement.executeUpdate();
//        SQLConnection.databaseDisconnect(conn);

    }

}
