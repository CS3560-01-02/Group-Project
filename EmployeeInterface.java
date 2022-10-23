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

}