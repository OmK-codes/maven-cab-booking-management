package com.omkcodes.cab_booking.service.impl;

import com.omkcodes.cab_booking.enums.BookingStatus;
import com.omkcodes.cab_booking.exception.InvalidBookingIDException;
import com.omkcodes.cab_booking.model.Booking;
import com.omkcodes.cab_booking.service.BookingService;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final HashMap<String, Booking> bookingList = new HashMap<>();
    @Override
    public void displayBookingDetails(Booking booking) {
        Optional.ofNullable(booking)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Booking details are not available."));
    }
    @Override
    public Booking createNewBooking(String bookingId, String passengerId, String passengerName,
                                    String driverId, String driverName, String vehicleId,
                                    String pickupLocation, String dropLocation, double fare,
                                    double distance, String statusInput) throws InvalidBookingIDException {

        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new InvalidBookingIDException("Booking ID cannot be null or empty.");
        }

        return bookingList.computeIfAbsent(bookingId, id -> {
            Booking booking = new Booking();
            BookingStatus bookingStatus = BookingStatus.PENDING;

            try {
                bookingStatus = BookingStatus.valueOf(statusInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid booking status! Setting default to PENDING.");
            }

            booking.setBookingId(id);
            booking.setPassengerId(passengerId);
            booking.setPassengerName(passengerName);
            booking.setDriverId(driverId);
            booking.setDriverName(driverName);
            booking.setVehicleId(vehicleId);
            booking.setPickupLocation(pickupLocation);
            booking.setDropLocation(dropLocation);
            booking.setFare(fare);
            booking.setDistance(distance);
            booking.setStatus(bookingStatus);
            return booking;
        });
    }

    @Override
    public Booking updateBookingStatus(String bookingId, BookingStatus newStatus) throws InvalidBookingIDException {
        if (!bookingList.containsKey(bookingId)) {
            throw new InvalidBookingIDException("Booking not found with ID: " + bookingId);
        }
        Booking booking = bookingList.get(bookingId);
        booking.setStatus(newStatus);
        return booking;
    }

    @Override
    public void showAllBookings() {
        if (bookingList.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            bookingList.values().forEach(System.out::println);
        }
    }

    @Override
    public Booking getBookingById(String bookingId) throws InvalidBookingIDException {
        if (!bookingList.containsKey(bookingId)) {
            throw new InvalidBookingIDException("Booking not found with ID: " + bookingId);
        }
        return bookingList.get(bookingId);
    }

    @Override
    public List<String> getAllBookingIds() {
        return bookingList.values().stream()
                .map(Booking::getBookingId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingList.values().stream()
                .filter(booking -> Objects.equals(booking.getStatus(), status))
                .collect(Collectors.toList());
    }
}
