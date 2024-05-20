public class Cymric
{
     //Cymric {name} {furLength}
    private String name;
    private double furLength;
    private String className = "Cymric";

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }
    @Override
    public String toString()
    {
        return String.format("%s %s %.2f", className, name, furLength);
    }
}
