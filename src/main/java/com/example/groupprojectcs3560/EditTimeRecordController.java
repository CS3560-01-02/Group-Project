package com.example.groupprojectcs3560;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditTimeRecordController {
    @FXML
    TextField timeIDTextField;
    @FXML
    TextField clockInTextField;
    @FXML
    TextField clockOutTextField;
    @FXML
    TextField mealInTextField;
    @FXML
    TextField mealOutTextField;
    @FXML
    Button enterIDButton;
    @FXML
    Button updateDBButton;
    @FXML
    Label mealInLabel;
    @FXML
    Label mealOutLabel;
    @FXML
    Label clockInLabel;
    @FXML
    Label clockOutLabel;
    @FXML
    Label timeIDErrorLabel;

    int currentTimeID = 0;

    public void showTime(ActionEvent event) throws IOException, SQLException, InterruptedException {
        try {
            Connection conn = SQLConnection.databaseConnect();
            currentTimeID = Integer.parseInt(timeIDTextField.getText());
            String clockInTime = "";
            String clockOutTime = "";
            String mealInTime = "";
            String mealOutTime = "";

            ResultSet rs = null;

            String sql = "SELECT * FROM timeworked WHERE time_id = '" + currentTimeID + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs  = preparedStatement.executeQuery();

            while(rs.next()){
                clockInTime = rs.getString("shiftIn");
                clockOutTime = rs.getString("shiftOut");
                mealInTime = rs.getString("mealIn");
                mealOutTime = rs.getString("mealOut");
            }

            clockInLabel.setText("Clock In: " + clockInTime);
            clockOutLabel.setText("Clock Out: " + clockOutTime);
            mealInLabel.setText("Meal In: " + mealInTime);
            mealOutLabel.setText("Meal Out: " + mealOutTime);

            clockInTextField.setDisable(false);
            clockOutTextField.setDisable(false);
            mealInTextField.setDisable(false);
            mealOutTextField.setDisable(false);
            updateDBButton.setDisable(false);

        }
        catch(Exception e) {
            timeIDErrorLabel.setText("Error!");
        }

    }

    public void updateTime(ActionEvent event) throws IOException, SQLException {
        Connection conn = SQLConnection.databaseConnect();
        String sql = "";
        try {
            if(!(clockInTextField.getText().equals(""))) {
                String newClockIn = clockInTextField.getText();
                sql = "update timeworked SET shiftIn = '" + newClockIn + "' where time_id = " + currentTimeID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
            if(!(clockOutTextField.getText().equals(""))) {
                String newClockOut = clockOutTextField.getText();
                sql = "update timeworked SET shiftOut = '" + newClockOut + "' where time_id = " + currentTimeID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
            if(!(mealInTextField.getText().equals(""))) {
                String newMealIn = mealInTextField.getText();
                sql = "update timeworked SET mealIn = '" + newMealIn + "' where time_id = " + currentTimeID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }
            if(!(mealOutTextField.getText().equals(""))) {
                String newMealOut = mealOutTextField.getText();
                sql = "update timeworked SET mealOut = '" + newMealOut + "' where time_id = " + currentTimeID + ";";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.executeUpdate();
            }

            timeIDErrorLabel.setText("Changes saved!");
        }
        catch(Exception e) {
            timeIDErrorLabel.setText("Time format incorrect!");
        }


    }
}
