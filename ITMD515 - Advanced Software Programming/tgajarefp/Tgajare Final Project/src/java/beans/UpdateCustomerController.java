/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Address;
import domain.Brand;
import domain.Customer;
import domain.Designer;
import domain.security.User;
import ejb.AddressBean;
import ejb.BrandBean;
import ejb.CustomerBean;
import ejb.DesignerBean;
import ejb.security.UserBean;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * This controller is used to update the customer's profile
 * @author Tejal
 */
@RequestScoped
@Named
public class UpdateCustomerController implements Serializable {

    @EJB
    private AddressBean addressBean;
    @EJB
    private CustomerBean customerBean;
    @EJB
    private UserBean userBean;
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    String tempDate="";
    Date tempDateFormat;
    private User user = new User();
    private HtmlInputText dUsername = new HtmlInputText();
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

    @PostConstruct
    private void init() {
        customer = customerBean.findByUserName(context.getExternalContext().getRemoteUser());

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

    public HtmlInputText getdUsername() {
        return dUsername;
    }

    public void setdUsername(HtmlInputText dUsername) {
        this.dUsername = dUsername;
    }
    private FacesContext context;

    public UpdateCustomerController() {
        context = FacesContext.getCurrentInstance();

    }
    private static final Logger LOG = Logger.getLogger(UpdateCustomerController.class.getName());

    public String getDataFromDB() {

//
//        brand.setName(designer.getBrand().getName());
//        brand.setProducts(designer.getBrand().getProducts());
//        return "/secure/updateDesigner.xhtml";
        return null;
    }

    public String saveChanges() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        customer.setFirstName(request.getParameter("myForm:fn"));
        customer.setLastName(request.getParameter("myForm:ln"));
        customer.setEmail(request.getParameter("myForm:email"));
        tempDate=request.getParameter("myForm:dob");
        try {
            java.util.Date date=df.parse(tempDate);
            java.sql.Date sqlDate=new java.sql.Date(date.getTime()); 
            customer.setDateOfBirth(sqlDate);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        customer.setPhone(Long.parseLong(request.getParameter("myForm:phone")));
        address.setLine1(request.getParameter("myForm:line1"));
        address.setLine2(request.getParameter("myForm:line2"));
        address.setCity(request.getParameter("myForm:city"));
        address.setState(request.getParameter("myForm:state"));
        address.setZip(request.getParameter("myForm:zip"));
        address.setCountry(request.getParameter("myForm:country"));
        customer.setAddress(address);

        try {

            customerBean.update(this.customer);

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Changes Saved", "No Changes Saved"));
            LOG.log(Level.SEVERE, null, e);
        }
        return "/secure/customerProfile.jsf";
    }
}
