package models;

public class Dog extends Animal implements Pet{
	public Dog(String name, String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	
	public String showAffection() {
		if (this.weight < 15) {
			return "Your "+ weight+ " pound "+ breed + " dog waggles its tail.";
		}
		else if (this.weight <  50) {
			return "Your "+ weight+ " pound "+ breed + " dog waggles its tail and rolls over!";
		}
		
		else {
			return "Your "+ weight+ " pound "+ breed + " dog waggles its tail and rolls over, then knocks out your teeth and steals your wallet";
		}
	}

}
