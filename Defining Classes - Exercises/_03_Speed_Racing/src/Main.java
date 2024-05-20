import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Car>> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++)
        {
            String[] items = scanner.nextLine().split(" ");
            cars = createNewCar(cars, items);
        }
        String command = scanner.nextLine();
        while(!command.equals("End"))
        {
            String[] comArgs = command.split(" ");
            cars = driveExistingCar(cars, comArgs);
            command = scanner.nextLine();
        }
        printFinalState(cars);
    }
    public static Map<String, List<Car>> createNewCar(Map<String, List<Car>> cars,  String[] items)
    {
        //String model, int fuelAmount, double fuelCostPer1Km
        String model = items[0];
        double fuelAmount = Double.parseDouble(items[1]);
        int distance = 0;
        double fuelCostPer1Km = Double.parseDouble(items[2]);
        cars.put(model, new ArrayList<>());
        List<Car> currentList = new ArrayList<>();
        Car car = new Car(fuelAmount, fuelCostPer1Km, distance);
        currentList.add(car);
        cars.put(model, currentList);

        return cars;
    }
    public static Map<String, List<Car>> driveExistingCar(Map<String, List<Car>> cars,  String[] comArgs)
    {

        String model = comArgs[1];
        int distance = Integer.parseInt(comArgs[2]);
        if(cars.containsKey(model))
        {
            List<Car> currentList = cars.get(model);
            for(int i = 0; i < currentList.size(); i++)
            {
                double fuelAmount = currentList.get(i).getFuelAmount();
                if(fuelAmount < distance * currentList.get(i).getFuelCostPer1Km())
                {
                    System.out.println("Insufficient fuel for the drive");
                }
                else
                {
                    fuelAmount -= distance * currentList.get(i).getFuelCostPer1Km();
                    currentList.get(i).setFuelAmount(fuelAmount);
                    currentList.get(i).setDistance(currentList.get(i).getDistance() + distance);
                }
            }
        }
        return cars;
    }
    public static void printFinalState( Map<String, List<Car>> cars)
    {
        for(String key : cars.keySet())
        {
            List<Car> currentList = cars.get(key);
            for(Car car : currentList)
            {
                System.out.printf("%s %.2f %d%n", key, car.getFuelAmount(), car.getDistance());
            }
        }
    }
}