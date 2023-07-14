package labs_examples.objects_classes_methods.labs.oop.A_inheritance.hierarchy;

public class WorldFootball {
    protected String continent;
    protected String country;

    public WorldFootball() {
        this.continent = "";
        this. country = "";
    }

    public WorldFootball(String continent, String country) {
        this.continent = continent;
        this.country = country;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "WorldFootball{" +
                "continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
