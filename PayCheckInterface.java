import java.sql.Date;

public interface PayCheckInterface {

    /**Get ID of paycheck. */
    public String getID();

    /**
     * Set ID of paycheck.
     * @param ID The ID to be set.
     */
    public void setID(String ID);

    /**Get date paycheck is sent. */
    public Date getDate();
    
    /**
     * Set date paycheck is sent.
     * @param date The date of delivery.
     */
    public void setDate(Date date);

    /**Get paycheck in paycheck. */
    public float getAmount();
    
    /**
     * Set paycheck amount.
     * @param amount The amount of the paycheck.
     */
    public void setAmount(float amount);

    /**Get type of paycheck. */
    public String getType();
    
    /**
     * Sets paycheck type
     * @param type The type of the paycheck.
     */
    public void setType(String type);
}
