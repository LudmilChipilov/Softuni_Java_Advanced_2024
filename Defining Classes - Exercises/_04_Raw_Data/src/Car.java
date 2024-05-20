import java.util.List;

public class Car
{
    //{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
    private String model;
    private int enginePower;
    private String cargoType;
    private List<Double> pressure;

    public Car(String model, int enginePower, String cargoType, List<Double> pressure) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;

        this.pressure = pressure;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }


    public List<Double> getPressure() {
        return pressure;
    }

    public void setPressure(List<Double> pressure) {
        this.pressure = pressure;
    }
}
