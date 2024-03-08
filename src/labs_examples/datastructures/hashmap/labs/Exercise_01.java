package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate your mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */

class Exercise_01 {
    public static void main(String[] args){
        HashMap<String, String> newcastleUnitedResults = new HashMap<>();
        HashMap<String, String> someEmptyList = new HashMap<>();
        newcastleUnitedResults.put("Manchester United", "1-0");
        newcastleUnitedResults.put("PSG", "1-1");
        newcastleUnitedResults.put("Chelsea", "4-1");
        System.out.println("The result against MUFC: " + newcastleUnitedResults.get("Manchester United"));
        someEmptyList.putAll(newcastleUnitedResults);
        System.out.println(someEmptyList);
        System.out.println(newcastleUnitedResults);
        System.out.println("Size of hashmap: " + newcastleUnitedResults.size());
        System.out.println("Do we contain the key 'PSG'? " + newcastleUnitedResults.containsKey("PSG"));
        System.out.println("Do we contain the value '4-1'? " + newcastleUnitedResults.containsValue("4-1"));

        Set<String> myKeys = newcastleUnitedResults.keySet(); // not needed but an alternative way if required
        int counter = 0;
        for (String key : newcastleUnitedResults.keySet()) {
            counter++;
            System.out.println("Key " + counter + ": " + key);
            System.out.println("Result (value): " + newcastleUnitedResults.get(key));
        }

        newcastleUnitedResults.putIfAbsent("Milan", "3-1");

        Set<Map.Entry<String, String>> myEntrySets = newcastleUnitedResults.entrySet(); // also not needed but an alternative way if required
        for (Map.Entry<String, String> entrySet : newcastleUnitedResults.entrySet()) {
            System.out.println("Key value pair as an entrySet: " + entrySet.getKey() + " " + entrySet.getValue());
        }

        newcastleUnitedResults.remove("PSG");
        newcastleUnitedResults.replace("Milan", "3-1", "4-0");
        newcastleUnitedResults.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
        newcastleUnitedResults.clear();
    }
}