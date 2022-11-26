package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RequestController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField requestTextField;

    @FXML
    Label requestConfirmationLabel;

    int currentID = Employee.empID;
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

    public void switchToUpdateWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("updateDetailsWindow.fxml"));
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

    public void getRequestText(ActionEvent event) throws IOException, SQLException {
        String description = requestTextField.getText();
        Connection conn = SQLConnection.databaseConnect();
        if(description.isEmpty()) {
            requestConfirmationLabel.setText("Please enter a request!");
        }
        else {
            requestConfirmationLabel.setText("Request Sent!");
            requestTextField.setText("");

            Date date = new Date();
            SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
            String todayDate = currentDate.format(date);
            String currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

            Statement stat = conn.createStatement();
            String sql = "INSERT INTO Request (emp_id, reqDate, reqTime, description, approved)" + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, currentID);
            preparedStatement.setString(2, todayDate);
            preparedStatement.setString(3, currentTime);
            preparedStatement.setString(4, description);
            preparedStatement.setBoolean(5, false);

            preparedStatement.executeUpdate();
        }

    }


}