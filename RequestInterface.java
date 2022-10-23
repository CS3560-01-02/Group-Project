import java.sql.Time;

public interface RequestInterface {

    /* Getters and Setters for the request ID*/
    public void setID();
    public int getID();

    /* Getters and Setters for the date the request was made*/
    public String getDate();
    public void setDate();

    /* Getters and Setters for the time which the request was made*/
    public Time getTime();
    public void setTime();

    /* Getters and Setters for the description of the request*/
    public String getDescription();
    public void setDescription();

    /* Getters and Setters for the status of the request*/
    public String getStatus();
    public void setStatus();

    
}
