# Cab-booking-management.

## **Project Overview**
The Core Java  Cab Booking Management Project is a straightforward Java application that demonstrates a
cab booking management system. It uses object-oriented programming principles to model the interactions between passengers, drivers, vehicles, and bookings.

## **Features**
- **Manage bookings for passengers and drivers.**
- **Assign drivers automatically based on proximity and availability.**
- **Track ride status and payment processing.**
- **Simple, intuitive structure to demonstrate key Java concepts.**

## **Installation and Setup**
- Prerequisites
- Java Development Kit (JDK) 21.
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- Git (optional, for version control).

## **Steps**
- Clone the repository:
- hashmap-cab-booking-management
- Navigate to the project directory:
- cd hashmap-cab-booking-management.
- Open the project in your preferred IDE.
- Compile and run the application:
- Locate CabBookingManagement.java
- Run the file to start the application.
---
## **Code Structure**
### **Package Structure**
```plaintext
com.omkcodes.cab_booking
│── model
│   ├── Booking.java
│   ├── Driver.java
│   ├── Passenger.java
│   ├── Vehicle.java
│
│── service
│   ├── BookingService.java
│   ├── DriverService.java
│   ├── PassengerService.java
│   ├── VehicleService.java
│
│── enums
│   ├── BookingStatus.java
│   ├── DriverStatus.java
│   ├── PassengerStatus.java
│   ├── VehicleStatus.java
│
│── controller
│   ├── BookingController.java
│   ├── DriverController.java
│   ├── PassengerController.java
│   ├── VehicleController.java
│
│── exception
│   ├── CabBookingException.java
│   ├── InvalidBookingIDException.java
│   ├── InvalidDriverIDException.java
│   ├── InvalidPassengerIDException.java
│   ├── InvalidVehicleIDException.java
│
│── main
│   ├── CabBookingManagement.java
```
---
## **Database Schema (POJO Classes)**
| **Entity**     | **Attributes**                                                    |
|---------------|------------------------------------------------------------------|
| **Passenger**  | passengerId, passengerName, email, phone, address, passengerStatus |
| **Driver**     | driverId, driverName, phone, licenseNumber, totalTrips, onlineStatus, driverStatus |
| **Vehicle**    | vehicleId, model, registrationNumber, color, available, seatCapacity, perKmRate, vehicleStatus |
| **Booking**    | bookingId, passengerId, passengerName, driverId, driverName, vehicleId, pickupLocation, dropLocation, fare, distance, status |

---
## **Class Diagram of Cab Booking Management (Mermaid.js)**
```mermaid
classDiagram
    Passenger <|-- Booking
    Driver <|-- Booking
    Vehicle <|-- Booking

    class Passenger {
      +int id
      +String name
      +String contact
      +String email
      +bookRide()
      +cancelRide()
    }

    class Driver {
      +int id
      +String name
      +String licenseNo
      +String status
      +acceptRide()
      +rejectRide()
      +updateStatus()
    }

    class Vehicle {
      +int id
      +String model
      +String plateNumber
      +String status
      +assignDriver()
      +updateStatus()
    }

    class Booking {
      +int id
      +DateTime bookingTime
      +String status
      +confirmBooking()
      +cancelBooking()
      +assignDriver()
    }

    Passenger --> Booking : "books"
    Booking --> Driver : "assigned to"
    Driver --> Vehicle : "drives"
    Vehicle --> Booking : "used in"

