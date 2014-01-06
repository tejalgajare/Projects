/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Brand;
import java.util.List;
import javax.ejb.Stateless;

/**
 * This represents the bean used for the Brand entity
 * @author Tejal
 */
@Stateless
public class BrandBean extends AbstractBean<Brand>{

    public BrandBean() {
    }

    public List<Brand> findall(){
        return super.findAll("select b from Brand b");
    }

}
