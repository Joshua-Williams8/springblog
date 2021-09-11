# TODO: Get a better understanding of how Spring Boot works, with hiberate, thymeleaf, th security, and other things.

USE springblog_db;

INSERT INTO springblog_db.users(username, email, password)
values ('admin', 'admin@email.com', 'notpassword');


INSERT INTO springblog_db.ads(title, description, user_id)
values ('describe it', 'bruv', 1),
       ('brudies', 'oof', 1);

INSERT INTO springblog_db.categories(name)
values ('lorem'),
       ('ipsum'),
       ('ok');

INSERT INTO springblog_db.ads_categories(ad_id, category_id)
VALUES (1,1),
       (1,2),
       (2,1),
       (2,3);

