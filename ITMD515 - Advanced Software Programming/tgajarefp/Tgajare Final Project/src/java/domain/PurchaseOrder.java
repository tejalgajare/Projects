/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This Entity represents a customer order. It has attributes which specify the order details
 * It has many-many relationship with Product
 * @author Tejal
 */
@Entity
@Named
public class PurchaseOrder extends UtilityEntity implements Serializable {
    
    private int quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Embedded
    private Address shippingAddress;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Temporal(TemporalType.TIME)
    private Date orderTime;
    @ManyToMany(mappedBy = "orders",cascade= CascadeType.PERSIST)
    private List<Product> products=new ArrayList<>();
    
    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
        if (!product.getOrders().contains(this)) {
            product.getOrders().add(this);
        }
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public PurchaseOrder() {
    }
    
    public PurchaseOrder(int quantity, Address shippingAddress, Date orderDate, Date orderTime) {
        
        this.quantity = quantity;
        this.shippingAddress = shippingAddress;
      
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }
    
    public Address getShippingAddress() {
        return shippingAddress;
    }
    
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
   

    /**
     * Get the value of orderTime
     *
     * @return the value of orderTime
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * Set the value of orderTime
     *
     * @param orderTime new value of orderTime
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Get the value of orderDate
     *
     * @return the value of orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set the value of orderDate
     *
     * @param orderDate new value of orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
}
