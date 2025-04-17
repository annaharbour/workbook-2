package com.pluralsight;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please provide the following information:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Full name:");
        String fullName = scanner.nextLine();
        String[] billingPrompts = {"Billing Street: ", "Billing City: ", "Billing State: ", "Billing Zip: "};
        String[] shippingPrompts = {"Shipping Street: ", "Shipping City: ", "Shipping State: ", "Shipping Zip: "};
        String[] shippingAddressData = acceptAddressInfo(shippingPrompts, scanner);
        String[] billingAddressData = acceptAddressInfo(billingPrompts, scanner);
        String shippingAddress = formatAddressInfo(shippingAddressData);
        String billingAddress = formatAddressInfo(billingAddressData);
        scanner.close();
        printAddresses(fullName, shippingAddress, billingAddress);
    }

    public static String formatAddressInfo(String[] addressData) {
        StringBuilder address = new StringBuilder();
        address.append(addressData[0]).append("\n").append(addressData[1]).append(", ").append(addressData[2]).append(
                " ").append(addressData[3]);
        return address.toString();
    }

    public static String[] acceptAddressInfo(String[] prompts, Scanner scanner) {
        String[] addressData = new String[prompts.length];
        for (int i = 0; i < prompts.length; i++) {
            System.out.println(prompts[i]);
            addressData[i] = scanner.nextLine();
        }
        return addressData;
    }

    private static void printAddresses(String fullName, String shippingAddress, String billingAddress) {
        System.out.println(fullName);

        System.out.println("\nBilling Address:");
        System.out.println(billingAddress);

        System.out.println("\nShipping Address:");
        System.out.println(shippingAddress);

    }
}