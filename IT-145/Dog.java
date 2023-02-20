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
	
	public String getPetType(){
		return petType;
	}
	
	public void setPetType(String petType){
		this.petType = petType;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	//We will assume that all ages are rounded to the nearest INT; 
	//TODO Check User Story on if this rounding should be an INT and if FLOOR or CEIL
	public int getPetAge() {
		return petAge;		
	}
	
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	
	//Double check the catSpaces and dogSpaces uses, these don't look like a Pet Property
	public int getDogSpaces() {
		return dogSpaces;
	}
	
	public void setDogSpaces() {
		dogSpaces -= 1;//need to decrement the available spaces by one
	}
	
	public int getCatSpaces() {
		return catSpaces;
	}
	
	public void setCatSpaces() {
		catSpaces -= 1; //need to decrement the available cat spaces
	}

	//Double so we can do half days; need to check the USer Story/Elaboration on this need
	public double getDaysStay() {
		return daysStay;
	}
	
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

	private int dogSpaceNumber;
	private double dogWeight;
	private boolean grooming;	

	
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

