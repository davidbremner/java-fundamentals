package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */

class Exercise_01 {
    public static void main(String[] args){
        System.out.println("Threads will start on next line...");
        // Method 1:
        new MyRunnable("Thread 1");
        // Method 2:
        new Thread(new MyRunnable(), "Thread 2").start();
        System.out.println("...Main has finished");
    }
}

class MyRunnable implements Runnable {
    Thread thread;
    public MyRunnable(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }
    public MyRunnable(){}
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


