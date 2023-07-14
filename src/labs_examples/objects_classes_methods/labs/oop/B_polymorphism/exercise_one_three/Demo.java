package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_three;

public class Demo {
    public static void main(String[] args){

        // demonstrate that you understand how we can use Interfaces as dependencies (instance variables)
        // and how useful and flexible they make our application.

        Playstation ps5 = new Playstation();
        UniversalRemote remote = new UniversalRemote(ps5);
        remote.turnOn();
        System.out.println("-------9 hours later-------");
        remote.turnOff();

        System.out.println("---------------------------");
        System.out.println("---------------------------");

        Nintendo nintendoSwitch = new Nintendo();
        remote.setConsole(nintendoSwitch);
        nintendoSwitch.setConnectedToTV(false);
        remote.turnOn();
        System.out.println("-------9 hours later-------");
        remote.turnOff();

    }
}