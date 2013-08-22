package miniproject1;

import domain.MilkyWayPlanet;
import domain.Planet;

/**
 * This class represents the Driver class containing the main method. Import the
 * classes - {@link MilkyWayPlanet} and {@link Planet} from package domain.
 *
 * @author Tejal Gajare
 */
public class MiniProject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Created 9 objects of MilkyWayPlanet class(instances representing each
         * of the 9 planets of our galaxy). Parameters passed in the order of:
         * Name,Mass,Diameter,Revolution Period and Mean Surface Temperature.
         */
        MilkyWayPlanet mwp1 = new MilkyWayPlanet("Mercury", 3.3 * Math.pow(10, 23), 4.87 * Math.pow(10, 6), 7603200, 800);
        MilkyWayPlanet mwp2 = new MilkyWayPlanet("Venus", 4.86 * 1024, 1.21 * Math.pow(10, 7), 19440000, 780);
        MilkyWayPlanet mwp3 = new MilkyWayPlanet("Earth", 5.97 * 1024, 1.275 * Math.pow(10, 7), 31536000, 59);
        MilkyWayPlanet mwp4 = new MilkyWayPlanet("Mars", 064 * Math.pow(10, 24), 6.79 * Math.pow(10, 6), 59356800, -81);
        MilkyWayPlanet mwp5 = new MilkyWayPlanet("Jupiter", 1.89 * Math.pow(10, 27), 1.42 * Math.pow(10, 8), 1024704, 680);
        MilkyWayPlanet mwp6 = new MilkyWayPlanet("Saturn", 5.68 * Math.pow(10, 26), 1.2 * Math.pow(10, 8), 29.46 * 31536000, 332.3);
        MilkyWayPlanet mwp7 = new MilkyWayPlanet("Uranus", 8.68 * Math.pow(10, 25), 5.11 * Math.pow(10, 7), 84.01 * 31536000, -67);
        MilkyWayPlanet mwp8 = new MilkyWayPlanet("Neptune", 1.024 * Math.pow(10, 26), 4.95 * Math.pow(10, 7), 5.17 * 2.718, -373);
        MilkyWayPlanet mwp9 = new MilkyWayPlanet("Pluto", 1.3 * Math.pow(10, 22), 2.36 * Math.pow(10, 6), 7.82 * Math.pow(10, 9), -380);
        /*
         * Upcast to Planet abstract class-collects all MilkyWayPlanet objects into an array of Planet called solarSystem.
         * Polymorphism uses toString overrides at subclass level even though upcasted to Planet level,which is the superclass.
         */

        Planet[] solarSystem = {mwp1, mwp2, mwp3, mwp4, mwp5, mwp6, mwp7, mwp8, mwp9};
        for (Planet planet : solarSystem) {
            System.out.println(planet);
        }
        /*
         * Following depicts the inheritance property: The implemented methods of Relatable Interface in the abstract Planet 
         * class are being called by the objects of MilkyWayPlanet subclass. 
         */
        if (mwp5.isDiameterGreater(mwp1)) {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nJupiter's Diameter is greater than Mercury's Diameter!");
        } else {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nMercury's Diameter is greater than Jupiter's Diameter!");
        }
        if (mwp5.isMassSmaller(mwp3)) {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nJupiter's Mass is smaller than Earth's Mass!");
        } else {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nEarth's Mass is smaller than Jupiter's Mass!");
        }
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("Additional Test Cases: \n");
        //1.//Planet[] solarSystem = new Planet(); //Cannot instantiate an abstract class - Negative Test Case

        //2.//Positive Test Case to show  call to no args constructor
        System.out.println("1.To show  call to no args constructor: \n");
        MilkyWayPlanet mwp10 = new MilkyWayPlanet();
        System.out.println(mwp10);

        //3.//Positive Test Case to show how to access the mutators of the Planet class
        System.out.println("\n2.To show how to access the mutators of the Planet class: \n");
        mwp5.setMass(3.0); //setting the mass of Jupiter to a lesser value         
        mwp3.setMass(4.0); //setting the mass of Earth to a greater value
        if (mwp5.isMassSmaller(mwp3)) {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nJupiter's Mass is smaller than Earth's Mass!");
        } else {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nEarth's Mass is smaller than Jupiter's Mass!");
        }
    }
}
