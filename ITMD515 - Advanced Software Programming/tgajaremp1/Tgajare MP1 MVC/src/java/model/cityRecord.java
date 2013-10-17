
package model;

import java.io.Serializable;

/**
 * This model is created for storing the City Table properties.It includes a constructor(no arg and
 * full arg), setter/getters for all properties and a tostring method
 * @author Tejal Gajare
 */
public class cityRecord implements Serializable {

    public cityRecord() {
    }

    public cityRecord(int vID, String name, String countryCode, String district, int population) {
        this.vID = vID;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }
    private int vID;

    /**
     * Get the value of vID
     *
     * @return the value of vID
     */
    public int getvID() {
        return vID;
    }

    /**
     * Set the value of vID
     *
     * @param vID new value of vID
     */
    public void setvID(int vID) {
        this.vID = vID;
    }
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getname() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setname(String name) {
        this.name = name;
    }
    private String countryCode;

    /**
     * Get the value of countryCode
     *
     * @return the value of countryCode
     */
    public String getcountryCode() {
        return countryCode;
    }

    /**
     * Set the value of countryCode
     *
     * @param countryCode new value of countryCode
     */
    public void setcountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    private String district;

    /**
     * Get the value of district
     *
     * @return the value of district
     */
    public String getdistrict() {
        return district;
    }

    /**
     * Set the value of district
     *
     * @param district new value of district
     */
    public void setdistrict(String district) {
        this.district = district;
    }
    private int population;

    /**
     * Get the value of population
     *
     * @return the value of population
     */
    public int getpopulation() {
        return population;
    }

    /**
     * Set the value of population
     *
     * @param population new value of population
     */
    public void setpopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "cityRecord{" + "vID=" + vID + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district + ", population=" + population + '}';
    }
}
