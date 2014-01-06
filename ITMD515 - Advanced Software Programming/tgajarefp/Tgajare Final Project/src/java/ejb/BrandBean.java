/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Brand;
import domain.Designer;
import domain.Product;
import domain.PurchaseOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

/**
 * This represents the bean used for the Brand entity
 * @author Tejal
 */
@Stateless
@Named
public class BrandBean extends AbstractBean<Brand>{

    public BrandBean() {
    }

    public List<Brand> findall(){
        return super.findAll("select b from Brand b");
    }
    public Brand findByBrandID(Integer brand){
        TypedQuery<Brand> query = getEntityManager().createNamedQuery("Brand.findByBrandID", Brand.class);
        query.setParameter("brand", brand);
        return query.getSingleResult();
    }
    
    public void removeProduct(Brand b, Product p){
        p = getEntityManager().getReference(Product.class, p.getId());
        b = getEntityManager().getReference(Brand.class, b.getId());
   
        b.removeProduct(p);
        super.update(b);

        getEntityManager().remove(p);
    }

        public void addNewProduct(Brand b, Product p){
   
       getEntityManager().persist(p);
        
        b.addProduct(p);
        super.update(b);
    }
}
