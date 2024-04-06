package com.telran.org.algorithmsHomeworks.algorithm_HW_4_March_14_2024;

public class DivideAndConquerApp {

    public static void main(String[] args) {
        String unsortedAlphabet = "poiuytrewqlkjhgfdsamnbvcxz"; // created string in default order of the alphabet
        System.out.println("Original unsorted alphabet : " + unsortedAlphabet); // printed created string

//        Should print on the exit ABCDEFGHIJKLMNOPQRSTUVWXYZ all capital letters
        String sortedAlphabet = sortAlphabet(unsortedAlphabet); // sorted and merged our alphabet
        System.out.println("Here is the result of Divide and Conquer method for sorting strings alphabetically with conversion to uppercase : " + sortedAlphabet);
        // please see printed sorted merged alphabet all in capital letters by pressing 'run' green play triangle
    }

    public static String sortAlphabet(String unsortedAlphabet) { // we call our unsorted string to get it sorted in this method
        if (unsortedAlphabet.length() <= 1) { // sorting logic executes if string length does not have 1 or less characters
            return unsortedAlphabet.toUpperCase(); // if string has one character or less it returns that character and converts it to uppercase
        } else {
            String leftSideOfAlphabet = unsortedAlphabet.substring(0, unsortedAlphabet.length() / 2); // define left side of the string
            String rightSideOfAlphabet = unsortedAlphabet.substring(unsortedAlphabet.length() / 2); // define fight side of the string
            String sortedLeftSideOfAlphabet = sortAlphabet(leftSideOfAlphabet); // sort method for left side executes by dividing 'till it reaches one character or less
            String sortedRightSideOfAlphabet = sortAlphabet(rightSideOfAlphabet); // sort method for right side executes by dividing 'till it reaches one character or less
            return merge(sortedLeftSideOfAlphabet, sortedRightSideOfAlphabet); // here we call merge method to combine left and right sides
        }
    }

    public static String merge(String sortedLeftSideOfAlphabet, String sortedRightSideOfAlphabet) { // we take left and right side of the sorted strings and combine them together
        StringBuilder mergeLeftAndRightSideOfAlphabet = new StringBuilder(); // create string builder
        int i = 0; // create start point for left side
        int j = 0; // create start point for right side
        while (i < sortedLeftSideOfAlphabet.length() && j < sortedRightSideOfAlphabet.length()) { // cycle while executes while start point is less than the size of left and right string
            if (sortedLeftSideOfAlphabet.charAt(i) < sortedRightSideOfAlphabet.charAt(j)) { // if logic to compare each character left with right if meaning of i is less than j
                mergeLeftAndRightSideOfAlphabet.append(sortedLeftSideOfAlphabet.charAt(i)); // we add the smallest i meaning to the merged string
                i++; // and increase i start point
            } else { // otherwise
                mergeLeftAndRightSideOfAlphabet.append(sortedRightSideOfAlphabet.charAt(j)); // we add the smallest j meaning to the merged string
                j++; // and increase j start point
            }
        }
        while (i < sortedLeftSideOfAlphabet.length()) { // next in our method while cycle executes 'till i is less than left side size
            mergeLeftAndRightSideOfAlphabet.append(sortedLeftSideOfAlphabet.charAt(i)); // all characters here add in to the merged list
            i++; // and we go through each character by increasing our i start point
        }
        while (j < sortedRightSideOfAlphabet.length()) { // next in our method while cycle executes 'till j is less than right side size
            mergeLeftAndRightSideOfAlphabet.append(sortedRightSideOfAlphabet.charAt(j)); // all characters here add in to the merged list
            j++; // and we go through each character by increasing our j start point
        }
        return mergeLeftAndRightSideOfAlphabet.toString().toUpperCase(); // last step we return all merged and sorted characters in capital letters to the String
    }
}