import java.sql.Date;

public interface PayCheckInterface {
    
    /**Get ID of paycheck. */
    public void getID();

    /**
     * Set ID of paycheck.
     * @param ID The ID to be set.
     */
    public void setID(String ID);

    /**Get date paycheck is sent. */
    public void getDate();
    
    /**
     * Set date paycheck is sent.
     * @param date The date of delivery.
     */
    public void setDate(Date date);

    /**Get paycheck in paycheck. */
    public void getAmount();
    
    /**
     * Set paycheck amount.
     * @param amount The amount of the paycheck.
     */
    public void setAmount(float amount);

    /**Get type of paycheck. */
    public void getType();
    
    /**
     * Sets paycheck type
     * @param type The type of the paycheck.
     */
    public void setType(String type);
}
