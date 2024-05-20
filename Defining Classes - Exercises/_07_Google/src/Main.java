import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
          Scanner scanner = new Scanner(System.in);
          Map<String, Person> persons = new LinkedHashMap<>();
          String command = scanner.nextLine();
          while(!command.equals("End"))
          {
              String[] items = command.split("\\s+");
              String personName = items[0];
              Person person = null;
              if(!persons.containsKey(personName))
              {
                  persons.put(personName, new Person());
              }
              String itemsCommand = items[1];
              if(itemsCommand.equals("company"))
              {
                  String companyName = items[2];
                  String department = items[3];
                  double salary = Double.parseDouble(items[4]);
                  Company company = new Company(companyName, department, salary);
                  persons.get(personName).setCompany(company);
              }
              else if(itemsCommand.equals("pokemon"))
              {
                  String pokemonName = items[2];
                  String pokemonType = items[3];
                  Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                  persons.get(personName).getPokemons().add(pokemon);
              }
              else if(itemsCommand.equals("parents"))
              {
                  String parentName = items[2];
                  String parentBirthday = items[3];
                  Parent parent = new Parent(parentName, parentBirthday);
                  persons.get(personName).getParents().add(parent);
              }
              else if(itemsCommand.equals("children"))
              {
                  String childName = items[2];
                  String childBirthday = items[3];
                  Child child = new Child(childName, childBirthday);
                  persons.get(personName).getChildren().add(child);
              }
              else if(itemsCommand.equals("car"))
              {
                  String carModel = items[2];
                  int carSpeed = Integer.parseInt(items[3]);
                  Car car = new Car(carModel, carSpeed);
                  persons.get(personName).setCar(car);
              }
              command = scanner.nextLine();
          }
          String personToPrint = scanner.nextLine();
          System.out.println(personToPrint);

          Person person = persons.get(personToPrint);
          System.out.println(person);
    }
}