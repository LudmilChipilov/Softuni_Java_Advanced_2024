import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Cat> catsList = new ArrayList<>();
        String command = scanner.nextLine();
        while(!command.equals("End"))
        {
            String[] items = command.split("\\s+");
            catsList = addNewCatToList(catsList, items);
            command = scanner.nextLine();
        }
        String catName = scanner.nextLine();
        printFinalState(catsList, catName);
    }
    public static  List<Cat> addNewCatToList(List<Cat> catsList, String[] items)
    {
        String className = items[0];
        String catName = items[1];
        double catProperty = Double.parseDouble(items[2]);
        Cymric cymric = null;
        Siamese siamese = null;
        StreetExtraordinaire streetExtraordinaire = null;
        if(className.equals("Cymric"))
        {
             cymric = new Cymric(catName, catProperty);

        }
        else if(className.equals("Siamese"))
        {
            siamese = new Siamese(catName, catProperty);
        }
        else if(className.equals("StreetExtraordinaire"))
        {
            streetExtraordinaire = new StreetExtraordinaire(catName, catProperty);
        }
        Cat cat = new Cat(cymric, siamese, streetExtraordinaire);
        catsList.add(cat);
        return catsList;
    }
    public static void printFinalState(List<Cat> catsList, String catName)
    {
        StringBuilder sb = new StringBuilder();
        for(Cat cat : catsList)
        {
            if(cat.getCymric() != null)
            {
                if(cat.getCymric().getName().equals(catName))
                {
                    sb.append(cat.getCymric().toString()).trimToSize();
                    break;
                }
            }
            if(cat.getSiamese() != null)
            {
                if(cat.getSiamese().getName().equals(catName))
                {
                    sb.append(cat.getSiamese().toString()).trimToSize();
                    break;
                }
            }
            if(cat.getStreetExtraordinaire() != null)
            {
                if(cat.getStreetExtraordinaire().getName().equals(catName))
                {
                    sb.append(cat.getStreetExtraordinaire().toString()).trimToSize();
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}