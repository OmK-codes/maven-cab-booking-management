package com.omkcodes.cab_booking.repository;
import com.omkcodes.cab_booking.model.Vehicle;
import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private final Map<String, Vehicle> vehicleDatabase = new HashMap<>();
    public void saveVehicle(Vehicle vehicle) {
        vehicleDatabase.put(vehicle.getVehicleId(), vehicle);
    }
    public Vehicle findVehicleById(String vehicleId) {
        return vehicleDatabase.get(vehicleId);
    }
    public Map<String, Vehicle> getAllVehicles() {
        return vehicleDatabase;
    }
    public void deleteVehicle(String vehicleId) {
        vehicleDatabase.remove(vehicleId);
    }
}