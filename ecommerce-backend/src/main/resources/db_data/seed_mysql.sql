-- seed_mysql.sql
-- Assumptions about table names/columns; adjust at the top if different.
-- users(id, name, email, phone, address, password, role)
-- categories(id, name)
-- products(id, name, description, price, quantity)
-- products_categories(product_id, category_id) [join table]
-- orders(id, order_date, status, total_price, shipping_address, user_id)
-- order_items(id, order_id, product_id, unit_price, quantity)
-- carts(id, user_id)
-- cart_items(id, cart_id, product_id, unit_price_snapshot, quantity)

SET FOREIGN_KEY_CHECKS = 0;

-- Truncate in dependency order (children first)
TRUNCATE TABLE order_items;
TRUNCATE TABLE orders;
TRUNCATE TABLE cart_items;
TRUNCATE TABLE carts;
TRUNCATE TABLE product_category;
TRUNCATE TABLE products;
TRUNCATE TABLE categories;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;

-- Users
INSERT INTO users (id, name, email, phone, address, password, role) VALUES
  (1, 'Alice Admin', 'admin@example.com', '1234567890', '123 Admin Street', '$2b$10$BclFqNbtXVbCxJzGX/Q9r.L6zXYuNUCrG.69QrnJ5BxQRKMR0G21G', 'ADMIN'),
  (2, 'Bob Customer', 'user@example.com',  '0987654321', '456 Customer Ave', '$2b$10$aP12FfleTg5Uv/TEsBjTl.whnKq1kIsYwvVqJMa7TbmAYThQLJ2rK',  'CUSTOMER');

-- Categories
INSERT INTO categories (id, name, description) VALUES
  (10, 'Roses', 'Description'),
  (11, 'Tulips', 'Description'),
  (12, 'Gadgets', 'Description');

-- Products
INSERT INTO products (id, name, description, price, quantity) VALUES
  (100, 'Red Rose', 'Fresh red rose', 12.00, 100),
  (101, 'White Rose', 'Elegant white rose', 11.50, 80),
  (102, 'Tulip Bouquet', 'Spring tulip bouquet', 24.99, 50),
  (103, 'USB-C Cable', 'Durable 1m cable', 9.90, 200),
  (104, 'Wireless Mouse', 'Ergonomic mouse', 29.00, 70);

-- Product-Category Mapping
INSERT INTO product_category (product_id, category_id) VALUES
  (100, 10),
  (101, 10),
  (102, 11),
  (103, 12),
  (104, 12);

-- Cart for Bob
INSERT INTO carts (id, user_id, total_price) VALUES (1000, 2, 100.0);

INSERT INTO cart_items (id, cart_id, product_id, price, quantity) VALUES
  (2000, 1000, 100, 12.00, 2),  -- 2 x Red Rose
  (2001, 1000, 103, 9.90, 1);   -- 1 x USB-C Cable

-- Sample Order for Bob (assumes no triggers computing total)
INSERT INTO orders (id, order_date, status, total_price, shipping_address, user_id)
VALUES (3000, NOW(), 'NEW', 33.90, '456 Customer Ave', 2);

INSERT INTO order_items (id, order_id, product_id, price, quantity) VALUES
  (4000, 3000, 100, 12.00, 2),
  (4001, 3000, 103, 9.90, 1);

-- Optional: reset AUTO_INCREMENTs to keep IDs predictable
ALTER TABLE users AUTO_INCREMENT = 100;
ALTER TABLE categories AUTO_INCREMENT = 100;
ALTER TABLE products AUTO_INCREMENT = 1000;
ALTER TABLE carts AUTO_INCREMENT = 2000;
ALTER TABLE cart_items AUTO_INCREMENT = 3000;
ALTER TABLE orders AUTO_INCREMENT = 4000;
ALTER TABLE order_items AUTO_INCREMENT = 5000;