package domain.util;

import CRUD.UtilityFunctions;
import domain.DaylightRecord;
import domain.Equinox;
import domain.PersistentObject;
import domain.Record;
import domain.SummerSolstice;
import domain.VernalEquinox;
import domain.WinterSolstice;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class contains methods responsible for serialization , de-serialization and displaying the output results
 * @author Tejal
 */
public class MP2Utilities implements Serializable {

        public static List readCSV() {

        DaylightRecord record = null;
       
        List daylightRecords = null;
        int month,day,rise,set;
        try {

            Connection conn=UtilityFunctions.getConnection();
            daylightRecords = new ArrayList<DaylightRecord>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SunriseSunset;");
            while (rs.next()) {

                    month=rs.getInt("month");
                    day=rs.getInt("day");
                    rise=rs.getInt("sunrise");
                    set=rs.getInt("sunset");
                    record = new DaylightRecord(month, day, rise, set);     // Creating a DaylightRecord object 
                    month++;

                    daylightRecords.add(record);                        // Adding the records to list daylightRecords
            }
                            


        } catch (SQLException ex) {
            Logger.getLogger(MP2Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return daylightRecords;
    }
        
    public static void serializeObject(PersistentObject po) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data/daylight-record.ser")); //initiating ObjectOutputStream Obj-oos
        } catch (IOException ex) {
            Logger.getLogger(MP2Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.writeObject(po.getCurrent_timestamp());     // storing the timestamp from PersistentObject object
            oos.writeObject(po.getArrayList());             // storing the array list
            oos.flush();
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(MP2Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static PersistentObject deserializeListObject() {

        PersistentObject pObject = null;
        ObjectInputStream ois = null;
        Date date;
        ArrayList deserializedDaylightRecords = null;
        try {

            ois = new ObjectInputStream(new FileInputStream("data/daylight-record.ser"));// Initiating ObjectInputStream Obj-ois
            date = (Date) ois.readObject();                                              // Reading date from the ois object
            deserializedDaylightRecords = (ArrayList) ois.readObject();                  // Reading list from the ois object
            pObject = new PersistentObject(date, deserializedDaylightRecords);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MP2Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MP2Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pObject;
    }

    public static StringBuilder createCSVfile(PersistentObject po) {

        StringBuilder sb = new StringBuilder();   // Instantiating a Stringbuilder object to store the contents of PersistentObject
        DaylightRecord record;                            

        for (Object r : po.getArrayList()) {

            record = (DaylightRecord) r;
            sb.append(po.getCurrent_timestamp()).append(",");
            sb.append(record.getMonth()).append(",");
            sb.append(record.getDate()).append(",");
            sb.append(record.getSunrise()).append(",");
            sb.append(record.getSunset()).append("\n");

        }

        return sb;
    }

    public static void writeCSVfile(StringBuilder sb) {
        FileWriter fw,fw1;
        try {
            fw = new FileWriter("data/output.csv");     //creation of output.csv
            fw.write(sb.toString(), 0, sb.length());
            fw.flush();
            
            fw1 = new FileWriter("output/daylight-records.txt");     //creation of records file- daylight-records.txt
            fw1.write(sb.toString(), 0, sb.length());
            fw1.flush();

        } catch (IOException ex) {
            Logger.getLogger(MP2Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    
}
