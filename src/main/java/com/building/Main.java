package com.building;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Building building = new Building(25.0);

        // Initial setup
        building.addRoom(new Apartment("101", "Can Kurt", 1.0, 1.0, 0.9));
        building.addRoom(new Apartment("102", "Ali Yilmaz", 1.0, 1.0, 0.9));
        building.addRoom(new CommonRoom("Gym1", "Gym", 1.0, 1.0, 0.9));
        building.addRoom(new CommonRoom("Library1", "Library", 1.0, 1.0, 0.9));

        System.out.println("Initial Room Statuses:");
        building.printRoomStatuses();

        // Start the temperature update scheduler
        building.startTemperatureUpdateScheduler();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a command (set-temp, add-room, quit): ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                break;
            } else if (command.equalsIgnoreCase("set-temp")) {
                System.out.print("Enter new requested temperature: ");
                try {
                    double newTemperature = Double.parseDouble(scanner.nextLine());
                    building.setRequestedTemperature(newTemperature);
                    System.out.println("Updated Room Statuses:");
                    building.printRoomStatuses();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            } else if (command.equalsIgnoreCase("add-room")) {
                System.out.print("Enter room type (apartment/common): ");
                String roomType = scanner.nextLine();
                if (roomType.equalsIgnoreCase("apartment")) {
                    System.out.print("Enter apartment ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("Enter tolerance: ");
                    double tolerance = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter initial rate: ");
                    double initialRate = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter decay factor: ");
                    double decayFactor = Double.parseDouble(scanner.nextLine());
                    building.addRoom(new Apartment(id, ownerName, tolerance, initialRate, decayFactor));
                } else if (roomType.equalsIgnoreCase("common")) {
                    System.out.print("Enter common room ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter room type (Gym/Library/Laundry): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter tolerance: ");
                    double tolerance = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter initial rate: ");
                    double initialRate = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter decay factor: ");
                    double decayFactor = Double.parseDouble(scanner.nextLine());
                    building.addRoom(new CommonRoom(id, type, tolerance, initialRate, decayFactor));
                } else {
                    System.out.println("Invalid room type.");
                }
            } else {
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }
}