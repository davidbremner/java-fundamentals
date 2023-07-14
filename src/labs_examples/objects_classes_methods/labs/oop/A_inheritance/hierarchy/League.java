package labs_examples.objects_classes_methods.labs.oop.A_inheritance.hierarchy;

public class League extends WorldFootball {
    protected String leagueName;
    protected int tier;
    protected int numOfTeams;

    public League() { // default constructor
        super();
        this.leagueName = "";
        this.tier = 0;
        this.numOfTeams = 0;
    }
    public League(String continent, String country, String leagueName, int tier, int numOfTeams) {
        super(continent, country);
        this.leagueName = leagueName;
        this.tier = tier;
        this.numOfTeams = numOfTeams;
    }
    public League(String leagueName, int tier, int numOfTeams) { // call default constructor of WorldFootball
        super();
        this.leagueName = leagueName;
        this.tier = tier;
        this.numOfTeams = numOfTeams;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getNumOfTeams() {
        return numOfTeams;
    }

    public void setNumOfTeams(int numOfTeams) {
        this.numOfTeams = numOfTeams;
    }

    public void summary() {
        System.out.println("This league is " + leagueName + " on tier " + tier + " of the footballing pyramid and " +
                "has a total of " + numOfTeams + " teams in the league");
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueName='" + leagueName + '\'' +
                ", tier=" + tier +
                ", numOfTeams=" + numOfTeams +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
