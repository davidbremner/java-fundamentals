package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all relational operators below. These include:
 *
 * less than, less than or equal to, greater than, greater than or equal to, and equal to
 *
 */
class RelationalOperators {

    public static void main(String[] args) {

        // example of "less than"
        int a = 1;
        int b = 2;
        if (a < b){
            System.out.println("a is less than b");
        }

        // write your code below
        int c = 3;
        int d = 3;
        if (c <= d) {
            System.out.println("is c equal to d or less than d = yes, c is equal to d");
        }
        if (b > a) {
            System.out.println("b is greater than a");
        }
        if (c >= d) {
            System.out.println("is c equal to d or greater than d = yes, c is equal to d");
        }
        if (c == d) {
            System.out.println("is c equal to d = yes, c is equal to d");
        }
    }

}

