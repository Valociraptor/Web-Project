
public abstract class AbstractClass implements PokeInterface {
	//@Override
	public Pokemon createPokemon(String name, String type, int health ){
		return new Pokemon(name, type, health);
	}
    
	//@Override
	public void attackPokemon(Pokemon p){
		int currentHealth = p.getHealth() - 10;
		p.setHealth(currentHealth);
	}
}
