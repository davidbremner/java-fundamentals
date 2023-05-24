package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class LogicalOperators {

    public static void main(String[] args) {

        // example of "OR"
        boolean a = true;
        boolean b = false;
        if (a | b){
            System.out.println("a or b is true");
        }

        // write your code below
        boolean c = true;
        boolean d = false;
        if (a & c) {
            System.out.println("a and c are true");
        }
        if (b && c) {
            System.out.println("This won't print due to b as false and will exit at b - short circuit");
        }
        if (d | c) {
            System.out.println("d or c is true (c is true)");
        }
        if (c || d) {
            System.out.println("c or d is true. c is true so doesn't check d - short circuit");
        }
        if (d ^ c) {
            System.out.println("c is true, d is false so this results in true (^)");
        }
        if (!b & !d) {
            System.out.println("b and d are false so therefore with the not operator it is true");
        }

    }

}

