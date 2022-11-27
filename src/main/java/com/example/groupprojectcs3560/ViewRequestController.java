package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewRequestController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button SwitchToSearchEmployeeScene;
    @FXML
    Button SwitchToViewRequestScene;
    @FXML
    Button LogoutButtonForSupervisor;
    @FXML
    Button SwitchToEditTimesheetScene;
    @FXML
    Button SwitchToCreateEmployeeScene;
    @FXML
    Button normalViewButton;
    @FXML
    Button viewLatestRequest;
    @FXML
    TextArea fetchedRequest;
    @FXML
    Button approveRequest;
    int requestID = -1;

    public void initialize() {

        fetchedRequest.setEditable(false);
        approveRequest.setDisable(true);
        fetchedRequest.setWrapText(true);
    }

    public void getLatestRequest(ActionEvent event) throws IOException, SQLException {

        String requestDescription = "";
        Connection conn = SQLConnection.databaseConnect();
        int currentID = Employee.empID;
        ResultSet rs = null;

        String sql = "SELECT * FROM request JOIN employee WHERE request.emp_id = employee.emp_id AND sup_id = " + currentID + " AND approved = 0 ORDER BY reqDate ASC limit 1;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            requestDescription = rs.getString("description");
            requestID = rs.getInt("req_id");
        }

        if (requestDescription.equals("")) {
            fetchedRequest.setText("No requests made");
        } else {
            fetchedRequest.setText(requestDescription);
            approveRequest.setDisable(false);
        }

    } //end getLatestRequest

    public void approveRequest(ActionEvent event) throws SQLException {

        Connection conn = SQLConnection.databaseConnect();

        String setApprovedToTrue = "UPDATE request SET approved = true WHERE req_id = " + requestID + ";";
        PreparedStatement preparedStatementTRUE = conn.prepareStatement(setApprovedToTrue);
        preparedStatementTRUE.executeUpdate();

        approveRequest.setDisable(true);
        fetchedRequest.setText("");
    }


    public void switchToTimeWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("timeWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchSearchEmployeeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("searchEmployeeWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditTimeSheetScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("editTimeSheet.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateEmployeeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createEmployeeWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoginWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
