package domain;

import java.io.Serializable;

/**
 * This class extends the {@link Record} class. This class also implements the serializable interface. It has few functions
 * to calculate the difference between the sunset/sunrise time for the particular date of the invoking object.
 *
 * @author Tejal
 */
public class DaylightRecord extends Record implements Serializable {

    public DaylightRecord() {
    }

    public DaylightRecord(int Month, int date, int sunrise, int sunset) {
        super(Month, date, sunrise, sunset);
    }

    //Function that returns the difference between sunset and sunrise
    public double getWinterDifference(DaylightRecord d) {
        double diff;
        diff = Math.abs((double) (d.getSunset() / 100.0) - (double) (d.getSunrise() / 100.0));
        return diff;
    }

    //Function that returns the difference between sunrise and sunset
    public double getSummerDifference(DaylightRecord d) {
        double diff;
        diff = Math.abs((double) (d.getSunrise() / 100.0) - (double) (d.getSunset() / 100.0));
        return diff;
    }

    //Function that returns the difference between (difference between sunset/sunrise and 12) to find the nearest value to 12
    //Lsss the returned difference, more the accuracy towards Equinox
    public double getDifference(DaylightRecord d) {
        double diff;
        diff = Math.abs((double) (d.getSunset() / 100.0) - (double) (d.getSunrise() / 100.0));
        double distance = Math.abs(diff - 12.0);
        return distance;
    }

    @Override
    public String toString() {
        return "DaylightRecord{" + super.toString() + " }";
    }
}