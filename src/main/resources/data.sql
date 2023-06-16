-- Insert 10 random values into the televisions table
INSERT INTO televisions (id, type, brand, name, price, refresh_rate, available_size, screen_type, screen_quality,
                         smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold)
VALUES (101, 'LED', 'Samsung', 'Samsung Smart TV', 699.99, 60.0, 55.0, 'LCD', '4K Ultra HD', true, true, false, true,
        true, false, 50, 20),
       (102, 'OLED', 'LG', 'LG OLED TV', 1499.99, 120.0, 65.0, 'OLED', '4K Ultra HD', true, true, true, true, true,
        true, 30, 10),
       (103, 'LED', 'Sony', 'Sony Bravia', 899.99, 60.0, 50.0, 'LCD', '4K Ultra HD', true, true, false, true, false,
        false, 40, 15),
       (104, 'QLED', 'Samsung', 'Samsung QLED TV', 1799.99, 120.0, 75.0, 'QLED', '8K Ultra HD', true, true, true, true,
        true, false, 20, 5),
       -- Add more random values here
       (105, 'LED', 'Panasonic', 'Panasonic LED TV', 799.99, 60.0, 60.0, 'LCD', '4K Ultra HD', true, true, true, false,
        true, true, 60, 25),
       (106, 'OLED', 'Sony', 'Sony OLED TV', 1999.99, 120.0, 55.0, 'OLED', '4K Ultra HD', true, true, false, true, true,
        false, 35, 12),
       (107, 'QLED', 'LG', 'LG QLED TV', 1599.99, 120.0, 65.0, 'QLED', '8K Ultra HD', true, true, true, true, false,
        false, 15, 3),
       (108, 'LED', 'TCL', 'TCL LED TV', 599.99, 60.0, 43.0, 'LCD', '4K Ultra HD', true, false, false, false, true,
        false, 45, 18),
       (109, 'OLED', 'Philips', 'Philips OLED TV', 1799.99, 120.0, 55.0, 'OLED', '4K Ultra HD', true, true, true, true,
        false, false, 25, 8),
       (110, 'QLED', 'Sony', 'Sony QLED TV', 2499.99, 120.0, 75.0, 'QLED', '8K Ultra HD', true, true, true, true, true,
        true, 10, 2);

INSERT INTO remotecontrollers (id, compatible_with, battery_type, name, brand, price, original_stock)
VALUES (301, 'TV', 'AA', 'Universal Remote Control', 'Logitech', 19.99, 50),
       (302, 'DVD Player', 'AAA', 'DVD Remote Control', 'Sony', 9.99, 30),
       (303, 'TV', 'AAA', 'Smart TV Remote', 'Samsung', 24.99, 40),
       (304, 'Soundbar', 'AA', 'Soundbar Remote Control', 'Bose', 14.99, 25),
       (305, 'TV', 'AAA', 'LED TV Remote', 'LG', 12.99, 35),
       (306, 'Set-top Box', 'AAA', 'Set-top Box Remote Control', 'Cisco', 17.99, 20),
       (307, 'TV', 'AA', 'Smart Remote Control', 'Sony', 29.99, 45),
       (308, 'Streaming Device', 'AAA', 'Streaming Remote Control', 'Roku', 7.99, 15),
       (309, 'Projector', 'AA', 'Projector Remote Control', 'Epson', 22.99, 30),
       (310, 'Air Conditioner', 'AAA', 'Air Conditioner Remote', 'Panasonic', 16.99, 25);

INSERT INTO ci_modules (id, name, type, price)
VALUES (201, 'CI Module 1', 'Standard', 19.99),
       (202, 'CI Module 2', 'HD', 29.99),
       (203, 'CI Module 3', 'Ultra HD', 39.99),
       (204, 'CI Module 4', '4K', 49.99),
       (205, 'CI Module 5', 'Standard', 14.99),
       (206, 'CI Module 6', 'HD', 24.99),
       (207, 'CI Module 7', 'Ultra HD', 34.99),
       (208, 'CI Module 8', '4K', 44.99),
       (209, 'CI Module 9', 'Standard', 12.99),
       (210, 'CI Module 10', 'HD', 22.99);

-- Insert 10 random values into the wallbrackets table
INSERT INTO wallbrackets (id, size, adjustable, name, price)
VALUES (401, '32-55 inches', true, 'Adjustable Wall Bracket', 29.99),
       (402, '40-70 inches', false, 'Fixed Wall Bracket', 19.99),
       (403, '26-50 inches', true, 'Tilting Wall Bracket', 24.99),
       (404, '55-85 inches', true, 'Full-Motion Wall Bracket', 49.99),
       (405, '32-55 inches', false, 'Fixed Wall Bracket', 14.99),
       (406, '40-70 inches', true, 'Adjustable Wall Bracket', 34.99),
       (407, '26-50 inches', false, 'Fixed Wall Bracket', 17.99),
       (408, '55-85 inches', true, 'Tilting Wall Bracket', 39.99),
       (409, '32-55 inches', true, 'Full-Motion Wall Bracket', 44.99),
       (410, '40-70 inches', false, 'Fixed Wall Bracket', 21.99);

INSERT INTO users (username, password, email, enabled)
VALUES ('user', '$2a$12$IzA1Ja1LH4PSMoro9PeITO1etDlknPjSX1nLusgt1vi9c1uaEXdEK', 'user@test.nl', TRUE);
INSERT INTO users (username, password, email, enabled)
VALUES ('admin', '$2a$12$jOANSQmLQpueyFxgvdy4X.aomIR1ulCd5uuQiriVR2Ak8w2s1jQbq', 'admin@test.nl', TRUE);
-- wachtwoord van admin is admin

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');

