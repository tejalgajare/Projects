package Producer;

import Product.Product;
import Product.ProductMessage;
import domain.Utilities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This is the Producer class sub class.It implements the run() method.
 * @author Tejal
 */
public class ProducerChild extends ProductProducer{


    public ProducerChild(ArrayList<Product> productList) {
        super(productList);
    }
    @Override
	public void run() {
                         
                        //Generates random product
                        Product randomProduct=Utilities.generateRandomProduct(this.getReadProductList());
                        
                        //Creates a product message
                        ProductMessage productMessage=Utilities.createProductMessage(randomProduct);
                        
                        //add msg to the queue
                        this.add(productMessage);

                        //print the details about product message
			System.out.println(this.getClass().toString() + " added => "+ productMessage.getProduct() + ", " + productMessage.getRegionID() + " product message.");

	} 
}
