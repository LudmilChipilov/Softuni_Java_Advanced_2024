public class StreetExtraordinaire
{
    //StreetExtraordinaire {name} {decibelsOfMeows}
    private String name;
    private double decibelsOfMeows;
    private String className = "StreetExtraordinaire";

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }
    @Override
    public String toString()
    {
        return String.format("%s %s %.2f", className, name, decibelsOfMeows);
    }
}
