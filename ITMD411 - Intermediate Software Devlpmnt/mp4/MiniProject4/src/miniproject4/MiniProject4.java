package miniproject4;

import Utilities.UtilityFunctions;
import java.util.Scanner;

/**
 * This is the main driver class which invokes the methods : displayMenu and getUserSelection from the {@link UtilityFunctions} class.
 * These functions are responsible to display the menu infinitely till the user quits the program.
 * @author Tejal
 */
public class MiniProject4 {

    public static void main(String[] args) {
        while (true) {
            UtilityFunctions.displayMenu();
            UtilityFunctions.getUserSelection(new Scanner(System.in));
        }
    }
}
