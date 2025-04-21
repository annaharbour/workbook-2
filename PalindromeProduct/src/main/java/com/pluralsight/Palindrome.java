package com.pluralsight;

public class Palindrome {
    public static String findPalindromes() {
        int potential = 0;
        int largest = 0;
        for (int i = 1; i <= 99; i++) {
            for (int j = 1; j <= 99; j++) {
                potential = i * j;
                if (isPalindrome(potential) && potential > largest) {
                    largest = potential;
                }

            }
        }
        return String.valueOf(largest);
    }

    public static boolean isPalindrome(int potential) {
        String potentialStr = String.valueOf(potential);
        String reversed = new StringBuilder(potentialStr).reverse().toString();
        return potentialStr.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println("Largest palindrome from the product of two 3-digit #'s: " + findPalindromes());
    }
}
