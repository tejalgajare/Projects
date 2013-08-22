package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This class encapsulates the Current Timestamp in the form of a date object and the read .csv input in the form of a list object.
 * @author Tejal
 */
public class PersistentObject implements Serializable {

    private Date current_timestamp;
    private List ArrayList;

    public PersistentObject() {
    }

    public PersistentObject(Date current_timestamp, List ArrayList) {
        this.current_timestamp = current_timestamp;
        this.ArrayList = ArrayList;
    }

    public Date getCurrent_timestamp() {
        return current_timestamp;
    }

    public void setCurrent_timestamp(Date current_timestamp) {
        this.current_timestamp = current_timestamp;
    }

    public List getArrayList() {
        return ArrayList;
    }

    public void setArrayList(List ArrayList) {
        this.ArrayList = ArrayList;
    }

    @Override
    public String toString() {
        return "PersistentObject{" + "current_timestamp=" + current_timestamp + ", ArrayList=" + ArrayList + '}';
    }
}
