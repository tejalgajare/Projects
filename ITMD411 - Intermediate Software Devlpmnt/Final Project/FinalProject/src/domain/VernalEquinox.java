package domain;

import java.util.Comparator;

/**
 * This class implements the Comparator interface in order to return the date for the vernal equinox.It implements 
 * the compare() method to compare the differences between the sunrise/sunset times of the invoking objects to 
 * find out the vernal equinox date.
 * @author Tejal
 */
public class VernalEquinox implements Comparator {

    int month_of_vernal_equinox;
    int date_of_vernal_equinox;

    public VernalEquinox() {
    }

    public int getMonth_of_vernal_equinox() {
        return month_of_vernal_equinox;
    }

    public void setMonth_of_vernal_equinox(int month_of_vernal_equinox) {
        this.month_of_vernal_equinox = month_of_vernal_equinox;
    }

    public int getDate_of_vernal_equinox() {
        return date_of_vernal_equinox;
    }

    public void setDate_of_vernal_equinox(int date_of_vernal_equinox) {
        this.date_of_vernal_equinox = date_of_vernal_equinox;
    }

    @Override
    public int compare(Object o1, Object o2) {
        PersistentObject po1, po2;
        po1 = (PersistentObject) o1;
        po2 = (PersistentObject) o2;
        int flag = -1;
        Double nearest = 100.0;
        Double closest = 100.0;
        DaylightRecord record1 = null, record2 = null;
        
    
        for (Object r1 : po1.getArrayList()) {
            record1 = (DaylightRecord) r1;

            for (Object r2 : po2.getArrayList()) {
                record2 = (DaylightRecord) r2;

                if (record1.getMonth() == 3 && record2.getMonth() == 3) {

                    if (record1.getDifference(record1) < record2.getDifference(record2)) {

                        if (record1.getDifference(record1) < closest && record1.getDifference(record1) != 0.0) {
                            closest = record1.getDifference(record1);
                            this.setDate_of_vernal_equinox(record1.getDate());
                            this.setMonth_of_vernal_equinox(record1.getMonth());
                            flag=1;
                        }

                    } else if (record1.getDifference(record1) > record2.getDifference(record2)) {

                        if (record2.getDifference(record2) < closest && record2.getDifference(record2) != 0.0) {
                            closest = record2.getDifference(record2);
                            this.setDate_of_vernal_equinox(record2.getDate());
                            this.setMonth_of_vernal_equinox(record2.getMonth());
                            flag=0;
                        }

                    }
                }
            }
        }
        return flag;
    }
}
