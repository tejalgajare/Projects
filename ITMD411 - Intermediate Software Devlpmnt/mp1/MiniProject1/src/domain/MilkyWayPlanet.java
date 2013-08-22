package domain;

/**
 * The MilkyWayPlanet (subclass/child class) extends the Planet
 * class(super/parent class). An implementation for the escapeVelocity()
 * abstract method from the parent class has been provided in this subclass.
 * Additional fields such as 'planetName' and 'gravitationalConstant' are
 * declared. This class can access the protected parent class fields (due to
 * property of inheritance)
 *
 * @author Tejal Gajare
 */
public class MilkyWayPlanet extends Planet {

    //Definitions of Fields
    private String planetName;
    private static double gravitationalConstant = 6.67 * (Math.pow(10, -11));

    //Definitions of Constructors
    //No args constructor
    public MilkyWayPlanet() {
        this.planetName = "Not Assigned";
    }

    //Semi-Full args constructor - using its private field
    public MilkyWayPlanet(String planetName) {
        this.planetName = planetName;
    }

    //Full args constructor- gives a call to super class' constructor and then initiates its own private field.
    public MilkyWayPlanet(String planetName, double mass, double diameter, double revolutionPeriod, double meanSurfaceTemperature) {
        super(mass, diameter, revolutionPeriod, meanSurfaceTemperature);
        this.planetName = planetName;
    }

    //Implementation for the abstract method inherited from the parent class
    @Override
    double escapeVelocity() {

        double e = 0.0;
        if (this.mass == 0.0 || this.diameter == 0.0) {
            return e;
        }
        e = Math.sqrt(2 * gravitationalConstant * this.mass / (this.diameter / 2)); //Using the formula
        return e;
    }

    //Definitions of Helper Methods - returns a description about the object in the form of a string.
    //Appends the call to the toString() of the super class in order to access its protected members
    //Appends the calculated escapeVelocity() result
    @Override
    public String toString() {
        System.out.println("------------------------------------------------------------------------");
        return "MilkyWayPlanet: " + "Name= " + planetName
                + super.toString() + "\nEscape Velocity= " + this.escapeVelocity() + "m/s";
    }
}
