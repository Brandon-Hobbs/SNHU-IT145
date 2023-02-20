//Brandon Hobbs
//IT 145 J6234
//July 23, 2021

public class Pet {
	
	private String petType;
	private String petName;
	private int petAge;
	private int dogSpaces = 30; //should this be a global CONST?
	private int catSpaces = 12; //should this be a global CONST?
	private double daysStay; //lets do double in case we need to support half days
	private double amountDue; //should we swap to the Currency class?
	
	//default constructor
	public Pet() {
		petType = "none";
		petName = "none";
		petAge = -1;
		daysStay = -1;
		amountDue = -1;
	}
	
	//return the Pet Type; Check in Class should validate this
	public String getPetType(){
		return petType;
	}
	
	//Set the pet type; Check in Class should validate this
	public void setPetType(String petType){
		this.petType = petType;
	}
	
	//Return the string containg the pet's name; Check in Class should validate this in case of long names
	public String getPetName() {
		return petName;
	}
	
	//Set the pet's name
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	//We will assume that all ages are rounded to the nearest INT; 
	//TODO Check User Story on if this rounding should be an INT and if FLOOR or CEILING
	public int getPetAge() {
		return petAge;		
	}
	
	//We will assume that all ages are rounded to the nearest INT; 
	//TODO Check User Story on if this rounding should be an INT and if FLOOR or CEILING
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	
	//Double check the catSpaces and dogSpaces uses, these don't look like a Pet Property
	public int getDogSpaces() {
		return dogSpaces;
	}
	
	public void setDogSpaces(int dogSpaces) {
		//dogSpaces -= 1;//need to decrement the available spaces by one
		this.dogSpaces = dogSpaces;
	}
	
	public int getCatSpaces() {
		return catSpaces;
	}
	
	//Double check the catSpaces and dogSpaces uses, these don't look like a Pet Property
	public void setCatSpaces(int catSpaces) {
		//catSpaces -= 1; //need to decrement the available cat spaces
		this.catSpaces = catSpaces; //for not allow this to be directly entered
	}

	//Double so we can do half days; need to check the USer Story/Elaboration on this need
	public double getDaysStay() {
		return daysStay; //we should return the double here and then format in the other Classes
	}
	
	//Double so we can do half days; need to check the User Story/Elaboration on this need
	public void setDaysStay(double daysStay) {
		this.daysStay = daysStay;
	}
	
	public double getAmountDue() {
		return amountDue;
	}
	
	//Business Logic should exist in a separate class to calculate this amount
	public void setAmountDue(double amountDue){
		this.amountDue = amountDue;
	}	
}


public class Dog extends Pet{

	private int dogSpaceNumber; //assigned space the dog is in
	private double dogWeight; //double for haigh weights. Need to look at what precision this needs to be in
	private boolean grooming; //BOOL as only options are YES/NO	

	
	//default constructor
	//TODO implement the parameterized constructor and a method to set the data via that
	public Dog() {
		grooming = false;
		dogWeight = -1;
		dogSpaceNumber = -1;
	}
	
	//Stores the assigned space ID of this object/dog
	public int getDogSpaceNumber() {
		return dogSpaceNumber;
	}

    //Stores the assigned space ID of this object/dog
	public void setDogSpaceNumber(int dogSpaceNumber) {
		this.dogSpaceNumber = dogSpaceNumber;
	}
	
	//Double due to smaller dogs and decimal weights; will we need to support Metric Units?
	public double getDogWeight() {
		return dogWeight;
	}
	
	public void setDogWeight(double dogWeight) {
		this.dogWeight = dogWeight;
	}
	
	//Grooming is BOOL YES/NO; Might need to expand if new options are implemented
	public boolean getGrooming() {
		return grooming;
	}
	
	public void setGrooming(boolean grooming) {
		this.grooming = grooming;
	}
}

public class Cat extends Pet {

	private int catSpaceNumber;
	
	//default Constructor
	public Cat() {
		
		this.catSpaceNumber = -1;
	}
	//Stores the assigned space ID of this object/cat
	public int getCatSpaceNumber() {
		return catSpaceNumber;
	}
    //Stores the assigned space ID of this object/cat
	public void setCatSpaceNumber(int catSpaceNumber) {
		this.catSpaceNumber = catSpaceNumber;
	}
}
