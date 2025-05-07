package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*; //Import JUnity assertion methods
import org.junit,jupiter.api.Test; //Junit 5 import for writng test classes and methods

class HotelTest {

    @Test //This test checks that booking a suite subtracts from available suites
    public void bookRoom_should_increaseBookedSuites(){
        //arrange, creata a hotel with 10 suites and 50 basic rooms
        Hotel hotel = new Hotel("Hotel ZaZa", 10, 50);


        //act, perform action we want to test, book 3 suites (true means we are booking)
        hotel.bookRoom(3, true);


        //assert, check if it updated, after booking 3 suites we should have 7 suites left.
        assertEquals(7, hotel.getAvailableSuites());
    }

    @Test//This test checks that booking a basic room subtracts from available rooms
    public void bookRoom_should_increaseBookedBasicRooms(){
        //arrange
        Hotel hotel = new Hotel("Hotel ZaZa", 10, 50);


        //act book 3 basic rooms, false means we are not booking suites
        hotel.bookRoom(3, false);


        //assert after booking 3 rooms, we should have 47 rooms left
        assertEquals(47, hotel.getAvailableRooms());
    }

    //personal notes
    /*Arrange–Act–Assert is a pattern for writing clear and structured tests:

    Arrange sets up the objects and values you need.

    Act calls the method you're testing.

    Assert checks that the method did what you expected.

    @Test tells JUnit that this method is a test.

    assertEquals(expected, actual) checks if the actual result matches the expected one.*/

}