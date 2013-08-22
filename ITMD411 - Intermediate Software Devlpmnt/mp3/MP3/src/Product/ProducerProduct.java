package Product;

/**
 * This class in used to create the producer object
 * @author Tejal
 */
public class ProducerProduct extends Product {

    public ProducerProduct() {
        
    }

    public ProducerProduct(int PRODUCT_ID, int MANUFACTURER_ID, String PRODUCT_CODE, float PURCHASE_COST, int QUANTITY_ON_HAND, float MARKUP, String AVAILABLE, String DESCRIPTION) {
        super(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND, MARKUP, AVAILABLE, DESCRIPTION);
    }
    
}
