package com.example.groupprojectcs3560.DAOfiles;

import com.example.groupprojectcs3560.ModelClasses.Employee;

import java.sql.SQLException;

public class EmployeeDAO {


    public static Employee searchEmployee(String employeeID) throws SQLException {


        String select = "SELECT * FROM employee WHERE employee_id=" + employeeID;

        Employee bruh = new Employee();

        return bruh;
    }
}
