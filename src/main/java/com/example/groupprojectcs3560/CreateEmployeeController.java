package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.Employee;
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
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateEmployeeController {

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
    int currentID = Employee.empID;
    @FXML
    TextField firstNameText;
    @FXML
    TextField lastNameText;
    @FXML
    Label confirmationLabel;

    public void createEmployee(ActionEvent event) throws IOException, SQLException {

        Connection conn = SQLConnection.databaseConnect();

        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String userName =  "";
        boolean validUsername = false;
        String foundUsername = "";
        int counter = 0;

        while(validUsername == false) {
            userName = String.valueOf(firstName.charAt(0));
            if(counter == 0) {
                userName = userName.concat(lastName);
            }
            else {
                userName = userName.concat(lastName + counter);
            }

            String sql = "SELECT * FROM employee WHERE userName = '" + userName + "';";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                foundUsername = rs.getString("userName");
            }

            if(foundUsername.equals(userName)) {
                counter++;
            }
            else {
                validUsername = true;
            }

        }


        Random rand = new Random();
        int randomInt = rand.nextInt(1000);
        String tempPassword = "temp" + randomInt;

        //insert employee record into db
        String sql1 = "INSERT INTO employee (sup_id, employmentDate, firstName, lastName, userName, password, phoneNumber, emailAddress, street, city, state, zip)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //search for newest employee's id
        String sql2 = "SELECT * from employee ORDER BY emp_id DESC LIMIT 1;";

        //make new employeeposition record for new employee
        String sql3 = "INSERT INTO employeeposition (emp_id, job_id, datePromoted)" + "VALUES(?,?,?);";

        PreparedStatement preparedStatement = conn.prepareStatement(sql1);

        java.util.Date date = new Date();
        SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
        String todayDate = currentDate.format(date);

        try {
            preparedStatement.setInt(1, currentID); // sup id, from current login
            preparedStatement.setString(2, todayDate); // current date
            preparedStatement.setString(3, firstName); // from text field
            preparedStatement.setString(4, lastName); // from text field
            preparedStatement.setString(5, userName); // automatic
            preparedStatement.setString(6, tempPassword); // automatic, employee changes
            preparedStatement.setNull(7, Types.NULL); // employee changes
            preparedStatement.setNull(8, Types.NULL); // employee changes
            preparedStatement.setNull(9, Types.NULL); // employee changes
            preparedStatement.setNull(10, Types.NULL); // employee changes
            preparedStatement.setNull(11, Types.NULL); // employee changes
            preparedStatement.setNull(12, Types.NULL); // employee changes
            preparedStatement.executeUpdate();

            //get new employee's id
            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            ResultSet rs = preparedStatement2.executeQuery();

            int emp_id = -1;
            if (rs.next()) {
                emp_id = rs.getInt("emp_id");
            }

            //finalize employeeposition record sql stmt
            PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
            preparedStatement3.setInt(1, emp_id);
            preparedStatement3.setInt(2, 3);
            preparedStatement3.setString(3, todayDate);
            preparedStatement3.executeUpdate();

            confirmationLabel.setText("Account created! Username: " + userName + " Password: " + tempPassword);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

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

    public void switchToEditTimeSheetScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("editTimeSheet.fxml"));
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

    public void switchSearchEmployeeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("searchEmployeeWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
