package domain;

import domain.Customer;
import domain.Designer;
import domain.PurchaseOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-04T23:42:11")
@StaticMetamodel(Product.class)
public class Product_ extends UtilityEntity_ {

    public static volatile SingularAttribute<Product, Float> price;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Designer> designer;
    public static volatile ListAttribute<Product, PurchaseOrder> orders;
    public static volatile SingularAttribute<Product, Customer> customer;

}