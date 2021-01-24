/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>Person.java</u></b>
 * </p>
 * <p>
 *     Interface that implements some methods common to all persons represented in the system.
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

interface Person {
    public String getFullName();				// Get the full name of the person
    public void setFullName(String fn);			// Set the full name of the person
    public int getRegistrationNumber();			// Get the registration number of the person
    public void setRegistrationNumber(int rn);	// Set the registration number of the person
}
