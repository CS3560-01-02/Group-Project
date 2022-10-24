import java.sql.Date;

public class JobPositionInterface {

    //Attributes
    int jobID;
    String jobTitle;
    int rate;
    Date employmentDate;

    /* Returns the ID of the job position*/
    public int getJobID() {

        return jobID;
    }

    /**
     * Sets ID of the job position
     * @param ID The new ID.
     */
    public void setJobID(int ID) {

    }

    /* Returns the title of the job position*/
    public String getTitle() {

        return jobTitle;
    }

    /**
     * Sets the title of the job position
     * @param title The new job title.
     */
    public void setTitle(String title){

    }

    /* Returns the wage rate the job position*/
    public int getRate() {

        return rate;
    }

    /**
     * Sets the wage rate of the job position
     * @param rate The new wage rate
     */
    public void setRate(int rate) {

    }

    /* Returns the employment date*/
    public Date getEmploymentDate() {

        return employmentDate;
    }

    /**
     * Sets the employment date of the job position
     * @param date The employment date.
     */
    public void setEmploymentDate(Date date) {

    }
    
}
