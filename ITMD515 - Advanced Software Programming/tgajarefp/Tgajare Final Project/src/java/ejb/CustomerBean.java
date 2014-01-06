/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

/**
 * This represents the bean used for the Customer entity
 * @author Tejal
 */
@Stateless
@Named
public class CustomerBean extends AbstractBean<Customer>{

    public CustomerBean() {
    }

    public List<Customer> findall(){
        return super.findAll("select c from Customer c");
    }
    public Customer findByUserName(String userName){
        TypedQuery<Customer> query = getEntityManager().createNamedQuery("Customer.findByUsername", Customer.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }


}
