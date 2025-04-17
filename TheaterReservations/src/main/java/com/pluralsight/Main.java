package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Formatter values
//Code Description
//d Allows for single digit days (i.e. 2002-10-5)
//dd Requires 2 digit days (i.e. 2002-10-05)
//M Allows for single digit months (i.e. 2002-7-12)
//MM Required 2 digit months (i.e. 2002-07-12)
//MMM Abbreviated month name (i.e. 12 Aug 2002)
//MMMM Full month name (i.e. 12 August 2002)
//yy Last 2 digits of the year (defaults to the current
//century)
//yyyy Full 4 digit year

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        String userName = scanner.nextLine();
        System.out.println("What date will you be coming (MM/dd/yyyy)");
        String showingDateInput = scanner.nextLine();
        System.out.println("How many tickets would you like?");
        int numTix = scanner.nextInt();
        LocalDate showingDate = formatDate(showingDateInput);
        String message = formatMessage(numTix, showingDate, userName);
        System.out.println(message);
        scanner.close();
    }

    public static LocalDate formatDate(String showingDateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(showingDateInput, formatter);
    }

    public static String formatMessage(int numTix, LocalDate showingDate, String userName) {
        String[] firstAndLast = userName.split(" ");
        StringBuilder message = new StringBuilder();
//        1 ticket reserved for 2023-05-13 under Johnson, Geri
        message.append(numTix).append(" ").append(numTix > 1 ? "tickets" : "ticket").append(" reserved for ").append(
                showingDate).append(" under ").append(
                firstAndLast[1]).append(", ").append((firstAndLast[0]));
        return message.toString();
    }

}