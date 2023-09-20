package labs_examples.packages.labs.package_a;

import labs_examples.packages.labs.package_b.ExampleTwo;

public class ExampleOneChild extends ExampleTwo {
    public static void main(String[] args){
        System.out.println("Calling from child class in package_a to method and class in package_b: ");
        methodTwo(2,5);
    }
}
