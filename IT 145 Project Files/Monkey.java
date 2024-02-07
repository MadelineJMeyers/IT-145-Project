/*This class is used to set information about monkeys for the main program and to be able to pass the information to a list.
 * Author: Madeline Meyers
 * Date: October 3, 2021
 * */
public class Monkey extends RescueAnimal {

	// Private variables for this class
	// These variables are specific to the monkey class per the specification document.
	// Used string for all variables to match existing variables from dog class, string also allows for useage of nextLine method for each variable that is not the boolean variable.

	private String species;
	private String height;
	private String tailLength;
	private String bodyLength;

	// Constructor, uses parameters to set information for the Monkey object.
	// Constructor based on dog class to set all needed variables when instantiating new monkeys.
	public Monkey(String name, String species, String gender, String age,
		    String weight, String height, String tailLength, String bodyLength,
		    String acquisitionDate, String acquisitionCountry,
			String trainingStatus, boolean reserved, String inServiceCountry){

		setName(name);
		setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setTailLength(tailLength);
        setBodyLength(bodyLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);


	}

	// Mutator for the species variable.
	public void setSpecies(String species) {
		this.species = species;
	}

	// Accessor for the species variable.
	public String getSpecies() {
		return species;
	}

	// Mutator for the height variable.
	public void setHeight(String height) {
		this.height = height;
	}

	// Accessor for the height variable.
	public String getHeight() {
		return height;
	}

	// Mutator for the tail length variable.
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}

	// Accessor for the tail length variable.
	public String getTailLength() {
		return tailLength;
	}

	// Mutator for the body length variable
	public String getBodyLength() {
		return bodyLength;
	}

	// Accessor for the body length variable.
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}




}
