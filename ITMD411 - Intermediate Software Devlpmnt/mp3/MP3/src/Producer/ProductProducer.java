package Producer;

import Product.Product;
import Product.ProductMessage;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the Producer Base class that encapsulates the common methods.It maintains an internal queue and an array list 
 * to store the product list in order to generate a random products and generate a product message to be stored in the queue.
 * @author Tejal
 */
public abstract class ProductProducer implements Runnable {

    private Queue<ProductMessage> prodMsgQ;
    private ArrayList readProductList;

    public ProductProducer() {
        this.prodMsgQ = new LinkedList<ProductMessage>();
        System.out.println(this.getClass().toString() + " started.");
    }

    /**
     * The following constructor initiates the array list to the product list read from the file
     */
    public ProductProducer(ArrayList<Product> productList) {
        this.prodMsgQ = new LinkedList<ProductMessage>();
        this.readProductList = productList;
        System.out.println(this.getClass().toString() + " started.");

    }

    public synchronized ArrayList getReadProductList() {
        return readProductList;
    }

    public synchronized void setReadProductList(ArrayList readProductList) {
        this.readProductList = readProductList;
    }

    public synchronized Queue<ProductMessage> getProducts() {
        return prodMsgQ;
    } 

    public synchronized void setProducts(Queue<ProductMessage> prodMsgQ) {
        this.prodMsgQ = prodMsgQ;
    } 

    /**
     * The following method is used to add a product message to the internal message queue on acquiring the lock
     * @param msg is the product message object that is to be added to the message queue. 
     */
    public synchronized void add(ProductMessage msg){
        this.prodMsgQ.add(msg);
    } 

    /**
     * The following method is used to consume an object out of the queue.
     */
    public synchronized ProductMessage poll(char lockOwner) {
        return this.prodMsgQ.poll();
    } 

    /**
     * The following method is used to see the message that is in the front of the queue.
     */
    public synchronized ProductMessage peek(char lockOwner) {
        return this.prodMsgQ.peek();
    } 
    
    @Override
    public abstract void run();
  
} 