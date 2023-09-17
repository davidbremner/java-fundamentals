package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_two;

public class PlotOfLand implements Construction {
    protected final String CONSTRUCTION_TYPE = "farm";
    private int landLengthInMetres;
    private int landWidthInMetres;
    private int sizeInSquareMetres;
    private double landValue;
    private int areaCostPerSqMetre;

    public PlotOfLand(int landLengthInMetres, int landWidthInMetres, int areaCostPerSqMetre) {
        this.landLengthInMetres = landLengthInMetres;
        this.landWidthInMetres = landWidthInMetres;
        this.areaCostPerSqMetre = areaCostPerSqMetre;
        this.sizeInSquareMetres = calculateSize(landLengthInMetres, landWidthInMetres);
        this.landValue = calculateCost(sizeInSquareMetres, areaCostPerSqMetre);
    }

    public void setAreaCostPerSqMetre(int areaCostPerSqMetre) {
        this.areaCostPerSqMetre = areaCostPerSqMetre;
        this.landValue = calculateCost(sizeInSquareMetres, areaCostPerSqMetre);
    }

    public String getCONSTRUCTION_TYPE() {
        return CONSTRUCTION_TYPE;
    }

    public int getLandLengthInMetres() {
        return landLengthInMetres;
    }

    public int getLandWidthInMetres() {
        return landWidthInMetres;
    }

    public int getSizeInSquareMetres() {
        return sizeInSquareMetres;
    }

    public double getLandValue() {
        return landValue;
    }

    public int getAreaCostPerSqMetre() {
        return areaCostPerSqMetre;
    }

    @Override
    public int calculateSize(int landLengthInMetres, int landWidthInMetres) {
        return landLengthInMetres * landWidthInMetres;
    }
    @Override
    public String renovation(int landLengthInMetres, int landWidthInMetres, String constructionType) {
        int currentLandSize = sizeInSquareMetres;
        double currentLandValue = landValue;
        this.landLengthInMetres = landLengthInMetres;
        this.landWidthInMetres = landWidthInMetres;
        this.sizeInSquareMetres = calculateSize(landLengthInMetres, landWidthInMetres);
        this.landValue = calculateCost(sizeInSquareMetres, areaCostPerSqMetre);
        return "Size of land previously: " + currentLandSize + " sqm" + "\nSize of land now: "
                + sizeInSquareMetres + " sqm" +"\nValue of " + CONSTRUCTION_TYPE + " previously: " + (int)currentLandValue
                + " SEK\nValue of " + CONSTRUCTION_TYPE + " now: " + (int)landValue + " SEK";
    }
    @Override
    public double calculateCost(int sizeInSquareMetres, int areaCostPerSqMetre) {
        return sizeInSquareMetres * areaCostPerSqMetre;
    }

    @Override
    public String toString() {
        return "PlotOfLand{" +
                "CONSTRUCTION_TYPE='" + CONSTRUCTION_TYPE + '\'' +
                ", landLengthInMetres=" + landLengthInMetres +
                ", landWidthInMetres=" + landWidthInMetres +
                ", sizeInSquareMetres=" + sizeInSquareMetres +
                ", landValue=" + (int)landValue +
                ", areaCostPerSqMetre=" + areaCostPerSqMetre +
                '}';
    }
}
