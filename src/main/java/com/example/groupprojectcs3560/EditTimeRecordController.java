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

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditTimeRecordController {
    private Stage stage;
    private Scene scene;
    private Parent root;
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

    String newClockIn = "";
    String newClockOut = "";
    String newMealIn = "";
    String newMealOut = "";

    public void showTime(ActionEvent event) throws IOException, SQLException, InterruptedException {
        try {
            Connection conn = SQLConnection.databaseConnect();
            currentTimeID = Integer.parseInt(timeIDTextField.getText());

            ResultSet rs = null;

            String sql = "SELECT * FROM timeworked WHERE time_id = '" + currentTimeID + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs  = preparedStatement.executeQuery();

            while(rs.next()){
                //Saves the original values as well
                newClockIn = rs.getString("shiftIn");
                newClockOut = rs.getString("shiftOut");
                newMealIn = rs.getString("mealIn");
                newMealOut = rs.getString("mealOut");
            }

            clockInLabel.setText("Clock In: " + newClockIn);
            clockOutLabel.setText("Clock Out: " + newClockOut);
            mealInLabel.setText("Meal In: " + newMealIn);
            mealOutLabel.setText("Meal Out: " + newMealOut);

            clockInTextField.setDisable(false);
            clockOutTextField.setDisable(false);
            mealInTextField.setDisable(false);
            mealOutTextField.setDisable(false);
            updateDBButton.setDisable(false);

        }
        catch(Exception e) {
            timeIDErrorLabel.setText("Error!");
        }

    } //end showTime

    public void updateTime(ActionEvent event) throws IOException, SQLException {
        Connection conn = SQLConnection.databaseConnect();
        String sql = "";

        try {
            //get original values
            sql = "SELECT * FROM timeworked WHERE time_id = '" + currentTimeID + "';";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs  = preparedStatement.executeQuery();

            while(rs.next()){
                //Saves the original values
                newClockIn = rs.getString("shiftIn");
                newClockOut = rs.getString("shiftOut");
                newMealIn = rs.getString("mealIn");
                newMealOut = rs.getString("mealOut");
            }

            //get inputted values for fields, update as necessary
            if(!(clockInTextField.getText().equals(""))) {
                newClockIn = clockInTextField.getText();
            }
            if(!(clockOutTextField.getText().equals(""))) {
                newClockOut = clockOutTextField.getText();
            }
            if(!(mealInTextField.getText().equals(""))) {
                newMealIn = mealInTextField.getText();
            }
            if(!(mealOutTextField.getText().equals(""))) {
                newMealOut = mealOutTextField.getText();
            }

            //check valid time
            if (checkValidTimeRecord(newClockIn, newClockOut, newMealIn, newMealOut)){
                //if valid, update db
                String sql1 = "update timeworked SET shiftIn = '" + newClockIn + "' where time_id = " + currentTimeID + ";";
                String sql2 = "update timeworked SET shiftOut = '" + newClockOut + "' where time_id = " + currentTimeID + ";";
                String sql3 = "update timeworked SET mealIn = '" + newMealIn + "' where time_id = " + currentTimeID + ";";
                String sql4 = "update timeworked SET mealOut = '" + newMealOut + "' where time_id = " + currentTimeID + ";";
                PreparedStatement preparedStatement2 = conn.prepareStatement(sql1);
                preparedStatement2.addBatch(sql1);
                preparedStatement2.addBatch(sql2);
                preparedStatement2.addBatch(sql3);
                preparedStatement2.addBatch(sql4);
                preparedStatement2.executeBatch();
                timeIDErrorLabel.setText("Changes saved!");
            } else {
                timeIDErrorLabel.setText("Invalid time input!");
            }

        }
        catch(Exception e) {
            timeIDErrorLabel.setText("Time format incorrect!");
            throw e;
        }

    } //end updateTime

    public boolean checkValidTimeRecord(String newClockIn, String newClockOut, String newMealIn, String newMealOut) throws SQLException {

        try {
            int valid = 0;

            Connection conn = SQLConnection.databaseConnect();
            String sql = "SELECT IF ((('" + newMealOut + "' is null and '" + newMealIn + "' is null) or ('" + newMealOut + "' = 0 and '" + newMealIn + "' = 0)), timediff('" + newClockOut + "', '" + newClockIn + "') > 0, (timediff('" + newClockOut + "', '" + newClockIn + "') > 0) and (TIME_FORMAT('" + newMealOut + "', '%H:%i') between '" + newClockIn + "' and '" + newClockOut + "') and (TIME_FORMAT('" + newMealIn + "', '%H:%i') between '" + newClockIn + "' and '" + newClockOut + "') and timediff('" + newMealOut + "', '" + newMealIn + "') > 0) as valid;";
            ResultSet rs = null;

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                valid = rs.getInt("valid");
                System.out.println("Gotten int: " + valid);
            }
            SQLConnection.databaseDisconnect(conn);
            System.out.println("shiftIn: " + newClockIn + ", shiftOut: " + newClockOut + ", mealIn: " + newMealIn + ", mealOut: " + newMealOut);
            System.out.println("valid: " + valid);
            return valid == 1;
        } catch (SQLException e) {
            timeIDErrorLabel.setText("SQLException!");
            throw e;
        }
    } //end checkValidTimeRecord

    public void switchToEditTimeSheetScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("editTimeSheet.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
