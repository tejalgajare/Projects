package domain;

import Product.Product;
import Product.ProductMessage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Utility Class contains the methods to read the file,generate random
 * product and create product message
 *
 * @author Tejal
 */
public class Utilities {

    public static ArrayList readFile() {

        Product record = null;
        BufferedReader br = null;
        String line = null;
        ArrayList productRecords = null;

        try {

            br = new BufferedReader(new FileReader("data/PRODUCT_data.csv"));
            productRecords = new ArrayList<Product>();
            while ((line = br.readLine()) != null) {

                String[] split = line.split("[\\r\\n]+");
                String[] split1 = line.split(",");                  //split1 is an array of all tokens separated by ','
                int PRODUCT_ID = Integer.parseInt(split1[0]);       //storing the first element of every line in day variable
                int MANUFACTURER_ID = Integer.parseInt(split1[1]);
                String PRODUCT_CODE = split1[2];
                float PURCHASE_COST = Float.parseFloat(split1[3]);
                int QUANTITY_ON_HAND = Integer.parseInt(split1[4]);
                float MARKUP = Float.parseFloat(split1[5]);
                String AVAILABLE = split1[6];
                String DESCRIPTION = split1[7];

                record = new Product(PRODUCT_ID, MANUFACTURER_ID, PRODUCT_CODE, PURCHASE_COST, QUANTITY_ON_HAND,
                                     MARKUP, AVAILABLE, DESCRIPTION);

                productRecords.add(record);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productRecords;
    }

    public static Product generateRandomProduct(ArrayList<Product> productList) {
        Product randomProduct = null;
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(19);   //index=19 as there are in all 20 rows in the product file and the count begins from 0
        return randomProduct = productList.get(rndIndex);
    }

    public static ProductMessage createProductMessage(Product randomProduct) {
        ProductMessage productMessage = null;
        char[] regionIds = {'N', 'S', 'E', 'W'};
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(4);
        return productMessage = new ProductMessage(randomProduct, new Date(), regionIds[rndIndex]);
    }
}
