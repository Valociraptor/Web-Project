package models;

public class Cat extends Animal implements Pet {
	public Cat(String name, String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = (double) weight;
	}
	
	public String showAffection() {
		return "Your "+ weight + " " + breed + " cat named, " + name + " purrs and pretends it's not loving this, but it totally is";
	}

}



