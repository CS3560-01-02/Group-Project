package com.example.groupprojectcs3560.ModelClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeTESTObject {

    private SimpleIntegerProperty employeeIDForTableView;
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty email;

    private SimpleStringProperty username;
    private SimpleStringProperty password;


    public EmployeeTESTObject(Integer empIDForTable_, String name_, String phoneNumber_, String email_, String username_, String password_) {

        this.employeeIDForTableView = new SimpleIntegerProperty(empIDForTable_);
        this.name = new SimpleStringProperty(name_);
        this.phoneNumber = new SimpleStringProperty(phoneNumber_);
        this.email = new SimpleStringProperty(email_);
        this.username = new SimpleStringProperty(username_);
        this.password = new SimpleStringProperty(password_);

    }

    //Getters for each "Simple" property
    public int getEmployeeIDForTable() {
        return employeeIDForTableView.get();
    }
    public String getNameForTable() {
        return name.get();
    }
    public String getPhoneNumberForTable() {
        return phoneNumber.get();
    }
    public String getEmailForTable() {
        return email.get();
    }
    public String getUsernameForTable() {
        return username.get();
    }
    public String getPasswordForTable() {
        return password.get();
    }


}
