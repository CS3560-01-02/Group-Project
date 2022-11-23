package com.example.groupprojectcs3560.ModelClasses;

import java.sql.Date;

public class EmployeePosition {

    //Attributes
    private String ID;
    private Date datePromoted;

    /**Get ID of Employee's position(Compound key) */
    public String getID(){
        return ID;
    }

    /**
     * Set ID of Employee's position.
     * @param ID The ID to be set.
     */
    public void setID(String ID){
        this.ID = ID;
    }

    /**Get date of promotion. */
    public Date getDatePromoted(){
        return datePromoted;
    }

    /**
     * Set employee's date of promotion.
     * @param datePromoted The date employee was promoted.
     */
    public void setDatePromoted(Date datePromoted){
        this.datePromoted = datePromoted;
    }
}
