/*
-- Insert 5 Cart objects
INSERT INTO carts (customer_id) VALUES (1);
INSERT INTO carts (customer_id) VALUES (2);
INSERT INTO carts (customer_id) VALUES (3);
INSERT INTO carts (customer_id) VALUES (4);
INSERT INTO carts (customer_id) VALUES (5);

-- Insert CartItem objects for each Cart
-- Cart 1
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (1, 'ADD', 3, '2023-02-28 00:00:00', 1);

-- Cart 2
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (1, 'MODIFY', 1, '2024-01-15 08:30:00', 2);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (2, 'ADD', 4, '2024-01-20 12:45:00', 2);

-- Cart 3
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (1, 'DELETE', 1, '2023-12-10 14:20:00', 3);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (2, 'ADD', 2, '2024-02-05 10:00:00', 3);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (3, 'MODIFY', 1, '2024-02-10 16:30:00', 3);

-- Cart 4
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (1, 'MODIFY', 1, '2024-03-15 09:45:00', 4);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (2, 'ADD', 6, '2024-03-18 11:00:00', 4);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (3, 'ADD', 1, '2024-03-20 13:15:00', 4);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (4, 'DELETE', 1, '2024-04-01 17:45:00', 4);

-- Cart 5
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (1, 'DELETE', 1, '2024-04-05 10:30:00', 5);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (2, 'ADD', 4, '2024-04-08 14:00:00', 5);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (3, 'ADD', 1, '2024-04-12 16:20:00', 5);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (4, 'MODIFY', 1, '2024-04-16 18:40:00', 5);
INSERT INTO cart_items (offer_id, action, quantity, created_at, fk_customer_id)
VALUES (5, 'ADD', 2, '2024-04-20 20:00:00', 5);

-- Insert Prices for each CartItem
-- CartItem 1
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 10.0, 3, 1);

-- CartItem 2
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 10.0, NULL, 2);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 6, 2);

-- CartItem 3
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 10.0, NULL, 3);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 9, 3);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 30.0, 12, 3);

-- CartItem 4
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 10.0, 4, 4);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 8, 4);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 30.0, 12, 4);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 40.0, 6, 4);

-- CartItem 5
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 10.0, 2, 5);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 4, 5);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 30.0, NULL, 5);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 40.0, NULL, 5);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 50.0, NULL, 5);

-- CartItem 6
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 10.0, NULL, 6);

-- CartItem 7
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 3, 7);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 30.0, 6, 7);

-- CartItem 8
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 15.0, 2, 8);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 25.0, 4, 8);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 35.0, 6, 8);

-- CartItem 9
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 10.0, 1, 9);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 2, 9);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 30.0, 3, 9);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 40.0, 4, 9);

-- CartItem 10
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('ONE_TIME', 10.0, NULL, 10);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 6, 10);

-- CartItem 11
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 15.0, 4, 11);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 25.0, 8, 11);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 35.0, 12, 11);

-- CartItem 12
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 10.0, 3, 12);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 6, 12);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 30.0, 9, 12);

-- CartItem 13
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 15.0, 2, 13);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 25.0, 4, 13);

-- CartItem 14
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 1, 14);

-- CartItem 15
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 10.0, 1, 15);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 20.0, 2, 15);
INSERT INTO prices (type, price_value, recurrence, fk_cart_item_id)
VALUES ('RECURRING', 30.0, 3, 15);*/
