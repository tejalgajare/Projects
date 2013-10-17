package domain;

import domain.Address;
import domain.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-12T02:35:00")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

    public static volatile SingularAttribute<PurchaseOrder, Long> id;
    public static volatile SingularAttribute<PurchaseOrder, Date> orderDate;
    public static volatile SingularAttribute<PurchaseOrder, Integer> quantity;
    public static volatile SingularAttribute<PurchaseOrder, Date> orderTime;
    public static volatile SingularAttribute<PurchaseOrder, Address> shippingAddress;
    public static volatile ListAttribute<PurchaseOrder, Product> products;

}