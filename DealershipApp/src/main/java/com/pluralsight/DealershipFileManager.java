package com.pluralsight;

import java.io.*;
import java.util.Scanner;

//This class is responsible for reading and saving dealership info to a file
public class DealershipFileManager {

    //This method reads the inventory file and builds a Dealership object
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            //Open the inventory.csv file for reading
            File file = new File("inventory.csv");
            Scanner scanner = new Scanner(file);

            //Read the first line, dealership info
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                //Create a Dealership object with the data
                dealership = new Dealership(name, address, phone);
            }

            //Read the rest of the lines each line is a vehicle
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: inventory.csv file not found.");
            e.printStackTrace();
        }

        return dealership;
    }
}