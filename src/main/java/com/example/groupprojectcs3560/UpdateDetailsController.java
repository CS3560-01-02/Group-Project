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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDetailsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    int currentID = Employee.empID;

    @FXML
    TextField phoneNumberText;
    @FXML
    TextField emailAddressText;
    @FXML
    TextField streetText;
    @FXML
    TextField cityText;
    @FXML
    TextField stateText;
    @FXML
    TextField zipText;
    @FXML
    TextField passwordText;
    @FXML
    Label updateLabel;
    @FXML
    Label confirmationLabel;

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

    public void updateDetails(ActionEvent event) throws IOException, SQLException {
        Connection conn = SQLConnection.databaseConnect();
        String sql = "";
        try {
            if(!(phoneNumberText.getText().equals(""))) {
                int phoneNumber = Integer.parseInt(phoneNumberText.getText());
                sql = "update Employee SET phoneNumber = '" + phoneNumber + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            if(!(emailAddressText.getText().equals(""))) {
                String emailAddress = emailAddressText.getText();
                sql = "update Employee SET emailAddress = '" + emailAddress + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            if(!(streetText.getText().equals(""))) {
                String street = streetText.getText();
                sql = "update Employee SET street = '" + street + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            if(!(cityText.getText().equals(""))) {
                String city = cityText.getText();
                sql = "update Employee SET city = '" + city + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            if(!(stateText.getText().equals(""))) {
                String state = stateText.getText();
                sql = "update Employee SET state = '" + state + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            if(!(zipText.getText().equals(""))) {
                int zip = Integer.parseInt(zipText.getText());
                sql = "update Employee SET zip = '" + zip + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            if(!(passwordText.getText().equals(""))) {
                String password = passwordText.getText();
                sql = "update Employee SET password = '" + password + "' where emp_id = " + currentID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
            confirmationLabel.setText("Changes saved!");
        }
        catch(Exception e) {
            confirmationLabel.setText("Please make sure phone number and zip are numbers only!");
        }


    }

}
