import java.sql.Date;
import java.sql.Time;

public class Request {

    //Attributes
    int requestID;
    Date requestDate;
    Time requestTime;
    String description;
    String status;

    /* Returns the ID of the request*/
    public int getID() {

        return requestID;
    }
    
     /**
     * Sets the ID of the request
     * @param ID the new ID of request.
     */
    public void setID(int ID) {
        this.requestID = ID;
    }

    /* Returns the date the request was made*/
    public Date getDate() {

        return requestDate;
    }
    
    /**
     * Sets the date of the request
     * @param date the new date of request.
     */
    public void setDate(Date date) {
        this.requestDate = date;
    }

    /* Returns the time the request was made*/
    public Time getTime() {

        return requestTime;
    }
    
     /**
     * Sets the time of the request
     * @param time the new time of request.
     */
    public void setTime(Time time) {
        this.requestTime = time;
    }

    /* Returns the description of the request*/
    public String getDescription() {

        return description;
    }
    
    /**
     * Sets the description of the request
     * @param description the new description of request.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /* Returns the status of the request*/
    public String getStatus() {

        return status;
    }
    
    /**
     * Sets the status of the request
     * @param status the new status of request.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    
}
