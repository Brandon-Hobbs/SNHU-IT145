//Brandon Hobbs
//IT145
//8-5-2021

import java.util.Scanner;
import java.util.InputMismatchException;

public class Paint1 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double gallonsPaintNeeded = 0.0;
        boolean inputValid; //loop logic control
        
        final double squareFeetPerGallons = 350.0;
        
        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's height
        do {
        	
        	inputValid = true;//init the flag to exit by default
        	
        	try {
        		System.out.println("Enter wall height (feet): ");
        		wallHeight = scnr.nextDouble();
        		
        		//check for bad input but formatted correctly
        		if (wallHeight <= 0) {
        			throw new Exception("Invalid height entered.");        			
        		}
        	}
        	//catch non-double entries
        	catch (InputMismatchException e) {
        		inputValid = false;//flip the bool to go around again
        		System.out.println("Please check your enetries. Values need to be numeric.");
        		scnr.nextLine();//clear the scanner
        	}
        	//catch the bad but well formatted data
        	catch(Exception excpt) {
        		inputValid = false;//flip the bool to go around again
        		System.out.println(excpt.getMessage());
        		System.out.println("Please check your enetries. Values need to be greater than 0.0");
        		scnr.nextLine();//clear the scanner
        	}        	
        	
        } while (!inputValid);
		
		
        // Implement a do-while loop to ensure input is valid
        // Prompt user to input wall's width
        do {
        	
        	inputValid = true;//init the flag to exit by default
        	
        	try {
       		
                System.out.println("Enter wall width (feet): ");
                wallWidth = scnr.nextDouble();
                
                //check for bad but well formatted data
        		if (wallWidth <= 0) {
        			throw new Exception("Invalid width enetered.");       			
        		}    
        	}
        	//catch non-double entries
        	catch (InputMismatchException e) {
        		inputValid = false;//flip the bool to go around again
        		System.out.println("Please check your enetries. Values need to be numeric.");
        		scnr.nextLine();//clear the scanner
        	}
        	//catch the bad but well formatted data
        	catch(Exception excpt) {
        		inputValid = false;//flip the bool to go around again
        		System.out.println(excpt.getMessage());
        		System.out.println("Please check your enetries. Values need to be greater than 0.0");
        		scnr.nextLine();//clear the scanner
        	}        	
        	
        } while (!inputValid);

        // Calculate and output wall area
        wallArea = wallHeight * wallWidth;
        System.out.println("Wall area: "  + wallArea + " square feet");

        // Calculate and output the amount of paint (in gallons) needed to paint the wall
        gallonsPaintNeeded = wallArea/squareFeetPerGallons;
        System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");

    }
}
