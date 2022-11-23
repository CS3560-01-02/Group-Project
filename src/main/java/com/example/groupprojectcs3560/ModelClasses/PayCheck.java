package com.example.groupprojectcs3560.ModelClasses;

import java.sql.Date;

public class PayCheck {

    //Attributes
    private String ID;
    private Date date;
    private float amount;
    private String type;

    /**Get ID of paycheck. */
    public String getID(){
        return ID;
    }

    /**
     * Set ID of paycheck.
     * @param ID The ID to be set.
     */
    public void setID(String ID){
        this.ID = ID;
    }

    /**Get date paycheck is sent. */
    public Date getDate(){
        return date;
    }

    /**
     * Set date paycheck is sent.
     * @param date The date of delivery.
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**Get paycheck in paycheck. */
    public float getAmount(){
        return amount;
    }

    /**
     * Set paycheck amount.
     * @param amount The amount of the paycheck.
     */
    public void setAmount(float amount){
        this.amount = amount;
    }

    /**Get type of paycheck. */
    public String getType(){
        return type;
    }

    /**
     * Sets paycheck type
     * @param type The type of the paycheck.
     */
    public void setType(String type){
        this.type = type;
    }
}
