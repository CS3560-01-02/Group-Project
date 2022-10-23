import java.sql.Date;
import java.sql.Time;

public interface RequestInterface {

    /* Returns the ID of the request*/
    public int getID();
    
     /**
     * Sets the ID of the request
     * @param ID the new ID of request.
     */
    public void setID(int ID);

    /* Returns the date the request was made*/
    public Date getDate();
    
    /**
     * Sets the date of the request
     * @param date the new date of request.
     */
    public void setDate(Date date);

    /* Returns the time the request was made*/
    public Time getTime();
    
     /**
     * Sets the time of the request
     * @param time the new time of request.
     */
    public void setTime(Time time);

    /* Returns the description of the request*/
    public String getDescription();
    
    /**
     * Sets the description of the request
     * @param description the new description of request.
     */
    public void setDescription(String description);

    /* Returns the status of the request*/
    public String getStatus();
    
    /**
     * Sets the status of the request
     * @param status the new status of request.
     */
    public void setStatus(String status);

    
}
