package com.omkcodes.cab_booking.repository;

import com.omkcodes.cab_booking.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private final Map<String, Booking> bookingDatabase = new HashMap<>();

    public void saveBooking(Booking booking) {
        bookingDatabase.put(booking.getBookingId(), booking);
    }

    public Booking findBookingById(String bookingId) {
        return bookingDatabase.get(bookingId);
    }

    public Map<String, Booking> getAllBookings() {
        return bookingDatabase;
    }

    public boolean deleteBooking(String bookingId) {
        if (bookingDatabase.containsKey(bookingId)) {
            bookingDatabase.remove(bookingId);
            return true;
        }
        return false;
    }
}