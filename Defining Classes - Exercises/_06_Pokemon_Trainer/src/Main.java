import java.util.*;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Trainer> trainerList = new ArrayList<>();
        String command = scanner.nextLine();
        while(!command.equals("Tournament"))
        {
            String[] items = command.split(" ");
            trainerList = createNewTrainerOrUpdate(trainerList, items);
            command = scanner.nextLine();
        }
        String element = scanner.nextLine();
        while(!element.equals("End"))
        {
            trainerList = checkTrainersListForElement(trainerList, element);
            element = scanner.nextLine();
        }
        Collections.sort(trainerList, Comparator.comparingInt(Trainer ::getNumberOfBadges).reversed());
       printFinalState(trainerList);
    }
    public static  List<Trainer> createNewTrainerOrUpdate(List<Trainer> trainerList, String[] items)
    {
        //{trainerName} {pokemonName} {pokemonElement} {pokemonHealth}
        String trainerName = items[0];
        String pokemonName = items[1];
        String pokemonElement = items[2];
        int pokemonHealth = Integer.parseInt(items[3]);
        int numberOfBadges = 0;
        Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
        boolean isExisting = false;
        if(!trainerList.isEmpty())
        {
            for (int i = 0; i < trainerList.size(); i++)
            {
                if (trainerList.get(i).getName().equals(trainerName))
                {
                    isExisting = true;
                    List<Pokemon> temp = trainerList.get(i).getPokemonList();
                    temp.add(pokemon);
                    break;
                }
            }
        }
        if(!isExisting)
        {
            List<Pokemon> temp = new ArrayList<>();
            temp.add(pokemon);
            Trainer trainer = new Trainer(trainerName, numberOfBadges, temp);
            trainerList.add(trainer);
        }

        return trainerList;
    }
    public static  List<Trainer> checkTrainersListForElement(List<Trainer> trainerList,  String element)
    {

        for(int i = 0; i < trainerList.size(); i++)
        {
            List<Pokemon> currentPokemon = trainerList.get(i).getPokemonList();

            boolean isExisting = false;
            for(int j = 0; j < currentPokemon.size(); j++)
            {
                if(currentPokemon.get(j).getElement().equals(element))
                {
                    trainerList.get(i).setNumberOfBadges(trainerList.get(i).getNumberOfBadges() + 1);
                    isExisting = true;
                    break;
                }

            }
            if(!isExisting)
            {
                for(int j = 0; j < currentPokemon.size(); j++)
                {
                    currentPokemon.get(j).setHealth(currentPokemon.get(j).getHealth() - 10);
                    if(currentPokemon.get(j).getHealth() <= 0)
                    {
                        currentPokemon.remove(j);
                        if(!currentPokemon.isEmpty())
                        {
                            j--;
                        }
                    }
                }
            }

        }

        return trainerList;
    }

    public static void printFinalState(List<Trainer> trainerList)
    {
        for(Trainer trainer : trainerList)
        {
            List<Pokemon> temp = trainer.getPokemonList();
            System.out.printf("%s %d %d%n", trainer.getName(), trainer.getNumberOfBadges(), temp.size());
        }
    }
}