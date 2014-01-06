/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * This entity represents the User JPA entity 
 * @author Tejal
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable{
  
    @Id
    private String userName;
    private String password;
    
    @ManyToMany
            @JoinTable(name = "USER_GROUPS",
            joinColumns = 
            @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = 
            @JoinColumn(name = "GROUPNAME"))
    List<Group> groups=new ArrayList<>();

    @PrePersist
    @PreUpdate
    private void hashPassword(){
        String hashPassword = DigestUtils.md5Hex(this.password);
        this.password = hashPassword;
    }
    
    public void addGroup(Group g) {
        if (!this.groups.contains(g)) {
            this.groups.add(g);
        }
        if (!g.getUsers().contains(this)) {
            g.getUsers().add(this);
        }
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    

     public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
