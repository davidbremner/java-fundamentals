package labs_examples.datatypes_operators.labs;

/**
 * Fundamentals Exercise 4: Volume and Surface Area
 *
 *      Write the necessary code to calculate the volume and surface area of a cylinder
 *      with a radius of 3.14 and a height of 5. Print out the result.
 *
 */

public class Exercise_06 {

    public static void main(String[] args) {

        // write code here
        int height = 5;
        float radius = 3.14f;

        //formula volume = 1. (radius squared) * height = answer 2. answer * pi(3.14) = Volume
        double volume = ((radius * radius) * height) * 3.14;
        System.out.println("The volume of the cylinder with a height of " + height + " and a radius of " + radius
                + " = " + volume);

        //formula surface area = (((radius * radius) * 2) + ((height * radius) * 2)) * pi (3.14)
        double surfaceArea = (((radius * radius) * 2) + ((height * radius)) * 2) * 3.14;
        System.out.println("The surface area of a cylinder with the height of " + height + " and a radius of "
                + radius + " = " + surfaceArea);
    }
}