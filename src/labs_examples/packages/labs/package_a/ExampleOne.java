package labs_examples.packages.labs.package_a;

import labs_examples.packages.labs.package_b.ExampleTwo;

public class ExampleOne {

    public static void main(String[] args){
        methodOne(2, 5);
        methodOne(5,5,5);
        ExampleTwo.methodTwo(5, 10, 15);
        // ExampleTwo.methodTwo(2, 5); - can't be called as it is a protected method
    }

    public static void methodOne(int a, int b) {
        System.out.println("public methodOne: " + a + " * " + b + " = " + (a * b));
    }

    protected static void methodOne(int a, int b, int c) {
        System.out.println("protected methodOne: " + a + " + " + b + " + " + c + " = " + (a + b + c));
    }
}
