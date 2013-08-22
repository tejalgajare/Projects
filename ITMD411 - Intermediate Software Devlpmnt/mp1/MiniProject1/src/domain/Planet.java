package domain;

/**
 * This is an abstract Planet class.
 * This class has protected fields-mass,diameter,revolutionPeriod and meanSurfaceTemperature.
 * This class implements the {@link Relatable} Interface.It also provides an implementation for the 
 * isDiameterGreater and isMassSmaller methods,declared in that interface.
 * In order to calculate the escape velocity field, an abstract escapeVelocity method is declared in this class.
 * @see MilkyWayPlanet for implementation of escapeVelocity
 * @author Tejal Gajare
 */
public abstract class Planet implements Relatable {

    //Definitions of Fields
    protected double mass;
    protected double diameter;
    protected double revolutionPeriod;
    protected double meanSurfaceTemperature;

    //Definitions of Methods
    abstract double escapeVelocity();

    //Definitions of Constructors
    //No args constructor
    public Planet() {

        this.mass = 0.0;
        this.diameter = 0.0;
        this.revolutionPeriod = 0.0;
        this.meanSurfaceTemperature = 0.0;
    }

    //full args constructor
    public Planet(double mass, double diameter, double revolutionPeriod, double meanSurfaceTemperature) {
        this.mass = mass;
        this.diameter = diameter;
        this.revolutionPeriod = revolutionPeriod;
        this.meanSurfaceTemperature = meanSurfaceTemperature;
    }

    //Accessors(getters) and Mutators(setters) for the fields-mass,diameter,revolutionPeriod and meanSurfaceTemperature
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRevolution_period() {
        return revolutionPeriod;
    }

    public void setRevolution_period(double revolutionPeriod) {
        this.revolutionPeriod = revolutionPeriod;
    }

    public double getMean_surface_temperature() {
        return meanSurfaceTemperature;
    }

    public void setMean_surface_temperature(double meanSurfaceTemperature) {
        this.meanSurfaceTemperature = meanSurfaceTemperature;
    }

    //Definitions of Helper Methods
    @Override
    public String toString() {
        return "\nFacts: " + "\nMass= " + mass + "kg,\nDiameter= " + diameter + "m,\nRevolution Period= " + revolutionPeriod + "sec,\nMean Surface Temperature= " + meanSurfaceTemperature + "F";

    }

    //Definitions of the implemented methods 
    @Override
    public boolean isMassSmaller(Object other) {
        boolean result = false;
        Planet otherPlanet = (Planet) other;
        if (this.getMass() > otherPlanet.getMass()) {
            result = false;
        } else if (this.getMass() < otherPlanet.getMass()) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean isDiameterGreater(Object other) {
        boolean result = false;
        Planet otherPlanet = (Planet) other;
        if (this.getDiameter() > otherPlanet.getDiameter()) {
            result = true;
        } else if (this.getDiameter() < otherPlanet.getDiameter()) {
            result = false;
        }
        return result;
    }
}
