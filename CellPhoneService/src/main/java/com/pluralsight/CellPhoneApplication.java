package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the serial number?"); // 2597153
        int serialNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What model is the phone? ");// iPhone 15 Pro Max
        String model = scanner.nextLine();
        System.out.println("Who is the carrier? "); // Verizon
        String carrier = scanner.nextLine();
        System.out.println("What is the phone number?");// 888-555-1234
        String phone = scanner.nextLine();
        System.out.println("Who is the owner of the phone?"); //Sandra
        String owner = scanner.nextLine();
        scanner.close();

        CellPhone cellPhone = new CellPhone();
        cellPhone.setSerialNumber(serialNum);
        cellPhone.setModel(model);
        cellPhone.setPhoneNumber(phone);
        cellPhone.setCarrier(carrier);
        cellPhone.setOwner(owner);

        System.out.printf("Serial number: %d\n", cellPhone.getSerialNumber());
        System.out.printf("Model: %s\n", cellPhone.getModel());
        System.out.printf("Carrier: %s\n", cellPhone.getCarrier());
        System.out.printf("Phone Number: %s\n", cellPhone.getPhoneNumber());
        System.out.printf("Phone owner: %s\n", cellPhone.getOwner());
    }
}
