/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This entity represents the Brand owned by a particular designer
 * It has one-one unidirectional relationship with Designer entity with Designer being the owner
 * @author Tejal
 */
@Entity
public class Brand extends UtilityEntity implements Serializable {

    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }


}
