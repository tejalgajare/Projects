/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Designer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * This represents the bean used for the Designer entity
 * @author Tejal
 */
@Stateless
public class DesignerBean extends AbstractBean<Designer>{

    public DesignerBean() {
    }

   public List<Designer> findall(){
        return super.findAll("select d from Designer d");
    }
   public Designer findByUserName(String userName){
        TypedQuery<Designer> query = getEntityManager().createNamedQuery("Designer.findByUsername", Designer.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }
}
