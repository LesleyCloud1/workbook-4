package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    //Test that punching in and out updates hoursWorked correctly
    @Test
    public void punchOut_should_calculateWorkedHoursCorrectly() {
        //Arrange, create an employee and punch in at time 9.0 (9:00 AM)
        Employee emp = new Employee(101, "Lesley", "IT", 100.0, 0.0);
        emp.punchIn(9.0);

        //Act, punch out at 17.0 (5:00 PM)
        emp.punchOut(17.0);

        //Assert, Employee should have worked 8 hours
        assertEquals(8.0, emp.getHoursWorked(), 0.001, "Hours worked should be 8.0");
    }

    //Test that calling punchOut without punching in doesn't change hoursWorked
    @Test
    public void punchOut_withoutPunchIn_should_notChangeHoursWorked() {
        //Arrange, create an employee who has not punched in
        Employee emp = new Employee(102, "Bob", "Sales", 15.0, 0.0);

        //Act, try to punch out without punching in
        emp.punchOut(12.0);

        //Assert, hoursWorked should still be 0
        assertEquals(0.0, emp.getHoursWorked(), 0.001, "Hours should remain 0 if not punched in");
    }

    //Test multiple punch in/out cycles accumulate hours
    @Test
    public void punchInOut_multipleTimes_should_accumulateHours() {
        //Arrange
        Employee emp = new Employee(103, "Cathy", "Marketing", 18.5, 0.0);
        emp.punchIn(8.0);
        emp.punchOut(12.0); //4 hours

        emp.punchIn(13.0);
        emp.punchOut(17.0); //another 4 hours

        //Assert, total should be 8 hours
        assertEquals(8.0, emp.getHoursWorked(), 0.001);
    }
}
