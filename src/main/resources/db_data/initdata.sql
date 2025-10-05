insert into products (id, price, quantity, description, name) values
(1, 12.0, 10,  'description', 'rose'),
(2, 14.0, 20,  'description', 'lily'),
(3, 15.0, 30,  'description', 'tulip'),
(4, 16.0, 40,  'description', 'rhododendron');

INSERT INTO users (id, name, email, phone, address, password, role) VALUES
(1, 'Alice Admin', 'admin@example.com', '1234567890', '123 Admin Street', '$2a$10$3nU91q5XUO6UO5xFy5F5HuXkPEtU77/pD.yIKvZ3gikYB3AHsKYmK', 'ADMIN'),
(2, 'Bob Customer', 'customer@example.com', '0987654321', '456 Customer Ave', '$2a$10$3nU91q5XUO6UO5xFy5F5HuXkPEtU77/pD.yIKvZ3gikYB3AHsKYmK', 'CUSTOMER');

insert into categories (id, name, description) values
(1, 'INDOOR', 'decription'),
(2, 'OUTDOOR', 'decription');

insert into product_category (category_id, product_id) values
(1, 1),
(2, 2),
(1, 3),
(2, 4);
#
# -- Insert orders
INSERT INTO orders (id, order_date, status, total_price, shipping_address, user_id) VALUES
    (1, '2025-04-20', 'NEW', 36.00, '123 Garden Street', 1),
    (2, '2025-04-21', 'PROCESSING', 45.00, '456 Plant Avenue', 2)

-- Insert order items for order 1
INSERT INTO order_item (id, quantity, price, product_id, order_id) VALUES
    (1, 2, 12.00, 1, 1),  -- 2 x Product ID 1 @ 12.00 = 24.00
    (2, 1, 12.00, 2, 2);  -- 1 x Product ID 2 @ 12.00 = 12.00

-- Insert order items for order 2
INSERT INTO order_item (id, quantity, price, product_id, order_id) VALUES
    (3, 3, 15.00, 3, 2);  -- 3 x Product ID 3 @ 15.00 = 45.00
