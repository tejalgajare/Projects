/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Address;
import domain.Brand;
import domain.Customer;
import domain.Designer;
import domain.Product;
import domain.PurchaseOrder;
import domain.security.Group;
import domain.security.User;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This represents the bean used for the populating the database relations that kicks off at the start
 * @author Tejal
 */
@Singleton
@Startup
public class DatabasePopulator {

    @EJB
    private UserBean userBean;
    @EJB
    private PurchaseOrderBean purchaseOrderBean;
    @EJB
    private ProductBean productBean;
    @EJB
    private GroupBean groupBean;
    @EJB
    private DesignerBean designerBean;
    @EJB
    private CustomerBean customerBean;
    @EJB
    private BrandBean brandBean;
    @PersistenceContext(unitName = "Tgajare_MP3_PU")
    private EntityManager em;
    private static final Logger LOG = Logger.getLogger(DatabasePopulator.class.getName());

    @PostConstruct
    private void populateDatabase() {

        Group customerGroup = new Group("Customers", "This group represents all the customers");
        Group designerGroup = new Group("Designers", "This group represents all the designers");

        User customerUser1 = new User("cust1", "cust");
        User customerUser2 = new User("cust2", "cust");
        User customerUser3 = new User("cust3", "cust");
        User customerUser4 = new User("cust4", "cust");
        User customerUser5 = new User("cust5", "cust");
        
        User designerUser1 = new User("designer1", "desi");
        User designerUser2 = new User("designer2", "desi");
        User designerUser3 = new User("designer3", "desi");
        User designerUser4 = new User("designer4", "desi");
        User designerUser5 = new User("designer5", "desi");
        
        customerUser1.addGroup(customerGroup);
        customerUser2.addGroup(customerGroup);
        customerUser3.addGroup(customerGroup);
        customerUser4.addGroup(customerGroup);
        customerUser5.addGroup(customerGroup);
        
        designerUser1.addGroup(designerGroup);
        designerUser2.addGroup(designerGroup);
        designerUser3.addGroup(designerGroup);
        designerUser4.addGroup(designerGroup);
        designerUser5.addGroup(designerGroup);
        
        groupBean.create(customerGroup);
        groupBean.create(designerGroup);
        
        userBean.create(customerUser1);
        userBean.create(customerUser2);
        userBean.create(customerUser3);
        userBean.create(customerUser4);
        userBean.create(customerUser5);
        
        userBean.create(designerUser1);
        userBean.create(designerUser2);
        userBean.create(designerUser3);
        userBean.create(designerUser4);
        userBean.create(designerUser5);

        Brand brand1 = new Brand("Gucci");
        Brand brand2 = new Brand("Armani");
        Brand brand3 = new Brand("Calvin Klein");
        Brand brand4 = new Brand("Dior");
        Brand brand5 = new Brand("Express");
        Brand brand6 = new Brand("Micheal Kors");
        brandBean.create(brand1);
        brandBean.create(brand2);
        brandBean.create(brand3);
        brandBean.create(brand4);
        brandBean.create(brand5);
        brandBean.create(brand6);

        Designer designer1 = new Designer("Guccio", "Gucci");
        Designer designer2 = new Designer("Giorgio", "Armani");
        Designer designer3 = new Designer("Calvin", "Klein");
        Designer designer4 = new Designer("Christian", "Dior");
        Designer designer5 = new Designer("Blair", "Waldorf");
        Designer designer6 = new Designer("Heidi", "Klum");

       
        Address addr1 = new Address("3001 S Michigan Ave", "1204", "Chicago", "IL", "60616", "USA");
        Address addr2 = new Address("1120 N Lasalle Blvd", "5P", "Chicago", "IL", "60610", "USA");
        Address addr3 = new Address("546 N Lamar Blvd", "4C", "Austin", "TX", "78705", "USA");
        Address addr4 = new Address("2600 Lake Austin Blvd", "7309", "Austin", "TX", "78703", "USA");
        Address addr5 = new Address("30 Descanso Drive", "3241", "San Jose", "CA", "98905", "USA");

        Customer customer1 = new Customer("Tejal", "Gajare", new GregorianCalendar(1988, 5, 23).getTime(), addr1, 7706256116L);
        Customer customer2 = new Customer("Aditya", "Ghule", new GregorianCalendar(1983, 2, 27).getTime(), addr2, 6784624248L);
        Customer customer3 = new Customer("Rashmi", "Ghule", new GregorianCalendar(1999, 3, 7).getTime(), addr3, 3125673024L);
        Customer customer4 = new Customer("Tanmay", "Gajare", new GregorianCalendar(2000, 1, 5).getTime(), addr5, 6457832456L);
        Customer customer5 = new Customer("Sayali", "Chandak", new GregorianCalendar(2001, 8, 14).getTime(), addr5, 9876546743L);
        Customer customer6 = new Customer("Abhed", "Kothadia", new GregorianCalendar(2001, 8, 14).getTime(), addr5, 5436787654L);

        PurchaseOrder po1 = new PurchaseOrder(1, addr5, new GregorianCalendar(2001, 8, 14).getTime(), new GregorianCalendar(2001, 8, 14, 12, 30).getTime());
        PurchaseOrder po2 = new PurchaseOrder(2, addr4, new GregorianCalendar(2013, 7, 5).getTime(), new GregorianCalendar(2013, 7, 5, 15, 30).getTime());
        PurchaseOrder po3 = new PurchaseOrder(2, addr3, new GregorianCalendar(2009, 6, 1).getTime(), new GregorianCalendar(2009, 6, 1, 22, 45).getTime());
        PurchaseOrder po4 = new PurchaseOrder(2, addr2, new GregorianCalendar(2008, 5, 2).getTime(), new GregorianCalendar(2008, 5, 2, 02, 27).getTime());
        PurchaseOrder po5 = new PurchaseOrder(3, addr1, new GregorianCalendar(2012, 4, 11).getTime(), new GregorianCalendar(2012, 4, 11, 12, 15).getTime());

        designer1.setBrand(brand1);
        designer2.setBrand(brand2);
        designer3.setBrand(brand3);
        designer4.setBrand(brand4);
        designer5.setBrand(brand5);
        
        designer1.setUser(designerUser1);
        designer2.setUser(designerUser2);
        designer3.setUser(designerUser3);
        designer4.setUser(designerUser4);
        designer5.setUser(designerUser5);
        
        designerBean.create(designer1);
        designerBean.create(designer2);
        designerBean.create(designer3);
        designerBean.create(designer4);
        designerBean.create(designer5);
        designerBean.create(designer6);


        customer1.addOrder(po5);
        customer1.addOrder(po4);
        customer2.addOrder(po4);
        customer3.addOrder(po3);
        customer4.addOrder(po2);
        customer5.addOrder(po1);
        
        customer1.setUser(customerUser1);
        customer2.setUser(customerUser2);
        customer3.setUser(customerUser3);
        customer4.setUser(customerUser4);
        customer5.setUser(customerUser5);
        
        customerBean.create(customer1);
        customerBean.create(customer2);
        customerBean.create(customer3);
        customerBean.create(customer4);
        customerBean.create(customer5);
        customerBean.create(customer6);


        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        
        product1.setCustomer(customer1);
        product1.setDesigner(designer5);
        product1.setName("Tunic");
        product1.setDescription("Plum Color");
        product1.setPrice(30);

        product2.setCustomer(customer2);
        product2.setDesigner(designer5);
        product2.setName("Top");
        product2.setDescription("Deep Sea Green Color");
        product2.setPrice(20);

        product3.setCustomer(customer3);
        product3.setDesigner(designer4);
        product3.setName("Capri");
        product3.setDescription("Black");
        product3.setPrice(10);

        product4.setCustomer(customer4);
        product4.setDesigner(designer1);
        product4.setName("Shirt");
        product4.setDescription("Coral");
        product4.setPrice(30);

        product5.setCustomer(customer5);
        product5.setDesigner(designer3);
        product5.setName("Dress");
        product5.setDescription("Black Color");
        product5.setPrice(50);

        productBean.create(product1);
        productBean.create(product2);
        productBean.create(product3);
        productBean.create(product4);
        productBean.create(product5);

        po5.addProduct(product1);
        po5.addProduct(product2);
        po5.addProduct(product5);
        po4.addProduct(product3);
        po4.addProduct(product4);
        po3.addProduct(product1);
        po3.addProduct(product2);
        po2.addProduct(product3);
        po1.addProduct(product3);
        po1.addProduct(product5);

        purchaseOrderBean.create(po1);
        purchaseOrderBean.create(po2);
        purchaseOrderBean.create(po3);
        purchaseOrderBean.create(po4);
        purchaseOrderBean.create(po5);




    }
}
