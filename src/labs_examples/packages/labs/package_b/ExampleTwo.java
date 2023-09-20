package labs_examples.packages.labs.package_b;

import labs_examples.packages.labs.package_a.ExampleOne;

public class ExampleTwo {

    public static void main(String[] args){
        methodTwo(3, 6);
        methodTwo(3,4,5);
        ExampleOne.methodOne(10, 10);
        // ExampleOne.methodOne(2, 2, 2); - can't be called as it is a protected method
    }

    protected static void methodTwo(int a, int b) {
        System.out.println("protected methodTwo: " + a + " * " + b + " = " + (a * b));
    }

    public static void methodTwo(int a, int b, int c) {
        System.out.println("public methodTwo: " + a + " + " + b + " + " + c + " = " + (a + b + c));
    }
}
