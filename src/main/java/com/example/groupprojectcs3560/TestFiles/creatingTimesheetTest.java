package com.example.groupprojectcs3560.TestFiles;

import com.example.groupprojectcs3560.ModelClasses.Employee;
import com.example.groupprojectcs3560.ModelClasses.TimeWorked;
import com.example.groupprojectcs3560.ModelClasses.TimeWorkedTESTObject;
import com.example.groupprojectcs3560.SQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class creatingTimesheetTest   {

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

    private ObservableList<TimeWorkedTESTObject> TimeRecords = createTimeWorkedObservableList();


    /*
       //Test objects to put into table view || what we would do is create these objects using data from the 5 records we get and then yuhhh
       TimeWorkedTESTObject test1 = new TimeWorkedTESTObject(1, "10/21/22", "06:32:54", ":32:54", "12:32:54", "12:32:54", 40);
       TimeWorkedTESTObject test2 = new TimeWorkedTESTObject(1, "11/06/22", "08:21:03", "yuh", "hai", "bruh", 69);
       TimeWorkedTESTObject test3 = new TimeWorkedTESTObject(1, "hurb", "man", "1medw", "12:32:54", "12ede54", 90);
       TimeWorkedTESTObject test4 = new TimeWorkedTESTObject(1, "yay", "12:beuh", "cock", "w", "12:32:54", 31);
       TimeWorkedTESTObject test5 = createTimeWorkedObject();
    */
    public creatingTimesheetTest() throws SQLException {

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
        int employeeId = 1;     //change later to get static variable employee id of who is logged in
        String workedDateAttribute = null;
        String clockInAttribute = null;
        String clockOutAttribute = null;
        String mealInAttribute = "texas";
        String mealOutAttribute = "lappland";
        int totalHoursWorkedAttribute = 20;

        Connection conn = SQLConnection.databaseConnect();
        ResultSet rs = null;
        String sql = null;

        /*in this for loop, you get the 5 latest records of the TimeWorked table, create TimeWorkedObjects for each,
         * and then you add those objects into an Observable List*/
        for (int i = 0; i < 5; i++) {
           /*this if statement basically allows us to get the latest record in first iteration of for loop,
           and then we use i to get the rest of the latest records before the first*/
            if (i == 0) {
                sql = "select * from timeworked where emp_id = '1' order by time_id desc limit 1;";
            } else {
                sql = "select * from timeworked where emp_id = '1' order by time_id desc limit 1," + i + ";";
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                timeRecordIDAttribute = rs.getInt("time_id");
                workedDateAttribute = rs.getString("workedDate");
                clockInAttribute = rs.getString("shiftIn");
                clockOutAttribute = rs.getString("shiftOut");
                // mealInAttribute = rs.getString("mealIn");
                // mealOutAttribute = rs.getString("mealIn");
            }
            currentRow = new TimeWorkedTESTObject(timeRecordIDAttribute, workedDateAttribute, clockInAttribute, clockOutAttribute, mealInAttribute, mealOutAttribute, totalHoursWorkedAttribute);
            temp.add(currentRow);
        }
        SQLConnection.databaseDisconnect(conn);
        return temp;
    }

//OG code just in case this doesn't work
/*
   public TimeWorkedTESTObject createTimeWorkedObject() throws SQLException {

       //Variables to insert into constructor for the TimeWorked objects that will be put into TableView
       int timeRecordIDAttribute = 0;
       int employeeId = 1;
       String workedDateAttribute = null;
       String clockInAttribute = null;
       String clockOutAttribute = null;
       String mealInAttribute = "texas";
       String mealOutAttribute = "lappland";
       int totalHoursWorkedAttribute = 20;

       Connection conn = SQLConnection.databaseConnect();
       ResultSet rs = null;

       //hardcoded for now
       String sql = "select * from timeworked where emp_id = '1' order by time_id desc limit 1;";

       PreparedStatement preparedStatement = conn.prepareStatement(sql);
       rs  = preparedStatement.executeQuery();

       while(rs.next()){
           timeRecordIDAttribute = rs.getInt("time_id");
           workedDateAttribute = rs.getString("workedDate");
           clockInAttribute = rs.getString("shiftIn");
           clockOutAttribute = rs.getString("shiftOut");
           // mealInAttribute = rs.getString("mealIn");
           // mealOutAttribute = rs.getString("mealIn");
       }

       TimeWorkedTESTObject timeSheetRow = new TimeWorkedTESTObject(timeRecordIDAttribute, workedDateAttribute, clockInAttribute, clockOutAttribute, mealInAttribute, mealOutAttribute, totalHoursWorkedAttribute);
       SQLConnection.databaseDisconnect(conn);
       return timeSheetRow;
   }

   private ObservableList<TimeWorkedTESTObject> TimeRecords = FXCollections.observableArrayList(
           test1,
           test2,
           test3,
           test4,
           test5
   ); */

}
