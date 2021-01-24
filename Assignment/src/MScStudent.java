/**
 * <p>
 *     <b><u>CSCU9A3 Assignment</u></b>
 *     <br />
 *     <b><u>MScStudent.java</u></b>
 * </p>
 *
 * @author 2629330
 * @version 01.11.2020
 */

public class MScStudent extends Student {
    protected String researchTitle;     // The research title of the MScStudent
    protected Professor supervisor;     // The Professor supervisor of the student

    /**
     * Constructor
     * @param fn Name
     * @param rn Registration Number
     * @param email Email
     * @param rt Research Title
     * @param s Supervisor
     */
    public MScStudent(String fn, int rn, String email, String rt, Professor s) {
        super(fn, rn, email);
        this.researchTitle = rt;
        this.supervisor = s;
    }

    public String toString() {
        return "MScStudent: " + fullName + " - StudentNo: " + registrationNumber + " - Research Title: "
                + researchTitle + " - Supervisor: " + supervisor;
    }
}
