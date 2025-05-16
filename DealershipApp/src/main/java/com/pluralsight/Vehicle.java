package com.pluralsight;
//Information that describe the vehicle
public class Vehicle {
    // Fields that describe the vehicle
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    //Creating constructor to create a new Vehicle object with all its data
    public Vehicle(int vin, int year, String make, String model, String vehicleType,
                   String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    //Getters (we use these to access private data safely)
    public int getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getVehicleType() { return vehicleType; }
    public String getColor() { return color; }
    public int getOdometer() { return odometer; }
    public double getPrice() { return price; }

    //Converts the vehicle object into a readable string for display
    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + vehicleType + "), " +
                "Color: " + color + ", Odometer: " + odometer + " miles, $" + price;
    }
}

