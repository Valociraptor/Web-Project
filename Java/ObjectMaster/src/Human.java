
public class Human {
	protected Integer strength = 3;
	protected Integer stealth = 3;
	protected Integer intelligence = 3;
	protected Integer health = 100;
	public Human() {
		System.out.println("A new being emerges from the shadows.  They have "+health+" health.");
	}
	
	public void attack(Human human) {
		human.health -= strength;
	}
	
	public void displayHealth() {
		System.out.println("This human has "+health+" health.");
	}
	
}
