package com.example.groupprojectcs3560;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeJobController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField employeeTextField;
    @FXML
    Label confirmationLabel;

    public void promoteEmployee(ActionEvent event) throws IOException, SQLException {
        Connection conn = SQLConnection.databaseConnect();
        try {
            int employeeID = Integer.parseInt(employeeTextField.getText());
            if(checkSupervisor(employeeID) == 1) {
                confirmationLabel.setText("Already a supervisor!");
            }
            else {
                String sql = "INSERT INTO employeeposition (emp_id, job_id, datePromoted)" + "VALUES(?,?,?);";

                java.util.Date date = new Date();
                SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
                String todayDate = currentDate.format(date);

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, employeeID);
                preparedStatement.setInt(2, 2);
                preparedStatement.setString(3, todayDate);
                preparedStatement.executeUpdate();
                confirmationLabel.setText("Promoted!");
            }
        }
        catch(Exception e) {
            confirmationLabel.setText("Invalid employee/Changed job too recently!");
        }


    }

    public void demoteEmployee(ActionEvent event) throws IOException, SQLException {
        Connection conn = SQLConnection.databaseConnect();
        try {
            int employeeID = Integer.parseInt(employeeTextField.getText());
            if(checkSupervisor(employeeID) == 0) {
                confirmationLabel.setText("Already an employee!");
            }
            else {
                String sql = "INSERT INTO employeeposition (emp_id, job_id, datePromoted)" + "VALUES(?,?,?);";

                java.util.Date date = new Date();
                SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
                String todayDate = currentDate.format(date);

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, employeeID);
                preparedStatement.setInt(2, 3);
                preparedStatement.setString(3, todayDate);
                preparedStatement.executeUpdate();
                confirmationLabel.setText("Demoted!");
            }
        }
        catch(Exception e) {
            confirmationLabel.setText("Invalid employee/Changed job too recently!");
        }


    }
    public int checkSupervisor(int empID) throws IOException, SQLException {

        Connection conn = SQLConnection.databaseConnect();

        ResultSet rs = null;

        int jobIDField = 0;

        String sql = "select * from employeeposition where emp_id = '" + empID + "' order by datePromoted desc limit 1;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        rs = preparedStatement.executeQuery();

        if (rs.next()) {
            jobIDField = rs.getInt("job_id");
        }

        if(jobIDField == 2) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public void switchToCreateEmployeeWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createEmployeeWIndow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
