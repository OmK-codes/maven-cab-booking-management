package com.omkcodes.cab_booking;

import com.omkcodes.cab_booking.controller.BookingController;
import com.omkcodes.cab_booking.controller.DriverController;
import com.omkcodes.cab_booking.controller.PassengerController;
import com.omkcodes.cab_booking.controller.VehicleController;
import com.omkcodes.cab_booking.service.impl.BookingServiceImpl;
import com.omkcodes.cab_booking.service.impl.DriverServiceImpl;
import com.omkcodes.cab_booking.service.impl.PassengerServiceImpl;
import com.omkcodes.cab_booking.service.impl.VehicleServiceImpl;

import java.util.Scanner;

public class CabBookingManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DriverServiceImpl driverService = new DriverServiceImpl();
        PassengerServiceImpl passengerService = new PassengerServiceImpl();
        VehicleServiceImpl vehicleService = new VehicleServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl();
        DriverController driverController = new DriverController(scanner, driverService);
        PassengerController passengerController = new PassengerController(scanner, passengerService);
        VehicleController vehicleController = new VehicleController(scanner, vehicleService);
        BookingController bookingController = new BookingController(scanner, bookingService);
        int mainOption;
        do {
            displayMainMenu();
            mainOption = getIntInput(scanner, "Select an option: ");
            switch (mainOption) {
                case 1 -> driverController.run();
                case 2 -> passengerController.run();
                case 3 -> vehicleController.run();
                case 4 -> bookingController.run();
                case 0 -> System.out.println("Exiting... Thank you for using Cab Booking Management!");
                default -> System.out.println("Invalid option, please try again.");
            }
        } while (mainOption != 0);
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== CAB BOOKING MANAGEMENT ===");
        System.out.println("1. Manage Drivers");
        System.out.println("2. Manage Passengers");
        System.out.println("3. Manage Vehicles");
        System.out.println("4. Manage Bookings");
        System.out.println("0. Exit");
    }

    private static int getIntInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}
