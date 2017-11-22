
class Samurai extends Human{
	private static int counter; 
	public Samurai() {
		health = 200;
		counter += 1;
		
	}
	
	public void deathBlow(Human human) {
		human.health -= human.health;
		this.health -= 50;
	}
	
	public void meditate() {
		health += health/2;
	}
	
	public void howMany() {
		System.out.println("There are "+counter+" Samurai in existence.");
	}

}
