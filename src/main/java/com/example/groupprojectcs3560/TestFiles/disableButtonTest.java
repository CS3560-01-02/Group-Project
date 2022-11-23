package com.example.groupprojectcs3560.TestFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class disableButtonTest {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int mealCounter = 0;
    private int clockCounter = 0;
    @FXML
    Button button1;

    @FXML
    Button button2;
    public void clockIn(ActionEvent event) throws IOException {

        if(clockCounter == 0) {
            button2.setText("Clock Out");
            button1.setDisable(false);
            clockCounter++;
        }
        else {
            button2.setText("Clock In");
            button1.setDisable(true);
            clockCounter--;
        }
    }
    public void mealIn(ActionEvent event) throws IOException {

        if(mealCounter == 0) {
            button1.setText("Meal Out");
            button2.setDisable(true);
            mealCounter++;
        }
        else {
            button1.setText("Meal In");
            button2.setDisable(false);
            button1.setDisable(true);
            mealCounter--;
        }
    }
}
