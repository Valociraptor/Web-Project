public class PokeTest {
	public static void main(String[] args){
		Pokemon p1 = new Pokemon("Pikachu", "Electric", 100);
		Pokemon p2 = new Pokemon("Charmander", "Fire", 120);
		Pokemon p3 = new Pokemon("Bulbasaur", "Grass", 120);
		
		Pokedex pokedex = new Pokedex();
		Pokemon p4 = pokedex.createPokemon("Squirtle", "Water", 120);
		System.out.println(pokedex.pokemonInfo(p1));
		pokedex.attackPokemon(p1);
		System.out.println(pokedex.pokemonInfo(p4));
		System.out.println(p4.getName());
		
		
	}
}