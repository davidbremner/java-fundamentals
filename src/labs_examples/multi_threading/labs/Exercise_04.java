package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

class Exercise_04 {

    static int numberOne;
    static int numberTwo;
    public static void main(String[] args){

        numberOne = 5;
        numberTwo = 10;

        Thread anotherThreadOne = new Thread(new TaskRunner(), "Thread 1");
        Thread anotherThreadTwo = new Thread(new TaskRunner(), "Thread 2");
        anotherThreadTwo.start();
        anotherThreadOne.start();

        System.out.println("End of main thread!");


    }

    synchronized static void addNumbers(int a, int b) {
        try {
            // sleep thread to demonstrate one thread is running on this method at a time
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a + " + " + b + " = " + (a + b) + " ran on: " + Thread.currentThread().getName());
    }

    static void subtractNumbers(int a, int b) {
        try {
            // sleep thread to demonstrate one thread is running on this method at a time
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a + " - " + b + " = " + (a - b) + " ran on: " + Thread.currentThread().getName());
    }
}

class TaskRunner implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins to run...");
        Exercise_04.addNumbers(Exercise_04.numberOne, Exercise_04.numberTwo);
        System.out.println(Thread.currentThread().getName() + " finished on addNumbers() method.");
        synchronized (Exercise_04.class) {
            System.out.println(Thread.currentThread().getName() + " starting on synchronized code block.");
            Exercise_04.subtractNumbers(Exercise_04.numberOne, Exercise_04.numberTwo);
            System.out.println(Thread.currentThread().getName() + " finished on subtractNumbers() method.");
        }
    }
}