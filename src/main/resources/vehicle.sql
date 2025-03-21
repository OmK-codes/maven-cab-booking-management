CREATE TABLE vehicle (
    vehicle_id VARCHAR(50) PRIMARY KEY,
    model VARCHAR(50),
    registration_number VARCHAR(20),
    color VARCHAR(20),
    available TINYINT(1),
    seat_capacity INT,
    per_km_rate DOUBLE,
    status ENUM('AVAILABLE', 'IN_USE', 'UNDER_MAINTENANCE')
);
INSERT INTO vehicle (vehicle_id, model, registration_number, color, available, seat_capacity, per_km_rate, status)
VALUES
('V-001', 'Toyota Prius', 'ABC-1234', 'White', 1, 4, 10.5, 'AVAILABLE'),
('V-002', 'Honda Civic', 'XYZ-5678', 'Black', 0, 4, 9.8, 'IN_USE'),
('V-003', 'Ford Focus', 'LMN-9101', 'Red', 1, 4, 11.2, 'AVAILABLE'),
('V-004', 'Hyundai Elantra', 'JKL-2345', 'Blue', 1, 4, 10.0, 'UNDER_MAINTENANCE'),
('V-005', 'Tesla Model 3', 'TES-6789', 'Silver', 1, 4, 12.0, 'AVAILABLE'),
('V-006', 'Chevrolet Malibu', 'MNO-3456', 'Gray', 0, 4, 9.5, 'IN_USE'),
('V-007', 'BMW 3 Series', 'BMW-7890', 'Black', 1, 4, 14.5, 'AVAILABLE'),
('V-008', 'Mercedes-Benz C-Class', 'MBZ-4567', 'White', 0, 4, 15.0, 'UNDER_MAINTENANCE'),
('V-009', 'Audi A4', 'AUD-6789', 'Blue', 1, 4, 13.2, 'AVAILABLE'),
('V-010', 'Kia Optima', 'KIA-9876', 'Red', 1, 4, 10.3, 'IN_USE'),
('V-011', 'Volkswagen Jetta', 'VW-5432', 'Gray', 0, 4, 9.7, 'AVAILABLE'),
('V-012', 'Nissan Altima', 'NIS-3452', 'Silver', 1, 4, 11.8, 'AVAILABLE'),
('V-013', 'Mazda 6', 'MAZ-2341', 'White', 1, 4, 10.6, 'IN_USE'),
('V-014', 'Subaru Impreza', 'SUB-7891', 'Blue', 0, 4, 10.1, 'UNDER_MAINTENANCE'),
('V-015', 'Lexus ES', 'LEX-6781', 'Black', 1, 4, 14.0, 'AVAILABLE');
