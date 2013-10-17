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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * This entity represents the designer information.
 * It has a one-one relationship with Brand and one-many relationship with Product
 * @author Tejal
 */
@Entity
public class Designer implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne
    private Brand brand;

    @OneToMany(mappedBy = "designer")
    private List<Product> products=new ArrayList<>();

    
    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
        }
        if (product.getDesigner()!= this) {
            
            product.setDesigner(this);
        }
    }
    
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    /**
     * Get the value of brand
     *
     * @return the value of brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Set the value of brand
     *
     * @param brand new value of brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Designer() {
    }

    public Designer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Designer {" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
