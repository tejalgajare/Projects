
package model;

import java.io.Serializable;

/**
 * This model is created for storing the Country Table properties.It includes a constructor(no arg and
 * full arg), setter/getters for all properties and a tostring() method
 * @author Tejal Gajare
 */
public class countryRecord implements Serializable {

    public countryRecord() {
    }
        private String code;

    public countryRecord(String code, String name, String continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float vGNP, float vGNPOld, String localName, String governmentForm, String headOfState, int capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.vGNP = vGNP;
        this.vGNPOld = vGNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public String getcode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setcode(String code) {
        this.code = code;
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
    private String continent;

    /**
     * Get the value of continent
     *
     * @return the value of continent
     */
    public String getcontinent() {
        return continent;
    }

    /**
     * Set the value of continent
     *
     * @param continent new value of continent
     */
    public void setcontinent(String continent) {
        this.continent = continent;
    }
    private String region;

    /**
     * Get the value of region
     *
     * @return the value of region
     */
    public String getregion() {
        return region;
    }

    /**
     * Set the value of region
     *
     * @param region new value of region
     */
    public void setregion(String region) {
        this.region = region;
    }
    private float surfaceArea;

    /**
     * Get the value of surfaceArea
     *
     * @return the value of surfaceArea
     */
    public float getsurfaceArea() {
        return surfaceArea;
    }

    /**
     * Set the value of surfaceArea
     *
     * @param surfaceArea new value of surfaceArea
     */
    public void setsurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
    private int indepYear;

    /**
     * Get the value of indepYear
     *
     * @return the value of indepYear
     */
    public int getindepYear() {
        return indepYear;
    }

    /**
     * Set the value of indepYear
     *
     * @param indepYear new value of indepYear
     */
    public void setindepYear(int indepYear) {
        this.indepYear = indepYear;
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
    private float lifeExpectancy;

    /**
     * Get the value of lifeExpectancy
     *
     * @return the value of lifeExpectancy
     */
    public float getlifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Set the value of lifeExpectancy
     *
     * @param lifeExpectancy new value of lifeExpectancy
     */
    public void setlifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
    private float vGNP;

    /**
     * Get the value of vGNP
     *
     * @return the value of vGNP
     */
    public float getvGNP() {
        return vGNP;
    }

    /**
     * Set the value of vGNP
     *
     * @param vGNP new value of vGNP
     */
    public void setvGNP(float vGNP) {
        this.vGNP = vGNP;
    }
    private float vGNPOld;

    /**
     * Get the value of vGNPOld
     *
     * @return the value of vGNPOld
     */
    public float getvGNPOld() {
        return vGNPOld;
    }

    /**
     * Set the value of vGNPOld
     *
     * @param vGNPOld new value of vGNPOld
     */
    public void setvGNPOld(float vGNPOld) {
        this.vGNPOld = vGNPOld;
    }
    private String localName;

    /**
     * Get the value of localName
     *
     * @return the value of localName
     */
    public String getlocalName() {
        return localName;
    }

    /**
     * Set the value of localName
     *
     * @param localName new value of localName
     */
    public void setlocalName(String localName) {
        this.localName = localName;
    }
    private String governmentForm;

    /**
     * Get the value of governmentForm
     *
     * @return the value of governmentForm
     */
    public String getgovernmentForm() {
        return governmentForm;
    }

    /**
     * Set the value of governmentForm
     *
     * @param governmentForm new value of governmentForm
     */
    public void setgovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }
    private String headOfState;

    /**
     * Get the value of headOfState
     *
     * @return the value of headOfState
     */
    public String getheadOfState() {
        return headOfState;
    }

    /**
     * Set the value of headOfState
     *
     * @param headOfState new value of headOfState
     */
    public void setheadOfState(String headOfState) {
        this.headOfState = headOfState;
    }
    private int capital;

    /**
     * Get the value of capital
     *
     * @return the value of capital
     */
    public int getcapital() {
        return capital;
    }

    /**
     * Set the value of capital
     *
     * @param capital new value of capital
     */
    public void setcapital(int capital) {
        this.capital = capital;
    }
    private String code2;

    /**
     * Get the value of code2
     *
     * @return the value of code2
     */
    public String getcode2() {
        return code2;
    }

    /**
     * Set the value of code2
     *
     * @param code2 new value of code2
     */
    public void setcode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public String toString() {
        return "countryRecord{" + "code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region + ", surfaceArea=" + surfaceArea + ", indepYear=" + indepYear + ", population=" + population + ", lifeExpectancy=" + lifeExpectancy + ", vGNP=" + vGNP + ", vGNPOld=" + vGNPOld + ", localName=" + localName + ", governmentForm=" + governmentForm + ", headOfState=" + headOfState + ", capital=" + capital + ", code2=" + code2 + '}';
    }

}
