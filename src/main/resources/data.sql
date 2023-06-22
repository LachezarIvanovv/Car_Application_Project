-- some test users
INSERT INTO user_roles (id, user_role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES
    (1, 'lachezar.x@gmail.com', 'Lachezar', 'Ivanov', null, 1, 'ca52ed9342544dc50eff98f58eabf787e3e7dd6859a8d8bf6a64692a9fb133507360c5afa9345722d');

INSERT INTO brands (id, name)
VALUES
    (1, 'Ford'),
    (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, imageurl)
VALUES (
        1, 'Fiesta', 'CAR', 1976, null, 1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.autovisie.nl%2Fnieuws%2Fford-fiesta-st-edition-de-stuggere-fiesta-st%2F&psig=AOvVaw2hk2_6j9dWpQ2sXEx5YA6o&ust=1677230720870000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCLiY_cCpq_0CFQAAAAAdAAAAABAD'),
        (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.nweuro.com%2Fblog%2F2020%2F4%2F13%2Fimperial-blue-1995-ford-escort-cosworth-rs&psig=AOvVaw3PhGnDy96Gq3kHBA6W4gMB&ust=1677227156444000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKC3kpmcq_0CFQAAAAAdAAAAABAE'),
        (3, 'Yaris', 'CAR', 1999, null, 2, 'https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_large/v1/editorial/2022-Toyota-GRMN-Yaris-hatch-grey-1001x565-1.jpg');


