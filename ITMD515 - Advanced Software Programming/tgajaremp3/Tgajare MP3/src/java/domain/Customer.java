/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This entity represents a customer buying a product. It has different attributes to identify a customer
 * This entity also makes use of the Address Embeddable class in order to represent the address of the customer
 * This entity has one-many relationship with PurchaseOrder and many-to-many relationship with Product
 * @author Tejal
 */
@Entity
@NamedQuery(name = "Customer.findByUsername", query = "select c from Customer c where c.user.userName = :userName")
public class Customer extends UtilityEntity implements Serializable {

    
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Embedded
    private Address address;
    private Long phone;
    @OneToMany(mappedBy = "customer")
    private List<Product> products=new ArrayList<>();
    
    @OneToMany
    private List<PurchaseOrder> orders=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    
    public void addOrder(PurchaseOrder order)
    {
        if(!this.orders.contains(order)){
            this.orders.add(order);
        }
    }
    
    public List<PurchaseOrder> getOrder() {
        return orders;
    }

    public void setOrder(List<PurchaseOrder> order) {
        this.orders = order;
    }
    
    
    
    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
        if (product.getCustomer() != this) {
            
            product.setCustomer(this);
        }
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Customer() {
    }
    
    public Customer(String firstName, String lastName, Date dateOfBirth, Address address, Long phone) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * Get the value of dateOfBirth
     *
     * @return the value of dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the value of dateOfBirth
     *
     * @param dateOfBirth new value of dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
}
