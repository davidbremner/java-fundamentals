package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_two;

public class Building implements Construction {
    protected final String CONSTRUCTION_TYPE = "building";
    protected static final double ROOM_VALUE = 0.05; // percentage of increase/decrease in building value for each room
    protected int numOfRooms;
    protected int buildingLengthInMetres;
    protected int buildingWidthInMetres;
    protected int sizeInSquareMetres;
    protected int areaCostPerSqMetre;
    protected double buildingValue;

    public Building(int numOfRooms, int buildingLengthInMetres, int buildingWidthInMetres, int areaCostPerSqMetre) {
        this.numOfRooms = numOfRooms;
        this.buildingLengthInMetres = buildingLengthInMetres;
        this.buildingWidthInMetres = buildingWidthInMetres;
        this.areaCostPerSqMetre = areaCostPerSqMetre;
        this.sizeInSquareMetres = calculateSize(this.buildingLengthInMetres, this.buildingWidthInMetres);
        this.buildingValue = calculateCost(this.sizeInSquareMetres, this.areaCostPerSqMetre);
    }

    private void setNumOfRooms(int numOfRooms) { // not be accessed outside of class, only via renovation() method
        this.numOfRooms = numOfRooms;
    }
    public void setAreaCostPerSqMetre(int areaCostPerSqMetre) {
        double currentValuePerSqm = calculateCost(sizeInSquareMetres, this.areaCostPerSqMetre);
        this.areaCostPerSqMetre = areaCostPerSqMetre;
        double additionalValues = buildingValue - currentValuePerSqm;
        this.buildingValue = calculateCost(sizeInSquareMetres, areaCostPerSqMetre) + additionalValues;
    }
    public int getNumOfRooms() {
        return numOfRooms;
    }
    public double getAreaCostPerSqMetre() {
        return areaCostPerSqMetre;
    }
    public double getBuildingValue() {
        return buildingValue;
    }
    public int getBuildingLengthInMetres() {
        return buildingLengthInMetres;
    }
    public int getBuildingWidthInMetres() {
        return buildingWidthInMetres;
    }
    public int getSizeInSquareMetres() {
        return sizeInSquareMetres;
    }

    private void roomValueAdjustment(int rooms) { // called from renovation method to recalculate building value
        this.buildingValue = buildingValue + ((buildingValue * ROOM_VALUE) * rooms);
    }
    @Override
    public int calculateSize(int buildingLength, int buildingWidth) {
        return buildingLength * buildingWidth;
    }
    @Override
    public String renovation(int lengthBuildingAdjustment, int widthBuildingAdjustment, String CONSTRUCTION_TYPE) {
        this.buildingLengthInMetres = buildingLengthInMetres + lengthBuildingAdjustment;
        this.buildingWidthInMetres = buildingWidthInMetres + widthBuildingAdjustment;
        int currentSize = sizeInSquareMetres;
        this.sizeInSquareMetres = calculateSize(buildingLengthInMetres, buildingWidthInMetres);
        double currentOverallValue = buildingValue;
        double currentValuePerSqm = calculateCost(currentSize, areaCostPerSqMetre);
        double additionalValues = currentOverallValue - currentValuePerSqm;
        this.buildingValue = calculateCost(sizeInSquareMetres, areaCostPerSqMetre) + additionalValues;
        return "Size of " + CONSTRUCTION_TYPE + " previously: " + currentSize + " sqm" +
                "\nNow after renovation: " + sizeInSquareMetres + " sqm" +
                "\nValue of " + CONSTRUCTION_TYPE + " previously: " + currentOverallValue + " SEK"
                + "\nValue of " + CONSTRUCTION_TYPE + " now: " + buildingValue + " SEK";
    }
    // Below is method overloading:
    public String renovation(int roomNumberAdjustment, String CONSTRUCTION_TYPE) {
        double currentBuildingValue = buildingValue;
        int currentNumOfRooms = numOfRooms;
        roomValueAdjustment(roomNumberAdjustment);
        setNumOfRooms(roomNumberAdjustment + numOfRooms);
        return "Number of rooms previously: " + currentNumOfRooms + "\nNumber of rooms now: "
                + numOfRooms + "\nValue of " + CONSTRUCTION_TYPE + " previously: " + currentBuildingValue
                + " SEK\nValue of " + CONSTRUCTION_TYPE + " now: " + buildingValue + " SEK";
    }
    @Override
    public double calculateCost(int sizeInSquareMetres, int areaCostPerSqMetre) {
        return sizeInSquareMetres * areaCostPerSqMetre;
    }

    @Override
    public String toString() {
        return "Building{" +
                "numOfRooms=" + numOfRooms +
                ", buildingLengthInMetres=" + buildingLengthInMetres +
                ", buildingWidthInMetres=" + buildingWidthInMetres +
                ", sizeInSquareMetres=" + sizeInSquareMetres +
                ", areaCostPerSqMetre=" + areaCostPerSqMetre +
                ", buildingValue=" + buildingValue +
                '}';
    }
}
