/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Address;
import domain.Brand;
import domain.Customer;
import domain.Designer;
import domain.Product;
import domain.PurchaseOrder;
import domain.security.Group;
import domain.security.User;
import ejb.AddressBean;
import ejb.BrandBean;
import ejb.CustomerBean;
import ejb.DesignerBean;
import ejb.ProductBean;
import ejb.PurchaseOrderBean;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

/**
 * This controller handles all the customer related order management activities such as create a order
 * @author Tejal
 */
@RequestScoped
@Named
public class ManageOrder {

    @EJB
    private ProductBean productBean;
    @EJB
    private PurchaseOrderBean purchaseOrderBean;
    @EJB
    private CustomerBean customerBean = new CustomerBean();
    @EJB
    private UserBean userBean = new UserBean();
    private User user = new User();
    private Customer customer = new Customer();
    private Product product = new Product();
    private Product product1 = new Product();
    private String selectedItem;
    private PurchaseOrder order = new PurchaseOrder();
    private HtmlDataTable datatableProducts = new HtmlDataTable();
    private HtmlInputHidden selectedItemId = new HtmlInputHidden();
    private HtmlInputHidden dataItemID = new HtmlInputHidden();
    private HtmlDataTable datatableProducts1 = new HtmlDataTable();

    /**
     * Get the value of datatableProducts1
     *
     * @return the value of datatableProducts1
     */
    public HtmlDataTable getDatatableProducts1() {
        return datatableProducts1;
    }

    /**
     * Set the value of datatableProducts1
     *
     * @param datatableProducts1 new value of datatableProducts1
     */
    public void setDatatableProducts1(HtmlDataTable datatableProducts1) {
        this.datatableProducts1 = datatableProducts1;
    }

    /**
     * Get the value of dataItemID
     *
     * @return the value of dataItemID
     */
    public HtmlInputHidden getDataItemID() {
        return dataItemID;
    }

    /**
     * Set the value of dataItemID
     *
     * @param dataItemID new value of dataItemID
     */
    public void setDataItemID(HtmlInputHidden dataItemID) {
        this.dataItemID = dataItemID;
    }

    /**
     * Get the value of selectedItemId
     *
     * @return the value of selectedItemId
     */
    public HtmlInputHidden getSelectedItemId() {
        return selectedItemId;
    }

    /**
     * Set the value of selectedItemId
     *
     * @param selectedItemId new value of selectedItemId
     */
    public void setSelectedItemId(HtmlInputHidden selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    /**
     * Get the value of order
     *
     * @return the value of order
     */
    public PurchaseOrder getOrder() {
        return order;
    }

    /**
     * Set the value of order
     *
     * @param order new value of order
     */
    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }

    /**
     * Get the value of selectedItem
     *
     * @return the value of selectedItem
     */
    public String getSelectedItem() {
        return selectedItem;
    }

    /**
     * Set the value of selectedItem
     *
     * @param selectedItem new value of selectedItem
     */
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    @PostConstruct
    private void init() {
        customer = customerBean.findByUserName(context.getExternalContext().getRemoteUser());
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

    public ManageOrder() {
        context = FacesContext.getCurrentInstance();

    }
    private static final Logger LOG = Logger.getLogger(SignUpController.class.getName());

    public String addProduct() {
        int index = 0;
        index = datatableProducts.getRowIndex(); // Actually not interesting info.
        product = (Product) datatableProducts1.getRowData();
        selectedItemId.setValue(product.getId());
        System.out.println("****************"+product.getName());
        return "";
    }

    public String saveChanges() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        product = (Product) datatableProducts1.getRowData();
        //order.setQuantity(Integer.parseInt(request.getParameter("addorder:quantity")));
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderTime(Calendar.getInstance().getTime());
        order.setShippingAddress(customer.getAddress());
        System.out.println("****************"+this.product.getName());
        product.addOrders(this.order);
        order.addProduct(product);
        purchaseOrderBean.create(order);
        
        productBean.update(this.product);
        customer.addOrder(order);
        customerBean.update(this.customer);
        return "/secure/browseOrders.jsf";
    }
}
