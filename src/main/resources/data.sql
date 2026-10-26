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

-- ===== LAB 02 · product =====
insert into product (sku, name, category, unit_price, active, introduced_on) values
    ('ELEC-USB-C-001', 'Ładowarka USB-C 65 W', 'ELECTRONICS', 89.99, true,  '2026-01-15'),
    ('HOME-LAMP-014',  'Lampka biurkowa LED',  'HOME',        74.50, true,  '2026-02-01'),
    ('CLOTH-JKT-042',  'Kurtka przeciwdeszczowa', 'CLOTHING', 219.00, true, '2026-03-10');

-- ===== LAB 02 · inventory_item =====
insert into inventory_item (serial_number, product_sku, status, received_at, zone, aisle, rack, bin) values
    ('SN-CHG-0001842', 'ELEC-USB-C-001', 'IN_STOCK', '2026-10-20 08:15:00', 'A', '03', '02', '014'),
    ('SN-LMP-0000917', 'HOME-LAMP-014',  'RESERVED', '2026-10-21 10:30:00', 'B', '01', '04', '006'),
    ('SN-JKT-0003021', 'CLOTH-JKT-042',  'DAMAGED',  '2026-10-22 14:05:00', 'C', '05', '01', '023');

-- ===== LAB 02 · stock_movement =====
insert into stock_movement (serial_number, movement_type, occurred_at, source_location, destination_location, performed_by) values
    ('SN-CHG-0001842', 'RECEIPT', '2026-10-20 08:15:00', null,             'A-03-02-014', 'kierownik@warehouse.test'),
    ('SN-LMP-0000917', 'TRANSFER', '2026-10-21 10:30:00', 'B-01-02-006', 'B-01-04-006', 's492703@student.wroclaw.merito.pl'),
    ('SN-JKT-0003021', 'ADJUSTMENT', '2026-10-22 14:05:00', 'C-05-01-023', null,        's700140@student.wroclaw.merito.pl');
