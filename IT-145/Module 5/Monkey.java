//Brandon Hobbs
//Aug 1, 2021
//IT 145


public class Monkey extends RescueAnimal {
	
	private String tailLength; //just hold as a string, no math being performed
	private String monkeyHeight; //just hold as a string, no math being performed
	private String monkeyBodyLength; //just hold as a string, no math being performed
	private String monkeySpecies; //Open entry but needs validation
	
	//Constructor
	public Monkey(){
		tailLength = "blank";
		monkeyHeight = "blank";
		monkeyBodyLength = "blank";
		monkeySpecies = "blank";
	
	}
	
	public Monkey(String tailLength, String monkeyHeight, String monkeyBodyLength, String monkeySpecies,
			String monkeyName, String monkeyGender, String monkeyAge, String monkeyWeight,
			String acquisitionDate, String acquisitionCountry, String trainingStatus,
			boolean monkeyReserved, String inServiceCountry) {
		
		setTailLength(tailLength);
		setMonkeyHeight(monkeyHeight);
		setMonkeyBodyLength(monkeyBodyLength);
		setMonkeySpecies(monkeySpecies);
        setName(monkeyName);        
        setGender(monkeyGender);
        setAge(monkeyAge);
        setWeight(monkeyWeight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(monkeyReserved);
        setInServiceCountry(inServiceCountry);
	}
	
	//Get and Set the tailLength
	public void setTailLength (String tailLength) {
		this.tailLength = tailLength;
	}
	
	public String getTailLength() {
		return tailLength;
	}
	
	//Get and Set the Monkey Height
	public void setMonkeyHeight(String monkeyHeight) {
		this.monkeyHeight = monkeyHeight;
	}
	
	public String getMonkeyHeight() {
		return monkeyHeight;
	}
	
	//Get and Set the monkey Body Length
	public void setMonkeyBodyLength(String bodyLength) {
		this.monkeyBodyLength = bodyLength;
	}
	
	public String getMonkeyBodyLength() {
		return monkeyBodyLength;
	}
	
	//Get and Set the Monkey Species
	//Needs validation to protect against spelling and wrong species types
	public void setMonkeySpecies(String monkeySpecies) {
		this.monkeySpecies = monkeySpecies;
	}
	
	public String getMonkeySpecies() {
		return monkeySpecies;
	}

}
