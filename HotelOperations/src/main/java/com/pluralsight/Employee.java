package com.pluralsight;
import java.time.LocalDateTime;

public class Employee {
    private int id;              //Employee ID
    private String name;         //Name of employee
    private String department;   //Department employee is working
    private double payRate;      //Hourly wage
    private double hoursWorked;  //Total hours worked
    private Double startTime;    //Time when the employee last punched in (decimal)

    //Constructor to set up employee
    public Employee(int id, String name, String department, double payRate, double hoursWorked) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = null; //Not clocked in
    }

    //This method saves punching time with manual time
    public void punchIn(double time) {
        startTime = time;
        System.out.println(name + " punched in at " + time);
    }

    //Punch in using the system clock
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now(); //Get current date and time
        double time = now.getHour() + now.getMinute() / 60.0; //Convert to decimal
        startTime = time;
        System.out.println(name + " automatically punched in at " + time);
    }

    //Punch out using a manual time
    public void punchOut(double time) {
        if (startTime != null) {
            double hours = time - startTime;       //Time worked = end - start
            hoursWorked += hours;                  //Add to total hours worked
            System.out.println(name + " manually punched out at " + time + ", worked " + hours + " hours.");
            startTime = null;                      //Reset clock-in time
        } else {
            System.out.println("Employee must punch in before punching out.");
        }
    }

    //Punch out using system clock
    // Punch out using system clock
    public void punchOut() {
        if (startTime != null) {
            LocalDateTime now = LocalDateTime.now(); // Get current time
            double endTime = now.getHour() + now.getMinute() / 60.0;
            double hours = endTime - startTime;
            hoursWorked += hours;
            System.out.println(name + " automatically punched out at " + endTime + ", worked " + hours + " hours.");
            startTime = null;
        } else {
            System.out.println("Error: Must punch in before punching out.");
        }
    }
    // Combines punch in/out in one method
    public void punchTimeCard(double time) {
        if (startTime == null) {
            punchIn(time); // If not clocked in, punch in
        } else {
            punchOut(time); // Otherwise, punch out
        }
    }

    // Get how much money the employee has earned
    public double getTotalPay() {
        return payRate * hoursWorked;
    }

    // Total number of hours worked
    public double getHoursWorked() {
        return hoursWorked;
    }
    //Getter for employee name
    public String getName() {
        return name;
    }
}
