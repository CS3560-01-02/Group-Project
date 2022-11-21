package com.example.groupprojectcs3560.DAOfiles;

import com.example.groupprojectcs3560.Employee;

import java.sql.Connection;
import java.sql.SQLException;

import static com.example.groupprojectcs3560.SQLConnection.databaseConnect;

public class EmployeeDAO {


    public static Employee searchEmployee(String employeeID) throws SQLException {

        databaseConnect();

        String select = "SELECT * FROM employee WHERE employee_id=" + employeeID;

        Employee bruh = new Employee();

        return bruh;
    }
}
