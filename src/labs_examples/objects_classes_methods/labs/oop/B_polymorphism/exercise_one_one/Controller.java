package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_one;

public class Controller {
    public static void main(String[] args){
        PartTime personOne = new PartTime("David Bremner", 34, "16-02-2022",
                20, 200, "Software Engineer");
        personOne.printDetails();
        personOne.calculateStartDate();
        FullTime personTwo = new FullTime("Clara Andersson", 29, "05-08-2023",
                45353, "Social Media Marketing Manager");
        personTwo.printDetails();
        personTwo.calculateStartDate();
        personOne.contractUpdate(28); // method overloading
        personOne.contractUpdate(230.00); // method overloading
    }
}
