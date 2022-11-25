package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField firstNameText;
    @FXML
    TextField lastNameText;

    int currentID = Employee.empID;

    public void createEmployee(ActionEvent event) throws IOException, SQLException {

        Connection conn = SQLConnection.databaseConnect();

        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String userName = String.valueOf(firstName.charAt(0));
        userName = userName.concat(lastName); // I need to add username validation, will do later
        String tempPassword = "ChangeMePlease";

        //insert employee record into db
        String sql1 = "INSERT INTO employee (sup_id, employmentDate, firstName, lastName, userName, password, phoneNumber, emailAddress, street, city, state, zip)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //search for newest employee's id
        String sql2 = "SELECT * from employee ORDER BY emp_id DESC LIMIT 1;";

        //make new employeeposition record for new employee
        String sql3 = "INSERT INTO employeeposition(emp_id, job_id, datePromoted)" + "VALUES(?,?,?);";

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
            preparedStatement3.executeQuery();


        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
