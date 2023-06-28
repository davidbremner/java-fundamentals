package labs_examples.objects_classes_methods.labs.objects;

class Output {
    public static void main(String[] args){
        /** For my own reference:
         * This is creating objects for each individual constructor method below this is creating it all within the Airplane constructor method.
         * Specs planeSpecs = new Specs("Boeing 737", 42, 36);
         * Operator myOperator = new Operator("Emirates", "worldwide", "Dubai", planeSpecs);
         * Engines myEngine = new Engines(2, 250);
         * Destinations myDestination = new Destinations("Milan", "Italy", 3.5);
         */

        Airplane holidayFlight =
                new Airplane(
                        new Operator("Emirates", "worldwide", "Dubai", new Specs("Boeing 737", 42, 36)),
                        new Engines(2, 250),
                        new Destinations("Milan", "Italy", 3.5));

        Engines test = new Engines(4, 300); // test of another object
        System.out.println("Number of engines on this test plane: " + test.getNumEngines());

        System.out.println(holidayFlight.getOperator().getName()); //getter as well as invoking toString method
        System.out.println("Get the model from specs via operator: " + (holidayFlight.getOperator().getSpecs().getModel())); //getter as well as invoking toString method
        System.out.println(holidayFlight.getOperator()); //getter as well as invoking toString method
        System.out.println(holidayFlight.getDestinations()); //getter as well as invoking toString method
        System.out.println(holidayFlight);  //getter as well as invoking toString method

    }
}
class Airplane {
    private double fuelCapacity;
    private double currentFuelLevel;
    private Operator operator;
    private Engines engines;
    private Destinations destinations;

    Airplane(Operator operator, Engines engines, Destinations destinations) {
        this.operator = operator;
        this.engines = engines;
        this.destinations = destinations;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public Operator getOperator() {
        return operator;
    }

    public Engines getEngines() {
        return engines;
    }

    public Destinations getDestinations() {
        return destinations;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                ", Operator=" + operator +
                ", Engine=" + engines +
                ", Destination=" + destinations +
                '}';
    }
}

class Specs {
    private String model;
    private int length;
    private int width;

    public Specs(String model, int length, int width) {
        this.model = model;
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Specs{" +
                "model='" + model + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }

    public String getModel() {
        return model;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}

class Operator {
    private String name;
    private String region;
    private String territory;
    private Specs specs;

    public Operator(String name, String region, String territory, Specs specs) {
        this.name = name;
        this.region = region;
        this.territory = territory;
        this.specs = specs;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getTerritory() {
        return territory;
    }

    public Specs getSpecs() {
        return specs;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", territory='" + territory + '\'' +
                ", specs=" + specs +
                '}';
    }
}

class Engines {
    private int numEngines;
    private int topSpeed;

    public Engines(int numEngines, int topSpeed) {
        this.numEngines = numEngines;
        this.topSpeed = topSpeed;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "numEngines=" + numEngines +
                ", topSpeed=" + topSpeed +
                '}';
    }
}

class Destinations {
    private String city;
    private String country;
    private double distanceInHours;

    Destinations(String city, String country, double distanceInHours) {
        this.city = city;
        this.country = country;
        this.distanceInHours = distanceInHours;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getDistanceInHours() {
        return distanceInHours;
    }

    @Override
    public String toString() {
        return "Destinations{" +
                "city='" + city + '\'' +
                "country='" + country + '\'' +
                ", distanceInHours=" + distanceInHours +
                '}';
    }
}






