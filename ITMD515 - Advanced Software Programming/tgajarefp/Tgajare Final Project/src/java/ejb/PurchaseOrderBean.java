/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.PurchaseOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * This represents the bean used for the Purchase Order entity
 * @author Tejal
 */
@Stateless
@Named
public class PurchaseOrderBean extends AbstractBean<PurchaseOrder>{

    public PurchaseOrderBean() {
    }

    public List<PurchaseOrder> findall(){
        return super.findAll("select po from PurchaseOrder po");
    }

}
