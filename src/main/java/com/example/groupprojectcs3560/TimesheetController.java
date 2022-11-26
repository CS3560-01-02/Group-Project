package com.example.groupprojectcs3560;


import com.example.groupprojectcs3560.ModelClasses.Employee;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Math;


public class TimesheetController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<TimeWorkedTESTObject> timeSheetTable;

    @FXML
    Button viewTimesheetButton;

    @FXML
    public TableColumn<TimeWorked, Integer> timeRecordIDColumn;
    @FXML
    public TableColumn<TimeWorked, String> timeRecordDateColumn;
    @FXML
    public TableColumn<TimeWorked, String> clockInColumn;
    @FXML
    public TableColumn<TimeWorked, String> clockOutColumn;
    @FXML
    public TableColumn<TimeWorked, String> mealInColumn;
    @FXML
    public TableColumn<TimeWorked, String> mealOutColumn;
    @FXML
    public TableColumn<TimeWorked, Integer> totalHoursColumn;
    int currentID = Employee.empID;

    private ObservableList<TimeWorkedTESTObject> TimeRecords = createTimeWorkedObservableList();


    public TimesheetController() throws SQLException {
    }


    public void showLast5Days() {

        timeRecordIDColumn.setCellValueFactory(new PropertyValueFactory<>("TimeIDForTimeSheet"));
        timeRecordDateColumn.setCellValueFactory(new PropertyValueFactory<>("DateWorked"));
        clockInColumn.setCellValueFactory(new PropertyValueFactory<>("ShiftIn"));
        clockOutColumn.setCellValueFactory(new PropertyValueFactory<>("ShiftOut"));
        mealInColumn.setCellValueFactory(new PropertyValueFactory<>("MealIn"));
        mealOutColumn.setCellValueFactory(new PropertyValueFactory<>("MealOut"));
        totalHoursColumn.setCellValueFactory(new PropertyValueFactory<>("TotalHours"));

        timeSheetTable.setItems(TimeRecords);
    }

    public ObservableList<TimeWorkedTESTObject> createTimeWorkedObservableList() throws SQLException {

        ObservableList<TimeWorkedTESTObject> temp = FXCollections.observableArrayList();
        TimeWorkedTESTObject currentRow = null;

        //Variables to insert into constructor for the TimeWorked objects that will be put into TableView
        int timeRecordIDAttribute = 0;
        int employeeId = currentID;
        String workedDateAttribute = null;
        String clockInAttribute = null;
        String clockOutAttribute = null;
        String mealInAttribute = null;
        String mealOutAttribute = null;
        String timeWorked = null;
        int totalHoursWorkedAttribute = 10; // Add calculation later
        double totalHoursWorked = 0;
        double wage = 0;

        Connection conn = SQLConnection.databaseConnect();
        ResultSet rs = null;
        String sql = null;

        /*in this for loop, you get the 5 latest records of the TimeWorked table, create TimeWorkedObjects for each,
         * and then you add those objects into an Observable List*/
        for (int i = 0; i < 5; i++) {
           /*this if statement basically allows us to get the latest record in first iteration of for loop,
           and then we use i to get the rest of the latest records before the first*/
            if (i == 0) {
                sql = "select *, timediff(timediff(shiftOut,shiftIn),timediff(mealOut,mealIn)) as timeWorked from timeworked where emp_id = '" + employeeId + "' order by time_id desc limit 1;";
            } else {
                sql = "select *, timediff(timediff(shiftOut,shiftIn),timediff(mealOut,mealIn)) as timeWorked from timeworked where emp_id = '" + employeeId + "' order by time_id desc limit 1," + i + ";";
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                timeRecordIDAttribute = rs.getInt("time_id");
                workedDateAttribute = rs.getString("workedDate");
                clockInAttribute = rs.getString("shiftIn");
                clockOutAttribute = rs.getString("shiftOut");
                mealInAttribute = rs.getString("mealIn");
                mealOutAttribute = rs.getString("mealIn");
                timeWorked = rs.getString("timeWorked");
            }

            //hours worked calculation
            double hours = 0;
            double minutes = 0;
            double seconds = 0;

            hours =  Double.valueOf(timeWorked.substring(0,2));
            minutes = Double.valueOf(timeWorked.substring(3,5));
            seconds = Double.valueOf(timeWorked.substring(6,8));

            //hours worked for table view
            totalHoursWorkedAttribute = (int) (hours + (minutes/60) + (seconds/360));

            //hours worked for calculating pay
            double actualHoursWorked = hours + (minutes/60) + (seconds/360);

            //update totalHoursWorked
            totalHoursWorked += actualHoursWorked;

            currentRow = new TimeWorkedTESTObject(timeRecordIDAttribute, workedDateAttribute, clockInAttribute, clockOutAttribute, mealInAttribute, mealOutAttribute, totalHoursWorkedAttribute);
            temp.add(currentRow);
        }

        //get payRate of employee
        int currentID = Employee.empID;
        String sql2 = "SELECT payRate FROM jobposition JOIN employeeposition WHERE employeeposition.job_id = jobposition.job_id and emp_id = " + currentID + ";";

        PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
        ResultSet rs2 = preparedStatement2.executeQuery();
        if (rs2.next()){
            wage = rs2.getFloat("payRate");
        }

        SQLConnection.databaseDisconnect(conn);

        //round totalHoursWorked
        totalHoursWorked = Math.round(totalHoursWorked * 100.0) / 100.0;

        //output
        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.println("Your wage: " + wage);
        double totalPay = totalHoursWorked* wage;
        //round totalPay
        totalPay = Math.round(totalPay * 100.0) / 100.0;
        System.out.println("Estimated Pay: " + totalPay);
        return temp;
    }

    public void switchToLoginWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginWindow.fxml"));
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

    public void switchToRequestWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("requestWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUpdateWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("updateDetailsWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}