/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 * This entity acts as an abstract entity to provide generalization for all entities with 
 * respect to ID and activityDate
 * @author Tejal
 */
@MappedSuperclass
public class UtilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityDate;

    
    @PrePersist
    @PreUpdate
    @PreRemove
    public void setTimeStamp(){
        this.activityDate=new Date();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        

    /**
     * Get the value of activityDate
     *
     * @return the value of activityDate
     */
    public Date getActivityDate() {
        return activityDate;
    }

    /**
     * Set the value of activityDate
     *
     * @param activityDate new value of activityDate
     */
    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

}
