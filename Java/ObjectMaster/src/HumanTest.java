
public class HumanTest {

	public static void main(String[] args) {
		Human steve = new Human();
		Human dave = new Human();
		dave.displayHealth();
		steve.displayHealth();
		steve.attack(dave);
		dave.displayHealth();
		steve.displayHealth();
		
		Ninja nancy = new Ninja();
		Wizard wilbur = new Wizard();
		Samurai sam = new Samurai();
		Samurai seth = new Samurai();
		Samurai sally = new Samurai();
		Samurai sylvio = new Samurai();
		
		nancy.steal(wilbur);
		wilbur.displayHealth();
		wilbur.fireball(nancy);
		nancy.displayHealth();
		
		sam.deathBlow(sally);
		sally.displayHealth();
		sam.displayHealth();
		
		sam.howMany();

	}

}
