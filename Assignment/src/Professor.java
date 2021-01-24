/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>Professor.java</u></b>
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class Professor implements Person {
    protected String fullName;
    protected int registrationNumber;

    public Professor(String fn, int registrationNumber, String email) {
        this.fullName = fn;
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fn) { this.fullName = fn; }

    public int getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(int rn) { this.registrationNumber = rn; }

    public String toString() { return "Professor: " + fullName; }
}
