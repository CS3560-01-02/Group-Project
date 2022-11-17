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

public class RequestController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField requestTextField;

    @FXML
    Label requestConfirmationLabel;


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

    public void switchToEstimatePayWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("estimatePayWindow.fxml"));
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

    public void getRequestText(ActionEvent event) throws IOException {
        String description = requestTextField.getText();

        if(description.isEmpty()) {
            requestConfirmationLabel.setText("Please enter a request!");
        }
        else {
            requestConfirmationLabel.setText("Request Sent!");
            requestTextField.setText("");
            // and then do something with description and save it to db
        }

    }


}