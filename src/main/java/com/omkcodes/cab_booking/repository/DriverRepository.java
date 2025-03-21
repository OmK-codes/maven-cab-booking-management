package com.omkcodes.cab_booking.repository;
import com.omkcodes.cab_booking.model.Driver;
import java.util.HashMap;
import java.util.Map;

public class DriverRepository {
    private final Map<String, Driver> driverDatabase = new HashMap<>();

    public void saveDriver(Driver driver) {
        driverDatabase.put(driver.getDriverId(), driver);
    }
    public Driver findDriverById(String driverId) {
        return driverDatabase.get(driverId);
    }
    public Map<String, Driver> getAllDrivers() {
        return driverDatabase;
    }
    public void deleteDriver(String driverId) {
        driverDatabase.remove(driverId);
    }
}
