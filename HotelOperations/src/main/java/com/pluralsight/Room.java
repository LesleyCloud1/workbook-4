package com.pluralsight;

public class Room {
    private int beds;           // Number of beds in the room
    private double rate;        // Price per night
    private boolean occupied;   // True if the room is occupied
    private boolean clean;      // True if the room is clean

    // Constructor to create a room
    public Room(int beds, double rate, boolean occupied, boolean clean) {
        this.beds = beds;
        this.rate = rate;
        this.occupied = occupied;
        this.clean = clean;
    }

    // Check if the room is available: not occupied AND clean
    public boolean isAvailable() {
        return !occupied && clean;
    }

    // When a guest checks in, the room becomes occupied and dirty
    public void checkIn() {
        if (isAvailable()) {
            occupied = true;
            clean = false;
            System.out.println("Check-in successful.");
        } else {
            System.out.println("Room is not available for check-in.");
        }
    }

    // When a guest checks out, the room is no longer occupied but still dirty
    public void checkOut() {
        if (occupied) {
            occupied = false;
            System.out.println("Check-out successful. Room must be cleaned before next guest.");
        } else {
            System.out.println("Room is already vacant.");
        }
    }

    // Clean the room so it becomes available if not occupied
    public void cleanRoom() {
        clean = true;
        System.out.println("Room cleaned.");
    }
}
