class Dragon extends Mammal{
	
	public Dragon() {
		energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("WHOOOSH!! The Dragon has launched itself into the air and lost 50 energy.");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("OMNOMNOMNOM  It regains 25 energy");
		energyLevel +=25;
	}
	
	public void attackTown() {
		System.out.println("THe Dragon says '#$%& YO COUCH' and attacks the town.  It looses 100 energy");
		energyLevel -=100;
	}
	
	
}
