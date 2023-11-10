package labs_examples.enumerations.labs;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a separate class.
 *      2) Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
 *      of this enum from a separate class.
 */

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

enum ZeldaPurchase {
    THE_LEGEND_OF_ZELDA_TEARS_OF_THE_LAST_KINGDOM("The Legend of Zelda: Tears of the Kingdom", 699.00),
    THE_LEGEND_OF_ZELDA_BREATH_OF_THE_WILD("The Legend of Zelda: Breath of the Wild", 649.00),
    THE_LEGEND_OF_ZELDA_OCARINA_OF_TIME("The Legend of Zelda: Ocarina of Time", 545.00),
    THE_LEGEND_OF_ZELDA_MAJORAS_MASK("The Legend of Zelda: Majora's Mask", 499.00),
    THE_LEGEND_OF_ZELDA_WIND_WAKER("The Legend of Zelda: The Wind Waker", 499.50);

    final String selectedGame;
    final double price;

    ZeldaPurchase(String selectedGame, double price) {
        this.selectedGame = selectedGame;
        this.price = price;
    }
}

class EnumController {
    public static void main(String[] args){
        // enum one:
        System.out.println("This month is: " + Month.NOVEMBER);
        System.out.println("Next month is: " + Month.DECEMBER);
        // enum two:
        System.out.println("Here is my purchase: \n" + ZeldaPurchase.THE_LEGEND_OF_ZELDA_MAJORAS_MASK.selectedGame +
                " | Price: " + ZeldaPurchase.THE_LEGEND_OF_ZELDA_MAJORAS_MASK.price);
        System.out.println("Here is my next purchase: \n" + ZeldaPurchase.THE_LEGEND_OF_ZELDA_TEARS_OF_THE_LAST_KINGDOM.selectedGame +
                " | Price: " + ZeldaPurchase.THE_LEGEND_OF_ZELDA_TEARS_OF_THE_LAST_KINGDOM.price);
    }
}