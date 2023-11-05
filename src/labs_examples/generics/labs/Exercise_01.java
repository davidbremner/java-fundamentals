package labs_examples.generics.labs;

import java.util.ArrayList;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

class DataController {
    public static void main(String[] args){
        DataStorage<String> footballer = new DataStorage<>("Callum Wilson", "31", "Newcastle United");
        DataStorage<Integer> someNumbers = new DataStorage<>(542, 324223, 32434);
        DataStorage<ArrayList<String>> someList = new DataStorage<>(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        System.out.println(footballer);
        System.out.println(someNumbers);
        System.out.println(someList);
    }
}

class DataStorage<T> {
    private T dataOne;
    private T dataTwo;
    private T dataThree;

    public DataStorage(T dataOne, T dataTwo, T dataThree) {
        this.dataOne = dataOne;
        this.dataTwo = dataTwo;
        this.dataThree = dataThree;
    }

    public T getDataOne() {
        return dataOne;
    }

    public T getDataTwo() {
        return dataTwo;
    }

    public void setDataOne(T dataOne) {
        this.dataOne = dataOne;
    }

    public void setDataTwo(T dataTwo) {
        this.dataTwo = dataTwo;
    }

    public T getDataThree() {
        return dataThree;
    }

    public void setDataThree(T dataThree) {
        this.dataThree = dataThree;
    }

    @Override
    public String toString() {
        return "DataStorage{" +
                "dataOne=" + dataOne +
                ", dataTwo=" + dataTwo +
                ", dataThree=" + dataThree +
                '}';
    }
}
