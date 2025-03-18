package com.omkcodes.cab_booking.service.impl;

import com.omkcodes.cab_booking.enums.DriverStatus;
import com.omkcodes.cab_booking.model.Driver;
import com.omkcodes.cab_booking.service.DriverService;

import java.util.*;
import java.util.stream.Collectors;

public class DriverServiceImpl implements DriverService {
    private final Map<String, Driver> driverList = new HashMap<>();

    @Override
    public void displayDriverDetails(Driver driver) {
        Optional.ofNullable(driver)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Driver details are not available."));
    }

    @Override
    public Driver createNewDriver(String driverId, String driverName, String phone,
                                  String licenseNumber, int totalTrips, boolean onlineStatus,
                                  String statusInput) {
        if (driverId == null || driverId.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver ID cannot be null or empty.");
        }
        return driverList.computeIfAbsent(driverId, id -> {
            DriverStatus driverStatus = DriverStatus.INACTIVE;
            try {
                driverStatus = DriverStatus.valueOf(statusInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid driver status! Setting default to INACTIVE.");
            }

            return new Driver(id, driverName, phone, licenseNumber, totalTrips, onlineStatus, driverStatus);
        });
    }

    @Override
    public void showAllDrivers() {
        if (driverList.isEmpty()) {
            System.out.println("No drivers available.");
        } else {
            driverList.values().forEach(System.out::println);
        }
    }

    @Override
    public List<Driver> getOnlineDrivers() {
        return driverList.values().stream()
                .filter(Driver::isOnlineStatus)
                .collect(Collectors.toList());
    }

    @Override
    public List<Driver> getTopDriversByTrips(int limit) {
        return driverList.values().stream()
                .sorted(Comparator.comparingInt(Driver::getTotalTrips).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Driver> getDriverList() {
        return driverList;
    }
}