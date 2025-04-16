package com.pluralsight;

import java.util.Scanner;

public class FullNameGenerator {

    public static void main(String[] args) {
        System.out.println("Please enter your nameInput");
        Scanner scanner = new Scanner(System.in);
        String firstName = collectName(scanner, "First nameInput: ");
        String midName = collectName(scanner, "Middle nameInput: (type ↵ to bypass)");
        String lastName = collectName(scanner, "Last nameInput: ");
        String suffix = collectName(scanner, "Suffix: (type ↵ to bypass)");
        String fullName = String.valueOf(buildFullName(firstName, midName, lastName, suffix));
        System.out.println(fullName);
        scanner.close();
    }

    public static String collectName(Scanner scanner, String msg) {
        System.out.println(msg);
        String nameInput = scanner.nextLine().trim();
        if (!nameInput.isEmpty()) nameInput = formatInput(nameInput);
        return nameInput;
    }

    public static String formatInput(String nameInput) {
        nameInput = nameInput.substring(0, 1).toUpperCase() + nameInput.substring(1).toLowerCase();
        return nameInput;
    }

    public static StringBuilder buildFullName(String firstName, String midName, String lastName, String suffix) {
        StringBuilder fullName = new StringBuilder();
        fullName.append(firstName + " ");
//        handle initials or entire middle nameInput
        if (!midName.isEmpty()) {
            if (midName.length() == 1) {
                fullName.append(midName + ".");
            } else if (midName.length() == 2 && midName.charAt(1) == '.'){
                    fullName.append(midName);
            } else {
                fullName.append(midName);
            }
        }

        fullName.append(" "+ lastName);

        if (!suffix.isEmpty()) {
            fullName.append(", " + suffix);
        }

        return fullName;
    }

}