CREATE TABLE driver (
    driver_id VARCHAR(50) PRIMARY KEY,
    driver_name VARCHAR(100),
    phone VARCHAR(15),
    license_number VARCHAR(50),
    total_trips INT,
    online_status ENUM('ONLINE', 'OFFLINE'),
    driver_status ENUM('AVAILABLE', 'ON_TRIP', 'INACTIVE')
);
INSERT INTO driver (driver_id, driver_name, phone, license_number, total_trips, online_status, driver_status)
VALUES
('D-001', 'Michael Johnson', '345-678-9012', 'DL123456', 120, 'ONLINE', 'AVAILABLE'),
('D-002', 'Emily Davis', '456-789-0123', 'DL789012', 95, 'ONLINE', 'ON_TRIP'),
('D-003', 'David Wilson', '567-890-1234', 'DL345678', 150, 'OFFLINE', 'INACTIVE'),
('D-004', 'Sarah Brown', '678-901-2345', 'DL567890', 85, 'ONLINE', 'ON_TRIP'),
('D-005', 'James White', '789-012-3456', 'DL789123', 200, 'ONLINE', 'AVAILABLE'),
('D-006', 'Laura Harris', '890-123-4567', 'DL901234', 60, 'OFFLINE', 'INACTIVE'),
('D-007', 'Daniel Clark', '901-234-5678', 'DL112233', 175, 'ONLINE', 'AVAILABLE'),
('D-008', 'Olivia Lewis', '012-345-6789', 'DL445566', 90, 'ONLINE', 'ON_TRIP'),
('D-009', 'William Martinez', '111-222-3333', 'DL778899', 130, 'OFFLINE', 'INACTIVE'),
('D-010', 'Sophia Anderson', '222-333-4444', 'DL990011', 140, 'ONLINE', 'AVAILABLE'),
('D-011', 'Ethan Thomas', '333-444-5555', 'DL223344', 80, 'ONLINE', 'ON_TRIP'),
('D-012', 'Emma Taylor', '444-555-6666', 'DL556677', 50, 'OFFLINE', 'INACTIVE'),
('D-013', 'Alexander Moore', '555-666-7777', 'DL889900', 160, 'ONLINE', 'AVAILABLE'),
('D-014', 'John Carter', '666-777-8888', 'DL112244', 110, 'ONLINE', 'ON_TRIP'),
('D-015', 'Sophia Miller', '777-888-9999', 'DL334455', 145, 'OFFLINE', 'INACTIVE');
