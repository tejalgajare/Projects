package domain;

import domain.Address;
import domain.Product;
import domain.PurchaseOrder;
import domain.security.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-04T23:42:11")
@StaticMetamodel(Customer.class)
public class Customer_ extends UtilityEntity_ {

    public static volatile SingularAttribute<Customer, Date> dateOfBirth;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, Long> phone;
    public static volatile SingularAttribute<Customer, Address> address;
    public static volatile ListAttribute<Customer, PurchaseOrder> orders;
    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile ListAttribute<Customer, Product> products;
    public static volatile SingularAttribute<Customer, User> user;

}