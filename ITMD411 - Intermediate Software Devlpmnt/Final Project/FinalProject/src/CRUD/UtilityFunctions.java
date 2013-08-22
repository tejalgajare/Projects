package CRUD;

import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This class encapsulates the various methods in order to perform the tasks of
 * creating,updating, retrieving and deleting of the records from the SunriseSunset Table
 * of itm411db database created in MySql. This table is populated using the sunset-sunrise.csv file
 *
 * @author Tejal
 */
public class UtilityFunctions {

    //This function is required to create a record in the employees table
    public static String createRecord(JTable table, int month, int day, int rise, int set) {

        try {


            Connection conn = getConnection();      //call to getConnection function
            Connection conn1 = getConnection();
            //The following prepared statement is used for manipulating the database (eg: creation of records...)
            PreparedStatement prepareStatement1 = conn.prepareStatement("insert into SunriseSunset values(?,?,?,?)");

            Statement stmt = conn1.createStatement();
            //Following statement is used to check if the empID exists in the database...
            ResultSet rs = stmt.executeQuery("SELECT * FROM SunriseSunset where month = " + month + " AND day = " + day + " AND sunrise= " + rise);
            rs.last();
            //If there is no record with the entered empID then the record is added to the table
            if (rs.getRow() == 0) {

                prepareStatement1.setInt(1, month);
                prepareStatement1.setInt(2, day);
                prepareStatement1.setInt(3, rise);
                prepareStatement1.setInt(4, set);

                prepareStatement1.executeUpdate();


            } else {
                return "Status: Duplicate Record! Not added !";
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.repaint();
        return "Status: Record added Successfully";
    }

    //This function is used to retrieve a record by EmpID...
    public static String RetrieveRecord(JTable table, int month, int day) {
        Connection conn = getConnection();

        try {


            Statement stmt = conn.createStatement();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{
                        "Month", "Day", "Sun Rise", "Sun Set"});
            //rs stores the returned record from the table after the query has been executed...
            ResultSet rs = stmt.executeQuery("SELECT * FROM SunriseSunset where month = " + month + " AND day = " + day);
            rs.last();
            if (rs.getRow() == 0) {
                return "Status: Record does not Exist!";
            }
            rs.beforeFirst();
            //save the record fetched from the table in the ER object through getter/setters...
            while (rs.next()) {

                Vector row = new Vector();
                row.add(rs.getInt("month"));
                row.add(rs.getInt("day"));
                row.add(rs.getInt("sunrise"));
                row.add(rs.getInt("sunset"));
                model.addRow(row);

            }
            table.setPreferredSize(new Dimension(500, 500));
            table.setModel(model);
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

        return "Status: Record Retrieved Successfully!";
    }

    //This function is used to retrieve all records from the employee table...
    public static String retrieveRecords(JTable table) {
        try {
            Connection conn1 = getConnection();
            Statement stmt = conn1.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SunriseSunset;");

            DefaultTableModel model = new DefaultTableModel();

            model.setColumnIdentifiers(new String[]{
                        "Month", "Day", "Sun Rise", "Sun Set"});

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("month"));
                row.add(rs.getInt("day"));
                row.add(rs.getInt("sunrise"));
                row.add(rs.getInt("sunset"));
                model.addRow(row);

                //  model.addRow(new Object [] {rs.getInt("month"), rs.getInt("day"), rs.getInt("sunrise"), rs.getInt("sunset")});       
            }

            table.setPreferredSize(new Dimension(6000, 6000));
            table.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Status: All Records Retrieved Successfully!";
    }

    //This function is used to update a record looked up by the EmpID...
    public static String updateRecord(JTable table, int month, int day, int rise, int set) {

        try {


            Connection conn = getConnection();
            //The following prepared statement is used to set new values for the entered EmpID record...
            PreparedStatement prepareStatement2 = conn.prepareStatement("update SunriseSunset set sunrise=?,sunset=? where month = " + month + " AND day = " + day);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SunriseSunset where month = " + month + " AND day = " + day);
            rs.last();
            //The following condition is used to check if the record with the entered EmpID exixts in the database...
            if (rs.getRow() != 0) {

                prepareStatement2.setInt(1, rise);
                prepareStatement2.setInt(2, set);
                prepareStatement2.executeUpdate();


            } else {

                return "Status: Record does not Exist!";
            }
        } catch (SecurityException | SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Status: Record Updated Successfully!";
    }

    //The following function is used to delete a record looked up by EmpID...
    public static String deleteRecord(JTable table, int month, int day) {

        Connection conn = getConnection();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SunriseSunset where month = " + month + " AND day = " + day);
            rs.last();
            //Check for the existence of the record in the table...
            if (rs.getRow() != 0) {
                Statement stmt1 = conn.createStatement();
                String sql = "DELETE FROM SunriseSunset where month = " + month + " AND day = " + day;
                stmt1.executeUpdate(sql);

            } else {
                return "Status: Record with entered value of Month / Day does not Exist!";
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
        table.repaint();
        return "Status: Record Deleted Successfully!";

    }

    //This function is used to establish a connection with the MySql database...
    public static Connection getConnection() {

        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itm411db", "root", "tejalgajare");
        } catch (SQLException ex) {
            Logger.getLogger(UtilityFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
