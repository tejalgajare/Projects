/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Address;
import domain.Brand;
import domain.Customer;
import domain.Designer;
import domain.Product;
import domain.PurchaseOrder;
import java.security.acl.Owner;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tejal
 */
public class DomainTest {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tgajare_MP2_DomainPU");
    protected static EntityManager em;
    protected static EntityTransaction tx;

    public DomainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Brand brand1 = new Brand("Gucci");
        Brand brand2 = new Brand("Armani");
        Brand brand3 = new Brand("Calvin Klein");
        Brand brand4 = new Brand("Dior");
        Brand brand5 = new Brand("Express");
        Brand brand6 = new Brand("Micheal Kors");


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

        customer1.addOrder(po5);
        customer1.addOrder(po4);

        customer2.addOrder(po4);
        customer3.addOrder(po3);
        customer4.addOrder(po2);
        customer5.addOrder(po1);

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
        product2.setDesigner(designer2);
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



        tx.begin();
        em.persist(brand1);
        em.persist(brand2);
        em.persist(brand3);
        em.persist(brand4);
        em.persist(brand5);
        em.persist(brand6);

        em.persist(designer1);
        em.persist(designer2);
        em.persist(designer3);
        em.persist(designer4);
        em.persist(designer5);
        em.persist(designer6);

        em.persist(customer1);
        em.persist(customer2);
        em.persist(customer3);
        em.persist(customer4);
        em.persist(customer5);
        em.persist(customer6);

        em.persist(po1);
        em.persist(po2);
        em.persist(po3);
        em.persist(po4);
        em.persist(po5);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);
        em.persist(product5);

        tx.commit();
    }

    @After
    public void tearDown() {
        em.close();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void domainTest() {
        TypedQuery<Designer> query = em.createQuery("select d from Designer d where d.firstName = 'Guccio' and d.lastName='Gucci'", Designer.class);
        Designer d1 = query.getSingleResult();
        assertNotNull(d1);
        System.out.println("\nDesigner: " + d1.getFirstName() + " " + d1.getLastName() + " owns Brand " + d1.getBrand().getName());


        TypedQuery<Customer> query1 = em.createQuery("select c from Customer c where c.firstName = 'Tejal' and c.lastName='Gajare'", Customer.class);
        Customer c1 = query1.getSingleResult();
        assertNotNull(c1);
        System.out.println("\nCustomer: " + c1.getFirstName() + " " + c1.getLastName() + " placed the following Orders:");

        List<PurchaseOrder> c1Orders = c1.getOrder();
        for (PurchaseOrder c1Order : c1Orders) {
            System.out.println("***********************************************************************************************");
            System.out.println("\tOrder ID:" + c1Order.getId() + "\n***********************************************************************************************"
                    + "\nDate:\t\t\t"
                    + c1Order.getOrderDate()
                    + "\nTime:\t\t\t"
                    + c1Order.getOrderTime()
                    + "\nShipping Address:\t"
                    + c1Order.getShippingAddress().getLine1() + " "
                    + c1Order.getShippingAddress().getLine2() + " "
                    + c1Order.getShippingAddress().getCity() + " "
                    + c1Order.getShippingAddress().getState() + " "
                    + c1Order.getShippingAddress().getZip() + " "
                    + c1Order.getShippingAddress().getCountry() + " ");
            List<Product> c1OrderProducts = c1Order.getProducts();
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("Products for Order:" + c1Order.getId());
            System.out.println("------------------------------------------------------------------------------------------------");
            for (Product c1OrderProduct : c1OrderProducts) {

                System.out.println(c1OrderProduct.getId() + "\t" + c1OrderProduct.getName()
                        + "\t" + c1OrderProduct.getDescription()
                        + "\t" + c1OrderProduct.getPrice()
                        + "\t" + c1OrderProduct.getDesigner() + "\n");

            }


        }

        tx.begin();
        TypedQuery<Brand> brandQuery = em.createQuery("select b from Brand b where b.name = 'Express'", Brand.class);
        Brand brand6 = brandQuery.getSingleResult();
        assertNotNull(brand6);
        brand6.setName("Coach (Updated)");
        tx.commit();

        tx.begin();
        TypedQuery<Customer> removeQuery = em.createQuery("select c from Customer c where c.firstName = 'Abhed'", Customer.class);
        Customer cust = removeQuery.getSingleResult();
        em.remove(cust);
        tx.commit();

    }
}