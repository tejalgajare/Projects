/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.Group;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 * This represents the bean used for the Group entity
 * @author Tejal
 */
@Stateless
public class GroupBean extends AbstractBean<Group>{

    public GroupBean() {
    }

    public List<Group> findall(){
        return super.findAll("select g from Group g");
    }
}
