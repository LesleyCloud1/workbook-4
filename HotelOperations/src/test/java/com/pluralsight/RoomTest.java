package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoomTest {
    //Test that checkIn & marks the room as occupied and dirty
    @Test
    public void checkIn_should_setRoomToOccupiedAndDirty() {
        // Arrange
        Room room = new Room();
        room.cleanRoom(); //It starts clean

        //Act
        room.checkIn();

        //Assert
        assertTrue(room.isOccupied(), "Room should be occupied after check-in.");
        assertFalse(room.isClean(), "Room should be dirty after check-in.");
    }

    //Test that checkOut sets the room to unoccupied
    @Test
    public void checkOut_should_setRoomToUnoccupied() {
        //Arrange
        Room room = new Room();
        room.checkIn(); //first check in to occupy the room

        //Act
        room.checkOut();

        //Assert
        assertFalse(room.isOccupied(), "Room should not be occupied after checkout.");
    }

    //Test that cleanRoom sets the room to clean if it is unoccupied
    @Test
    public void cleanRoom_should_setRoomToClean_ifUnoccupied() {
        // Arrange
        Room room = new Room();
        room.checkIn();    //occupy and dirty the room
        room.checkOut();   //unoccupy but leave it dirty

        //Act
        room.cleanRoom();

        // Assert
        assertTrue(room.isClean(), "Room should be clean after cleaning.");
    }

    //Test edge case — cleanRoom doesn't clean if room is occupied
    @Test
    public void cleanRoom_should_notClean_ifOccupied() {
        // Arrange
        Room room = new Room();
        room.checkIn(); //Room is now dirty and occupied

        // Act
        room.cleanRoom(); //Should not clean because it's still occupied

        // Assert
        assertFalse(room.isClean(), "Room should remain dirty if cleaned while occupied.");
    }
}

}