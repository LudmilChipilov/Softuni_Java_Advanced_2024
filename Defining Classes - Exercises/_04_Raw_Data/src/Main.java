import java.util.*;


public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Car>> carsList = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++)
        {
            String[] items = scanner.nextLine().split(" ");
            carsList = createNewCar(carsList, items);
        }
        String cargoType = scanner.nextLine();
        printFinalState(carsList, cargoType);
    }
    public static Map<String, List<Car>> createNewCar(Map<String, List<Car>> carsList,  String[] items)
    {
        String model = items[0];
        //String model, int enginePower, String cargoType, double averagePressure
        int enginePower = Integer.parseInt(items[2]);
        String cargoType = items[4];
        List<Double> pressure = new ArrayList<>();
        pressure.add(Double.parseDouble(items[5]));
        pressure.add(Double.parseDouble(items[7]));
        pressure.add(Double.parseDouble(items[9]));
        pressure.add(Double.parseDouble(items[11]));

        if(carsList.isEmpty() || !carsList.containsKey(cargoType))
        {
            carsList.put(cargoType, new ArrayList<>());
            List<Car> currentCar = new ArrayList<>();
            Car car = new Car(model, enginePower, cargoType, pressure);
            currentCar.add(car);
            carsList.put(cargoType, currentCar);
        }
        else
        {
            List<Car> currentCar = carsList.get(cargoType);
            Car car = new Car(model, enginePower, cargoType, pressure);
            currentCar.add(car);
        }
        return carsList;

    }
    public static void printFinalState(Map<String, List<Car>> carsList, String cargoType)
    {
          for(String key : carsList.keySet())
          {
              if(cargoType.equals("fragile") && key.equals(cargoType))
              {
                  List<Car> temporary = carsList.get(key);
                  for(Car car : temporary)
                  {
                      List<Double> tempPressure = car.getPressure();
                      for(Double pr : tempPressure)
                      {
                          if(pr < 1)
                          {
                              System.out.println(car.getModel());
                              break;
                          }
                      }

                  }
              }
              else if(cargoType.equals("flamable") && key.equals(cargoType))
              {
                  List<Car> temporary = carsList.get(key);
                  for(Car car : temporary)
                  {
                      if(car.getEnginePower() > 250)
                      {
                          System.out.println(car.getModel());
                      }
                  }
              }
          }
    }
}