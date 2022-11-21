package com.example.groupprojectcs3560;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class createAccountTest {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField empIDText;
    @FXML
    TextField supIDText;
    @FXML
    TextField employmentDateText;
    @FXML
    TextField firstNameText;
    @FXML
    TextField lastNameText;
    @FXML
    TextField userNameText;
    @FXML
    TextField passwordText;
    @FXML
    TextField phoneNumberText;
    @FXML
    TextField emailAddressText;
    @FXML
    TextField streetText;
    @FXML
    TextField cityText;
    @FXML
    TextField stateText;
    @FXML
    TextField zipText;

    public void createEmployee(ActionEvent event) throws IOException {

        final String DB_URL = "jdbc:mysql://10.110.167.161:3306/timesheet?serverTimezone=UTC";
        final String USERNAME = "waffles";
        final String PASSWORD = "ilovelappland";

        String empID = empIDText.getText();
        String supID = supIDText.getText();
        String employmentDate = employmentDateText.getText();
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String userName = userNameText.getText();
        String password = passwordText.getText();
        String phoneNumber = phoneNumberText.getText();
        String emailAddress = emailAddressText.getText();
        String street = streetText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String zip = zipText.getText();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stat = conn.createStatement();
            String sql = "INSERT INTO employee (emp_id, sup_id, employmentDate, firstName, lastName, userName, password, phoneNumber, emailAddress, street, city, state, zip)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.parseInt(empID));
            preparedStatement.setInt(2, Integer.parseInt(supID));
            preparedStatement.setString(3, employmentDate);
            preparedStatement.setString(4, firstName);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, userName);
            preparedStatement.setString(7, password);
            preparedStatement.setString(8, phoneNumber);
            preparedStatement.setString(9, emailAddress);
            preparedStatement.setString(10, street);
            preparedStatement.setString(11, city);
            preparedStatement.setString(12, state);
            preparedStatement.setInt(13, Integer.parseInt(zip));

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                Employee employee = new Employee();
                employee.empID = empID;
                employee.supID = supID;
                employee.employmentDate = employmentDate;
                employee.firstName = firstName;
                employee.lastName = lastName;
                employee.userName = userName;
                employee.password = password;
                employee.phoneNumber = phoneNumber;
                employee.emailAddress = emailAddress;
                employee.street = street;
                employee.city = city;
                employee.state = state;
                employee.zip = zip;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
