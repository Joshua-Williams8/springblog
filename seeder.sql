USE springblog_db;

# You will not beable to login to this user, unless you paste a hashed password  in here, but this is just to have some post displayed when you load the page.
INSERT INTO springblog_db.users(username, email, password)
values ('firstUser', 'user@email.com', 'notpassword');


INSERT INTO springblog_db.ads(title, description, user_id)
values ('I am a title', 'Max 255 characters.', 1),
       ('Estoy Aqui', 'I am here in spanish', 1);

# Not using categories currently so ignore lines below, this was for ads testing originally.
# INSERT INTO springblog_db.categories(name)
# values ('lorem'),
#        ('ipsum'),
#        ('ok');
#
# INSERT INTO springblog_db.ads_categories(ad_id, category_id)
# VALUES (1,1),
#        (1,2),
#        (2,1),
#        (2,3);

# Comment seeder:

INSERT INTO springblog_db.comments(body, commenter_id, post_id)
VALUES ('Test comment from baba', 2, 2),
       ('Admin Test comment', 2, 2);

