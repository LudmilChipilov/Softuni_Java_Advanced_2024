import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Engine> enginesList = new ArrayList<>();
        List<Car> carsList = new ArrayList<>();
        int enginesCount = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < enginesCount; i++)
        {
            String[] items = scanner.nextLine().split(" ");
            String[] current = checkForInputs(items);
            enginesList = createNewEngine(enginesList, current);
        }
        int carsCount = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < carsCount; i++)
        {
            String[] items = scanner.nextLine().split(" ");
            String[] current = checkForInputs(items);
            carsList = createNewCar(carsList, current);
        }
        printFinalState(enginesList, carsList);
    }
    public static String[] checkForInputs(String[] items)
    {
        String[] current = new String[4];
        current[0] = items[0];
        current[1] = items[1];
        current[2] = "n/a";
        current[3] = "n/a";
        if(items.length == 4)
        {
            current[2] = items[2];
            current[3] = items[3];
        }
        if(items.length == 3)
        {
            String temp = items[2];
            if(Character.isDigit(temp.charAt(0)))
            {
                current[2] = items[2];

            }
            else
            {

                current[3] = items[2];
            }

        }
        return current;
    }
    public static  List<Engine> createNewEngine(List<Engine> enginesList, String[] current)
    {
        //{modelEngine} {power} {displacement} {efficiency}
        String modelEngine = current[0];
        String power = current[1];
        String displacement = current[2];
        String efficiency = current[3];


        Engine engine = new Engine(modelEngine , power, displacement, efficiency);

        enginesList.add(engine);
        return enginesList;
    }
    public static  List<Car> createNewCar(List<Car> carsList, String[] current)
    {
        //{model} {engine} {weight} {color}
        String model = current[0];
        String engine = current[1];
        String weight = current[2];
        String color = current[3];


        Car car = new Car(model, engine, weight, color);
        carsList.add(car);
        return carsList;
    }
    public static void printFinalState(List<Engine> enginesList,  List<Car> carsList)
    {
        for(Car car : carsList)
        {

            for(Engine engine : enginesList)
            {

                if(engine.getModelEngine().equals(car.getEngine()))
                {
                    System.out.println(car.getModel() + ":");
                    System.out.println(car.getEngine() + ":");
                    System.out.println("Power: " + engine.getPower());
                    System.out.println("Displacement: " + engine.getDisplacement());
                    System.out.println("Efficiency: " + engine.getEfficiency());
                    System.out.println("Weight: " + car.getWeight());
                    System.out.println("Color: " + car.getColor());

                }
            }
        }
    }
}