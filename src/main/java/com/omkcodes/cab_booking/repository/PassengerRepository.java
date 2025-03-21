package com.omkcodes.cab_booking.repository;
import com.omkcodes.cab_booking.model.Passenger;
import java.util.HashMap;
import java.util.Map;

public class PassengerRepository {
    private final Map<String, Passenger> passengerDatabase = new HashMap<>();
    public void savePassenger(Passenger passenger) {
        passengerDatabase.put(passenger.getPassengerId(), passenger);
    }
    public Passenger findPassengerById(String passengerId) {
        return passengerDatabase.get(passengerId);
    }
    public Map<String, Passenger> getAllPassengers() {
        return passengerDatabase;
    }
    public void deletePassenger(String passengerId) {
        passengerDatabase.remove(passengerId);
    }
}
