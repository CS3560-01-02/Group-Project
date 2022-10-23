import java.sql.Date;

public interface JobPositionInterface {

    /* Returns the ID the job position*/
    public int getJobID();
    /* Sets the ID the job position*/
    public void setJobID(int ID);

    /* Returns the title the job position*/
    public String getTitle();
    /* Sets the title the job position*/
    public void setTitle(String title);

    /* Returns the wage rate the job position*/
    public int getRate();
    /* Sets the wage rate the job position*/
    public void setRate(int rate);

    /* Returns the date of employment*/
    public Date getEmploymentDate();
    /* Sets the date of employment*/
    public void setEmploymentDate(Date date);
    
}
