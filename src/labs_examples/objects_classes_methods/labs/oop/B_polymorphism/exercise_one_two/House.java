package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_two;

public class House extends Building{
    protected final String CONSTRUCTION_TYPE = "house";
    protected final double GARDEN_VALUE = 0.1; // value addition per garden in property
    private final String city;
    private final String area;
    private boolean frontGarden;
    private boolean backGarden;
    private final int numOfFloors;

    public House(int numOfRooms, int buildingLengthInMetres, int buildingWidthInMetres, int areaCostPerSqMetre,
                 String city, String area, boolean frontGarden, boolean backGarden, int numOfFloors) {
        super(numOfRooms, buildingLengthInMetres, buildingWidthInMetres, areaCostPerSqMetre);
        this.city = city;
        this.area = area;
        setGarden(frontGarden, backGarden); // adds additional value if there's a front/back garden
        this.numOfFloors = numOfFloors;
    }

    private void setGarden(boolean frontGarden, boolean backGarden) { // private as only called when constructed
        if(frontGarden && backGarden) {
            this.buildingValue = buildingValue + (buildingValue * (GARDEN_VALUE * 2));
        } else if(frontGarden || backGarden) {
            this.buildingValue = buildingValue + (buildingValue * GARDEN_VALUE);
        }
        this.frontGarden = frontGarden;
        this.backGarden = backGarden;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public boolean isFrontGarden() {
        return frontGarden;
    }

    public boolean isBackGarden() {
        return backGarden;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "CONSTRUCTION_TYPE='" + CONSTRUCTION_TYPE + '\'' +
                ", GARDEN_VALUE=" + GARDEN_VALUE +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", frontGarden=" + frontGarden +
                ", backGarden=" + backGarden +
                ", numOfFloors=" + numOfFloors +
                ", CONSTRUCTION_TYPE='" + CONSTRUCTION_TYPE + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", buildingLengthInMetres=" + buildingLengthInMetres +
                ", buildingWidthInMetres=" + buildingWidthInMetres +
                ", sizeInSquareMetres=" + sizeInSquareMetres +
                ", areaCostPerSqMetre=" + areaCostPerSqMetre +
                ", buildingValue=" + buildingValue +
                '}';
    }
}
