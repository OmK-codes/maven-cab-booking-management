CREATE TABLE booking (
    booking_id VARCHAR(50) PRIMARY KEY,
    passenger_id VARCHAR(50),
    passenger_name VARCHAR(100),
    driver_id VARCHAR(50),
    driver_name VARCHAR(100),
    vehicle_id VARCHAR(50),
    pickup_location VARCHAR(255),
    drop_location VARCHAR(255),
    fare DOUBLE,
    distance DOUBLE,
    status ENUM('PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED')
);
INSERT INTO booking (booking_id, passenger_id, passenger_name, driver_id, driver_name, vehicle_id, pickup_location, drop_location, fare, distance, status)
VALUES
('B-001', 'P-001', 'John Doe', 'D-001', 'Michael Johnson', 'V-001', 'Downtown', 'Airport', 25.50, 10.2, 'CONFIRMED'),
('B-002', 'P-002', 'Jane Smith', 'D-002', 'Emily Davis', 'V-002', 'Mall', 'Train Station', 18.75, 7.8, 'COMPLETED'),
('B-003', 'P-003', 'Robert Brown', 'D-003', 'David Wilson', 'V-003', 'Hotel', 'University', 22.00, 9.1, 'PENDING'),
('B-004', 'P-004', 'Alice Johnson', 'D-004', 'Sarah Brown', 'V-004', 'Park', 'Office', 15.30, 5.4, 'CANCELLED'),
('B-005', 'P-005', 'James White', 'D-005', 'Daniel Lee', 'V-005', 'Library', 'Museum', 20.60, 8.5, 'CONFIRMED'),
('B-006', 'P-006', 'Olivia Harris', 'D-006', 'Laura Harris', 'V-006', 'Supermarket', 'Hospital', 17.40, 6.2, 'COMPLETED'),
('B-007', 'P-007', 'Daniel Clark', 'D-007', 'Andrew Scott', 'V-007', 'Stadium', 'Cinema', 30.00, 12.3, 'CONFIRMED'),
('B-008', 'P-008', 'Sophia Lewis', 'D-008', 'Olivia Lewis', 'V-008', 'Gym', 'Restaurant', 12.90, 4.7, 'PENDING'),
('B-009', 'P-009', 'William Martinez', 'D-009', 'Ethan Walker', 'V-009', 'Bank', 'Shopping Center', 28.50, 11.4, 'CANCELLED'),
('B-010', 'P-010', 'Ethan Anderson', 'D-010', 'Sophia Anderson', 'V-010', 'Bus Stop', 'Train Station', 19.80, 7.2, 'COMPLETED'),
('B-011', 'P-011', 'Emma Thomas', 'D-011', 'Ethan Thomas', 'V-011', 'High School', 'College', 21.30, 8.9, 'CONFIRMED'),
('B-012', 'P-012', 'Alexander Moore', 'D-012', 'Emma Taylor', 'V-012', 'Beach', 'Resort', 35.00, 14.5, 'COMPLETED'),
('B-013', 'P-013', 'John Carter', 'D-013', 'Alexander Moore', 'V-013', 'Residential Area', 'Business Center', 24.60, 10.0, 'PENDING'),
('B-014', 'P-014', 'Sophia Miller', 'D-014', 'John Carter', 'V-014', 'Factory', 'Warehouse', 26.75, 10.8, 'CANCELLED'),
('B-015', 'P-015', 'Benjamin Hall', 'D-015', 'Sophia Miller', 'V-015', 'School', 'Playground', 16.50, 6.0, 'CONFIRMED');
