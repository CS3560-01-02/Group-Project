package com.example.groupprojectcs3560.ModelClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.sql.Time;

public class TimeWorkedTESTObject {

    //Attributes
    private SimpleIntegerProperty timeID;
    private SimpleStringProperty workedDate;
    private SimpleStringProperty shiftIn;
    private SimpleStringProperty shiftOut;
    private SimpleStringProperty breakIn;
    private SimpleStringProperty breakOut;
    private SimpleIntegerProperty totalHours;

    //Constructor
    public TimeWorkedTESTObject(Integer timeID_, String workedDate_, String shiftIn_, String shiftOut_, String breakIn_, String breakOut_, Integer totalHours_) {

        this.timeID = new SimpleIntegerProperty(timeID_);
        this.workedDate = new SimpleStringProperty(workedDate_);
        this.shiftIn = new SimpleStringProperty(shiftIn_);
        this.shiftOut = new SimpleStringProperty(shiftOut_);
        this.breakIn = new SimpleStringProperty(breakIn_);
        this.breakOut = new SimpleStringProperty(breakOut_);
        this.totalHours = new SimpleIntegerProperty(totalHours_);


    }
    //Getters for each "Simple" property
    public int getTimeIDForTimeSheet() {
        return timeID.get();
    }
    public String getDateWorked() {
        return workedDate.get();
    }
    public String getShiftIn() {
        return shiftIn.get();
    }
    public String getShiftOut() {
        return shiftOut.get();
    }
    public String getMealIn() {
        return breakIn.get();
    }
    public String getMealOut() {
        return breakOut.get();
    }

    public int getTotalHours() {
        return totalHours.get();
    }


}

