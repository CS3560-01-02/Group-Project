import java.sql.Date;

public interface EmployeePositionInterface {
    
    /**Get ID of Employee's position(Compound key) */
    public String getID();

    /**
     * Set ID of Employee's position.
     * @param ID The ID to be set.
     */
    public void setID(String ID);

    /**Get date of promotion. */
    public Date getDatePromoted();

    /**
     * Set employee's date of promotion.
     * @param datePromoted The date employee was promoted.
     */
    public void setDatePromoted(Date datePromoted);
}
