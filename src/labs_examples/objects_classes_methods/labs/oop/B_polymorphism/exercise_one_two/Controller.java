package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_two;

public class Controller {
    public static void main(String[] args){
        House myHouse = new House(5, 10, 10, 50000,
                "Stockholm", "Gröndal", true, true, 2);
        System.out.println("\n" + myHouse);

        System.out.println("\nBoth renovation work done on myHouse:");
        String houseRoomIncrease = myHouse.renovation(2, myHouse.CONSTRUCTION_TYPE); // adding 2 rooms
        System.out.println("\n" + houseRoomIncrease);
        String houseSizeIncrease = myHouse.renovation(2, 2, myHouse.CONSTRUCTION_TYPE); // increasing size by 2M & 2M
        System.out.println("\n" + houseSizeIncrease);

        System.out.println("\nExample of setting the area price per square metre up by 10%.\nCurrently: "
                + myHouse.getBuildingValue() + " SEK");
        myHouse.setAreaCostPerSqMetre(55000);
        System.out.println("Increase added: " + myHouse.getBuildingValue() + " SEK");

        // another House object but demonstrating the reverse:
        House anotherHouse = new House(3, 5, 5, 30000,
                "Newcastle", "Tynemouth", false, true, 1);
        System.out.println("\n" + anotherHouse);

        System.out.println("\nBoth renovation work done on anotherHouse:");
        String houseRoomDecrease = anotherHouse.renovation(-2, anotherHouse.CONSTRUCTION_TYPE); // reduction of 2 rooms
        System.out.println("\n" + houseRoomDecrease);
        String houseSizeDecrease = anotherHouse.renovation(-2, -1, anotherHouse.CONSTRUCTION_TYPE); // decreasing size by 2M & 1M
        System.out.println("\n" + houseSizeDecrease);

        System.out.println("\nExample of setting the area price per square metre down by 10%.\nCurrently: "
                + anotherHouse.getBuildingValue() + " SEK");
        anotherHouse.setAreaCostPerSqMetre(27000);
        System.out.println("Decrease made: " + anotherHouse.getBuildingValue() + " SEK");

        // demonstration of another class implementing the Construction interface:
        PlotOfLand myFarm = new PlotOfLand(20, 40, 20000);
        System.out.println("\n" + myFarm);
        // demonstration of increasing size of farm:
        System.out.println("\nRenovation work done on myFarm:");
        System.out.println(myFarm.renovation(40,60, myFarm.CONSTRUCTION_TYPE));
        System.out.println("\nExample of setting the area price per square metre up by 20% - \nCurrently: "
                + (int)myFarm.getLandValue() + " SEK");
        myFarm.setAreaCostPerSqMetre(24000);
        System.out.println("Increase made: " + (int)myFarm.getLandValue() + " SEK");
    }
}
