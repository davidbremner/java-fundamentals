package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_three;

public class Nintendo implements GamesConsole {
    private boolean connectedToTV;

    public void setConnectedToTV(boolean connectedToTV) {
        this.connectedToTV = connectedToTV;
    }

    public void powerOn() {
        System.out.println("Nintendo powers up...");
    }
    public void activateController() {
        System.out.println("Nintendo's handheld screen turns on");
    }
    public void powerOnTv() {
        if(connectedToTV) {
            System.out.println("Nintendo sends signal to the connected TV to turn on and switch the appropriate HDMI channel");
        } else {
            System.out.println("Nintendo activates handheld screen as main screen");
        }
    }
    public void powerOffAll() {
        System.out.println("Nintendo shuts down all appropriate equipment");
    }
}