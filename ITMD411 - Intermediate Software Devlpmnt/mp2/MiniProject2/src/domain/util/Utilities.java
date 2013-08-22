package domain.util;

import domain.DaylightRecord;
import domain.Equinox;
import domain.PersistentObject;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniproject2.MiniProject2;

/**
 * This class contains methods responsible for serialization , deserialization and displaying the output results
 * @author Tejal
 */
public class Utilities implements Serializable {

    public static List readCSV() {

        DaylightRecord record = null;
        BufferedReader br = null;
        String line = null;
        List daylightRecords = null;

        try {

            //Reading from the .csv file
            br = new BufferedReader(new FileReader("data/sunrise-sunset.csv"));
            daylightRecords = new ArrayList<DaylightRecord>();
            while ((line = br.readLine()) != null) {

                String[] split = line.split("[\\r\\n]+"); 
                String[] split1 = line.split(",");          //split1 is an array of all tokens separated by ','
                int day = Integer.parseInt(split1[0]);      //storing the first element of every line in day variable
                int rise, set;
                int x, z = 1;
                for (x = 1; x <= 24; x++) {                 

                    if (split1[x] == null || split1[x].isEmpty()) {   // Condition for handling months with 29 and 30 days only
                        split1[x] = "0";
                    }
                    if (split1[x + 1] == null || split1[x + 1].isEmpty()) {
                        split1[x + 1] = "0";
                    }
                    rise = Integer.parseInt(split1[x]);
                    set = Integer.parseInt(split1[x + 1]);

                    x++;
                    record = new DaylightRecord(z, day, rise, set);     // Creating a DaylightRecord object 
                    z++;

                    daylightRecords.add(record);                        // Adding the records to list daylightRecords

                }
            }




        } catch (FileNotFoundException ex) {
            Logger.getLogger(MiniProject2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MiniProject2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return daylightRecords;
    }

    public static void serializeObject(PersistentObject po) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data/daylight-record.ser")); //initiating ObjectOutputStream Obj-oos
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos.writeObject(po.getCurrent_timestamp());     // storing the timestamp from PersistentObject object
            oos.writeObject(po.getArrayList());             // storing the array list
            oos.flush();
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MiniProject2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MiniProject2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MiniProject2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Display functions...
    public static void displayWinterSolstice(int result, WinterSolstice ws) {


        if (result == 1) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Shortest day => winter solstice");
            System.out.println("\nDifference between sunset/sunrise of Persistent Object (po1) < Persistent Object (po2)! ");
            System.out.println("\nWinter Solstice day is: " + ws.getMonth_of_winter_solstice() + "/" + ws.getDate_of_winter_solstice() + "/2013.\n");

        } else if (result == 0) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Shortest day => winter solstice");
            System.out.println("\nDifference between sunset/sunrise of Persistent Object (po2) < Persistent Object (po1)! ");
            System.out.println("\nWinter Solstice day is: " + ws.getMonth_of_winter_solstice() + "/" + ws.getDate_of_winter_solstice() + "/2013.\n");

        } else {
            System.out.println("Error!!!");
        }
    }

    public static void displaySummerSolstice(int result, SummerSolstice ss) {

        if (result == 1) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Longest day => summer solstice");
            System.out.println("\nDifference between sunset/sunrise of Persistent Object (po1) > Persistent Object (po2)! ");
            System.out.println("\nSummer Solstice day is: " + ss.getMonth_of_summer_solstice() + "/" + ss.getDate_of_summer_solstice() + "/2013.\n");

        } else if (result == 0) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Longest day => summer solstice");
            System.out.println("\nDifference between sunset/sunrise of Persistent Object (po2) > Persistent Object (po1)! ");
            System.out.println("\nSummer Solstice day is: " + ss.getMonth_of_summer_solstice() + "/" + ss.getDate_of_summer_solstice() + "/2013.\n");

        } else {
            System.out.println("Error!!!");
        }
    }

    public static void displayAutumnalEquinox(int result, Equinox eq) {

        if (result == 1) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Equal day and night => autumnal equinox (Fall)");
            System.out.println("\nAutumnal Equinox of Persistent Object (po1) was more accurate than Persistent Object (po2)! ");
            System.out.println("\nAutumnal Equinox day is: " + eq.getMonth_of_autumnal_equinox() + "/" + eq.getDate_of_autumnal_equinox() + "/2013.\n");

        } else if (result == 0) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Equal day and night => autumnal equinox (Fall)");
            System.out.println("\nAutumnal Equinox of Persistent Object (po2) was more accurate than Persistent Object (po1)! ");
            System.out.println("\nAutumnal Equinox day is: " + eq.getMonth_of_autumnal_equinox() + "/" + eq.getDate_of_autumnal_equinox() + "/2013.\n");

        } else {
            System.out.println("Error!!!");
        }
    }

    public static void displayVernalEquinox(int result, VernalEquinox eq) {

        if (result == 1) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Equal day and night => vernal equinox (Spring)");
            System.out.println("\nVernal Equinox of Persistent Object (po1) was more accurate than Persistent Object (po2)! ");
            System.out.println("\nVernal Equinox day is: " + eq.getMonth_of_vernal_equinox() + "/" + eq.getDate_of_vernal_equinox() + "/2013.\n");

        } else if (result == 0) {
            System.out.println("\n****************************************************************************************");
            System.out.println("Display the Equal day and night => vernal equinox (Spring)");
            System.out.println("\nVernal Equinox of Persistent Object (po2) was more accurate than Persistent Object (po1)! ");
            System.out.println("\nVernal Equinox day is: " + eq.getMonth_of_vernal_equinox() + "/" + eq.getDate_of_vernal_equinox() + "/2013.\n");

        } else {
            System.out.println("Error!!!");
        }
    }
}
