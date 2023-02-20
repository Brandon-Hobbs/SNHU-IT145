//Brandon Hobbs
//Aug 5, 2021
//IT 145


import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;


public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static Scanner scnr = new Scanner(System.in);
    // Instance variables (if needed)
   
    
    public static void main(String[] args) {
    	String menuChoice = " "; //used to store the menu selections
    	
        initializeDogList(); //enable test data
        initializeMonkeyList(); //enable test data

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        // For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
        // Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        
        //prompt the user for input
        //show the menu and get the input       
        while (!menuChoice.equals("q")) {
        	
        	displayMenu();
        	menuChoice = scnr.nextLine();
        	
        	switch (menuChoice) {
        	
        	case "1": //intake new dog
        		intakeNewDog(scnr);
        		break;
        	case "2"://intake new  new monkey
        		intakeNewMonkey(scnr);
        		break;
        	case "3": //reserve an animal
        		reserveAnimal(scnr);
        		break;
        	case "4": //print the list of dogs
        		printAnimals("dog", scnr);
        		break;
        	case "5": //print the list of monkeys
        		printAnimals("monkey", scnr);
        		break;
        	case "6": //print all animals not reserved
        		printAnimals("available", scnr);
        		break;
        	case "q": //quit
        		System.out.println("q");
        		break; //do nothing with this
        	default: //error
        		System.out.println("Please check your input");
        	
        }
      }

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in-service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	
    	Monkey monk1 = new Monkey("12", "13", "14", "marmoset", "Bobo", "female", "1", "22", "2/5/22", "France", "Phase V", false, "none");
    	Monkey monk2 = new Monkey("13", "14", "15", "squirrel monkey", "Frank", "male", "5", "23", "3/5/22", "Canada", "in-service", false, "Canada");
    	Monkey monk3 = new Monkey("14", "15", "16", "marmoset", "Fifi", "female", "9", "24", "4/5/22", "USA", "Phase III", false, "none");
    	Monkey monk4 = new Monkey("15", "16", "17", "tamarin", "Dudette", "female", "2", "25", "5/5/22", "canada", "in-service", false, "canada");

    	monkeyList.add(monk1);
    	monkeyList.add(monk2);
    	monkeyList.add(monk3);
    	monkeyList.add(monk4);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scnr) {
    	String name;
    	String breed;
    	String gender;
    	String age;
    	String weight;
    	String acqDate;
    	String acqCountry;
    	String trainingStatus;
    	String reserved; //user input
    	boolean reservedBool; //pass to the object
    	String inServiceCountry;
    	
    	
        System.out.println("What is the dog's name?");
        name = scnr.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog is already in our system\n");
                System.out.println("Press enter to return to the Main Menu"); //hold the screen so the user can see the message
                scnr.nextLine();
                return; //returns to menu
            }
        }
        // Now need to add all of the prompts to gather the information for the new Dog
        System.out.println("What is the dog's breed?");
        breed = scnr.nextLine().toLowerCase();
        
        System.out.println("What is the dog's gender?");
        gender = scnr.nextLine().toLowerCase();
        
        //Validate the input
        while ((!gender.equals("male")) && (!gender.equals("female"))) {
            System.out.println("Please type male or female");
            gender = scnr.nextLine().toLowerCase();
        }
        
        //get the dogs age
        System.out.println("What is the dog's age?");
        age = scnr.nextLine();
        
        //get the dogs weight
        System.out.println("What is the dog's weight?");
        weight = scnr.nextLine();
        
        //get the dogs acquisition date
        System.out.println("What is the dog's acquisition date?");
        acqDate = scnr.nextLine();
        
        //get the acquisition country
        System.out.println("What is the dog's acquisition Country?");
        acqCountry = scnr.nextLine();
        
        //get the training status        
        System.out.println("What is the dog's training status?");
        trainingStatus = scnr.nextLine();
        
        //validate the input
        //if validateTrainingStatus returns false (meaning it doesn't exist in the Hash)
        //throw a warning and request better input
        while (!validateTrainingStatus(trainingStatus)) {
        	System.out.println("Please enter one of the following: Phase I, II, II, IV, V, intake, farm, or in-service");
        	trainingStatus = scnr.nextLine();
        }
        
        //only need to gather in service country and reserved status if training status is "in-service"
        
        // if in service branch
        if (trainingStatus.equals("in-service")) {
            System.out.println("What is the dog's service Country?");
            inServiceCountry = scnr.nextLine();
                  
            //get the reserved status
            //validate the input for boolean
            System.out.println("What is the dog's reserved status?");
            reserved = scnr.nextLine().toLowerCase();
            
            //Validate the input
            while ((!reserved.equals("false")) && (!reserved.equals("true"))) {
                System.out.println("Please type true or false");
                reserved = scnr.nextLine().toLowerCase();
            }    
        	
        }
        else {//this is the not in service branch
        	inServiceCountry = "none";
        	reserved = "false";
        }
        
        //need to set the reservedBool status based on the string value
        reservedBool = reserved.equals("true") ? true : false;
        	
        //now we need to add the dog
        Dog dogTmp = new Dog(name, breed, gender, age, weight, acqDate, acqCountry, trainingStatus, reservedBool, inServiceCountry);
        dogList.add(dogTmp);

    }


        // Complete intakeNewMonkey
		//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
		// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scnr) {
        	String name;
        	String gender;
        	String age;
        	String weight;
        	String acqDate;
        	String acqCountry;
        	String trainingStatus;
        	String reserved; //user input
        	boolean reservedBool; //pass to the object
        	String inServiceCountry;
        	String tailLength;
        	String monkeyHeight;
        	String bodyLength;
        	String monkeySpecies;
        	
        	
            System.out.println("What is the monkeys's name?");
            name = scnr.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\nThis monkey is already in our system\n");
                    System.out.println("Press enter to return to the Main Menu"); //hold the screen so the user can see the message
                    scnr.nextLine();
                    return; //returns to menu
                }
            }
            // Now need to add all of the prompts to gather the information for the new Monkey
            //Get the species
            //Validate using the validateMonkeySpecies function
            System.out.println("What is the monkey's species?");
            monkeySpecies = scnr.nextLine().toLowerCase();
            
            //warn the user to correct the input and wait for correct entry
            while (!validateMonkeySpecies(monkeySpecies)) {
            	System.out.println("Please enter one of the following: capuchin, guenon, macaque, marmoset, squirrel monkey, tamarin");
            	monkeySpecies = scnr.nextLine();
            }

            System.out.println("What is the monkey's gender?");
            gender = scnr.nextLine().toLowerCase();
            
            //Validate the input
            while ((!gender.equals("male")) && (!gender.equals("female"))) {
                System.out.println("Please type male or female");
                gender = scnr.nextLine().toLowerCase();
            }
            
            //get the monkey's age
            System.out.println("What is the monkey's age (years)?");
            age = scnr.nextLine();
            
            //get the monkey's weight
            System.out.println("What is the monkey's weight (kgs)?");
            weight = scnr.nextLine();
            
            //get the monkey's tail length
            System.out.println("What is the monkey's tail length (cm)?");
            tailLength = scnr.nextLine();
            
            //get the monkey's height
            System.out.println("What is the monkey's height (cm)?");
            monkeyHeight = scnr.nextLine();
            
            //get the monkey's body length
            System.out.println("What is the monkey's body length (cm)?");
            bodyLength = scnr.nextLine();
            
            //get the monkeys acquisition date
            System.out.println("What is the monkey's acquisition date?");
            acqDate = scnr.nextLine();
            
            //get the acquisition country
            System.out.println("What is the monkey's acquisition Country?");
            acqCountry = scnr.nextLine();
            
            //get the training status        
            System.out.println("What is the monkey's training status?");
            trainingStatus = scnr.nextLine();
            
            //validate the input
            //if validateTrainingStatus returns false (meaning it doesn't exist in the Hash)
            //throw a warning and request better input
            while (!validateTrainingStatus(trainingStatus)) {
            	System.out.println("Please only enter on of the following: Phase I, II, II, IV, V, intake, farm, or in-service");
            	trainingStatus = scnr.nextLine();
            }
            
            //only need to gather in service country and reserved status if training status is "in-service"
            
            // if in service branch
            if (trainingStatus.equals("in-service")) {
                System.out.println("What is the monkey's service Country?");
                inServiceCountry = scnr.nextLine();
                      
                //get the reserved status
                //validate the input for boolean
                System.out.println("What is the monkey's reserved status?");
                reserved = scnr.nextLine().toLowerCase();
                
                //Validate the input
                while ((!reserved.equals("false")) && (!reserved.equals("true"))) {
                    System.out.println("Please type true or false");
                    reserved = scnr.nextLine().toLowerCase();
                }    
            	
            }
            else {//this is the not in service branch
            	inServiceCountry = "none";
            	reserved = "false";
            }
            
            //need to set the reservedBool status based on the string value
            reservedBool = reserved.equals("true") ? true : false;
            	
            //now we need to add the monkey to the list
            Monkey monkeyTmp = new Monkey(tailLength, monkeyHeight, bodyLength, monkeySpecies, name, gender, 
            		age, weight, acqDate, acqCountry, trainingStatus, reservedBool, inServiceCountry);
            
            monkeyList.add(monkeyTmp);

        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scnr) {
        	
        	String countryName;
        	String species;
        	boolean animalFound = false;//this is used to check if the animal is in the system, LOGIC variable
        	
        	//Using the assumption that a monkey and dog could have the same name
        	//ask for species
        	//ask for name
        	//if that name exists get the reserved status and print
        	//ask if the user wants to update
        	//get new status and set
            System.out.println("What species are you wanting to reserve?");
            species = scnr.nextLine();
            
            //validate the input
            while ((!species.equals("monkey")) && (!species.equals("dog"))) {
                System.out.println("Please enter monkey or dog.");
                species = scnr.nextLine();            	
            }
            
            //get the name
            System.out.println("In what country do you want to reserve the " + species + "?");
            countryName = scnr.nextLine();
            
            //check if that name exists
            switch (species) {
            	case "monkey":
            		//scan monkeyList
            		//check is an animal is available in the user specified country
            		//if there is a match of available and inServiceCountry then change the status+
            		//set aniumalFound to true
                	for(Monkey m : monkeyList) {
                		if (!m.getReserved() && m.getInServiceLocation().equalsIgnoreCase(countryName)) {
                			
                			//throw the logic flag
                			animalFound = true;
                			
                			//print the name of the monkey that is available and being reserved
                			System.out.println(m.getName() + " is available and will be reserved.");
                			
                			//set the new reserved status
                			m.setReserved(true); 
                			
                			//now break so we only reserve one
                			break;
                		}         		
                	}
                	//throw an error saying no animals are found
                	if (!animalFound) {
                		System.out.println("No " + species + " were available in " + countryName + ".");
                		
                	}
                	
                	break; //break for the switch
                	
            	case "dog":
            		//scan dogList
            		//check is an animal is available in the user specified country
            		//if there is a match of available and inServiceCountry then change the status
            		//set aniumalFound to true
                	for(Dog d : dogList) {
                		if (!d.getReserved() && d.getInServiceLocation().equalsIgnoreCase(countryName)) {
                			
                			//throw the logic flag
                			animalFound = true;
                			
                			//print the name of the monkey that is available and being reserved
                			System.out.println(d.getName() + " is available and will be reserved.");
                			
                			//set the new reserved status
                			d.setReserved(true); 
                			
                			//now break so we only reserve one
                			break;
                		}         		
                	}
                	//throw an error saying no animals are found
                	if (!animalFound) {
                		System.out.println("No " + species + " were available in " + countryName + ".");                		
                	}
                	
                	break;//break for the switch
            		
            }//switch
            System.out.println("\nPress enter to return to the main menu.");
            scnr.nextLine();
            		
        }


        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
        // Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
        // Remember that you only have to fully implement ONE of these lists. 
        // The other lists can have a print statement saying "This option needs to be implemented".
        // To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String printType, Scanner scnr) {
            
        	switch (printType) {
            
            case "dog": //just print the dogs
            	for(Dog d : dogList) {
            		System.out.println(d);
            	}
                System.out.println("\nPress enter to return to the Main Menu"); //hold the screen so the user can see the message
                scnr.nextLine();
            	break;
            	
            case "monkey": //just print the monkeys
            	for(Monkey m : monkeyList) {
            		System.out.println(m);
            	}
                System.out.println("\nPress enter to return to the Main Menu"); //hold the screen so the user can see the message
                scnr.nextLine();
            	break;
            	
            case "available": //print BOTH the monkeys and the dogs that are "in-service" AND "reserved" == false
            	//do the dogs first
            	//loop the list; match the 2 string criterion
            	//if the string match the criterion print
            	for(Dog d : dogList) {
            		if (d.getTrainingStatus().equals("in-service") && !d.getReserved()) {
            			System.out.println(d);
            		
            		}            		
            	}
            	//do the monkeys; same as the dogs
            	for(Monkey m : monkeyList) {
            		if (m.getTrainingStatus().equals("in-service") && !m.getReserved()) {
            			System.out.println(m);
            		
            		}            		
            	}
                System.out.println("\nPress enter to return to the Main Menu"); //hold the screen so the user can see the message
                scnr.nextLine();
                break;
            default:
            	break;
            }

        }
        
        //function to validate the training status input
        //string from he intake function as input
        //return a bool if the hash value exists
        public static boolean validateTrainingStatus(String trainingStatus) {
        	
        	//create the hashmap of all the training status so we can validate
        	HashMap<Integer, String> trainingHash = new HashMap<Integer, String>();
        	
        	trainingHash.put(1, "Phase I");
        	trainingHash.put(2, "Phase II");
        	trainingHash.put(3, "Phase III");
        	trainingHash.put(4, "Phase IV");
        	trainingHash.put(5, "Phase V");
        	trainingHash.put(6, "in-service");
        	trainingHash.put(7, "farm");
        	trainingHash.put(8, "intake");
        	
        	boolean flag = trainingHash.containsValue(trainingStatus);
        	
        	return flag;
        	
        }
        
        //validate the acceptable monkey species
        //species name from the intake function as the input
        //return a bool if the hash value exists
        public static boolean validateMonkeySpecies(String monkeySpecies) {
        	
        	//create the hashmap of all the training status so we can validate
        	HashMap<Integer, String> speciesHash = new HashMap<Integer, String>();
        	
        	speciesHash.put(1, "capuchin");
        	speciesHash.put(2, "guenon");
        	speciesHash.put(3, "macaque");
        	speciesHash.put(4, "marmoset");
        	speciesHash.put(5, "squirrel monkey");
        	speciesHash.put(6, "tamarin");
        	
        	boolean flag = speciesHash.containsValue(monkeySpecies);
        	
        	return flag;
        	
        }
}

