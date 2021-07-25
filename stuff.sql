USE springblog_db;

INSERT INTO springblog_db.users(username,email,password)
values ('admin','admin@email.com','notpassword');


INSERT INTO springblog_db.ads(title,description,user_id)
values ('describe it','bruv',1),
       ('brudies','oof', 1);

