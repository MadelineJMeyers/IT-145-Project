/*This class uses the other classes to build lists using User input and display the information at the User's request.
 * This class also contains a menu loop to allow the User to perform the task they need to and allows the user to exit the program.
 * Author: Matthew Meyers
 * Date: October 17, 2021
 * */
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>(); // List of dogs in system.
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // List of monkeys in system.
    private static ArrayList<String> speciesList = new ArrayList<String>(); // List of allowed species.


    // Instance variables (if needed)

    public static void main(String[] args) {

    	Scanner scnr = new Scanner(System.in); // Scanner used in the menu loop.
        initializeDogList();				// Initializes dog list.
        initializeMonkeyList();				// Initializes monkey list.
        initializeSpeciesList();			// Initializes species list.
        String userInput = "";				// Variable initialized for the menu loop.

        // Loop to display the menu, program ends when the letter q is entered.
        // Added an output for if the input is not any of the
        while(!userInput.equals("q")) { // Loop runs unless userInput is the letter q.
        	displayMenu(); // displayMenu method displays the full menu and explains the options.
	        userInput = scnr.nextLine(); // Allows for user input to choose which option is needed.
	        if(userInput.equals("1")) {
	        	intakeNewDog(scnr);	// intakeNewDog method to add dogs to dog list.
	        }
	        else if(userInput.equals("2")) {
	        	intakeNewMonkey(scnr);	// intakeNewMonkey method used to add monkeys to monkey list.
	        }
	        else if(userInput.equals("3")) {
	        	reserveAnimal(scnr);	// reverveAnimal method to reserve an available animal.
	        }
	        else if(userInput.equals("4")) {
	        	printAnimals("dog");	// Prints a list of all dogs.
	        }
	        else if(userInput.equals("5")) {
	        	printAnimals("monkey"); // Prints a list of all monkeys.
	        }
	        else if(userInput.equals("6")) {
	        	printAnimals("available");		// Prints a list of all available animals.
	        }
          else if(userInput.equals("q")){
            return; // Returns and ends the program if q is the user input.
          }
          else{
            System.out.println("Invalid input."); // Error prompt to inform the user if an invalid input is entered.
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
    // This list is used to check if the dog being added has the same name as an existing dog and to test the printAnimals method.
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }




    // Adds monkeys to a list for testing
    //Optional for testing
    // This list is used to check if the name of the monkey is the same as any in the list as well as testing the printAnimals method.
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Chimp", "capuchin", "male", "2" , "14" , "2", "42", "26", "5-25-20", "Ethiopia",  "in service", true, "United States");
    	Monkey monkey2 = new Monkey("Bear", "marmoset", "female", "3" , "20" ,  "3", "26", "15", "6-23-21", "Brazil", "in service", false, "Canada");
    	Monkey monkey3 = new Monkey("Ralph", "guenon","male", "5", "35", "20", "10", "5", "10-31-2019", "United States", "Stage 1", false, "United Kingdom");
    	Monkey monkey4 = new Monkey("Jack", "macaque", "male", "4", "30", "20", "10","20", "12-24-2018", "United Kingdom", "in service", true, "United States");
    	Monkey monkey5 = new Monkey("Clyde", "squirrel monkey", "male", "10", "30", "20", "10", "20", "9-1-2011", "Brazil", "in service", false, "Canada");
    	Monkey monkey6 = new Monkey("Enid", "tamarin", "female", "5", "30", "20", "10", "10", "8-25-2017", "Canada", "in service", true, "Canada");
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    	monkeyList.add(monkey4);
    	monkeyList.add(monkey5);
    	monkeyList.add(monkey6);

    }
    // Initializes a list of species that are allowed per the specification document.
    private static void initializeSpeciesList() {
    	String monkey1 = new String("capuchin");
    	String monkey2 = new String("marmoset");
    	String monkey3 = new String("guenon");
    	String monkey4 = new String("macaque");
    	String monkey5 = new String("squirrel monkey");
    	String monkey6 = new String("tamarin");

    	speciesList.add(monkey1);
    	speciesList.add(monkey2);
    	speciesList.add(monkey3);
    	speciesList.add(monkey4);
    	speciesList.add(monkey5);
    	speciesList.add(monkey6);
	}


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you

    // Added the instantiation method used for the monkey intake, rewritten for dog intake.
    // Allows for new dogs to be added to the existing dog list.
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
            else {
            	System.out.println("What is the dog's breed?");
            	String breed = scanner.nextLine();
            	System.out.println("What gender is the dog?");
            	String gender = scanner.nextLine();
            	System.out.println("What is the dog's age?");
            	String age = scanner.nextLine();
            	System.out.println("What is the dog's weight?");
            	String weight = scanner.nextLine();
            	System.out.println("What date was the dog aquired?");
            	String acquisitionDate = scanner.nextLine();
            	System.out.println("What country was the dog acquired from?");
            	String acquisitionCountry = scanner.nextLine();
            	System.out.println("What is the dog's training status?");
            	String trainingStatus = scanner.nextLine();
            	System.out.println("Is the dog reserved?");
            	boolean reserved = scanner.nextBoolean();
            	scanner.nextLine();
            	System.out.println("What is the service country of the dog?");
            	String inServiceCountry = scanner.nextLine();

            	Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry); // Instantiates new dog for the list.

            	dogList.add(newDog); //Adds the new dog to the dog list.
              return;
            }
        }

    }


      	// This method is used to add new monkeys to the monkeyList
    	// The method checks two areas, if the monkey's name is the same and if the monkey's species exists in the species list.
        public static void intakeNewMonkey(Scanner scanner) {
        	System.out.println("What is the monkey's name?");
        	String name = scanner.nextLine();	// Variable to check the list for the name of a monkey and if possible add to new monkey information.
        	System.out.println("What is the monkey's species?");
			String species = scanner.nextLine();	// Variable to check the list for the species of monkey and if possible add to new monkey information.
        	for(Monkey monkey: monkeyList) {
        		if(monkey.getName().equalsIgnoreCase(name)) {	// If there is a monkey with the same name it will not be allowed to proceed any further.
        			System.out.println("\n\nThis monkey is already in our system\n\n");	// Error message if monkey already exists.
        			return; // Returns to menu.
        		}
        	}
        	for(String monkeySpecies: speciesList) {
        		if(monkeySpecies.equalsIgnoreCase(species)) { // Unless the species matches one of the existing species it will not be allowed to go further.

        			// Series of prompts for information to add to new monkey instance and add to list.
        			System.out.println("What is the monkey's gender?");
                	String gender = scanner.nextLine();
                	System.out.println("What is the monkey's age?");
                	String age = scanner.nextLine();
                	System.out.println("What is the monkey's weight?");
                	String weight = scanner.nextLine();
                	System.out.println("What is the monkey's height?");
                	String height = scanner.nextLine();
                	System.out.println("What is the monkey's tail length?");
                	String tailLength = scanner.nextLine();
                	System.out.println("What is the monkey's body length?");
                	String bodyLength = scanner.nextLine();
                	System.out.println("What is the date the monkey was acquired?");
                	String acquisitionDate = scanner.nextLine();
                	System.out.println("What country was the monkey acquired from?");
                	String acquisitionCountry = scanner.nextLine();
                	System.out.println("What is the monkey's training status?");
                	String trainingStatus = scanner.nextLine();
                	System.out.println("Is the monkey reserved?");
                	boolean reserved = scanner.nextBoolean();
                	scanner.nextLine();
                	System.out.println("What is the service country of the monkey?");
                	String inServiceCountry = scanner.nextLine();

                	Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, tailLength,
                			bodyLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry); // Instantiates new monkey.
                	monkeyList.add(newMonkey); // Adds new monkey to monkeyList.
        			return;

        		}
        		else {
        			System.out.println("Species is not an approved species."); // Error prompt to inform user that the species is not approved.
        			return;
        		}


        	}

        }







        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country

        // Added prompts asking for the animal type and in service country from the user.
        // Added an if else branching area that is chosen based on the animal type.
        // Added for loops to the if else to iterate over the lists and find an available animal to reserve.
        // Added an error message to both branches if no animals exist in their animal types.
        public static void reserveAnimal(Scanner scanner) {
          System.out.println("What type of animal would you like to reserve?");
        	String animalType = scanner.nextLine();
          System.out.println("What is the in service country of the animal you would like to reserve?");
        	String inServiceCountry = scanner.nextLine();
            if(animalType.equalsIgnoreCase("dog")) { // If the animal type from the user input is a dog reserve a dog that is in the input service country and not reserved.
              for(Dog dog: dogList){
                if(dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && dog.getReserved() == false){
                  System.out.println("Reserved " + dog.getName()); // Prompt to inform user that reservation was successful and shows the name of the dog reserved.
                  dog.setReserved(true); // Sets the dog's reserved status to true so it cannot be reserved by a different user.
                  return;
                }
                else { // If there are no dogs available in the service country then print this error message.
                  System.out.println("No animals of this type and in this country are available at this time.");
                  return;
                }
              }

            }
            else if(animalType.equalsIgnoreCase("monkey")) { // If the animal type from the user input is a monkey reserve a monkey that is in the input service country and not reserved.
            	for(Monkey monkey: monkeyList) {
            		if(monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && monkey.getReserved() == false) {

            			System.out.println("Reserved " + monkey.getName()); // Prompt to inform the user that the reservation was successful and shows the name of the monkey reserved.
            			monkey.setReserved(true); // Sets the monkey's reserved status to true so that it cannot be reserved by a different user,
            			return;

            		}
            		else { // If no monkey is available based on the search criteria then print this error message.
            			System.out.println("No animals of this type and in this country are available at this time.");
                  return;
            		}
            	}
            }

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

        // Added switch statement to handle different outputs.
        // Method takes the string input from the menu to choose which list to display.
        // String useage allows for immediate display from the chosen list.
        public static void printAnimals(String listType) {

        	switch(listType){
        	case "dog":
        		for(Dog dog: dogList) { // Prints the list of dogs with their name, training status, acquisition location and reserved status.

        			System.out.println(dog.getName() + " " + dog.getTrainingStatus() + " " + dog.getAcquisitionLocation() + " " + dog.getReserved());
        		}
        		return;

        	case "monkey":
        		for(Monkey monkey: monkeyList) { // Prints the list of monkeys with their name, training status, acquisition country and reserved status.
        			System.out.println(monkey.getName() + " " + monkey.getTrainingStatus() + " " + monkey.getAcquisitionLocation() + " " + monkey.getReserved());

        		}
        		return;

        	case "available":
        		for(Dog dog: dogList) { // Prints the dog part of the list for dogs that are in service and not reserved.
        			if(dog.getReserved() == false && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
        				System.out.println(dog.getName() + " " + dog.getTrainingStatus() + " " + dog.getAcquisitionLocation() + " " + dog.getReserved());
        			}
        		}

        		for(Monkey monkey: monkeyList) { // Prints the monkey part of the list for monkeys that are in service and not reserved.
        			if(monkey.getReserved() == false && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
        				System.out.println(monkey.getName() + " " + monkey.getTrainingStatus() + " " + monkey.getAcquisitionLocation() + " " + monkey.getReserved());
        			}
        		}

        		return;
        	default:
        		return;



        	}

        }
    }
