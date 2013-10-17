/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * This class is the embeddable class which is used in the rest of the classes for representing the
 * Address as whole.This class contains attributes to further classify the address as line numbers,
 * city, state, zip and country
 * @author Tejal
 */
@Embeddable
public class Address implements Serializable {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address(String line1, String line2, String city, String state, String zip, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public Address() {
    }

    /**
     * Get the value of line2
     *
     * @return the value of line2
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Set the value of line2
     *
     * @param line2 new value of line2
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * Get the value of city
     *
     * @return the value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the value of city
     *
     * @param city new value of city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the value of zip
     *
     * @return the value of zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set the value of zip
     *
     * @param zip new value of zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Get the value of country
     *
     * @return the value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the value of line1
     *
     * @return the value of line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Set the value of line1
     *
     * @param line1 new value of line1
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }
}
