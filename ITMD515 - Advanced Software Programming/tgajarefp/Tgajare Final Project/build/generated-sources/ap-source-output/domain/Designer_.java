package domain;

import domain.Brand;
import domain.security.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-09T04:27:12")
@StaticMetamodel(Designer.class)
public class Designer_ extends UtilityEntity_ {

    public static volatile SingularAttribute<Designer, String> lastName;
    public static volatile SingularAttribute<Designer, String> email;
    public static volatile SingularAttribute<Designer, Brand> brand;
    public static volatile SingularAttribute<Designer, String> firstName;
    public static volatile SingularAttribute<Designer, User> user;

}