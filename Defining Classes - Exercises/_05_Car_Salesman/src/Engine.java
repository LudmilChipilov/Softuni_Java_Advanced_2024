public class Engine
{
    //{modelEngine} {power} {displacement} {efficiency}
    private String modelEngine;
   private String power;
   private String displacement;
   private String efficiency;

    public Engine(String modelEngine, String power, String displacement, String efficiency) {
        this.modelEngine = modelEngine;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModelEngine() {
        return modelEngine;
    }

    public void setModelEngine(String modelEngine) {
        this.modelEngine = modelEngine;
    }
}
