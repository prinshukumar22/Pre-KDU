package com.prekdu;
import java.util.Scanner;
/*
 * Create a basic Java Program that takes two strings as input and produces the following output.
 * Print the length of the first string
 * Print the length of the second string
 * Print if the length matches or not
 * Print if the two strings are the same
 */

public class StringComparison {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first string
        System.out.print("Enter the first string-> ");
        String firstString = scanner.nextLine();

        // Prompt the user to enter the second string
        System.out.print("Enter the second string-> ");
        String secondString = scanner.nextLine();

        // Calculate and print the length of the first string
        int lengthFirstString = firstString.length();
        System.out.println("Length of the first string= " + lengthFirstString);

        // Calculate and print the length of the second string
        int lengthSecondString = secondString.length();
        System.out.println("Length of the second string= " + lengthSecondString);

        // Check if the lengths match and print the result
        if (lengthFirstString == lengthSecondString) {
            System.out.println("The lengths of the strings match.");
        } else {
            System.out.println("The lengths of the strings do not match.");
        }

        // Check if the strings are the same and print the result
        if (firstString.equals(secondString)) {
            System.out.println("The two strings are the same.");
        } else {
            System.out.println("The two strings are not the same.");
        }

        // Close the scanner
        scanner.close();
    }
}
