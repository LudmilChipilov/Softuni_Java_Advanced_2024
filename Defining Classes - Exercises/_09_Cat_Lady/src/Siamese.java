public class Siamese
{
    //{name} {earSize}
    private String name;
    private double earSize;
    private String className = "Siamese";

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }
    @Override
    public String toString()
    {
        return String.format("%s %s %.2f", className, name, earSize);
    }
}
