

class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("This jackass just chucked a banana at your head");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The Gorilla is satisfied with the banana.  It regains 10 energy");
		energyLevel +=10;
	}
		
	
	public void climb() {
		System.out.println("The Gorilla climbed a tree and lost  10 energy");
		energyLevel -=10;
	}
}
