package labs_examples.objects_classes_methods.labs.methods;

/**
 *     1) Demonstrate method overloading in this class
 *
 *     2) Demonstrate the difference between "pass by value" and "pass by reference"
 *
 *     3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)
 *
 *     4) Write a method to count all consonants (the opposite of vowels - a, e, i, o, u) in a String
 *
 *     5) Write a method that will determine whether or not a number is prime
 *
 *     6) Write a method that will return a small array containing the highest and lowest numbers in a given numeric array,
 *             which is passed in as an argument
 *
 *     7) Write a method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an Integer Arraylist.
 *         In this method create an Integer ArrayList and populate it with each number between zero and maxNum that is
 *         divisible by both divisor1 and divisor2. Then return this ArrayList. After calling this method, print out the
 *         length of the returned list
 *
 *
 *     8) Write a method that will reverse an array in place use only one extra temp variable. For this exercise you cannot
 *         instantiate a second array. You must reverse the array in place using only one extra temp variable. Hint: this
 *         variable is used to temporarily store individual values in the array
 */
public class MethodTraining {
    // Task 1:
    static int calculation(int one, int two) {
        return one * two;
    }
    static int calculation(int one, int two, int three) {
        return one + two + three;
    }
    static double calculation(double one) {
        return one * one;
    }

    // Task 2:
    private String name;
    private int age;
    MethodTraining(String namePerson, int agePerson) {
        this.name = namePerson;
        this.age = agePerson;
    }

    // below two methods could be used to retrieve specific data points. (However not used here).
    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    void setAge(int value) {
        this.age = value;
    }

    void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return "MethodTraining{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    static void calculateAge(int age) {
        age += 1;
        System.out.println("Age changed in method (by value): " + age);
    }

    // Task 3:
    static int findHighestNumber(int... nums) {
        int highestNum = Integer.MIN_VALUE;
        for(int num : nums) {
            if (num > highestNum) {
                highestNum = num;
            }
        }
        return highestNum;
    }

    // Task 4:
    static int countConsonants(String sentence) {
        char[] characters = sentence.toCharArray();
        int count = characters.length;
        for(char letter : characters) {
            char lowercaseChar = Character.toLowerCase(letter);
            if (isVowel(lowercaseChar) || !Character.isLetter(lowercaseChar)) {
                count--;
            }
        }
        return count;

    }

    static boolean isVowel(char letter) {
        String vowels = "aeiou";
        return vowels.contains(Character.toString(letter));
    }

    // Task 5:
    static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        // Task 1:
        System.out.println("Method overloading example one: " + calculation(3, 4));
        System.out.println("Method overloading example two: " + calculation(5, 2, 4));
        System.out.println("Method overloading example three: " + calculation(5.5));

        // Task2:
        MethodTraining person = new MethodTraining("Clara", 29);
        int personAge = 29;
        calculateAge(personAge);
        System.out.println("pass by value after method: " + personAge);
        System.out.println("pass by ref before method: " + person);
        person.setAge(34);
        person.setName("David");
        System.out.println("pass by reference after method call: " + person);

        // Task 3:
        System.out.println("The highest number is: " + findHighestNumber(3, -5, 2, 1));

        // Task 4:
        System.out.println("How many consonants in the sentence: " + countConsonants("Hello there Sunshine!"));

        // Task 5:
        System.out.println("Is or isn't a prime number: " + isPrimeNumber(36));

  }
}
