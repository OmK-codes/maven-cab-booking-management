CREATE TABLE passenger (
    passenger_id VARCHAR(50) PRIMARY KEY,
    passenger_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    address TEXT,
    passenger_status ENUM('ACTIVE', 'INACTIVE')
);
INSERT INTO passenger (passenger_id, passenger_name, email, phone, address, passenger_status)
VALUES
('P-001', 'John Doe', 'johndoe@example.com', '123-456-7890', '123 Main St, City A', 'ACTIVE'),
('P-002', 'Jane Smith', 'janesmith@example.com', '234-567-8901', '456 Elm St, City B', 'INACTIVE'),
('P-003', 'Robert Brown', 'robertbrown@example.com', '345-678-9012', '789 Pine St, City C', 'ACTIVE'),
('P-004', 'Alice Johnson', 'alicejohnson@example.com', '456-789-0123', '321 Oak St, City D', 'ACTIVE'),
('P-005', 'James White', 'jameswhite@example.com', '567-890-1234', '654 Cedar St, City E', 'INACTIVE'),
('P-006', 'Olivia Harris', 'oliviaharris@example.com', '678-901-2345', '987 Birch St, City F', 'ACTIVE'),
('P-007', 'Daniel Clark', 'danielclark@example.com', '789-012-3456', '147 Walnut St, City G', 'INACTIVE'),
('P-008', 'Sophia Lewis', 'sophialewis@example.com', '890-123-4567', '258 Maple St, City H', 'ACTIVE'),
('P-009', 'William Martinez', 'williammartinez@example.com', '901-234-5678', '369 Spruce St, City I', 'ACTIVE'),
('P-010', 'Ethan Anderson', 'ethananderson@example.com', '012-345-6789', '741 Palm St, City J', 'INACTIVE'),
('P-011', 'Emma Thomas', 'emmathomas@example.com', '123-456-7899', '852 Fir St, City K', 'ACTIVE'),
('P-012', 'Alexander Moore', 'alexmoore@example.com', '234-567-8909', '963 Chestnut St, City L', 'INACTIVE'),
('P-013', 'John Carter', 'johncarter@example.com', '345-678-9019', '159 Redwood St, City M', 'ACTIVE'),
('P-014', 'Sophia Miller', 'sophiamiller@example.com', '456-789-0129', '753 Sycamore St, City N', 'INACTIVE'),
('P-015', 'Benjamin Hall', 'benjaminhall@example.com', '567-890-1239', '951 Aspen St, City O', 'ACTIVE');
