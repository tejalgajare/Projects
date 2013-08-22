package mp3;

import Consumer.EastRegionConsumer;
import Consumer.NorthRegionConsumer;
import Consumer.SouthRegionConsumer;
import Consumer.WestRegionConsumer;
import Producer.ProducerChild;
import domain.Utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MP3 {

    /**
     * This is the main driver class.
     *
     * @author Tejal
     */
    public static void main(String[] args) {
        try {
            
            //Read the pre-processed csv file...
            ArrayList productList = Utilities.readFile();

            //Creation of Producer object
            ProducerChild prodChild = new ProducerChild(productList);

            //Creation of Consumer objects
            NorthRegionConsumer nrc = new NorthRegionConsumer(prodChild);
            EastRegionConsumer erc = new EastRegionConsumer(prodChild);
            SouthRegionConsumer src = new SouthRegionConsumer(prodChild);
            WestRegionConsumer wrc = new WestRegionConsumer(prodChild);

            //To accept the keystroke to end the simulation... (PRESS ENTER)
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("");
            System.out.println("Press 'Enter' to terminate simulation!");
            System.out.println("");
            //Note the starting time stamp
            Date start = new Date();

            System.out.println("Simulation begins...");
            System.out.println("-----------------------------------------------------------------------------");
            //Run till the user presses enter... 
            while (!br.ready()) {

                prodChild.run();

                nrc.run();
                erc.run();
                src.run();
                wrc.run();
            }

            System.out.println("Simulation finished...");
            System.out.println("-----------------------------------------------------------------------------");
            //Note the ending time stamp
            Date end = new Date();

            //Calculate the time difference to get the elapsed time of simulation
            long diff = end.getTime() - start.getTime();

            System.out.println("");

            // Following writes the contents of each consumer region's product message to the console...

            nrc.consoleOutput();
            erc.consoleOutput();
            src.consoleOutput();
            wrc.consoleOutput();

            System.out.println("");

            //Display the total number of consumed products for each region...

            System.out.println(nrc.toString());
            System.out.println(erc.toString());
            System.out.println(src.toString());
            System.out.println(wrc.toString());

            System.out.println("");

            //Displays the total elapsed time of the simulation

            System.out.println("Simulation Time in Seconds: " + diff/1000);

            //Writes all Product objects per ProductConsumer to a file in output folder
            //based on region: N.csv,E.csv,S.csv or W.csv

            nrc.writeToFile();
            erc.writeToFile();
            src.writeToFile();
            wrc.writeToFile();
        } 
        
        catch (IOException ex) {

            Logger.getLogger(MP3.class.getName()).log(Level.SEVERE, null, ex);
        }


    } 
} 