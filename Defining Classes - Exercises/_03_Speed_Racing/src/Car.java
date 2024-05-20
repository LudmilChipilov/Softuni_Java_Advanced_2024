public class Car
{
    //int fuelAmount, double fuelCostPer1Km
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private int distance;

    public Car(double fuelAmount, double fuelCostPer1Km, int distance) {
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distance = distance;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPer1Km() {
        return fuelCostPer1Km;
    }

    public void setFuelCostPer1Km(double fuelCostPer1Km) {
        this.fuelCostPer1Km = fuelCostPer1Km;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


}
