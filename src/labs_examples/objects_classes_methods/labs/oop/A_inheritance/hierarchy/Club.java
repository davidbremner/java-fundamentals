package labs_examples.objects_classes_methods.labs.oop.A_inheritance.hierarchy;

public class Club extends League {
    protected String teamName;
    protected String stadium;
    protected String location;
    protected boolean europeanCompetition;

    public Club(String teamName, String stadium, String location, boolean europeanCompetition) {
        this.teamName = teamName;
        this.stadium = stadium;
        this.location = location;
        this.europeanCompetition = europeanCompetition;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isEuropeanCompetition() {
        return europeanCompetition;
    }

    public void setEuropeanCompetition(boolean europeanCompetition) {
        this.europeanCompetition = europeanCompetition;
    }

    @Override
    public void summary() {
        System.out.print("This team is " + teamName + " which play at the stadium " + stadium + " in the area of " +
                location);
        if(europeanCompetition) {
            System.out.println(" and play in a European competition");
        }
    }

    @Override
    public String toString() {
        return "Club{" +
                "teamName='" + teamName + '\'' +
                ", stadium='" + stadium + '\'' +
                ", location='" + location + '\'' +
                ", europeanCompetition=" + europeanCompetition +
                ", leagueName='" + leagueName + '\'' +
                ", tier=" + tier +
                ", numOfTeams=" + numOfTeams +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
