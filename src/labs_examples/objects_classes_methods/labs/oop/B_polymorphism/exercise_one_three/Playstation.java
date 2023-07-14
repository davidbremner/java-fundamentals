package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_three;

public class Playstation implements GamesConsole {
    public void powerOn() {
        System.out.println("Playstation powers up...");
    }
    public void activateController() {
        System.out.println("Playstation controller receives signal to connect to the console");
    }
    public void powerOnTv() {
        System.out.println("Playstation sends signal to the connected TV to turn on and switch to " +
                "the appropriate HDMI channel");
    }
    public void powerOffAll() {
        System.out.println("Playstation shuts down all appropriate equipment");
    }
}