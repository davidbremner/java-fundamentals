package labs_examples.static_nonstatic.labs;

public class ClassTwo {
    static void staticMethodC(boolean trigger) {
        if (trigger) {
            System.out.println("8. A non-static method calling a static method in another class");
        } else {
            System.out.println("3. A static method calling a static method in another class");
        }
    }
    void nonStaticMethodB(boolean trigger) {
        if (trigger) {
            System.out.println("6. A non-static method calling a non-static method in another class");
        } else {
            System.out.println("4. A static method calling a non-static method in another class");
        }
    }
}
