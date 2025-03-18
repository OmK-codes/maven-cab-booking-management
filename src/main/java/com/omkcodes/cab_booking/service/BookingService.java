package com.omkcodes.cab_booking.service;

import com.omkcodes.cab_booking.enums.BookingStatus;
import com.omkcodes.cab_booking.exception.InvalidBookingIDException;
import com.omkcodes.cab_booking.model.Booking;

import java.util.List;

public interface BookingService {
    void displayBookingDetails(Booking booking);

    Booking createNewBooking(String bookingId, String passengerId, String passengerName,
                             String driverId, String driverName, String vehicleId,
                             String pickupLocation, String dropLocation, double fare,
                             double distance, String statusInput) throws InvalidBookingIDException;

    void showAllBookings();

    Booking updateBookingStatus(String bookingId, BookingStatus newStatus) throws InvalidBookingIDException;

    Booking getBookingById(String bookingId) throws InvalidBookingIDException;

    List<String> getAllBookingIds();

    List<Booking> getBookingsByStatus(BookingStatus status);
}