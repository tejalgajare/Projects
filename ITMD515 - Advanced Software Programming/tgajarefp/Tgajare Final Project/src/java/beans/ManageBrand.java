/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Brand;
import domain.Designer;
import domain.Product;
import ejb.BrandBean;
import ejb.DesignerBean;
import ejb.ProductBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * This controller is used to handle all the designer related brand management activities
 * Such as adding a new product, delete a product or update an existing product in the brand
 * @author Tejal
 */
@RequestScoped
@Named
public class ManageBrand {

    @EJB
    private DesignerBean designerBean;
    @EJB
    private ProductBean productBean;
    @EJB
    private BrandBean brandBean;
    private Designer designer = new Designer();
    private Product product = new Product();
    private Brand brand = new Brand();
    private FacesContext context;
    private HtmlDataTable datatableProducts = new HtmlDataTable();
    private Product selectedProduct = new Product();
    private Product prod = new Product();
    private static final Logger LOG = Logger.getLogger(ManageBrand.class.getName());
    private Product addProduct = new Product();
    private HtmlInputHidden dataItemId = new HtmlInputHidden();
    private HtmlInputHidden delDataItemId = new HtmlInputHidden();

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    
    
    /**
     * Get the value of delDataItemId
     *
     * @return the value of delDataItemId
     */
    public HtmlInputHidden getDelDataItemId() {
        return delDataItemId;
    }

    /**
     * Set the value of delDataItemId
     *
     * @param delDataItemId new value of delDataItemId
     */
    public void setDelDataItemId(HtmlInputHidden delDataItemId) {
        this.delDataItemId = delDataItemId;
    }

    /**
     * Get the value of addProduct
     *
     * @return the value of addProduct
     */
    public Product getAddProduct() {
        return addProduct;
    }

    /**
     * Set the value of addProduct
     *
     * @param addProduct new value of addProduct
     */
    public void setAddProduct(Product addProduct) {
        this.addProduct = addProduct;
    }

    /**
     * Get the value of selectedProduct
     *
     * @return the value of selectedProduct
     */
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    /**
     * Set the value of selectedProduct
     *
     * @param selectedProduct new value of selectedProduct
     */
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    /**
     * Get the value of datatableProducts
     *
     * @return the value of datatableProducts
     */
    public HtmlDataTable getDatatableProducts() {
        return datatableProducts;
    }

    /**
     * Set the value of datatableProducts
     *
     * @param datatableProducts new value of datatableProducts
     */
    public void setDatatableProducts(HtmlDataTable datatableProducts) {
        this.datatableProducts = datatableProducts;
    }

    @PostConstruct
    private void init() {
        designer = designerBean.findByUserName(context.getExternalContext().getRemoteUser());
        brand = designer.getBrand();
        product.setBrand(brand);
        addProduct.setBrand(brand);
    }

    public ManageBrand() {
        context = FacesContext.getCurrentInstance();

    }

    public HtmlInputHidden getDataItemId() {
        return dataItemId;
    }

    public void setDataItemId(HtmlInputHidden dataItemId) {
        this.dataItemId = dataItemId;
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

    public String editProduct() {

        int index = datatableProducts.getRowIndex(); // Actually not interesting info.
        selectedProduct = (Product) datatableProducts.getRowData();
        dataItemId.setValue(selectedProduct.getId());
        
        return "/secure/updateProducts.html";
    }

    public String addProduct() {

        brandBean.addNewProduct(brand, addProduct);
        List<Product> prodList=new ArrayList();
        prodList=brand.getProducts();
        for(Product prod1:prodList)
        {
         if(prod1.getName()==null)
         {
                productBean.delete(prod1);
         }
        }
        

        return "/secure/brand.html";
    }

    public String deleteProduct() {
        int index = 0;
        index = datatableProducts.getRowIndex();
        
        prod = (Product) datatableProducts.getRowData();
        delDataItemId.setValue(prod.getId());
        
      //  LOG.info("Deleting product " + prod.getName() + " with ID " + prod.getId());
        brandBean.removeProduct(brand, prod);
      //  context.addMessage(null, new FacesMessage("Prod has been deleted"));
        return "/secure/brand.html";
    }

    public String saveChanges() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        product.setId(Long.valueOf(dataItemId.getValue().toString()));

        product.setName(request.getParameter("update:name"));
        product.setDescription(request.getParameter("update:desc"));
        product.setPrice(Float.parseFloat(request.getParameter("update:price")));

        product.setBrand(this.brand);

        System.out.println("**************************" + product.getName());

        try {

            productBean.update(this.product);
            context.addMessage(null, new FacesMessage("Product has been updated"));

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Changes Saved", "No Changes Saved"));
            LOG.log(Level.SEVERE, null, e);
        }
        return "/secure/brand.jsf";
    }
}
