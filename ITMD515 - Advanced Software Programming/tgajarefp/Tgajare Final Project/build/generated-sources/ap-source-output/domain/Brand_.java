package domain;

import domain.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-09T04:27:12")
@StaticMetamodel(Brand.class)
public class Brand_ extends UtilityEntity_ {

    public static volatile SingularAttribute<Brand, String> name;
    public static volatile ListAttribute<Brand, Product> products;

}