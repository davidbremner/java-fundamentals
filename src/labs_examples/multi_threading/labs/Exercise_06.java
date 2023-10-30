package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

class Exercise_06 {
    static int counter = 0;
    static final int MAX_COUNT = 100;
    static final Object LOCK = new Object();

    public static void main(String[] args){
        SequentialCounter sequentialCounterOne = new SequentialCounter(true);
        SequentialCounter sequentialCounterTwo = new SequentialCounter(false);
        Thread threadOne = new Thread(sequentialCounterOne, "Thread-1");
        Thread threadTwo = new Thread(sequentialCounterTwo, "Thread-2");
        threadOne.start();
        threadTwo.start();
    }
}

class SequentialCounter implements Runnable {
    private final boolean isEven;

    public SequentialCounter(boolean isEven) {
        this.isEven = isEven;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is now running!");
        synchronized (Exercise_06.LOCK) {
            while (Exercise_06.counter <= Exercise_06.MAX_COUNT) {
                if (Exercise_06.counter % 2 == (isEven ? 0 : 1)) {
                    System.out.println(Thread.currentThread().getName() + " is printing: " + Exercise_06.counter);
                    Exercise_06.counter++;
                    Exercise_06.LOCK.notifyAll();
                } else {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting...");
                        Exercise_06.LOCK.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}