package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

class Exercise_02 {
    public static void main(String[] args){
        PowerRaiser threadOne = new PowerRaiser("threadOne", 6);
        new PowerRaiser("threadTwo", 4).start();
        threadOne.setPriority(Thread.MAX_PRIORITY); // demonstrating changing the priority of a thread (Exercise_03)
        threadOne.start();
        try {
            System.out.println("Now waiting on " + threadOne.getName());
            threadOne.join();
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        }
        System.out.println(threadOne.getName() + " caught up and finishing main thread");
    }
}

class PowerRaiser extends Thread {
    int baseExponent;
    int result;

    public PowerRaiser(String threadName, int baseExponent) {
        super(threadName);
        this.baseExponent = baseExponent;
        this.result = baseExponent;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started running!");
        for (int i = 1; i < baseExponent; i++) {
            System.out.println("Loop number: " + i + " for " + Thread.currentThread().getName());
            System.out.print(result + " * " + baseExponent + " = ");
            result = result * baseExponent;
            System.out.println(result);
        }
        System.out.println(baseExponent + " to the power of " + baseExponent + " = " + result);
    }
}