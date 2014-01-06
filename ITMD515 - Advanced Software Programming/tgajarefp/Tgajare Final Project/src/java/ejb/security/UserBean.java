/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.User;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

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
    
    public User findByUserName(String userName){
        TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByUsername", User.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }
}
