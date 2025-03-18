package com.omkcodes.cab_booking.service;

import com.omkcodes.cab_booking.exception.InvalidVehicleIDException;
import com.omkcodes.cab_booking.model.Vehicle;

import java.util.Map;

public interface VehicleService {
    Vehicle createNewVehicle(String vehicleId, String model, String registrationNumber,
                             String color, boolean availability, int seatCapacity,
                             double perKmRate, String status) throws InvalidVehicleIDException;

    void showAllVehicles();

    void displayVehicleDetails(Vehicle vehicle);

    Map<String, Vehicle> getVehicleList();
}
