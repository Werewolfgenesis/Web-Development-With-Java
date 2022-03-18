package labs.streams;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise {

    // T0) Write a method to insert an element into the array list at the first position
    private static void pushFront(int elem, ArrayList<Integer> arrayList) {
        arrayList.add(0, elem);
    }

    // T1) Write a method to retrieve an element (at a specified index) from a given list.
    private static int getAtPos(int pos, ArrayList<Integer> arrayList) {
        return arrayList.get(pos);
    }

    // T2) Write a method to remove the third element from an array list.
    private static void removeThirdElem(ArrayList<Integer> arrayList){
        arrayList.remove(2);
    }

    // T3) Write a method to search an element in a list.
    private static boolean isPart(int elem, ArrayList<Integer> arrayList){
        return arrayList.contains(elem);
    }

    // T4) Write a method to sort a given array list. (list of String/Integer/Dog).
    private static void sortArr(ArrayList<String> arrayList){
        arrayList.stream().sorted();
    }
    // Implement Dog class with attribute breed and weight, sort the array by weight property.
    private class Dog implements Comparator {
        private double weight;
        private String breed;

        public Dog(){
            this.weight = -1;
            this.breed = "NZBRAT";
        }

        public boolean heavier(Dog d){
            return this.weight > d.weight;
        }


        @Override
        public int compare(Object o1, Object o2) {
            o1 = new Dog();
            o2 = new Dog();

            return 0;
        }
    }



    private static void sortDogs(ArrayList<Dog> dogs){
    }
    // Tip: implement the task with Comparator and Comparable


    // T5) Write a method to replace the second element of a ArrayList with the specified element.

    // T6)?? Write a Java program to count the number of key-value (size) mappings in a map.

    // T7) Write the following structure against aircraft tail number associate
    // list of leg information (fromAirport, toAirport, date).
    // Fill test information
    // Extract legs inside list/set that have from/to airport for a specific airport
    // (Example: All legs for airport LBSF)
}
