/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Address;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Tejal
 */
@Stateless
@Named
public class AddressBean extends AbstractBean<Address>{

    public AddressBean() {
    }
    
}
