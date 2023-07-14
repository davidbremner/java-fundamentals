package labs_examples.objects_classes_methods.labs.oop.A_inheritance.hierarchy;

public class Player extends Club {
    protected String playerName;
    protected int age;
    protected String position;

    public Player(String teamName, String stadium, String location, boolean europeanCompetition, String playerName, int age, String position) {
        super(teamName, stadium, location, europeanCompetition);
        this.playerName = playerName;
        this.age = age;
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void summary() {
        System.out.println("This player is called " + playerName + " and is aged " + age + " years old and plays in the " +
                "position of " + position + " for the club " + teamName);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", teamName='" + teamName + '\'' +
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
