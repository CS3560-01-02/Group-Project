package com.example.groupprojectcs3560.ModelClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.sql.Time;

public class TimeWorkedTESTObject {

    //Attributes
    private SimpleIntegerProperty timeID;
    private SimpleStringProperty date;
    private SimpleStringProperty shiftIn;
    private SimpleStringProperty shiftOut;
    private SimpleStringProperty breakIn;
    private SimpleStringProperty breakOut;
    private SimpleIntegerProperty totalHours;

    public TimeWorkedTESTObject(Integer timeID_, String date_, String shiftIn_, String shiftOut_, String breakIn_, String breakOut_, Integer totalHours_) {

        this.timeID = new SimpleIntegerProperty(timeID_);


    }


}
