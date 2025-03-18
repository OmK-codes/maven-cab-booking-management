package com.omkcodes.cab_booking.service;
import com.omkcodes.cab_booking.enums.PassengerStatus;
import com.omkcodes.cab_booking.exception.InvalidPassengerIDException;
import com.omkcodes.cab_booking.model.Passenger;
import java.util.List;
import java.util.Map;

public interface PassengerService {
    void displayPassengerDetails(Passenger passenger);
    List<Passenger> getPassengersByStatus(PassengerStatus status);
    List<String> getAllPassengerNames();
    void showAllPassengers();
    Map<String, Passenger> getPassengerList();
    Passenger createNewPassenger(String passengerId, String passengerName, String phone, String email, String statusInput) throws InvalidPassengerIDException;
}
