package com.example.groupprojectcs3560;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class createRequestTest {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    CheckBox approvedBox;
    @FXML
    TextField requestFieldTEST;
    @FXML
    TextField requestRequestIDText;
    @FXML
    TextField requestEmployeeIDText;
    @FXML
    TextField requestDate;
    @FXML
    TextField requestTime;

    @FXML
    TextField getRequestIDTEXT;


    public void createRequest(ActionEvent event) throws IOException, SQLException {

        final String DB_URL = "jdbc:mysql://10.110.167.161:3306/timesheet?serverTimezone=UTC";
        final String USERNAME = "waffles";
        final String PASSWORD = "ilovelappland";

        String requestID = requestRequestIDText.getText();
        String employeeID = requestEmployeeIDText.getText();
        String description = requestFieldTEST.getText();
        String date = requestDate.getText();
        String time = requestTime.getText();
        Boolean approved = approvedBox.isSelected();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stat = conn.createStatement();
            String sql = "INSERT INTO request (req_id, emp_id, reqDate, reqTime, description, approved)" + "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(requestID));
            preparedStatement.setInt(2, Integer.parseInt(employeeID));
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, time);
            preparedStatement.setString(5, description);
            preparedStatement.setBoolean(6, approved);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToGetRequestWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("getRequestWindowTEST.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
