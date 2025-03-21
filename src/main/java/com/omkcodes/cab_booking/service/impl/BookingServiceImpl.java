package com.omkcodes.cab_booking.service.impl;

import com.omkcodes.cab_booking.enums.BookingStatus;
import com.omkcodes.cab_booking.exception.InvalidBookingIDException;
import com.omkcodes.cab_booking.model.Booking;
import com.omkcodes.cab_booking.repository.BookingRepository;
import com.omkcodes.cab_booking.service.BookingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository = new BookingRepository();

    @Override
    public void displayBookingDetails(Booking booking) {
        if (booking != null) {
            System.out.println("Booking Details: " + booking);
        } else {
            System.out.println("Booking details are not available.");
        }
    }

    @Override
    public Booking createNewBooking(String bookingId, String passengerId, String passengerName,
                                    String driverId, String driverName, String vehicleId,
                                    String pickupLocation, String dropLocation, double fare,
                                    double distance, String statusInput) throws InvalidBookingIDException {

        BookingStatus status;
        try {
            status = BookingStatus.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidBookingIDException("Invalid booking status: " + statusInput);
        }

        Booking booking = new Booking(bookingId, passengerId, passengerName, driverId, driverName,
                vehicleId, pickupLocation, dropLocation, fare, distance, status);

        bookingRepository.saveBooking(booking);
        System.out.println("Booking created successfully!");
        return booking;
    }

    @Override
    public void showAllBookings() {
        Map<String, Booking> bookings = bookingRepository.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            bookings.values().forEach(System.out::println);
        }
    }

    @Override
    public Booking updateBookingStatus(String bookingId, BookingStatus newStatus) throws InvalidBookingIDException {
        Booking booking = bookingRepository.findBookingById(bookingId);
        if (booking == null) {
            throw new InvalidBookingIDException("Booking ID not found: " + bookingId);
        }
        booking.setStatus(newStatus);
        bookingRepository.saveBooking(booking);
        System.out.println("Booking status updated successfully!");
        return booking;
    }

    @Override
    public Booking getBookingById(String bookingId) throws InvalidBookingIDException {
        Booking booking = bookingRepository.findBookingById(bookingId);
        if (booking == null) {
            throw new InvalidBookingIDException("No booking found with ID: " + bookingId);
        }
        return booking;
    }

    @Override
    public List<String> getAllBookingIds() {
        return new ArrayList<>(bookingRepository.getAllBookings().keySet());
    }

    @Override
    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.getAllBookings().values()
                .stream()
                .filter(booking -> booking.getStatus() == status)
                .collect(Collectors.toList());
    }
}
