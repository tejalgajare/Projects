package Utilities;

import domain.EmployeeRecord;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class encapsulates the various methods in order to  perform the tasks of creating,updating, retrieving and deleting
 * of the records from the Employees Table of itm411db database created in MySql. It also has the displayMenu and getUserSelection
 * methods to provide a menu driven program.
 * @author Tejal
 */
public class UtilityFunctions {

    //The FileHandler and Logger are used in order to support the console menu driven program through script.bat file.
    private static FileHandler hand;
    private static Logger log;

    //This function takes a string as an input parameter and prints the same on the .bat console and the mp4output.txt file
    public static void print(String str) {
        System.out.println(str);
        log.info(str);
    }

    //This function is required to create a record in the employees table
    public static List createRecord() {

        List<EmployeeRecord> recList = null;
        EmployeeRecord ER = new EmployeeRecord();   //create a EmployeeRecord objectin order to save the data retrieved from the 
                                                    //user or table temporarily
        try {

            recList = new ArrayList();
            Connection conn = getConnection();      //call to getConnection function
            
            //The following prepared statement is used for manipulating the database (eg: creation of records...)
            PreparedStatement prepareStatement1 = conn.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?)");

            Scanner scan = new Scanner(System.in);

            //The following statements are used for getting the user's input for a record creation...
            print("Enter the Employee ID for the new record : ");
            String ID = scan.nextLine();

            print("Enter the Employee's Last Name : ");
            ER.setLastName(scan.nextLine());

            print("Enter the Employee's First Name : ");
            ER.setFirstName(scan.nextLine());

            print("Enter the Employee's Extension : ");
            ER.setExtension(scan.nextLine());

            print("Enter the Employee's Email : ");
            ER.setEmail(scan.nextLine());

            print("Enter the Employee's Office Code : ");
            ER.setOfficeCode(scan.nextLine());

            print("Enter the Employee's Report's To Number : ");
            String reportTo = scan.nextLine();

            print("Enter the Employee's Job Title : ");
            ER.setJobTitle(scan.nextLine());

            //This condition is used to verify if the reportsTo and the EmployeeID fields are entered with a numeric value
            if (reportTo.matches("[0-9]+") && ID.matches("[0-9]+")) {   //[0-9]+ is a regular expression to verify the numeric input
                ER.setEmp_ID(Integer.parseInt(ID));
                ER.setReportsTo(Integer.parseInt(reportTo));
            } else {

                print("Enter an integer value in the 'Employee-ID' / 'ReportsTo' field");
                return null;
            }
            
            Statement stmt = conn.createStatement();
            //Following statement is used to check if the empID exists in the database...
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees where employeeNumber=" + ER.getEmp_ID());
            rs.last();
            //If there is no record with the entered empID then the record is added to the table
            if (rs.getRow() == 0) {

                prepareStatement1.setInt(1, ER.getEmp_ID());
                prepareStatement1.setString(2, ER.getLastName());
                prepareStatement1.setString(3, ER.getFirstName());
                prepareStatement1.setString(4, ER.getExtension());
                prepareStatement1.setString(5, ER.getEmail());
                prepareStatement1.setString(6, ER.getOfficeCode());
                prepareStatement1.setInt(7, ER.getReportsTo());
                prepareStatement1.setString(8, ER.getJobTitle());
                prepareStatement1.executeUpdate();
                EmployeeRecord rec = new EmployeeRecord(ER.getEmp_ID(), ER.getLastName(), ER.getFirstName(), ER.getExtension(),
                        ER.getEmail(), ER.getOfficeCode(), ER.getReportsTo(), ER.getJobTitle());
                recList.add(rec);

           } else {
                print("Record with entered Employee Number already exists! Please enter a unique Employee ID! ");
                return null;
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        return recList;
    }
 
    //This function is used to retrieve a record by EmpID...
    public static boolean retrieveRecord_ID() {
        Connection conn = getConnection();
        List<EmployeeRecord> recList = null;
        EmployeeRecord ER = new EmployeeRecord();

        print("Enter the Employee ID for the record to be retrieved: ");
        Scanner scan = new Scanner(System.in);
        String ID = scan.nextLine();

        if (ID.matches("[0-9]+")) {
            ER.setEmp_ID(Integer.parseInt(ID));
        } else {

            print("Enter an integer value in the 'Employee-ID' field");
            return false;
        }

        try {

            recList = new ArrayList();
            Statement stmt = conn.createStatement();
            //rs stores the returned record from the table after the query has been executed...
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees where employeeNumber=" + ER.getEmp_ID());
            rs.last();
            if (rs.getRow() == 0) {
                return false;
            }
            rs.beforeFirst();
            //save the record fetched from the table in the ER object through getter/setters...
            while (rs.next()) {
                ER.setEmp_ID(rs.getInt("employeeNumber"));
                ER.setLastName(rs.getString("lastName"));
                ER.setFirstName(rs.getString("firstName"));
                ER.setExtension(rs.getString("extension"));
                ER.setEmail(rs.getString("email"));
                ER.setOfficeCode(rs.getString("OfficeCode"));
                ER.setReportsTo(rs.getInt("reportsTo"));
                ER.setJobTitle(rs.getString("jobTitle"));

                EmployeeRecord rec = new EmployeeRecord(ER.getEmp_ID(), ER.getLastName(), ER.getFirstName(), ER.getExtension(),
                        ER.getEmail(), ER.getOfficeCode(), ER.getReportsTo(), ER.getJobTitle());
                recList.add(rec);

                print(" \t \t EMPID \t \t LastName \t FirstName \t \t Extension \t \t Email \t \t \t  OfficeCode \t \t  ReportsTo \t  JobTitle ");

                print("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                for (EmployeeRecord r : recList) {

                    print(r.toString());
                }
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    //This function is used to retrieve all records from the employee table...
    public static void retrieveRecords() {

        Connection conn = getConnection();
        List<EmployeeRecord> recList = null;
        EmployeeRecord ER = new EmployeeRecord();
        try {

            recList = new ArrayList();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees;");
            while (rs.next()) {
                ER.setEmp_ID(rs.getInt("employeeNumber"));
                ER.setLastName(rs.getString("lastName"));
                ER.setFirstName(rs.getString("firstName"));
                ER.setExtension(rs.getString("extension"));
                ER.setEmail(rs.getString("email"));
                ER.setOfficeCode(rs.getString("OfficeCode"));
                ER.setReportsTo(rs.getInt("reportsTo"));
                ER.setJobTitle(rs.getString("jobTitle"));


                EmployeeRecord rec = new EmployeeRecord(ER.getEmp_ID(), ER.getLastName(), ER.getFirstName(), ER.getExtension(),
                        ER.getEmail(), ER.getOfficeCode(), ER.getReportsTo(), ER.getJobTitle());
                recList.add(rec);
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        print(" \t \t EMPID \t \t LastName \t FirstName \t \t Extension \t \t Email \t \t \t  OfficeCode \t \t  ReportsTo \t  JobTitle ");

        print("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (EmployeeRecord r : recList) {

            print(r.toString());
            print("");
        }

    }

    //This function is used to update a record looked up by the EmpID...
    public static boolean updateRecord_ID() {

        List<EmployeeRecord> recList = null;
        EmployeeRecord ER = new EmployeeRecord();

        //Get the EmployeeID from the user...
        print("Enter the Employee ID for the record to be updated : ");
        Scanner scan = new Scanner(System.in);
        String ID = scan.nextLine();

        //To check if the entered EmpID is numeric else pop error message...
        if (ID.matches("[0-9]+")) {
            ER.setEmp_ID(Integer.parseInt(ID));
        } else {

            print("Enter an integer value in the 'Employee-ID' field");
            return false;
        }
        try {

            recList = new ArrayList();
            Connection conn = getConnection();
            //The following prepared statement is used to set new values for the entered EmpID record...
            PreparedStatement prepareStatement2 = conn.prepareStatement("update employees set lastName=?,"
                    + "firstName=?,extension=?,email=?,officeCode=?,reportsTo=?,jobTitle=? where employeeNumber=" + ER.getEmp_ID());
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees where employeeNumber=" + ER.getEmp_ID());
            rs.last();
            //The following condition is used to check if the record with the entered EmpID exixts in the database...
            if (rs.getRow() != 0) {

                print("Enter new value of the Employee's Last Name : ");
                ER.setLastName(scan.nextLine());


                print("Enter new value of the Employee's First Name : ");
                ER.setFirstName(scan.nextLine());


                print("Enter new value of the Employee's Extension : ");
                ER.setExtension(scan.nextLine());


                print("Enter new value of the Employee's Email : ");
                ER.setEmail(scan.nextLine());


                print("Enter new value of the Employee's Office Code : ");
                ER.setOfficeCode(scan.nextLine());


                print("Enter new value of the Employee's Report's To Number : ");
                String reportTo = scan.nextLine();


                print("Enter new value of the Employee's Job Title : ");
                ER.setJobTitle(scan.nextLine());
                //To chceck for numeric input...
                if (reportTo.matches("[0-9]+")) {
                    ER.setReportsTo(Integer.parseInt(reportTo));
                } else {

                    print("Enter an integer value in the 'ReportTo' field");
                    return false;
                }

                prepareStatement2.setString(1, ER.getLastName());
                prepareStatement2.setString(2, ER.getFirstName());
                prepareStatement2.setString(3, ER.getExtension());
                prepareStatement2.setString(4, ER.getEmail());
                prepareStatement2.setString(5, ER.getOfficeCode());
                prepareStatement2.setInt(6, ER.getReportsTo());
                prepareStatement2.setString(7, ER.getJobTitle());
                prepareStatement2.executeUpdate();
                EmployeeRecord rec = new EmployeeRecord(ER.getEmp_ID(), ER.getLastName(), ER.getFirstName(), ER.getExtension(),
                        ER.getEmail(), ER.getOfficeCode(), ER.getReportsTo(), ER.getJobTitle());
                recList.add(rec);

            } else {

                return false;
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    //The following function is used to delete a record looked up by EmpID...
    public static boolean deleteRecord_ID() {
        
        Connection conn = getConnection();

        EmployeeRecord ER = new EmployeeRecord();
        //Get the user's input...
        print("Enter the Employee ID for the record to be deleted: ");
        Scanner scan = new Scanner(System.in);
        String ID = scan.nextLine();
        //check for numeric input...
        if (ID.matches("[0-9]+")) {
            ER.setEmp_ID(Integer.parseInt(ID));
        } else {

            print("Enter an integer value in the 'Employee-ID' field");
            return false;
        }

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees where employeeNumber=" + ER.getEmp_ID());
            rs.last();
            //Check for the existence of the record in the table...
            if (rs.getRow() != 0) {
                Statement stmt1 = conn.createStatement();
                String sql = "DELETE FROM employees where employeeNumber=" + ER.getEmp_ID();
                stmt.executeUpdate(sql);

            } else {
                return false;
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;

    }

    //This function is used to display the menu to the user...
    public static void displayMenu() {
        try {
            //The following handling/logger variables are initiated...
            hand = new FileHandler("data/mp4log.txt");
            log = Logger.getLogger("");
            log.addHandler(hand);

            print("Please enter choice from the following options: \n ");
            print("a - Create an Employee Record.\n"
                    + "b - Retrieve an Employee Record by ID.\n"
                    + "c - Retrieve all Employee Records.\n"
                    + "d - Update an Employee Record by ID.\n"
                    + "e - Delete an Employee Record by ID.\n"
                    + "q - quit the application.\n");

        } catch (IOException | SecurityException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //This function gets the user's input...
    public static void getUserSelection(Scanner s) {
        if (s.hasNext()) {
            displayMenu();
            switch (s.next()) {
                //Case for creating a record...
                case "a":
                    print("Creating an Employee Record...");

                    List newRecord = UtilityFunctions.createRecord();
                    if (newRecord == null) {

                        print("Unable to add record!");
                    } else {

                        print("New record added successfully!");
                    }
                    break;
                    
                //Case for retrieving a record by EmpID...
                case "b":

                    print("Retrieving an Employee Record by ID...");
                    boolean retrieveRecord = UtilityFunctions.retrieveRecord_ID();
                    if (retrieveRecord == false) {

                        print("Unable to retrieve record!");
                        print("Record with the entered Employee ID does not exist in the database/Invalid format!!");
                    } else {

                        print("Record retrieved successfully!");
                    }
                    break;
                    
                //Case for retrieving all records...
                case "c":

                    print("Retrieving all Employee Records...");
                    UtilityFunctions.retrieveRecords();
                    break;
                    
                //Case for updating a record...
                case "d":

                    print("Updating an Employee Record by ID...");
                    boolean updateRecord = UtilityFunctions.updateRecord_ID();
                    if (updateRecord == false) {

                        print("Unable to update record!");
                        print("Record with the entered Employee ID does not exist in the database/Invalid format!");
                    } else {

                        print("Record updated successfully!");
                    }
                    break;
                    
                //Case for deleting a  record...   
                case "e":

                    print("Deleting an Employee Record by ID...");
                    boolean deleteRecord = UtilityFunctions.deleteRecord_ID();
                    if (deleteRecord == false) {

                        print("Unable to delete the record!");
                        print("Record with the entered Employee ID does not exist in the database/Invalid format!!");
                    } else {

                        print("Record deleted successfully!");
                    }
                    break;
                    
                //Case for exit...
                case "q":

                    print("Exiting...");
                    System.exit(0);
                    break;
                    
                //Default case to check invalid option...
                default:

                    print("Invalid option!");
                    break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UtilityFunctions.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            s.reset();
        }
    }

    //This function is used to establish a connection with the MySql database...
    private static Connection getConnection() {

        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itm411db", "root", "tejalgajare");
        } catch (SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
