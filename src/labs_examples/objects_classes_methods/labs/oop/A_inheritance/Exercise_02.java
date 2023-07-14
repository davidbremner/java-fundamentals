package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Run the class below and study the output. What prints and why?
 *
 * Your answer:
 *  10 prints, this is because object a is of type A even though it is of an instance of B. So the i in class A
 *  is the value accessed. This is possible due to B being a subclass of A and can be treated like an A due to polymorphism.
 *  The value of i can be accessed in the main method with casting. For ex: System.out.println(((B)a).i);
 */
class A {
    int i = 10;
}

class B extends A{
    int i = 20;
}

public class Exercise_02 {

    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.i);
    }
}