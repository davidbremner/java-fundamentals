package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_three;

public class UniversalRemote {
    private GamesConsole console; // Demonstrate using an interface as an instance variable

    public UniversalRemote(GamesConsole console) { // have a constructor that takes in the interface as a parameter
        this.console = console;
    }

    public void setConsole(GamesConsole console) { // have a setter that allows you to update the interface object
        this.console = console;
    }

    public void turnOn() {
        console.powerOn();
        console.activateController();
        console.powerOnTv();
    }

    public void turnOff() {
        console.powerOffAll();
    }
}