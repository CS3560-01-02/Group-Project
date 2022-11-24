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
import java.sql.*;
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
        String clockInTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
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
        preparedStatement.setNull(4, Types.NULL);
        preparedStatement.setNull(5, Types.NULL);
        preparedStatement.setNull(6, Types.NULL);

        preparedStatement.executeUpdate();

        //SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        displayClockInTime.setText("Clocked in at " + clockInTime);

        SQLConnection.databaseDisconnect(conn);


    }

    public void clockOut() throws SQLException {

        Connection conn = SQLConnection.databaseConnect();

        int empID = 001;
        String clockOutTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        String updateSTM = "update timeWorked SET shiftOut = '" + clockOutTime + "' where emp_id = 1 and shiftOut is NULL;";
        PreparedStatement preparedStatement = conn.prepareStatement(updateSTM);
        preparedStatement.executeUpdate();

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        displayClockInTime.setText("Clocked out at " + clockOutTime);

        SQLConnection.databaseDisconnect(conn);
    }

}
