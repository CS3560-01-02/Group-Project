public interface EmployeeInterface{
    /**Sends a request to the manager to fix a mistake in the timesheet. */
    public void requestEdit();

    /**Records time of clocking in for shift. */
    public void shiftIn();

    /**Records time of clocking out for shift. */
    public void shiftOut();

    /**Records time of clocking in for break. */
    public void breakIn();

    /**Records time of clocking out for break */
    public void breakOut();

    /**Get Employee's ID */
    public String getID();

    /**
     * Set Employee's ID 
     * @param ID The new ID.
     */
    public void setID(String ID);

    /**Get Employee's Name*/
    public String getName();

    /**
     * Set Employee's Name
     * @param name The new name.
     */
    public void setName(String name);

    /**Get Employee's phone number*/
    public String getPhoneNum();

    /**
     * Set Employee's phone number
     * @param number The new phone number.
     */
    public void setPhoneNum(String number);

    /**Get Employee's address*/
    public String getAddress();

    /**
     * Set Employee's address
     * @param address The new address.
     */
    public void setAddress(String address);

    /**Get Employee's supervisor*/
    public String getSupervisor();

    /**
     * Set Employee's supervisor
     * @param supervisor The new supervisor.
     */
    public void setSupervisor(String supervisor);

}