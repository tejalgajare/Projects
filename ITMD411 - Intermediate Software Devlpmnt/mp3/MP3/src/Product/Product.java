package Product;

/**
 * This class is used to store the contents of the file in various declared member fields
 * @author Tejal
 */
public class Product {
    
    private int PRODUCT_ID;
    private int MANUFACTURER_ID;
    private String PRODUCT_CODE;
    private float PURCHASE_COST;
    private int QUANTITY_ON_HAND;
    private float MARKUP;
    private String AVAILABLE;
    private String DESCRIPTION;

    public Product() {
        
        this.PRODUCT_ID=0;
        this.MANUFACTURER_ID=0;
        this.PRODUCT_CODE="";
        this.PURCHASE_COST=0;
        this.QUANTITY_ON_HAND=0;
        this.MARKUP=0;
        this.AVAILABLE="";
        this.DESCRIPTION="";
    }

    
    public Product(int PRODUCT_ID, int MANUFACTURER_ID, String PRODUCT_CODE, float PURCHASE_COST, int QUANTITY_ON_HAND, float MARKUP, String AVAILABLE, String DESCRIPTION) {
        super();
        this.PRODUCT_ID = PRODUCT_ID;
        this.MANUFACTURER_ID = MANUFACTURER_ID;
        this.PRODUCT_CODE = PRODUCT_CODE;
        this.PURCHASE_COST = PURCHASE_COST;
        this.QUANTITY_ON_HAND = QUANTITY_ON_HAND;
        this.MARKUP = MARKUP;
        this.AVAILABLE = AVAILABLE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public synchronized int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public synchronized void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public synchronized int getMANUFACTURER_ID() {
        return MANUFACTURER_ID;
    }

    public synchronized void setMANUFACTURER_ID(int MANUFACTURER_ID) {
        this.MANUFACTURER_ID = MANUFACTURER_ID;
    }

    public synchronized String getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    public synchronized void setPRODUCT_CODE(String PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }

    public synchronized float getPURCHASE_COST() {
        return PURCHASE_COST;
    }

    public synchronized void setPURCHASE_COST(float PURCHASE_COST) {
        this.PURCHASE_COST = PURCHASE_COST;
    }

    public synchronized int getQUANTITY_ON_HAND() {
        return QUANTITY_ON_HAND;
    }

    public synchronized void setQUANTITY_ON_HAND(int QUANTITY_ON_HAND) {
        this.QUANTITY_ON_HAND = QUANTITY_ON_HAND;
    }

    public synchronized float getMARKUP() {
        return MARKUP;
    }

    public synchronized void setMARKUP(float MARKUP) {
        this.MARKUP = MARKUP;
    }

    public synchronized String getAVAILABLE() {
        return AVAILABLE;
    }

    public synchronized void setAVAILABLE(String AVAILABLE) {
        this.AVAILABLE = AVAILABLE;
    }

    public synchronized String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public synchronized void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Product{" + "PRODUCT_ID=" + PRODUCT_ID + ", MANUFACTURER_ID=" + MANUFACTURER_ID + ", PRODUCT_CODE=" + PRODUCT_CODE + ", PURCHASE_COST=" + PURCHASE_COST + ", QUANTITY_ON_HAND=" + QUANTITY_ON_HAND + ", MARKUP=" + MARKUP + ", AVAILABLE=" + AVAILABLE + ", DESCRIPTION=" + DESCRIPTION + '}';
    }
    
    
    
}
