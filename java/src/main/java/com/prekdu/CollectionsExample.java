package com.prekdu;

import java.util.*;
/*
 * Create a basic Java Program that takes 10 strings as input and adds them to an ArrayList and
 * HashSet. Also, create a HashMap by populating the words as key and frequency as the value in the
 * map. Iterate the list, set and map and print the content of the collection.
 */

public final class CollectionsExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList to store input strings
        ArrayList<String> stringList = new ArrayList<>();

        // HashSet to store unique strings
        HashSet<String> stringSet = new HashSet<>();

        // HashMap to store words as keys and their frequencies as values
        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();

        System.out.println("Enter 10 strings:");

        // Input 10 strings and add them to ArrayList and HashSet
        for (int i = 0; i < 10; i++) {
            String input = scanner.nextLine();
            stringList.add(input);
            stringSet.add(input);

            // Populate the HashMap with word frequencies
            wordFrequencyMap.put(input, wordFrequencyMap.getOrDefault(input, 0) + 1);
        }

        // Close the scanner
        scanner.close();

        // Print contents of ArrayList
        System.out.println("\nContents of the ArrayList:");
        for (String str : stringList) {
            System.out.println(str);
        }

        // Print contents of HashSet
        System.out.println("\nContents of the HashSet:");
        for (String str : stringSet) {
            System.out.println(str);
        }

        // Print contents of HashMap
        System.out.println("\nContents of the HashMap (Word Frequencies):");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
