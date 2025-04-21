package com.pluralsight;
import com.pluralsight.Car;
import java.util.Arrays;
import java.util.Scanner;

public class CarInventoryApp {

    public static void listAllCars(Car[] cars) {
        System.out.printf("Printing all car listings\n");
        Arrays.stream(cars).filter(car -> car != null).forEach(car -> {
            printCarData(car);
        });
    }


    public static void searchByMakeModel(Car[] cars, Scanner scanner) {
        System.out.println(
                "What make and model would you like to search for: (ie Honda Civic)\n");
        String makeModel = scanner.nextLine();
        System.out.printf("Printing all cars of the make and model %s:\n", makeModel);
        Arrays.stream(cars).filter(
                        car -> car != null && car.getMakeModel().trim().equalsIgnoreCase(makeModel.trim()))
                .forEach(
                        car -> printCarData(car));
    }


    public static void searchByPriceRange(Car[] cars, Scanner scanner) {
        System.out.println("Enter the lowest price of a car you would like to search for: ");
        float lowPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the highest price for a car you can afford: ");
        float highPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.printf("Printing cars priced between %.2f and %.2f: \n", lowPrice, highPrice);
        Arrays.stream(cars).filter(
                car -> car != null && car.getPrice() >= lowPrice && car.getPrice() <= highPrice).forEach(
                car -> printCarData(car));
    }

    public static void searchByColor(Car[] cars, Scanner scanner) {
        System.out.println("What color car would you like to search for: \n");
        String color = scanner.nextLine();
        Arrays.stream(cars).filter(
                car -> car != null && car.getColor().trim().equalsIgnoreCase(color.trim())).forEach(
                car -> printCarData(car));
    }

    public static void addACar(Car[] cars, Scanner scanner) {
        System.out.println("Enter Car ID: \n");
        long carId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter Car Make/Model: \n");
        String makeModel = scanner.nextLine();
        System.out.println("Enter Car Color: \n");
        String color = scanner.nextLine();
        System.out.println("Enter Car Odometer Reading: ");
        int odometerReading = scanner.nextInt();
        System.out.println("Enter Car Price: ");
        float price = scanner.nextFloat();
        Car car = new Car(carId, makeModel, color, odometerReading, price);
        int nextFreeIdx = -1;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                nextFreeIdx = i;
                break;
            }
        }
        if (nextFreeIdx == -1) {
            System.out.println("Cannot add any more cars");
        } else {
            cars[nextFreeIdx] = car;
            System.out.println("Car added");
        }
    }


    public static void promptUser(Scanner scanner, Car[] cars) {
        boolean quit = false;
        while (!quit) {
            System.out.println(
                    "What do you want to do?\n" +
                            "1 - List all cars\n" +
                            "2 - Search by make/model\n" +
                            "3 - Search by price range\n" +
                            "4 - Search by color\n" +
                            "5 - Add a car\n" +
                            "6 - Quit\n" +
                            "Enter your command:");

            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    listAllCars(cars);
                    promptUser(scanner, cars);
                    break;
                case 2:
                    searchByMakeModel(cars, scanner);
                    promptUser(scanner, cars);
                    break;
                case 3:
                    searchByPriceRange(cars, scanner);
                    break;
                case 4:
                    searchByColor(cars, scanner);
                    break;
                case 5:
                    addACar(cars, scanner);
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


    private static void printCarData(Car car) {
        System.out.println("===================");
        System.out.println("Car ID: " + car.getCarId());
        System.out.println("Make / Model: " + car.getMakeModel());
        System.out.println("Color: " + car.getColor());
        System.out.println("Odometer Reading: " + car.getOdometerReading());
        System.out.printf("Price: $%.2f \n", car.getPrice());
    }

    public static void main(String[] args) {
//        instantiating an array to hold up to 20 Cars
        Car[] cars = new Car[20];
//        preloading array with cars
        cars[0] = new Car(101121, "Ford Explorer", "Red", 45000, 13500);
        cars[1] = new Car(101122, "Toyota Camry", "Blue", 60000, 11000);
        cars[2] = new Car(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        cars[3] = new Car(101124, "Honda Civic", "White", 70000, 7500);
        cars[4] = new Car(101125, "Subaru Outback", "Green", 55000, 14500);
        cars[5] = new Car(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
        Scanner scanner = new Scanner(System.in);
        promptUser(scanner, cars);
        scanner.close();
    }
}
