package com.pluralsight;

import java.util.ArrayList;
import java.util.List
import java.util.Scanner;

//Holds dealership details and list of vehicles
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    //Contructor to create new dealship with the info
    public Dealership(String name, Scanner address,String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>()//Creates new Inventory list
    }
    //Getters
    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
    //Method to add vehicle to the dealership inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    //Method to return the vehicle list
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

}
