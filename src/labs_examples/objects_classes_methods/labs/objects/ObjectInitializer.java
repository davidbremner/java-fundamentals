/**
 * Exercise 4:
 * For this exercise please create two classes. The first class is the controller and it will contain the main() method.
 * The second class is a POJO. Just a simple object type class that defines an object. In this POJO, demonstrate
 * at least three overloaded constructors. In the main() method, create at least 3 objects of your POJO class, each using
 * a different constructor.
 */
package labs_examples.objects_classes_methods.labs.objects;

public class ObjectInitializer {
    public static void main(String[] args){
        //Person personZero = new Person();
        Person personOne = new Person ("David", 34);
        Person personTwo = new Person("JJ", "musician/singer", 10);
        Person personThree = new Person("Elle", 3, "football");

        System.out.println("personOne name: " + personOne.getName());
        System.out.println("personTwo profession: " + personTwo.getProfession());
        System.out.println("personTwo years of experience: " + personTwo.getExperienceYears());
        System.out.println("personThree hobby: " + personThree.getHobby());
  }
}

class Person {
    private String name;
    private int age;
    private String profession;
    private int experienceYears;
    private String hobby;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String profession, int experienceYears) {
        this.name = name;
        this.profession = profession;
        this.experienceYears = experienceYears;
    }

    public Person(String name, int age, String hobby) {
        this.name = name;
        this.hobby = hobby;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public String getHobby() {
        return hobby;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

}
