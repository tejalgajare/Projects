/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.City;
import domain.Country;
import domain.CountryLanguage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
public class MP2_RE_Test {
    
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tgajare_MP2_REPU");
    protected static EntityManager em;
    protected static EntityTransaction tx;
    
    public MP2_RE_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        em=emf.createEntityManager();
        tx=em.getTransaction();
    }
    
    @After
    public void tearDown() {
        
        em.close();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void RETest() {
     Query query = em.createQuery("select c from Country c");
        List<Country> countries = new ArrayList<>();
        countries = query.getResultList();
        
        for(Country c : countries){
            System.out.println("\n*********************************************\n");
            System.out.println(c.toString());
            System.out.println("Cities:");
            System.out.println("---------------------------");
            
            for(City city : c.getCityList()){
                System.out.println("\t\t" + city.getName());
            }
            
            System.out.println("\nCountryLanguages:");
            System.out.println("---------------------------");
            for(CountryLanguage lang : c.getCountryLanguageList() ){
                System.out.println("\t\t" + lang.getCountryLanguagePK().getLanguage());
               
            }
        }
    }
}