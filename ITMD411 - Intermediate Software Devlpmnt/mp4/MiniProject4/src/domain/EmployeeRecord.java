package domain;

/**
 * This class is used to save the records fetched from the table Employees...
 * @author Tejal
 */
public class EmployeeRecord {

    //Member fields corresponding to the table columns...
    int Emp_ID;
    String lastName;
    String firstName;
    String extension;
    String email;
    String OfficeCode;
    int reportsTo;
    String jobTitle;

    
    //No Arg constructor;
    public EmployeeRecord() {
        Emp_ID = 0;
        lastName = null;
        firstName = null;
        extension = null;
        email = null;
        OfficeCode = null;
        reportsTo = 0;
        jobTitle = null;
    }

    //Arg constructor...
    public EmployeeRecord(int Emp_ID, String lastName, String firstName, String extension, String email, String OfficeCode, int reportsTo, String jobTitle) {
        this.Emp_ID = Emp_ID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.OfficeCode = OfficeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    //Getter and Setter functions...
    public int getEmp_ID() {
        return Emp_ID;
    }

    public void setEmp_ID(int Emp_ID) {
        this.Emp_ID = Emp_ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return OfficeCode;
    }

    public void setOfficeCode(String OfficeCode) {
        this.OfficeCode = OfficeCode;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        
        return "EmployeeRecord: " + "Emp_ID=" + Emp_ID + ", lastName=" + lastName + ", firstName=" + firstName + ", extension=" + extension + ", email=" + email + ", OfficeCode=" + OfficeCode + ", reportsTo=" + reportsTo + ", jobTitle=" + jobTitle ;
    }
}
