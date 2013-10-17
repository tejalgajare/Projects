package domain;

import domain.Brand;
import domain.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-12T02:35:00")
@StaticMetamodel(Designer.class)
public class Designer_ { 

    public static volatile SingularAttribute<Designer, Long> id;
    public static volatile SingularAttribute<Designer, String> lastName;
    public static volatile SingularAttribute<Designer, Brand> brand;
    public static volatile SingularAttribute<Designer, String> firstName;
    public static volatile ListAttribute<Designer, Product> products;

}