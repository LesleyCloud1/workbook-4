package com.pluralsight;

public class TheApp {
    public static void main(String[] args) {
        //Room tests
        Room room1 = new Room(2, 99.99, false, false);
        Room room2 = new Room(1, 89.99, true, false);
        Room room3 = new Room(2, 129.99, false, true);

        System.out.println("Room 1 available: " + room1.isAvailable()); // true
        System.out.println("Room 2 available: " + room2.isAvailable()); // false
        System.out.println("Room 3 available: " + room3.isAvailable()); // false

        // Reservation test
        Reservation res1 = new Reservation("king", 3, true);
        System.out.println("Reservation total: $" + res1.getReservationTotal());

        // Employee test
        Employee emp1 = new Employee(101, "Jane Doe", "Front Desk", 20.0, 45.0);
        System.out.println("Employee total pay: $" + emp1.getTotalPay());
    }
}
