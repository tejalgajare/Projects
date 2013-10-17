
package model;

import java.io.Serializable;

/**
 * This model is created for storing the CountryLanguage Table properties.It includes a constructor(no arg and
 * full arg), setter/getters for all properties and a tostring method
 * @author Tejal Gajare
 */
public class countryLanguageRecord implements Serializable  {

    public countryLanguageRecord() {
    }

    public countryLanguageRecord(String countryCode, String language, String isOfficial, float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
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
    private String language;

    /**
     * Get the value of language
     *
     * @return the value of language
     */
    public String getlanguage() {
        return language;
    }

    /**
     * Set the value of language
     *
     * @param language new value of language
     */
    public void setlanguage(String language) {
        this.language = language;
    }
    private String isOfficial;

    /**
     * Get the value of isOfficial
     *
     * @return the value of isOfficial
     */
    public String getisOfficial() {
        return isOfficial;
    }

    /**
     * Set the value of isOfficial
     *
     * @param isOfficial new value of isOfficial
     */
    public void setisOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }
    private float percentage;

    /**
     * Get the value of percentage
     *
     * @return the value of percentage
     */
    public float getpercentage() {
        return percentage;
    }

    /**
     * Set the value of percentage
     *
     * @param percentage new value of percentage
     */
    public void setpercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "countryLanguageRecord{" + "countryCode=" + countryCode + ", language=" + language + ", isOfficial=" + isOfficial + ", percentage=" + percentage + '}';
    }
    
}
