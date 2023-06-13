package labs_examples.objects_classes_methods.labs.methods;

/**
 * Create a recursive method named factorial that will return the factorial of any number passed to it.
 *
 * For instance, after creating the factorial method, uncomment the two lines in the main() method. When you run
 * it, it should print 120. It should also work for any ther number you pass it.
 *
 */
public class Exercise_03 {

    static int factorial(int number) {
        int result;
        if (number == 1) {
            return number;
        }
        result = factorial(number - 1) * number;
        return result;
    }

    public static void main(String[] args) {
        int x = factorial(5);
        System.out.println(x);
//        should print 120
    }




}

