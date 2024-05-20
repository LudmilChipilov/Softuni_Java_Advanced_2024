import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++)
        {
            String[] items = scanner.nextLine().split(" ");
            persons = addNewPerson(persons, items);
        }
        persons.sort(Comparator.comparing(Person::getName));
        printFinalState(persons);
    }

    public static List<Person> addNewPerson(List<Person> persons, String[] items)
    {
        String name = items[0];
        int age = Integer.parseInt(items[1]);

        if(age > 30)
        {
            Person person = new Person(name, age);
            persons.add(person);
        }
        return persons;
    }
    public static void printFinalState(List<Person> persons)
    {
        for(Person person : persons)
        {
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}