package labs_examples.multi_threading.examples.sender_receiver;

public class Controller {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        new Thread(new Runnable() {
            @Override
            public void run() {
                // some code
            }
        }).start();

        sender.start();
        receiver.start();
    }
}
