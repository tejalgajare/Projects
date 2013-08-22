package domain;

import java.io.Serializable;

/**
 * This is the basic abstract class which contains the fields to store the month, date and their respective sunrise and sunset times
 * @author Tejal
 */
public class Record implements Serializable {

    protected int Month;
    protected int date;
    protected int sunrise;
    protected int sunset;
     
    
    public Record() {
        
        Month=0;
        date = 0;
        sunrise = 0;
        sunset = 0;
       
      }

    public Record(int Month, int date, int sunrise, int sunset) {
        this.Month = Month;
        this.date = date;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "Record{" + "Month=" + Month + ", date=" + date + ", sunrise=" + sunrise + ", sunset=" + sunset + '}';
    }

}
