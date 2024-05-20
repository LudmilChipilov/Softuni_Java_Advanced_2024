import java.util.ArrayList;
import java.util.List;

public class Person
{
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;


    public Person()
    {
        parents = new ArrayList<>();
        children = new ArrayList<>();
        pokemons = new ArrayList<>();
    }

    public Person(Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pokemons) {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Company:%n"));
        if(company != null)
        {
            sb.append(String.format("%s%n", company));
        }
        sb.append(String.format("Car:%n"));
        if(car != null)
        {
            sb.append(String.format("%s%n", car));
        }
        sb.append(String.format("Pokemon:%n"));
        for (Pokemon pokemon : pokemons) {
            sb.append(String.format("%s%n", pokemon));
        }

        sb.append(String.format("Parents:%n"));
        for (Parent parent : parents) {
            sb.append(String.format("%s%n", parent));
        }

        sb.append(String.format("Children:%n"));
        for (Child child : children) {
            sb.append(String.format("%s%n", child));
        }

        return sb.toString();
    }
}
