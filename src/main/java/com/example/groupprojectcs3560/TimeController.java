package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    //direct connection to clockInButton from timeWindow.fxml
    @FXML
    Button clockButton;
    @FXML
    Button mealButton;

    private int mealCounter = 0;
    private int clockCounter = 0;

    private int currentID = Employee.empID;

    //direct connection to timeLabel from timeWindow.fxml
    @FXML
    private Label timeLabel;

    //this just updates timeLabel to show what time someone pressed the clock in button
    //also changes text of clock in button to "clock out" and vice versa each time they press it
    public void pressClockButton() throws SQLException {
        Connection conn = SQLConnection.databaseConnect();
        if(clockCounter == 0) {

            Date date = new Date();
            SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
            String todayDate = currentDate.format(date);
            String shiftIn = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

            Statement stat = conn.createStatement();
            String sql = "INSERT INTO TimeWorked (emp_id, workedDate, shiftIn, shiftOut, mealIn, mealOut)" + "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, currentID);
            preparedStatement.setString(2, todayDate);
            preparedStatement.setString(3, shiftIn);
            preparedStatement.setNull(4, Types.NULL);
            preparedStatement.setNull(5, Types.NULL);
            preparedStatement.setNull(6, Types.NULL);

            preparedStatement.executeUpdate();

            clockButton.setText("Clock Out");
            mealButton.setDisable(false);
            clockCounter++;
        }
        else {

            String clockOutTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

            String sql2 = "update timeWorked SET shiftOut = '" + clockOutTime + "' where emp_id = " + currentID + " and shiftOut is NULL;";
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.executeUpdate();

            String sql3 = "update timeWorked SET mealIn = '" + "-" + "' where emp_id = " + currentID + " and mealIn is NULL;";
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            preparedStatement3.executeUpdate();

            String sql4 = "update timeWorked SET mealOut = '" + "-" + "' where emp_id = " + currentID + " and mealOut is NULL;";
            PreparedStatement preparedStatement4 = conn.prepareStatement(sql4);
            preparedStatement4.executeUpdate();

            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

            SQLConnection.databaseDisconnect(conn);

            clockButton.setText("Clock In");
            mealButton.setDisable(true);
            clockCounter--;
        }

//        if (clockButton.getText().equals("Clock Out")) {
//            Date currentDate = new Date();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//
//            timeLabel.setText("Clocked out at " + timeFormat.format(currentDate));
//            clockButton.setText("Clock In");
//        } else {
//
//            Date currentDate = new Date();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//
//            timeLabel.setText("Clocked in at " + timeFormat.format(currentDate));
//            clockButton.setText("Clock Out");
//        }
    }

    public void pressMealButton() throws SQLException {
        Connection conn = SQLConnection.databaseConnect();
        if(mealCounter == 0) {

            String mealInTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

            String sql = "update timeWorked SET mealIn = '" + mealInTime + "' where emp_id = " + currentID + " and mealIn is NULL;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();

            mealButton.setText("Meal Out");
            clockButton.setDisable(true);
            mealCounter++;
        }
        else {

            String mealOutTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

            String sql2 = "update timeWorked SET mealOut = '" + mealOutTime + "' where emp_id = " + currentID + " and mealOut is NULL;";
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.executeUpdate();

            mealButton.setText("Meal In");
            clockButton.setDisable(false);
            mealButton.setDisable(true);
            mealCounter--;
        }

//        if (clockButton.getText().equals("Clock Out")) {
//            Date currentDate = new Date();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//
//            timeLabel.setText("Clocked out at " + timeFormat.format(currentDate));
//            clockButton.setText("Clock In");
//        } else {
//
//            Date currentDate = new Date();
//            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
//
//            timeLabel.setText("Clocked in at " + timeFormat.format(currentDate));
//            clockButton.setText("Clock Out");
//        }
    }

    public void switchToLoginWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAccountWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createAccountWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTimeWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("timeWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTimesheetWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("timesheetWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRequestWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("requestWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUpdateWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("estimatePayWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}