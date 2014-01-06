/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Brand;
import domain.Designer;
import domain.security.User;
import ejb.BrandBean;
import ejb.DesignerBean;
import ejb.security.UserBean;
import java.io.Serializable;
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
 * This controller is used to update the designer's profile
 * @author Tejal
 */
@RequestScoped
@Named
public class UpdateDesignerController implements Serializable {

    @EJB
    private BrandBean brandBean;
    @EJB
    private UserBean userBean;
    @EJB
    private DesignerBean designerBean;
    private Designer designer = new Designer();
    private User user = new User();
    private HtmlInputText dUsername = new HtmlInputText();
    private Designer tempDesigner = new Designer();
    private Brand brand = new Brand();

    @PostConstruct
    private void init() {
        designer = designerBean.findByUserName(context.getExternalContext().getRemoteUser());
        brand=designer.getBrand();
    }
    /**
     * Get the value of brand
     *
     * @return the value of brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Set the value of brand
     *
     * @param brand new value of brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Get the value of tempDesigner
     *
     * @return the value of tempDesigner
     */
    public Designer getTempDesigner() {
        return tempDesigner;
    }

    /**
     * Set the value of tempDesigner
     *
     * @param tempDesigner new value of tempDesigner
     */
    public void setTempDesigner(Designer tempDesigner) {
        this.tempDesigner = tempDesigner;
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

    /**
     * Get the value of designer
     *
     * @return the value of designer
     */
    public Designer getDesigner() {
        return designer;
    }

    /**
     * Set the value of designer
     *
     * @param designer new value of designer
     */
    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public HtmlInputText getdUsername() {
        return dUsername;
    }

    public void setdUsername(HtmlInputText dUsername) {
        this.dUsername = dUsername;
    }
    private FacesContext context;

    public UpdateDesignerController() {
        context = FacesContext.getCurrentInstance();

    }
    private static final Logger LOG = Logger.getLogger(UpdateDesignerController.class.getName());

    public String getDataFromDB() {
      
        
        brand.setName(designer.getBrand().getName());
        brand.setProducts(designer.getBrand().getProducts());
        return "/secure/updateDesigner.xhtml";
    }

    public String saveChanges() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
         
         designer.setFirstName(request.getParameter("myForm:fn"));
         designer.setLastName(request.getParameter("myForm:ln"));
         designer.setEmail(request.getParameter("myForm:email"));
         brand.setName(request.getParameter("myForm:brand"));
         designer.setBrand(brand);
        
        
        try {
            brandBean.update(brand);
            designerBean.update(this.designer);
            
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Changes Saved", "No Changes Saved"));
            LOG.log(Level.SEVERE, null, e);
        }
        return "/secure/designerProfile.jsf";
    }
}
