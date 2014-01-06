/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import domain.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * This represents the bean used for the Product entity
 * @author Tejal
 */
@Stateless
@Named
public class ProductBean extends AbstractBean<Product> {

    public ProductBean() {
    }

    public List<Product> findall(){
        return super.findAll("select p from Product p");
    }

}
