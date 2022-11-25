package com.example.groupprojectcs3560;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class EditTimesheetController {

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

    public void switchToTimeWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("timeWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchViewRequestScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewRequestWindow.fxml"));
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
