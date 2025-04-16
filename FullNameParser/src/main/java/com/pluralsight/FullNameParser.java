package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {

    public static void main(String[] args) {
        String[] nameArr = createNameArr();
        String firstName = nameArr[0];
        String lastName = nameArr[nameArr.length - 1];
        String midName = "";
        printLabeledNames(nameArr, midName, firstName, lastName);
    }

    private static void printLabeledNames(String[] nameArr, String midName, String firstName, String lastName) {
        if (nameArr.length > 2) {
            midName = String.join(" ", java.util.Arrays.copyOfRange(nameArr, 1, nameArr.length - 1));
        }
        if (!midName.isEmpty()) {
            System.out.printf("First name: %s\nMiddle name(s): %s\nLast name: %s", firstName, midName, lastName);
        } else {
            if (!firstName.equals(lastName)) {
                System.out.printf("First name: %s\nLast name: %s", firstName, lastName);
            } else {
                System.out.printf("Your name: %s", firstName);
            }

        }
    }

    private static String[] createNameArr() {
        while (true) {
            System.out.println("Please enter your name:");
            Scanner scanner = new Scanner(System.in);
            String fullName;
            fullName = scanner.nextLine().trim();
            return fullName.split(" ");
        }
    }
}