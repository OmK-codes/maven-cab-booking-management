package com.omkcodes.cab_booking.service.impl;

import com.omkcodes.cab_booking.model.Driver;
import com.omkcodes.cab_booking.repository.DriverRepository;
import com.omkcodes.cab_booking.service.DriverService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository = new DriverRepository();

    @Override
    public Driver createNewDriver(String driverId, String driverName, String phone,
                                  String licenseNumber, int totalTrips, boolean onlineStatus,
                                  String statusInput) {
        Driver driver = new Driver(driverId, driverName, phone, licenseNumber, totalTrips, onlineStatus, null);
        driverRepository.saveDriver(driver);
        return driver;
    }

    @Override
    public void showAllDrivers() {
        Map<String, Driver> drivers = driverRepository.getAllDrivers();
        if (drivers.isEmpty()) {
            System.out.println("No drivers found.");
        } else {
            drivers.values().forEach(System.out::println);
        }
    }

    @Override
    public List<Driver> getOnlineDrivers() {
        return driverRepository.getAllDrivers().values().stream()
                .filter(Driver::isOnlineStatus)
                .collect(Collectors.toList());
    }

    @Override
    public List<Driver> getTopDriversByTrips(int limit) {
        return driverRepository.getAllDrivers().values().stream()
                .sorted((d1, d2) -> Integer.compare(d2.getTotalTrips(), d1.getTotalTrips()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Driver> getDriverList() {
        return driverRepository.getAllDrivers();
    }

    @Override
    public void displayDriverDetails(Driver driver) {
        if (driver != null) {
            System.out.println(driver);
        } else {
            System.out.println("Driver not found!");
        }
    }
}
