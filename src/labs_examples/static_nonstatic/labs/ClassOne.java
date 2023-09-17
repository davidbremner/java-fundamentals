package labs_examples.static_nonstatic.labs;

public class ClassOne {
    static boolean trigger = false;
    public static void main(String[] args){
        staticMethodA();
        ClassOne nonStaticObjectC = new ClassOne();
        nonStaticObjectC.nonStaticMethodC();
    }
    static void staticMethodA() {
        staticMethodB();
        ClassOne nonStaticObjectA = new ClassOne();
        nonStaticObjectA.nonStaticMethodA();
        ClassTwo.staticMethodC(trigger);
        ClassTwo nonStaticObjectB = new ClassTwo();
        nonStaticObjectB.nonStaticMethodB(false);
    }
    static void staticMethodB() {
        if (trigger) {
            System.out.println("7. A non-static method calling a static method in the same class");
        } else {
            System.out.println("1. A static method calling another static method in the same class");
        }
    }
    void nonStaticMethodA() {
        if (trigger) {
            System.out.println("5. A non-static method calling a non-static method in the same class");
        } else {
            System.out.println("2. A static method calling a non-static method in the same class");
        }
    }
    void nonStaticMethodC() {
        trigger = true;
        nonStaticMethodA();
        ClassTwo nonStaticObjectD = new ClassTwo();
        nonStaticObjectD.nonStaticMethodB(trigger);
        staticMethodB();
        ClassTwo.staticMethodC(trigger);
    }
}
