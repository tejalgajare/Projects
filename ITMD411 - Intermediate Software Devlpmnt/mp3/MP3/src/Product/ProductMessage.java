package Product;

import java.util.Date;
/**
 * This class encapsulates the Product object, timestamp and regionID
 * @author Tejal
 */
public class ProductMessage {
    
    private Product product;
    private Date timestamp;
    private char regionID;

    public ProductMessage()
	{
		this.timestamp = new Date();
		this.product = null;
		this.regionID = ' ';
	}
    
    public ProductMessage(Product product, Date timestamp, char regionID) {
        this.product = product;
        this.timestamp = timestamp;
        this.regionID = regionID;
    }

    public synchronized Product getProduct() {
        return product;
    }

    public synchronized void setProduct(Product product) {
        this.product = product;
    }

    public synchronized Date getTimestamp() {
        return timestamp;
    }

    public synchronized void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public synchronized char getRegionID() {
        return regionID;
    }

    public synchronized void setRegionID(char regionID) {
        this.regionID = regionID;
    }

    @Override
    public String toString() {
        return "ProductMessage{" + "product=" + product + ", timestamp=" + timestamp + ", regionID=" + regionID + '}';
    }
    
    
}
