package labs_examples.objects_classes_methods.labs.oop.A_inheritance.hierarchy;

public class HierarchyController {
    public static void main(String[] args){
        WorldFootball region = new WorldFootball(); // creating object using default constructor
        System.out.println(region);
        WorldFootball regionTwo = new WorldFootball("Europe", "England"); // creating object using other constructor
        System.out.println(regionTwo);
        League premierLeague = new League("Premier League", 1, 20); // creating object using default constructor of superclass
        System.out.println(premierLeague);
        League championship = new League("Europe", "England", "Championship", 2, 24);
        System.out.println(championship);
        Club newcastleUnited = new Club("Newcastle United", "St.James Park", "Newcastle", true);
        System.out.println(newcastleUnited);
        Player callum = new Player("Newcastle United", "St.James Park", "Newcastle", true,
                "Callum Wilson", 31, "striker"); // no default constructor for superclass Club so must initialize
        System.out.println(callum);

        System.out.println("\nMethod call of 'summary' from League class:");
        premierLeague.summary();  // original summary() method

        System.out.println("Method call of 'summary' from Club class:");
        newcastleUnited.summary(); // overriding summary() method

        System.out.println("Method call of 'summary' from Player class:");
        callum.summary(); // overriding summary() method & demonstrating access to variables in superclass with teamName
  }
}
