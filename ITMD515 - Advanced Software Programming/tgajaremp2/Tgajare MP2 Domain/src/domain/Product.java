/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * This entity represents a product that a customer would buy which contains the product details as 
 * attributes.
 * It has a many-many relationship with Order and many-one relationship with designer and many to one with customer
 * @author Tejal
 */
@Entity
public class Product implements Serializable {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    @ManyToMany
    private List<PurchaseOrder> orders=new ArrayList<>();
    @ManyToOne
    private Designer designer;
    
    @ManyToOne
    private Customer customer;

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
        if(! designer.getProducts().contains(this))
        {
            designer.getProducts().add(this);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if(! customer.getProducts().contains(this))
        {
            customer.getProducts().add(this);
        }
        
    }
    
    
    
    public void addOrders(PurchaseOrder order) {
        
        if (!this.orders.contains(order)) {
            this.orders.add(order);
        }
        if (!order.getProducts().contains(this)) {
            order.getProducts().add(this);
        }
    }
    
    public List<PurchaseOrder> getOrders() {
        return orders;
    }
    
    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }
    
    public Product() {
    }
    
    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + '}';
    }
}
