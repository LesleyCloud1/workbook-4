package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    //This method starts the app, shows menu and handles user input.
    public void display() {
        init();//load dealership data

        Scanner scanner = new Scanner(System.in);
        int command = 0;

        while (command != 99) {
            displayMenu();//Show menu options
            System.out.print("enter command: ");
            command = scanner.nextInt();

            //Decide what to do based on user command.
            switch (command) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processAllVehiclesRequest();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command, try again!");
            }
        }
    }
    // Search vehicles by price range
        private void processGetByPriceRequest() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter minimum price: ");
            double min = scanner.nextDouble();
            System.out.print("Enter maximum price: ");
            double max = scanner.nextDouble();

            //Get vehicles by the price range and display
            List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
            displayVehicles(results);
    }
    //Loads the dealership from file
    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    //Prints all vehicles returned from getAllVehicles
    private void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    //Displays a list of vehicles nicely
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v); //uses Vehicle's toString()
            }
        }
    }

    //Shows the command menu
    private void displayMenu() {
        System.out.println("\n---- Dealership Menu ----");
        System.out.println("1 - Find vehicles by price range");
        System.out.println("2 - List all vehicles");
        System.out.println("3 - Quit");
    }
}
