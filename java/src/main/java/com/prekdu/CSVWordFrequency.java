package com.prekdu;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Create a basic Java Program that reads a CSV file and prints the top 3 repeated words in the file.
 * The CSV file is in the reosurces folder and the file name is input.csv.
 */

public class CSVWordFrequency {
  public static void main(String[] args) {
    // Define the path to the CSV file
    InputStream inputStream =
        CSVWordFrequency.class.getClassLoader().getResourceAsStream("input.csv");
    // String filePath = "../../resources/input.csv";

    if (inputStream == null) {
      System.out.println("Error: input.csv file not found in resources folder");
      return;
    }
    // Map to store word frequencies
    Map<String, Integer> wordCount = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;

      // Read the file line by line
      while ((line = br.readLine()) != null) {
        // Split the line into words (assuming comma-separated values)
        String[] words = line.split(",");

        // Count occurrences of each word
        for (String word : words) {
          word = word.trim().toLowerCase(); // Normalize words
          wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading the file: " + e.getMessage());
      return;
    }

    // Sort the word frequencies in descending order and get the top 3
    List<Map.Entry<String, Integer>> topWords =
        wordCount.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(3)
            .collect(Collectors.toList());

    // Print the top 3 repeated words
    System.out.println("Top 3 repeated words:");
    for (Map.Entry<String, Integer> entry : topWords) {
      System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
    }
  }
}
