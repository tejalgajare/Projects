package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class implements the Comparator interface in order to return the date for the winter solstice.It implements 
 * the compare() method to compare the differences between the sunrise/sunset times of the invoking objects to 
 * find out the winter solstice date.
 * @author Tejal
 */
public class WinterSolstice implements Comparator {

    int month_of_winter_solstice;
    int date_of_winter_solstice;

    public int getMonth_of_winter_solstice() {
        return month_of_winter_solstice;
    }

    public void setMonth_of_winter_solstice(int month_of_winter_solstice) {
        this.month_of_winter_solstice = month_of_winter_solstice;
    }

    public int getDate_of_winter_solstice() {
        return date_of_winter_solstice;
    }

    public void setDate_of_winter_solstice(int date_of_winter_solstice) {
        this.date_of_winter_solstice = date_of_winter_solstice;
    }
    
    public WinterSolstice() {
    }

    
    @Override
    public int compare(Object o1, Object o2) {

        PersistentObject po1, po2;
        po1 = (PersistentObject) o1;
        po2 = (PersistentObject) o2;
        int flag=-1;
        Double minimum = 100.00;
        DaylightRecord record1 = null, record2 = null;


        for (Object r1 : po1.getArrayList()) {
            record1 = (DaylightRecord) r1;

            for (Object r2 : po2.getArrayList()) {
                record2 = (DaylightRecord) r2;
    
                if (record1.getWinterDifference(record1) < record2.getWinterDifference(record2)) {
                   
                    if (record1.getWinterDifference(record1) < minimum && record1.getWinterDifference(record1)!=0.0 ) {
                        minimum = record1.getWinterDifference(record1);
                        this.setDate_of_winter_solstice(record1.getDate());
                        this.setMonth_of_winter_solstice(record1.getMonth());
                       
                        flag=1;
                    }

                } else if (record1.getWinterDifference(record1) > record2.getWinterDifference(record2)) {

                    if (record2.getWinterDifference(record2) < minimum && record2.getWinterDifference(record2)!=0.0 ) {
                        minimum = record2.getWinterDifference(record2);
                        this.setDate_of_winter_solstice(record2.getDate());
                        this.setMonth_of_winter_solstice(record2.getMonth());
                       
                        flag=0;
                    }

                }

            }
        }
        return flag;
    }
}
