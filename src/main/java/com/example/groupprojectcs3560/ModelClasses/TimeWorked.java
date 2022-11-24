package com.example.groupprojectcs3560.ModelClasses;

import java.sql.Date;
import java.sql.Time;

public class TimeWorked {

    //Attributes
    private String timeID;
    private Date date;
    private Time shiftIn;
    private Time shiftOut;
    private Time breakIn;
    private Time breakOut;


    /**
     * Assigns an object of Time a unique ID
     * @param timeID // ID of Time object
     */
    public void setTimeID(String timeID) {
        this.timeID = timeID;
    };

    //* Gets the ID of Time object */
    public String getTimeID() {
        return this.timeID;
    }


    /**
     * Records the current date 
     * @param date // Current date when called
     */

    public void setDate(Date date) {
        this.date = date;
    }

    //* Gets the date of the Time object */
    public Date getDate() {
        return this.date;
    }


    /**
     * Records the current time into the shiftIn attribute
     * @param shiftIn // Time when the employee begins their shift
     */
    public void setShiftIn(Time shiftIn) {
        this.shiftIn = shiftIn;
    }

    //* Gets the time saved in shiftIn  */
    public Time getShiftIn() {
        return this.shiftIn;
    }


    /**
     * Records the current time into the shiftOut attribute
     * @param shiftOut // Time when the employee ends their shift
     */
    public void setShiftOut(Time shiftOut) {
        this.shiftOut = shiftOut;
    }

    //* Gets the time saved in shiftOut  */
    public Time getShiftOut() {
        return this.shiftOut;
    }


    /**
     * Records the current time into the breakIn attribute
     * @param breakIn // Time when the employee begins their break
     */
    public void setBreakIn(Time breakIn) {
        this.breakIn = breakIn;
    }

    //* Gets the time saved in breakIn  */
    public Time getBreakIn() {
        return this.breakIn;
    }


    /**
     * Records the current time into the breakOut attribute
     * @param breakOut // Time when the employee ends their break.
     */
    public void setBreakOut(Time breakOut) {
        this.breakOut = breakOut;
    }

    //* Gets the time saved in breakOut  */
    public Time getBreakOut() {
        return this.breakOut;
    }


    /**
     * Updates the shiftIn attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateShiftIn(Time newTime) {
        this.setShiftIn(newTime);
    }

    /**
     * Updates the shiftOut attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateShiftOut(Time newTime) {
        this.setShiftOut(newTime);
    }

    /**
     * Updates the breakIn attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateBreakIn(Time newTime) {
        this.setBreakIn(newTime);
    }

    /**
     * Updates the breakOUt attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateBreakOut(Time newTime) {
        this.setBreakOut(newTime);
    }
}