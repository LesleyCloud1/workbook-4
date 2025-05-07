package com.pluralsight;

public class Hotel {
    private String name;               //Name of the hotel
    private int numberOfSuites;        //Total King Suites
    private int numberOfRooms;         //Total Basic Rooms
    private int bookedSuites;          //How many suites are booked
    private int bookedBasicRooms;      //How many basic rooms are booked

    //Constructor to set total rooms, assume no bookings yet
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0, 0); //Default bookings = 0
    }

    //Constructor to set everything including booked rooms
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    //Room booking (true = suite, false = basic)
    public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite) {
        if (isSuite) {
            if (numberOfRoomsToBook <= getAvailableSuites()) {
                bookedSuites += numberOfRoomsToBook;
                System.out.println("Booked " + numberOfRoomsToBook + " suites.");
                return true;
            }
        } else {
            if (numberOfRoomsToBook <= getAvailableRooms()) {
                bookedBasicRooms += numberOfRoomsToBook;
                System.out.println("Booked " + numberOfRoomsToBook + " basic rooms.");
                return true;
            }
        }
        System.out.println("Not enough rooms available to book.");
        return false;
    }

    //Calculate how many suites are available
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    //Calculate how many basic rooms are available
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }
}

