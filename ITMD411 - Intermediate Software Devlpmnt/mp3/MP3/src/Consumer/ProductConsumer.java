package Consumer;

import Producer.ProducerChild;
import Product.ProductMessage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents the main consumer base class.Each ProductConsumer
 * consumes only their respective ProductMessage objects from the
 * ProductProducer and maintains an internal list of its collected products.
 *
 * @author Tejal
 */
public abstract class ProductConsumer implements Runnable {

    private ProducerChild prodChild;
    private Queue<ProductMessage> prodMsgQ;

    public ProductConsumer() {
        this.prodChild = null;

        this.prodMsgQ = new LinkedList<ProductMessage>();
    }

    public ProductConsumer(ProducerChild prodChild) {
        this.prodChild = prodChild;

        this.prodMsgQ = new LinkedList<ProductMessage>();

        System.out.println(this.getClass().toString() + " started.");

    }

    public abstract char getRegion();     //implemented in the sub classes

    public synchronized ProducerChild getProdChildQ() {
        return prodChild;
    }

    public synchronized void setProdChild(ProducerChild prodChildQ) {
        this.prodChild = prodChildQ;
    }

    public synchronized Queue<ProductMessage> getProdMsgQ() {
        return prodMsgQ;
    }

    public synchronized void setProdMsgQ(Queue<ProductMessage> prodMsgQ) {
        this.prodMsgQ = prodMsgQ;
    }

    @Override
    public void run() {
        this.operate_ProductChild();
    }

    private synchronized Boolean operate_ProductChild() {

        char region = this.getRegion();              //fetch the region ID of the invoking object
        ProductMessage prodMsg = this.getProdChildQ().peek(this.getRegion());   //get the front-most msg from the producer's queue 
        if (null != prodMsg && prodMsg.getRegionID() == region) {           //if region matched the product msg's region then enter 
            prodMsg = this.getProdChildQ().poll(this.getRegion());          //and consume the product messgae

            if (null != prodMsg) {
                System.out.println(this.getClass().toString() + " consumed the product message ");

                this.prodMsgQ.add(prodMsg);        // add the consumed message to the internal conusmer's queue
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public synchronized String toString() {
        return this.getClass().toString() + " Product Total:  "+ Integer.toString(this.prodMsgQ.size());
    }

    public void consoleOutput() {
        
        System.out.println("");
        System.out.println(this.getClass().toString() + " processed: ");
        System.out.println("");

        for (ProductMessage msg : this.prodMsgQ) {
            
            System.out.println(msg.getProduct().toString() + ", " + msg.getTimestamp() + " " + this.getRegion());
        } 
        System.out.println("");
    }

    public void writeToFile() {
        try {
            
            //check for existing files
            File file = new File("output/" + this.getRegion() + ".csv");
            if (file.exists()) {
                file.delete();
            }

            FileWriter fstream = new FileWriter("output/" + this.getRegion() + ".csv");
            BufferedWriter out = new BufferedWriter(fstream);
            
            out.write("Product Id, Manufacturer ID, Product Code,Purchase Cost,Quantity on Hand,Mark Up,Available,Description, TimeStamp,Region ID " + (char) (10));
            
            //Write the contents of the product message... 
            for (ProductMessage msg : this.prodMsgQ) {
                out.write(msg.getProduct().toString() + ", "
                        + msg.getTimestamp() + ", "
                        + this.getRegion() + (char) (10));
            }

            out.close();

        } 
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } 
    }
}
