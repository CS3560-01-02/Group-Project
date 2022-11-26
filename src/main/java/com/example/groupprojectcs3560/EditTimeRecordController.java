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

//Original values from the time record that was searched
    String OGclockInTime = "";
    String OGclockOutTime = "";
    String OGmealInTime = "";
    String OGmealOutTime = "";

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
                OGclockInTime = rs.getString("shiftIn");
                OGclockOutTime = rs.getString("shiftOut");
                OGmealInTime = rs.getString("mealIn");
                OGmealOutTime = rs.getString("mealOut");
            }

            clockInLabel.setText("Clock In: " + OGclockInTime);
            clockOutLabel.setText("Clock Out: " + OGclockOutTime);
            mealInLabel.setText("Meal In: " + OGmealInTime);
            mealOutLabel.setText("Meal Out: " + OGmealOutTime);

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

        //If the record change is invalid, change the time record back using the saved values
        if (checkValidTimeRecord() == false) {

            String sql1 = null;
            String sql2 = null;
            String sql3 = null;
            String sql4 = null;

            sql1 = "update timeworked SET shiftIn = '" + OGclockInTime + "' where time_id = " + currentTimeID + ";";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.executeUpdate();

            sql2 = "update timeworked SET shiftOut = '" + OGclockOutTime + "' where time_id = " + currentTimeID + ";";
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.executeUpdate();

            sql3 = "update timeworked SET mealIn = '" + OGmealInTime + "' where time_id = " + currentTimeID + ";";
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            preparedStatement3.executeUpdate();

            sql4 = "update timeworked SET mealOut = '" + OGmealOutTime + "' where time_id = " + currentTimeID + ";";
            PreparedStatement preparedStatement4 = conn.prepareStatement(sql4);
            preparedStatement4.executeUpdate();

            System.out.println("invalid input");
        } else {
            System.out.println("Valid!");
        }
        SQLConnection.databaseDisconnect(conn);
    } //end updateTime

    public boolean checkValidTimeRecord() throws SQLException {

        String check = null;
        boolean valid = true;


        Connection conn = SQLConnection.databaseConnect();
        String sql = "SELECT * from timeworked where (mealOut between shiftIn and shiftOut and mealIn between shiftIn and shiftOut and timediff(mealOut,mealIn) > 0 or ((mealOut = 0 and mealIn = 0) or (mealOut is null and mealIn is null))and timediff(shiftOut,shiftIn) > 0) and time_id = " + currentTimeID + ";";
        ResultSet rs = null;

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            check = rs.getString("shiftIn");
        }
        //if the time record change is invalid, check should be null because the SQL statement returns a result set of null values
        if (check == null) {
            valid = false;
        }
        SQLConnection.databaseDisconnect(conn);
        return valid;
    } //end checkValidTimeRecord

    public void switchToEditTimeSheetScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("editTimeSheet.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
