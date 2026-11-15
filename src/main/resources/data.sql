-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);
insert into user_account (email, display_name, role, created_at) values
    ('s700140@student.wroclaw.merito.pl', 'Bartosz Kowynia',   'USER', current_timestamp),
    ('s492703@student.wroclaw.merito.pl', 'Tomasz Kurowicki',  'USER', current_timestamp),
    ('kierownik@warehouse.test',          'Marek (kierownik)', 'ADMIN', current_timestamp);

-- ===== LAB 03 · user_account (partnerzy) =====
insert into user_account (email, display_name, role, created_at) values
    ('kontakt@homestyle.test', 'HomeStyle', 'PARTNER', current_timestamp),
    ('sklep@rainwear.test',    'RainWear',  'PARTNER', current_timestamp);

-- ===== LAB 03 · shop =====
-- user_account_id: 3 = Firma (TechStore), 8 = HomeStyle, 9 = RainWear
insert into shop (name, tax_id, contact_email, active, user_account_id) values
    ('TechStore', '8971234560', 'firma@example.com',      true, 3),
    ('HomeStyle', '8992345671', 'kontakt@homestyle.test', true, 8),
    ('RainWear',  '9113456782', 'sklep@rainwear.test',    true, 9);

-- ===== LAB 02 · product =====
insert into product (sku, name, category, unit_price, active, introduced_on, shop_id) values
    ('ELEC-USB-C-001', 'Ładowarka USB-C 65 W',    'ELECTRONICS', 89.99,  true, '2026-01-15', 1),
    ('HOME-LAMP-014',  'Lampka biurkowa LED',     'HOME',        74.50,  true, '2026-02-01', 2),
    ('CLOTH-JKT-042',  'Kurtka przeciwdeszczowa', 'CLOTHING',    219.00, true, '2026-03-10', 3);

-- ===== LAB 02 · inventory_item =====
insert into inventory_item (serial_number, product_id, status, received_at, zone, aisle, rack, bin) values
    ('SN-CHG-0001842', 1, 'RESERVED', '2026-10-20 08:15:00', 'A', '03', '02', '014'),
    ('SN-LMP-0000917', 2, 'RESERVED', '2026-10-21 10:30:00', 'B', '01', '04', '006'),
    ('SN-JKT-0003021', 3, 'DAMAGED',  '2026-10-22 14:05:00', 'C', '05', '01', '023'),
    ('SN-CHG-0001843', 1, 'RESERVED', '2026-10-23 09:40:00', 'A', '03', '02', '015'),
    ('SN-LMP-0000918', 2, 'IN_STOCK', '2026-10-24 11:20:00', 'B', '01', '04', '007');

-- ===== LAB 02 · stock_movement =====
-- user_account_id: 5 = Bartosz, 6 = Tomasz, 7 = kierownik
insert into stock_movement (inventory_item_id, movement_type, occurred_at, source_location, destination_location, user_account_id) values
    (1, 'RECEIPT',    '2026-10-20 08:15:00', null,          'A-03-02-014', 7),
    (2, 'TRANSFER',   '2026-10-21 10:30:00', 'B-01-02-006', 'B-01-04-006', 6),
    (3, 'ADJUSTMENT', '2026-10-22 14:05:00', 'C-05-01-023', null,          5),
    (4, 'RECEIPT',    '2026-10-23 09:40:00', null,          'A-03-02-015', 6),
    (5, 'RECEIPT',    '2026-10-24 11:20:00', null,          'B-01-04-007', 5);

-- ===== LAB 03 · issue_order =====
insert into issue_order (order_number, status, requested_at, recipient_name, delivery_address, shop_id) values
    ('ZW/2026/0001', 'PICKED',    '2026-11-02 09:00:00', 'Piotr Zieliński', 'ul. Długa 5, 50-001 Wrocław',      1),
    ('ZW/2026/0002', 'PICKED',    '2026-11-03 13:30:00', 'Anna Lis',        'ul. Polna 12/3, 30-002 Kraków',    2),
    ('ZW/2026/0003', 'CANCELLED', '2026-11-04 16:45:00', 'Karol Mazur',     'ul. Morska 8, 80-003 Gdańsk',      3);

-- ===== LAB 03 · issue_order_line =====
insert into issue_order_line (issue_order_id, product_id, quantity, note) values
    (1, 1, 2, null),
    (2, 2, 1, 'zapakować na prezent'),
    (3, 3, 1, null);

-- ===== LAB 03 · issue_order_item =====
insert into issue_order_item (issue_order_id, inventory_item_id) values
    (1, 1),
    (1, 4),
    (2, 2);
