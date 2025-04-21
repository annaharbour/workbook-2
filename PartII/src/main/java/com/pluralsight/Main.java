package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        Customer me = new Customer(1, "Anna H", (float) 1000.02);
        System.out.println(me.toString());
    }
}