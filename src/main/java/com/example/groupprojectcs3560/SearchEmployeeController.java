package com.example.groupprojectcs3560;

import com.example.groupprojectcs3560.ModelClasses.EmployeeTESTObject;
import com.example.groupprojectcs3560.ModelClasses.TimeWorked;
import com.example.groupprojectcs3560.ModelClasses.TimeWorkedTESTObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEmployeeController {

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

    @FXML
    private TableView<EmployeeTESTObject> listOfEmployeesTable;

    @FXML
    public TableColumn<EmployeeTESTObject, Integer> EmployeeIDColumn;
    @FXML
    public TableColumn<EmployeeTESTObject, String> nameColumn;
    @FXML
    public TableColumn<EmployeeTESTObject, String> phoneNumberColumn;
    @FXML
    public TableColumn<EmployeeTESTObject, String> emailColumn;
    @FXML
    public TableColumn<EmployeeTESTObject, String> usernameColumn;
    @FXML
    public TableColumn<EmployeeTESTObject, String> passwordColumn;
    @FXML
    Button searchEmployeeButton;
    @FXML
    TextField employeeNameTextField;


    //First Name of Employee for Searching
    String firstNameOfRequestEmployee;

    public SearchEmployeeController() throws SQLException {
    }

    public void searchEmployee(ActionEvent event) throws SQLException {

        if (employeeNameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Please enter a First Name");
            alert.showAndWait();
        } else {
            firstNameOfRequestEmployee = employeeNameTextField.getText();
            ObservableList<EmployeeTESTObject> EmployeeRecords = createEmployeeObservableList();
            showEmployees(EmployeeRecords);
        }

    }

    public void showEmployees(ObservableList<EmployeeTESTObject> EmployeeRecords_) {

        EmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("EmployeeIDForTable"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("NameForTable"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumberForTable"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("EmailForTable"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("UsernameForTable"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("PasswordForTable"));

        listOfEmployeesTable.setItems(EmployeeRecords_);
    }



    public ObservableList<EmployeeTESTObject> createEmployeeObservableList() throws SQLException {

        ObservableList<EmployeeTESTObject> temp = FXCollections.observableArrayList();
        EmployeeTESTObject currentRow = null;

        //Variables to insert into constructor for the Employee objects that will be put into TableView
        int employeeID = -1;
        String firstName = null;
        String lastName = null;
        String fullName = null;
        String phoneNumber = null;
        String email = null;
        String username = null;
        String password = null;


        ResultSet rs = null;
        Connection conn = SQLConnection.databaseConnect();
        String sql = null;

        sql = "SELECT * FROM employee WHERE firstName = '" + firstNameOfRequestEmployee + "'";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            employeeID = rs.getInt("emp_id");
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            phoneNumber = rs.getString("phoneNumber");
            email = rs.getString("emailAddress");
            username = rs.getString("userName");
            password = rs.getString("password");

            fullName = firstName + " " + lastName;

            currentRow = new EmployeeTESTObject(employeeID, fullName, phoneNumber, email, username, password);
            temp.add(currentRow);
        }

        return temp;
    }



    public void switchViewRequestScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("viewRequestWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTimeWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("timeWindow.fxml"));
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

    public void switchToCreateEmployeeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createEmployeeWindow.fxml"));
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

}
