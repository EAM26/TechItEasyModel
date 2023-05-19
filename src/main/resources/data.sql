-- Insert 10 random values into the televisions table
INSERT INTO televisions (id, type, brand, name, price, refresh_rate, available_size, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold)
VALUES
    (101, 'LED', 'Samsung', 'Samsung Smart TV', 699.99, 60.0, 55.0, 'LCD', '4K Ultra HD', true, true, false, true, true, false, 50, 20),
    (102, 'OLED', 'LG', 'LG OLED TV', 1499.99, 120.0, 65.0, 'OLED', '4K Ultra HD', true, true, true, true, true, true, 30, 10),
    (103, 'LED', 'Sony', 'Sony Bravia', 899.99, 60.0, 50.0, 'LCD', '4K Ultra HD', true, true, false, true, false, false, 40, 15),
    (104, 'QLED', 'Samsung', 'Samsung QLED TV', 1799.99, 120.0, 75.0, 'QLED', '8K Ultra HD', true, true, true, true, true, false, 20, 5),
    -- Add more random values here
    (105, 'LED', 'Panasonic', 'Panasonic LED TV', 799.99, 60.0, 60.0, 'LCD', '4K Ultra HD', true, true, true, false, true, true, 60, 25),
    (106, 'OLED', 'Sony', 'Sony OLED TV', 1999.99, 120.0, 55.0, 'OLED', '4K Ultra HD', true, true, false, true, true, false, 35, 12),
    (107, 'QLED', 'LG', 'LG QLED TV', 1599.99, 120.0, 65.0, 'QLED', '8K Ultra HD', true, true, true, true, false, false, 15, 3),
    (108, 'LED', 'TCL', 'TCL LED TV', 599.99, 60.0, 43.0, 'LCD', '4K Ultra HD', true, false, false, false, true, false, 45, 18),
    (109, 'OLED', 'Philips', 'Philips OLED TV', 1799.99, 120.0, 55.0, 'OLED', '4K Ultra HD', true, true, true, true, false, false, 25, 8),
    (110, 'QLED', 'Sony', 'Sony QLED TV', 2499.99, 120.0, 75.0, 'QLED', '8K Ultra HD', true, true, true, true, true, true, 10, 2);
