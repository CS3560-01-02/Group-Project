import java.sql.Date;
import java.sql.Time;

public interface TimeInterface {

    /**
     * Assigns an object of Time a unique ID
     * @param timeID // ID of Time object
     */
    public void setTimeID(String timeID);

    //* Gets the ID of Time object */
    public void getTimeID();

    
    /**
     * Records the current date 
     * @param currentDate // Current date when called
     */
    public void setDate(Date currentDate);

    //* Gets the date of the Time object */
    public void getDate();


    /**
     * Records the current time into the shiftIn attribute
     * @param shiftIn // Time when the employee begins their shift
     */
    public void setShiftIn(Time shiftIn);

    //* Gets the time saved in shiftIn  */
    public void getShiftIn();


    /**
     * Records the current time into the shiftOut attribute
     * @param shiftOut // Time when the employee ends their shift
     */
    public void setShiftOut(Time shiftOut);

    //* Gets the time saved in shiftOut  */
    public void getShiftOut();


    /**
     * Records the current time into the breakIn attribute
     * @param breakIn // Time when the employee begins their break
     */
    public void setBreakIn(Time breakIn);

    //* Gets the time saved in breakIn  */
    public void getBreakIn();


    /**
     * Records the current time into the breakOut attribute
     * @param breakOut // Time when the employee ends their break.
     */
    public void setBreakOut(Time breakOut);

    //* Gets the time saved in breakOut  */
    public void getBreakOut();

    /**
     * Updates the shiftIn attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateShiftIn(Time newTime); 

    /**
     * Updates the shiftOut attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateShiftOut(Time newTime);

    /**
     * Updates the breakIn attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateBreakIn(Time newTime);

    /**
     * Updates the breakOUt attribute with a new time
     * @param newTime // new time that will replace the previous one
     */
    public void updateBreakOut(Time newTime);

}
