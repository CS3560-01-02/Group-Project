package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int tempID;
    Employee currentUser = new Employee();

    @FXML
    TextField userNameText;

    @FXML
    PasswordField passwordText;

    @FXML
    Label loginLabel;

    @FXML
    Label errorLabel;

    public void verifyLogin(ActionEvent event) throws IOException, SQLException, InterruptedException {
        try {
            Connection conn = SQLConnection.databaseConnect();
            String currentUserName = userNameText.getText();
            String currentPassword = passwordText.getText();
            String correctPassword = null;
            ResultSet rs = null;

            String sql = "SELECT * FROM employee WHERE userName = '" + currentUserName + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs  = preparedStatement.executeQuery();

            while(rs.next()){
                correctPassword = rs.getString("password");
                tempID = rs.getInt("emp_id");
            }

            if(correctPassword.equals(currentPassword)) {
                currentUser.setEmpID(tempID);
                Parent root = FXMLLoader.load(getClass().getResource("timeWindow.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                errorLabel.setText("Wrong credentials!");
            }
        }
        catch(Exception e) {
            errorLabel.setText("Wrong credentials!");
        }

    }
    public void switchToLoginWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));
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


}