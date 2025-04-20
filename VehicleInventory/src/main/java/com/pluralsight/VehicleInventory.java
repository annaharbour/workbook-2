package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class VehicleInventory {

    public static void listAllVehicles(Vehicle[] vehicles) {
        System.out.printf("Printing all vehicle listings\n");
        Arrays.stream(vehicles).filter(vehicle -> vehicle != null).forEach(vehicle -> {
            printVehicleData(vehicle);
        });
    }


    public static void searchByMakeModel(Vehicle[] vehicles, Scanner scanner) {
        System.out.println(
                "What make and model would you like to search for: (ie Honda Civic)\n");
        String makeModel = scanner.nextLine();
        System.out.printf("Printing all vehicles of the make and model %s:\n", makeModel);
        Arrays.stream(vehicles).filter(
                        vehicle -> vehicle != null && vehicle.getMakeModel().trim().equalsIgnoreCase(makeModel.trim()))
                .forEach(
                        vehicle -> printVehicleData(vehicle));
    }


    public static void searchByPriceRange(Vehicle[] vehicles, Scanner scanner) {
        System.out.println("Enter the lowest price of a vehicle you would like to search for: ");
        float lowPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the highest price for a vehicle you can afford: ");
        float highPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.printf("Printing vehicles priced between %.2f and %.2f: \n", lowPrice, highPrice);
        Arrays.stream(vehicles).filter(
                vehicle -> vehicle != null && vehicle.getPrice() >= lowPrice && vehicle.getPrice() <= highPrice).forEach(
                vehicle -> printVehicleData(vehicle));
    }

    public static void searchByColor(Vehicle[] vehicles, Scanner scanner) {
        System.out.println("What color vehicle would you like to search for: \n");
        String color = scanner.nextLine();
        Arrays.stream(vehicles).filter(
                vehicle -> vehicle != null && vehicle.getColor().trim().equalsIgnoreCase(color.trim())).forEach(
                vehicle -> printVehicleData(vehicle));
    }

    public static void addAVehicle(Vehicle[] vehicles, Scanner scanner) {
        System.out.println("Enter Vehicle ID: \n");
        long vehicleId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter Vehicle Make/Model: \n");
        String makeModel = scanner.nextLine();
        System.out.println("Enter Vehicle Color: \n");
        String color = scanner.nextLine();
        System.out.println("Enter Vehicle Odometer Reading: ");
        int odometerReading = scanner.nextInt();
        System.out.println("Enter Vehicle Price: ");
        float price = scanner.nextFloat();
        Vehicle vehicle = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        int nextFreeIdx = -1;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                nextFreeIdx = i;
                break;
            }
        }
        if (nextFreeIdx == -1) {
            System.out.println("Cannot add any more vehicles");
        } else {
            vehicles[nextFreeIdx] = vehicle;
            System.out.println("Vehicle added");
        }
    }


    public static void promptUser(Scanner scanner, Vehicle[] vehicles) {
        boolean quit = false;
        while (!quit) {
            System.out.println(
                    "What do you want to do?\n" +
                            "1 - List all vehicles\n" +
                            "2 - Search by make/model\n" +
                            "3 - Search by price range\n" +
                            "4 - Search by color\n" +
                            "5 - Add a vehicle\n" +
                            "6 - Quit\n" +
                            "Enter your command:");

            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    listAllVehicles(vehicles);
                    promptUser(scanner, vehicles);
                    break;
                case 2:
                    searchByMakeModel(vehicles, scanner);
                    promptUser(scanner, vehicles);
                    break;
                case 3:
                    searchByPriceRange(vehicles, scanner);
                    break;
                case 4:
                    searchByColor(vehicles, scanner);
                    break;
                case 5:
                    addAVehicle(vehicles, scanner);
                    break;
                case 6:
                    System.out.println("Quitting...");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again. :)");
            }
        }
    }


    private static void printVehicleData(Vehicle vehicle) {
        System.out.println("===================");
        System.out.println("Vehicle ID: " + vehicle.getVehicleId());
        System.out.println("Make / Model: " + vehicle.getMakeModel());
        System.out.println("Color: " + vehicle.getColor());
        System.out.println("Odometer Reading: " + vehicle.getOdometerReading());
        System.out.printf("Price: $%.2f \n", vehicle.getPrice());
    }

    public static void main(String[] args) {
//        instantiating an array to hold up to 20 Vehicles
        Vehicle[] vehicles = new Vehicle[20];
//        preloading array with vehicles
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
        Scanner scanner = new Scanner(System.in);
        promptUser(scanner, vehicles);
        scanner.close();
    }
}
