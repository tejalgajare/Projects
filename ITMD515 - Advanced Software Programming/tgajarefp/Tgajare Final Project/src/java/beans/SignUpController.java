/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Address;
import domain.Brand;
import domain.Customer;
import domain.Designer;
import domain.security.Group;
import domain.security.User;
import ejb.AddressBean;
import ejb.BrandBean;
import ejb.CustomerBean;
import ejb.DesignerBean;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * This is a controller that handles all the sign up features such as signing in as a new designer or a customer
 * @author Tejal
 */
//@ManagedBean(name="sc")
@RequestScoped
@Named
public class SignUpController {

    @EJB
    private AddressBean addressBean = new AddressBean();
    @EJB
    private CustomerBean customerBean;
    @EJB
    private UserBean userBean = new UserBean();
    @EJB
    private GroupBean groupBean = new GroupBean();
    @EJB
    private BrandBean brandBean = new BrandBean();
    @EJB
    private DesignerBean designerBean = new DesignerBean();
    private User user = new User();
    private List<User> usersList = new ArrayList<>();
    private List<Group> groupsList = new ArrayList<>();
    private Designer designer = new Designer();
    private Brand brand = new Brand();
    private Customer customer = new Customer();
    private Address address = new Address();

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Get the value of customer
     *
     * @return the value of customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the value of customer
     *
     * @param customer new value of customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }
    private FacesContext context;

    public SignUpController() {
        context = FacesContext.getCurrentInstance();
    }
    private static final Logger LOG = Logger.getLogger(SignUpController.class.getName());
    private String username;

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    private String password;

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
    private String role;

    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(String role) {
        this.role = role;
    }

    public String signUpDesigner() {


        usersList = userBean.findall();
        for (User tempUser : usersList) {
            if (tempUser.getUserName().equals(this.username)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username exists", "Username exists"));
                LOG.log(Level.SEVERE, null);
                return "login.jsf";
            }

        }

        user.setUserName(this.username);
        user.setPassword(this.password);
        groupsList = groupBean.findall();

        user.addGroup(groupsList.get(1));

        designerBean.create(designer);
        brandBean.create(brand);
        userBean.create(user);
        designer.setUser(user);
        designer.setBrand(brand);
        designerBean.update(designer);
        return "login.jsf";
    }

    public String signUpCustomer() {


        usersList = userBean.findall();
        for (User tempUser : usersList) {
            if (tempUser.getUserName().equals(this.username)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username exists", "Username exists"));
                LOG.log(Level.SEVERE, null);
                return "login.jsf";
            }

        }

        user.setUserName(this.username);
        user.setPassword(this.password);
        groupsList = groupBean.findall();

        user.addGroup(groupsList.get(0));

        userBean.create(user);
        customerBean.create(customer);
        customer.setAddress(address);
        customer.setUser(user);
        customerBean.update(customer);
        

        return "login.jsf";
    }
}
