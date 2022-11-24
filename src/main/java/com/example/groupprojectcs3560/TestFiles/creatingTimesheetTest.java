package com.example.groupprojectcs3560.TestFiles;

import com.example.groupprojectcs3560.ModelClasses.TimeWorked;
import com.example.groupprojectcs3560.ModelClasses.TimeWorkedTESTObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



public class creatingTimesheetTest   {

    @FXML
    private TableView<TimeWorkedTESTObject> timeSheetTable;

    @FXML
    Button viewTimesheetButton;

    @FXML
    public TableColumn<TimeWorked, Integer> timeRecordDateColumn;
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


    //Test objects to put into table view
    TimeWorkedTESTObject test1 = new TimeWorkedTESTObject(1, "10/21/22", "06:32:54", ":32:54", "12:32:54", "12:32:54", 40);
    TimeWorkedTESTObject test2 = new TimeWorkedTESTObject(1, "11/06/22", "08:21:03", "yuh", "hai", "bruh", 69);
    TimeWorkedTESTObject test3 = new TimeWorkedTESTObject(1, "hurb", "man", "1medw", "12:32:54", "12ede54", 90);
    TimeWorkedTESTObject test4 = new TimeWorkedTESTObject(1, "yay", "12:beuh", "cock", "w", "12:32:54", 31);
    TimeWorkedTESTObject test5 = new TimeWorkedTESTObject(1, "wsup", "poopoo", "lappland", "fuck", "peepee", 45);


    public void showLast5Days() {

        timeRecordDateColumn.setCellValueFactory(new PropertyValueFactory<>("TimeRecordDate"));
        clockInColumn.setCellValueFactory(new PropertyValueFactory<>("ClockInTime"));
        clockOutColumn.setCellValueFactory(new PropertyValueFactory<>("ClockOutTime"));
        mealInColumn.setCellValueFactory(new PropertyValueFactory<>("MealInTime"));
        mealOutColumn.setCellValueFactory(new PropertyValueFactory<>("MealOutTime"));
        totalHoursColumn.setCellValueFactory(new PropertyValueFactory<>("TotalTime"));

        timeSheetTable.setItems(TimeRecords);
    }




    private ObservableList<TimeWorkedTESTObject> TimeRecords = FXCollections.observableArrayList(
        test1,
        test2,
        test3,
        test4,
        test5
    );



}
