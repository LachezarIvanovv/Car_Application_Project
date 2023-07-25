-- some test users
INSERT INTO user_roles (id, user_role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', null, 1, '{bcrypt}$2a$10$Y98X4IKxeKeCzJIUeuegpu5Tr3i5VXOxWJbPh7J4djBwpkkCTKR4e'),
    (2, 'l@gmail.com', 'Lachezar', 'Ivanov', null, 1, '{bcrypt}$2a$10$Y98X4IKxeKeCzJIUeuegpu5Tr3i5VXOxWJbPh7J4djBwpkkCTKR4e');
-- $2a$11$K6/6xbIqmoBkavzyiBdQEuI.S9e88sYrCAfBHPmqNJGb4wryHMV06

INSERT INTO users_user_roles(user_entity_id, user_roles_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);

INSERT INTO brands (id, name)
VALUES
    (1, 'Ford'),
    (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, imageurl)
VALUES (
        1, 'Fiesta', 'CAR', 1976, null, 1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.autovisie.nl%2Fnieuws%2Fford-fiesta-st-edition-de-stuggere-fiesta-st%2F&psig=AOvVaw2hk2_6j9dWpQ2sXEx5YA6o&ust=1677230720870000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCLiY_cCpq_0CFQAAAAAdAAAAABAD'),
        (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.nweuro.com%2Fblog%2F2020%2F4%2F13%2Fimperial-blue-1995-ford-escort-cosworth-rs&psig=AOvVaw3PhGnDy96Gq3kHBA6W4gMB&ust=1677227156444000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKC3kpmcq_0CFQAAAAAdAAAAABAE'),
        (3, 'Yaris', 'CAR', 1999, null, 2, 'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_large/v1/editorial/2022-Toyota-GRMN-Yaris-hatch-grey-1001x565-1.jpg');

INSERT INTO offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id)
VALUES
    (1, 'Качваш са, караш са, отиваш на фиеста 1. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320001, 2601, 'MANUAL', 2005, 1, 1),
    (2, 'Качваш са, караш са, отиваш на фиеста 2. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320002, 2602, 'MANUAL', 2005, 1, 1),
    (3, 'Качваш са, караш са, отиваш на фиеста 3. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320003, 2603, 'MANUAL', 2005, 1, 1),
    (4, 'Качваш са, караш са, отиваш на фиеста 4. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320004, 2605, 'MANUAL', 2005, 1, 1),
    (5, 'Качваш са, караш са, отиваш на фиеста 5. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320005, 2604, 'MANUAL', 2005, 1, 1),
    (6, 'Качваш са, караш са, отиваш на фиеста 6. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320006, 2606, 'MANUAL', 2005, 1, 1),
    (7, 'Качваш са, караш са, отиваш на фиеста 7. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320007, 2607, 'MANUAL', 2005, 1, 1),
    (8, 'Качваш са, караш са, отиваш на фиеста 8. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320008, 2609, 'MANUAL', 2005, 1, 1),
    (9, 'Качваш са, караш са, отиваш на фиеста 9. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320009, 2640, 'MANUAL', 2005, 1, 1),
    (10, 'Качваш са, караш са, отиваш на фиеста 10. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320010, 2630, 'MANUAL', 2005, 1, 1),
    (11, 'Качваш са, караш са, отиваш на фиеста 11. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320011, 2633, 'MANUAL', 2005, 1, 1),
    (12, 'Качваш са, караш са, отиваш на фиеста 12. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320012, 2654, 'MANUAL', 2005, 1, 1),
    (13, 'Качваш са, караш са, отиваш на фиеста 13. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320013, 2612, 'MANUAL', 2005, 1, 1);
