import java.util.*;
import java.util.stream.Collectors;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String initial = scanner.nextLine();
        String personName = null;
        String personBirthday = null;
        if(checkIfInitialIsNameOrBirthday(initial))
        {
            personBirthday = initial;
        }
        else if(!checkIfInitialIsNameOrBirthday(initial))
        {
            personName = initial;
        }
        List<String> personNameAndBirthday = new ArrayList<>();
        Map<String, String> parents = new LinkedHashMap<>();
        Map<String, String> children = new LinkedHashMap<>();
        List<String> items = new ArrayList<>();
        String command = scanner.nextLine();
        while(!command.equals("End"))
        {
            String[] arr = command.split("\\s+");
           personNameAndBirthday = checkForPersonsNameAndBirthday(arr, personName, personBirthday);
           if(personNameAndBirthday.size() == 2)
           {
               personName = personNameAndBirthday.get(0);
               personBirthday = personNameAndBirthday.get(1);
           }

            items.add(command);
            command = scanner.nextLine();
        }
        parents = checkForPersonParents(parents, items, personName, personBirthday);
        checkForPersonChildren(children, items, personName, personBirthday);
        parents = fillNullValuesInParentsList(parents, items);
        children = fillNullValuesInChildrenList(children, items);
        printFinalState(parents, children, personName, personBirthday);
    }
    public static boolean checkIfInitialIsNameOrBirthday(String initial)
    {
        char ch = initial.charAt(0);
        if(Character.isDigit(ch))
        {
            return true;
        }
        return false;
    }
    public static List<String> checkForPersonsNameAndBirthday(String[] arr,  String personName, String personBirthday)
    {
        List<String> current = new ArrayList<>();
        if(arr.length == 3 && !arr[1].equals("-"))
        {
            String name = arr[0] + " " + arr[1];
            String birthday = arr[2];
            if(personName != null && name.equals(personName))
            {
                personBirthday = birthday;
                current.add(name);
                current.add(personBirthday);
            }
            else if(personBirthday != null && personBirthday.equals(birthday))
            {
                personName = name;
                current.add(name);
                current.add(personBirthday);
            }

        }
        return current;
    }
    public static Map<String, String> checkForPersonParents(Map<String, String> parents,  List<String> items,
                                                            String personName, String personBirthday)
    {
        for(int i = 0; i < items.size(); i++)
        {
            String[] arr = items.get(i).split("\\s+");
            if(arr.length == 3 && arr[1].equals("-"))
            {
                if(arr[2].equals(personBirthday))
                {
                    parents.put(arr[0], null);
                }
            }
            else if(arr.length == 4 && arr[2].equals("-"))
            {
                if(arr[3].equals(personBirthday))
                {
                    String fullName = arr[0] + " " + arr[1];
                    parents.put(fullName, null);
                }
            }
            else if(arr.length == 4 && arr[1].equals("-"))
            {
                String fullName = arr[2] + " " + arr[3];
                if(fullName.equals(personName))
                {
                    parents.put(arr[0], null);
                }
            }
            else if(arr.length == 5)
            {
                String fullNameParent = arr[0] + " " + arr[1];
                String fullNamePerson = arr[3] + " " + arr[4];
                if(fullNamePerson.equals(personName))
                {
                    parents.put(fullNameParent, null);
                }
            }
        }
        return parents;
    }
    public static Map<String, String> checkForPersonChildren(Map<String, String> children,  List<String> items,
                                                            String personName, String personBirthday)
    {
        for(int i = 0; i < items.size(); i++)
        {
            String[] arr = items.get(i).split("\\s+");
            if(arr.length == 3 && arr[1].equals("-"))
            {
                if(arr[0].equals(personBirthday))
                {
                    children.put(arr[2], null);
                }
            }
            else if(arr.length == 4 && arr[2].equals("-"))
            {
                String fullName = arr[0] + " " + arr[1];
                if(fullName.equals(personName))
                {

                    children.put(arr[3], null);
                }
            }
            else if(arr.length == 4 && arr[1].equals("-"))
            {
                String fullName = arr[2] + " " + arr[3];
                if(arr[0].equals(personBirthday))
                {
                    children.put(fullName, null);
                }
            }
            else if(arr.length == 5)
            {
                String fullNamePerson = arr[0] + " " + arr[1];
                String fullNameChildren = arr[3] + " " + arr[4];
                if(fullNamePerson.equals(personName))
                {
                    children.put(fullNameChildren, null);
                }
            }
        }
        return children;
    }
    public static Map<String, String> fillNullValuesInParentsList(Map<String, String> parents, List<String> items)
    {
        for(int i = 0; i < items.size(); i++)
        {
            String[] arr = items.get(i).split("\\s+");
            if(arr.length == 3 && !arr[1].equals("-"))
            {
                String fullName = arr[0] + " " + arr[1];
                String birthday = arr[2];
                for(String key : parents.keySet())
                {
                    if(key.equals(fullName))
                    {
                        parents.put(key, birthday);
                    }
                    else if(key.equals(birthday))
                    {
                        parents.put(key, fullName);
                    }
                }
            }

        }
        return parents;
    }
    public static Map<String, String> fillNullValuesInChildrenList(Map<String, String> children, List<String> items)
    {
        for(int i = 0; i < items.size(); i++)
        {
            String[] arr = items.get(i).split("\\s+");
            if(arr.length == 3 && !arr[1].equals("-"))
            {
                String fullName = arr[0] + " " + arr[1];
                String birthday = arr[2];
                for(String key : children.keySet())
                {
                    if(key.equals(fullName))
                    {
                        children.put(key, birthday);
                    }
                    else if(key.equals(birthday))
                    {
                        children.put(key, fullName);
                    }
                }
            }

        }
        return children;
    }
    public static void printFinalState(Map<String, String> parents,  Map<String, String> children,
                                       String personName, String personBirthday)
    {
        System.out.println(personName + " " + personBirthday);
        System.out.println("Parents:");
        if(!parents.isEmpty())
        {
            for(String key : parents.keySet())
            {
                String currentKey = "";
                String currentValue = "";
                char ch = key.charAt(0);
                if(Character.isDigit(ch))
                {
                    currentKey = parents.get(key);
                    currentValue = key;
                }
                else
                {
                    currentKey = key;
                    currentValue = parents.get(key);
                }
                System.out.println(currentKey + " " + currentValue);
            }
        }
        System.out.println("Children:");
        if(!children.isEmpty())
        {
            for(String key : children.keySet())
            {
                String currentKey = "";
                String currentValue = "";
                char ch = key.charAt(0);
                if(Character.isDigit(ch))
                {
                    currentKey = children.get(key);
                    currentValue = key;
                }
                else
                {
                    currentKey = key;
                    currentValue = children.get(key);
                }
                System.out.println(currentKey + " " + currentValue);
            }
        }
    }

}