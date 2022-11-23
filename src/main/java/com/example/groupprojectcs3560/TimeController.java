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
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    //direct connection to clockInButton from timeWindow.fxml
    @FXML
    Button clockInButton;

    //direct connection to timeLabel from timeWindow.fxml
    @FXML
    private Label timeLabel;

    //this just updates timeLabel to show what time someone pressed the clock in button
    //also changes text of clock in button to "clock out" and vice versa each time they press it
    @FXML
    public void showClockInTime() {
        if (clockInButton.getText().equals("Clock Out")) {
            Date currentDate = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

            timeLabel.setText("Clocked out at " + timeFormat.format(currentDate));
            clockInButton.setText("Clock In");
        } else {

            Date currentDate = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

            timeLabel.setText("Clocked in at " + timeFormat.format(currentDate));
            clockInButton.setText("Clock Out");
        }
    }

    public void switchToLoginWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));
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

    public void switchToEstimatePayWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("estimatePayWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}