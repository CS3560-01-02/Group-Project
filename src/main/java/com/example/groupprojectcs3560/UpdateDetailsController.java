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

        try {
            int phoneNumber = Integer.parseInt(phoneNumberText.getText());
            String password = passwordText.getText();
            String emailAddress = emailAddressText.getText();
            String street = streetText.getText();
            String city = cityText.getText();
            String state = stateText.getText();
            int zip = Integer.parseInt(zipText.getText());

            String sql = "update Employee SET phoneNumber = '" + phoneNumber + "' where emp_id = " + currentID + ";";
            String sql2 = "update Employee SET emailAddress = '" + emailAddress + "' where emp_id = " + currentID + ";";
            String sql3 = "update Employee SET street = '" + street + "' where emp_id = " + currentID + ";";
            String sql4 = "update Employee SET city = '" + city + "' where emp_id = " + currentID + ";";
            String sql5 = "update Employee SET state = '" + state + "' where emp_id = " + currentID + ";";
            String sql6 = "update Employee SET zip = '" + zip + "' where emp_id = " + currentID + ";";
            String sql7 = "update Employee SET password = '" + password + "' where emp_id = " + currentID + ";";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.addBatch(sql);
            preparedStatement.addBatch(sql2);
            preparedStatement.addBatch(sql3);
            preparedStatement.addBatch(sql4);
            preparedStatement.addBatch(sql5);
            preparedStatement.addBatch(sql6);
            preparedStatement.addBatch(sql7);
            preparedStatement.executeBatch();
            confirmationLabel.setText("Changes saved!");

        }
        catch(Exception e) {
            confirmationLabel.setText("Please make sure phone number and zip are numbers only!");
        }


    }

}
