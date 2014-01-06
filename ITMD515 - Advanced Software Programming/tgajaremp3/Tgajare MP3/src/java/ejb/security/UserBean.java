/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.User;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 * This represents the bean used for the User entity
 * @author Tejal
 */
@Stateless
public class UserBean extends AbstractBean<User>{

    public UserBean() {
    }

    public List<User> findall(){
        return super.findAll("select u from User u");
    }
}
