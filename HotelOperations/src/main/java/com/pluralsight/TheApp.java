package com.pluralsight;

public class TheApp {
    public static void main(String[] args) {
        //Rooms
        Room room1 = new Room(2, 99.99, false, true);   // Clean and not occupied → should be available
        Room room2 = new Room(1, 89.99, true, false);   // Occupied and dirty → not available
        Room room3 = new Room(2, 129.99, false, false); // Dirty and not occupied → not available

        System.out.println("Room 1 available: " + room1.isAvailable()); // true
        System.out.println("Room 2 available: " + room2.isAvailable()); // false
        System.out.println("Room 3 available: " + room3.isAvailable()); // false

        //Check in to room 1
        room1.checkIn(); // Should work, now room1 is occupied and dirty
        System.out.println("Room 1 checked in. Available? " + room1.isAvailable()); // false

        //Check out of room 1
        room1.checkOut(); // Now not occupied but still dirty
        System.out.println("Room 1 checked out. Available? " + room1.isAvailable()); // false

        //Clean room 1
        room1.cleanRoom(); // Room should now be available
        System.out.println("Room 1 cleaned. Available? " + room1.isAvailable()); // true

        //Reservation Test
        Reservation res1 = new Reservation("king", 3, true);
        System.out.println("Reservation total: $" + res1.getReservationTotal());

        //Employee Test
        Employee emp1 = new Employee(101, "Jane Doe", "Front Desk", 20.0, 45.0);
        System.out.println("Employee total pay: $" + emp1.getTotalPay());

        emp1.punchTimeCard(10.0);    //Punch in at 10:00 AM
        emp1.punchTimeCard(14.75);   //Punch out at 2:45 PM
        System.out.println("New total hours: " + emp1.getHoursWorked());
        System.out.println("New total pay: $" + emp1.getTotalPay());

        //More Employee Test to check time systems on Ex.3
        Employee emp2 = new Employee(102, "John Smith", "Housekeeping", 18.0, 0.0);
        emp2.punchIn();   //Uses system time to punch in
        emp2.punchOut();  //Uses system time to punch out

        System.out.println("Employee " + emp2.getName() + " worked ...");
        System.out.println("Total pay: $" + emp2.getTotalPay());

        //Hotel Test
        Hotel myHotel = new Hotel("Sunrise Suites", 3, 5); // 3 suites, 5 basic rooms
        System.out.println("Available Suites: " + myHotel.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + myHotel.getAvailableRooms());

        myHotel.bookRoom(2, true);  // Try to book 2 suites
        myHotel.bookRoom(3, false); // Try to book 3 basic rooms

        System.out.println("Remaining Suites: " + myHotel.getAvailableSuites());
        System.out.println("Remaining Basic Rooms: " + myHotel.getAvailableRooms());

    }
}
