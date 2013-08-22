package miniproject2;

import domain.Equinox;
import domain.PersistentObject;
import domain.SummerSolstice;
import domain.VernalEquinox;
import domain.WinterSolstice;
import domain.util.Utilities;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents the Driver class containing the main method. Import the relevant classes
 * {@link Record} , {@link DaylightRecord} , {@link PersistentObject} , {@link WinterSolstice} , {@link SummerSolstice}
 * {@link Equinox} , {@link VernalEquinox} and {@link Utilities} from package domain and domain.util 
 * @author Tejal
 */
public class MiniProject2 {

    /**
     * Serialization and Deserialization is followed by Data Analysis to find the equinox and solstice.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        // Reading data from sunrise-sunset.csv file...
        System.out.println("\nReading data from sunrise-sunset.csv file...");
        List list = Utilities.readCSV();

        //Encapsulating the date and list objects into Persistent Object...
        Date date = new Date();
        PersistentObject pObject = new PersistentObject(date, list);

        //Recording the start of serialization...
        Date start_time;
        start_time = pObject.getCurrent_timestamp();

        //Actual Serialization...
        System.out.println("\nSerialization started...");
        Utilities.serializeObject(pObject);

        // Wait 10 secs...
        try {
            System.out.println("\nWaiting 10 seconds...");
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MiniProject2.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Deserialization from daylight-record.ser...
        PersistentObject pObject1;
        System.out.println("\nDeserialization from daylight-record.ser...");
        pObject1 = Utilities.deserializeListObject();

        // Calculate the time difference between serialization and deserialization...
        Date end_time;
        long time_difference;

        end_time = new Date();
        time_difference = (end_time.getTime() - start_time.getTime());
        System.out.println("\nTime difference (in milliseconds) between serialization and deserialization = " + time_difference);

        //Deserialize the persisted object into a date object and an ArrayList object..
        Date deserializedDate;
        ArrayList deserializedDaylightRecords;
        deserializedDate = pObject1.getCurrent_timestamp();
        deserializedDaylightRecords = (ArrayList) pObject1.getArrayList();

        // Creating .csv file...
        System.out.println("\nCreating .csv file...");
        StringBuilder sb = Utilities.createCSVfile(pObject1);

        // Write .csv file to output.csv...
        System.out.println("\nWrite .csv file to output.csv...");
        System.out.println("\nWriting all records to daylight-records.txt file...");
        Utilities.writeCSVfile(sb);

        //Display data analytics...
        System.out.println("\n****************************************************************************************");
        System.out.println("\n                           Data Analytics                                      ");
        PersistentObject po1, po2, po3, po4;
        po1 = new PersistentObject(date, list);
        po2 = new PersistentObject(date, list);
        po3 = new PersistentObject(date, list);
        po4 = new PersistentObject(date, list);

        WinterSolstice ws = new WinterSolstice();
        int result = ws.compare(po1, po2);
        Utilities.displayWinterSolstice(result, ws);

        SummerSolstice ss = new SummerSolstice();
        result = ss.compare(po3, po4);
        Utilities.displaySummerSolstice(result, ss);

        Equinox eq = new Equinox();
        result = eq.compare(po1, po2);
        Utilities.displayAutumnalEquinox(result, eq);

        VernalEquinox veq = new VernalEquinox();
        result = veq.compare(po1, po2);
        Utilities.displayVernalEquinox(result, veq);

        
        
        
    }
}
