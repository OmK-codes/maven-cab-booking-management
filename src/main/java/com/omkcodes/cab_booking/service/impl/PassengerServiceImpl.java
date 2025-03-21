package com.omkcodes.cab_booking.service.impl;

import com.omkcodes.cab_booking.enums.PassengerStatus;
import com.omkcodes.cab_booking.exception.InvalidPassengerIDException;
import com.omkcodes.cab_booking.model.Passenger;
import com.omkcodes.cab_booking.repository.PassengerRepository;
import com.omkcodes.cab_booking.service.PassengerService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository = new PassengerRepository();

    @Override
    public void displayPassengerDetails(Passenger passenger) {
        if (passenger != null) {
            System.out.println("Passenger Details: " + passenger);
        } else {
            System.out.println("Passenger details not available.");
        }
    }

    @Override
    public List<Passenger> getPassengersByStatus(PassengerStatus status) {
        return passengerRepository.getAllPassengers().values().stream()
                .filter(passenger -> passenger.getPassengerStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllPassengerNames() {
        return passengerRepository.getAllPassengers().values().stream()
                .map(Passenger::getPassengerName)
                .collect(Collectors.toList());
    }

    @Override
    public void showAllPassengers() {
        Map<String, Passenger> passengers = passengerRepository.getAllPassengers();
        if (passengers.isEmpty()) {
            System.out.println("No passengers found.");
        } else {
            passengers.values().forEach(System.out::println);
        }
    }

    @Override
    public Map<String, Passenger> getPassengerList() {
        return passengerRepository.getAllPassengers();
    }
    @Override
    public Passenger createNewPassenger(String passengerId, String passengerName, String phone, String email, String statusInput)
            throws InvalidPassengerIDException {
        if (passengerId == null || passengerId.isEmpty()) {
            throw new InvalidPassengerIDException("Passenger ID cannot be null or empty.");
        }
        if (passengerRepository.findPassengerById(passengerId) != null) {
            throw new InvalidPassengerIDException("Passenger with ID " + passengerId + " already exists.");
        }
        PassengerStatus status;
        try {
            status = PassengerStatus.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidPassengerIDException("Invalid Passenger Status: " + statusInput);
        }

        Passenger newPassenger = new Passenger(passengerId, passengerName, email, phone, "N/A", status);
        passengerRepository.savePassenger(newPassenger);
        System.out.println("Passenger created successfully!");
        return newPassenger;
    }
}
