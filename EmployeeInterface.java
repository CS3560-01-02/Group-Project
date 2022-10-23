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
    public void getID();

    /**Set Employee's ID */
    public void setID();

    /**Get Employee's Name*/
    public void getName();

    /**Set Employee's Name*/
    public void setName();

    /**Get Employee's phone number*/
    public void getPhoneNum();

    /**Set Employee's phone number*/
    public void setPhoneNum();

    /**Get Employee's address*/
    public void getAddress();

    /**Set Employee's address*/
    public void setAddress();

    /**Get Employee's supervisor*/
    public void getSupervisor();

    /**Set Employee's supervisor*/
    public void setSupervisor();

}