package com.omkcodes.cab_booking.service;

import com.omkcodes.cab_booking.model.Driver;
import java.util.List;
import java.util.Map;

public interface DriverService {
    Driver createNewDriver(String driverId, String driverName, String phone,
                           String licenseNumber, int totalTrips, boolean onlineStatus,
                           String statusInput);

    void showAllDrivers();

    List<Driver> getOnlineDrivers();

    List<Driver> getTopDriversByTrips(int limit);

    Map<String, Driver> getDriverList();

    void displayDriverDetails(Driver driver);
}
