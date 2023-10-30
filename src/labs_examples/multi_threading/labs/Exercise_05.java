package labs_examples.multi_threading.labs;

import java.util.ArrayList;
import java.util.Random;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 */

class Exercise_05 {
    static final int PASSWORD_LENGTH = 8;
    static final int MAX_ASCII_VALUE =  126;
    static final int MIN_ASCII_VALUE =  33;
    static boolean isLocked = false;
    static final Object OBJECT = new Object();
    public static void main(String[] args){
        AnotherRunnable anotherRunnable = new AnotherRunnable();
        AnotherRunnableTwo anotherRunnableTwo = new AnotherRunnableTwo();
        Thread threadOne = new Thread(anotherRunnable, "Thread-1");
        Thread threadTwo = new Thread(anotherRunnableTwo, "Thread-2");
        threadOne.start();
        try {
            Thread.sleep(1500);
            threadTwo.start();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    static void passwordReset(String emailAddress) {
        ArrayList<Character> password = new ArrayList<>();
        for (int index = 0; index <= PASSWORD_LENGTH; index++) {
            // this formula picks a random number between 33 and 126
            int randomAsciiValue = new Random().nextInt(MAX_ASCII_VALUE - MIN_ASCII_VALUE) + MIN_ASCII_VALUE;
            // convert int to ascii character
            password.add((char) randomAsciiValue);
        }
        System.out.println("Your email address: " + emailAddress);
        System.out.println("Your new password for " + Thread.currentThread().getName() + " is: ");
        for (Character character : password) {
            System.out.print(character);
        }
        System.out.println(); // line break
    }
}

class AnotherRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is now running!");
        synchronized (Exercise_05.OBJECT) {
            if (!Exercise_05.isLocked) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting.");
                    Exercise_05.OBJECT.wait();
                } catch (InterruptedException interruptedException) {
                    System.out.println(interruptedException.getMessage());
                }
            }
            Exercise_05.isLocked = true;
            Exercise_05.passwordReset(Thread.currentThread().getName() + "@java.com");
            Exercise_05.OBJECT.notify();
        }
        Exercise_05.isLocked = false;
    }
}

class AnotherRunnableTwo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is now running");
        synchronized (Exercise_05.OBJECT) {
            Exercise_05.isLocked = true;
            Exercise_05.passwordReset(Thread.currentThread().getName() + "@java.com");
            Exercise_05.OBJECT.notify();
        }
        Exercise_05.isLocked = false;
    }
}

