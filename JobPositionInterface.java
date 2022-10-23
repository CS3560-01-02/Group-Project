import java.sql.Date;

public interface JobPositionInterface {

    /* Returns the ID of the job position*/
    public int getJobID();

    /**
     * Sets ID of the job position
     * @param ID The new ID.
     */
    public void setJobID(int ID);

    /* Returns the title of the job position*/
    public String getTitle();

    /**
     * Sets the title of the job position
     * @param title The new job title.
     */
    public void setTitle(String title);

    /* Returns the wage rate the job position*/
    public int getRate();

    /**
     * Sets the wage rate of the job position
     * @param rate The new wage rate
     */
    public void setRate(int rate);

    /* Returns the employment date*/
    public Date getEmploymentDate();

    /**
     * Sets the employment date of the job position
     * @param date The employment date.
     */
    public void setEmploymentDate(Date date);
    
}
