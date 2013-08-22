package domain;

import java.util.Comparator;

/**
 * This class implements the Comparator interface in order to return the date for the summer solstice.It implements 
 * the compare() method to compare the differences between the sunrise/sunset times of the invoking objects to 
 * find out the summer solstice date.
 * @author Tejal
 */
public class SummerSolstice implements Comparator {

    int month_of_summer_solstice;
    int date_of_summer_solstice;

    public int getMonth_of_summer_solstice() {
        return month_of_summer_solstice;
    }

    public void setMonth_of_summer_solstice(int month_of_summer_solstice) {
        this.month_of_summer_solstice = month_of_summer_solstice;
    }

    public int getDate_of_summer_solstice() {
        return date_of_summer_solstice;
    }

    public void setDate_of_summer_solstice(int date_of_summer_solstice) {
        this.date_of_summer_solstice = date_of_summer_solstice;
    }

    public SummerSolstice() {
    }

    @Override
    public int compare(Object o1, Object o2) {

        PersistentObject po1, po2;
        po1 = (PersistentObject) o1;
        po2 = (PersistentObject) o2;
        Double maximum = 1.0;
        int flag=-1;
        DaylightRecord record1 = null, record2 = null;

        for (Object r1 : po1.getArrayList()) {
            record1 = (DaylightRecord) r1;

            for (Object r2 : po2.getArrayList()) {
                record2 = (DaylightRecord) r2;
  
                if (record1.getSummerDifference(record1) > record2.getSummerDifference(record2)) {

                    if (record1.getSummerDifference(record1) > maximum) {
                        maximum = record1.getSummerDifference(record1);
                        this.setDate_of_summer_solstice(record1.getDate());
                        this.setMonth_of_summer_solstice(record1.getMonth());
                        flag=1;
                      
                    }

                } else if (record1.getSummerDifference(record1) < record2.getSummerDifference(record1)) {

                    if (record2.getSummerDifference(record2) > maximum) {
                        maximum = record2.getSummerDifference(record2);
                        this.setDate_of_summer_solstice(record2.getDate());
                        this.setMonth_of_summer_solstice(record2.getMonth());
                        flag=0;
                      
                    }

                }
            }
        }
        return flag;
    }
}
