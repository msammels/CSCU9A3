/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>Student.java</u></b>
 * </p>
 * <p>
 *     The student class, which gets and sets various details of the student, such as:
 *     <ul>
 *         <li>The student's full name</li>
 *         <li>The student's registration number</li>
 *         <li>The student's email</li>
 *         <li>The number of modules the student is taking</li>
 *         <li>The name of the programme the student is on</li>
 *         <li>Whether or not the student has an ARUAA</li>
 *     </ul>
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class Student implements Person {
    protected static int MAX_NUM_MODULES = 5;	// Maximum number of modules a student can enroll on

    protected String fullName;
    protected int registrationNumber;
    protected String email;
    protected int numberModules;

    protected String programmeName;
    protected boolean isARUAA;

    /**
     * Constructor
     * @param fn the student's full name
     * @param registrationNumber the student's registration number
     * @param email the student's email
     */
    public Student(String fn, int registrationNumber, String email) {
        this.fullName = fn;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.numberModules = 0;
        this.programmeName = "Bachelor of Science";
        this.isARUAA = false;
    }

    /**
     * Constructor
     * @param fn the student's full name
     * @param registrationNumber the student's registration number
     * @param email the student's email
     * @param pn the name of the programme the student is on
     */
    public Student(String fn, int registrationNumber, String email, String pn) {
        this.fullName = fn;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.numberModules = 0;
        this.programmeName = pn;
        this.isARUAA = false;
    }

    /**
     * @return the full name of the student
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set/change the full name of the student
     * @param fn the new full name of the student
     */
    public void setFullName(String fn) {
        this.fullName = fn;
    }

    /**
     * @return the registration number of the student
     */
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Set/change the registration number of the student
     * @param rn the new registration number
     */
    public void setRegistrationNumber(int rn) {
        this.registrationNumber = rn;
    }

    /**
     * @return the programme name
     */
    public String getProgrammeName() {
        return programmeName;
    }

    /**
     * Set/change the programme name
     * @param pn the new programme name
     */
    public void setProgrammeName(String pn) {
        this.programmeName = pn;
    }

    /**
     * Set the isARUAA attribute to true to indicate that the student is an ARUAA student
     */
    public void isARUAAStudent() {
        this.isARUAA = true;
    }

    /**
     * Set the isARUAA attribute to false to indicate that the student is not an ARUAA student
     */
    public void isNotARUAAStudent() {
        this.isARUAA = false;
    }

    /**
     * @return the if the Student is ARUAA
     */
    public boolean isARUAA() {
        return this.isARUAA;
    }

    /**
     * Set/change the number of modules a student is on
     * @param inter add/increment this many modules to the student
     * @return true if the modules were added successfully, otherwise false
     */
    public boolean addModule(int inter) {
        if (this.numberModules + inter <= MAX_NUM_MODULES) {
            this.numberModules = (this.numberModules + inter);
            return true;
        }

        return false;
    }

    /**
     * @return the number of modules the student is on
     */
    public int getNumberModule() {
        return this.numberModules;
    }

    /**
     * @return a description of the student as a string
     */
    public String toString() {
        return "Student: " + fullName + " - StudentNo: " + registrationNumber;
    }
}
