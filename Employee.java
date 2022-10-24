public class Employee{

    //Attributes
    private String employeeID;
    private String name;
    private String phoneNum;
    private String emailAddress;
    private String address;
    private String supervisorID;

    /**Sends a request to the manager to fix a mistake in the timesheet. */
    public void requestEdit(){

    }

    /**Records time of clocking in for shift. */
    public void shiftIn(){

    }

    /**Records time of clocking out for shift. */
    public void shiftOut(){

    }

    /**Records time of clocking in for break. */
    public void breakIn(){

    }

    /**Records time of clocking out for break */
    public void breakOut(){

    }

    /**Get Employee's ID */
    public String getID(){
        return employeeID;
    }

    /**
     * Set Employee's ID 
     * @param ID The new ID.
     */
    public void setID(String employeeID){
        this.employeeID = employeeID;
    }

    /**Get Employee's Name*/
    public String getName(){
        return name;
    }

    /**
     * Set Employee's Name
     * @param name The new name.
     */
    public void setName(String name){
        this.name = name;
    }

    /**Get Employee's phone number*/
    public String getPhoneNum(){
        return phoneNum;
    }

    /**
     * Set Employee's phone number
     * @param number The new phone number.
     */
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    /**Get Employee's email address. */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * Set Employee's email address.
     * @param emailAddress The email address to be set.
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    /**Get Employee's address*/
    public String getAddress(){
        return address;
    }

    /**
     * Set Employee's address.
     * @param address The new address.
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**Get Employee's supervisor*/
    public String getSupervisor(){
        return supervisorID;
    }

    /**
     * Set Employee's supervisor
     * @param supervisor The new supervisor.
     */
    public void setSupervisor(String supervisorID){
        this.supervisorID = supervisorID;
    }
    

}