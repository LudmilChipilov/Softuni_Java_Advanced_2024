import java.util.List;

public class Trainer
{
     private String name;
     private int numberOfBadges;
     private List<Pokemon> pokemonList;

    public Trainer(String name, int numberOfBadges, List<Pokemon> pokemonList) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

}
