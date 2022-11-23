package com.example.groupprojectcs3560.TestFiles;

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

public class getRequestTest {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    TextField getRequestIDTEXT;
    @FXML
    TextField fetchedRequest;

    public void getRequest() {
        final String DB_URL = "jdbc:mysql://10.110.167.161:3306/timesheet?serverTimezone=UTC";
        final String USERNAME = "waffles";
        final String PASSWORD = "ilovelappland";
        String foundDescription = "";

        String requestedID = getRequestIDTEXT.getText();

        ResultSet rs = null;

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stat = conn.createStatement();
            String sql = "SELECT description FROM request WHERE req_id = " + requestedID + ";";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            rs  = preparedStatement.executeQuery();

            if(rs.next()){
                foundDescription = rs.getString("description");
            }

            System.out.println(foundDescription);
            fetchedRequest.setText(foundDescription);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToCreateRequestWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createRequestWindowTEST.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
