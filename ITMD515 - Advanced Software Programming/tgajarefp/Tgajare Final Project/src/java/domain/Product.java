/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * This entity represents a product that a customer would buy which contains the
 * product details as attributes. It has a many-many relationship with Order and
 * many-one relationship with brand and many to one with customer
 *
 * @author Tejal
 */
@Entity
@Named
public class Product extends UtilityEntity implements Serializable {

    private String name;
    private String description;
    private float price;
    private float sale;

    /**
     * Get the value of sale
     *
     * @return the value of sale
     */
    public float getSale() {
        return sale;
    }

    /**
     * Set the value of sale
     *
     * @param sale new value of sale
     */
    public void setSale(float sale) {
        this.sale = sale;
    }
    @ManyToMany
    private List<PurchaseOrder> orders = new ArrayList<>();
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Customer customer;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
        if (!brand.getProducts().contains(this)) {
            brand.getProducts().add(this);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (!customer.getProducts().contains(this)) {
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
    public float calculateTotalSale() {

        List<PurchaseOrder> orders = this.getOrders();
        for (PurchaseOrder order : orders) {
            float tempSale;
            tempSale = this.price * order.getQuantity();
            tempSale = tempSale + this.getSale();
            this.setSale(tempSale);
        }
        return this.getSale();
    }

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
}
