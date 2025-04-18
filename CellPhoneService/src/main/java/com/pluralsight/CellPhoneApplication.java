package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone cellPhone1 = createCellPhone(scanner);
        CellPhone cellPhone2 = createCellPhone(scanner);
        CellPhone cellPhone3 = new CellPhone(73490834, "Samsung Galaxy", "Verizon", "704555555", "Anna");
        display(cellPhone1);
        display(cellPhone2);
        display(cellPhone3);
        // or call cellPhone.printData() to print all data;
        cellPhone1.dial("555-555-555");
        cellPhone1.dial(cellPhone3);
        scanner.close();
    }

    public static CellPhone createCellPhone(Scanner scanner) {
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

        CellPhone cellPhone = new CellPhone();
        cellPhone.setSerialNumber(serialNum);
        cellPhone.setModel(model);
        cellPhone.setPhoneNumber(phone);
        cellPhone.setCarrier(carrier);
        cellPhone.setOwner(owner);
        return cellPhone;
    }

    public static void display(CellPhone phone) {
        System.out.println("Cell Phone Info\n");
        System.out.println("==============================");
        System.out.printf("Serial number: %d\n", phone.getSerialNumber());
        System.out.printf("Model: %s\n", phone.getModel());
        System.out.printf("Carrier: %s\n", phone.getCarrier());
        System.out.printf("Phone Number: %s\n", phone.getPhoneNumber());
        System.out.printf("Phone owner: %s\n", phone.getOwner());
        System.out.println("==============================");
    }
}
