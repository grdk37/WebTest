drop database if exists blog;
create database blog default character set utf8mb4 collate utf8mb4_unicode_ci;
use blog;

DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS author;

CREATE TABLE author (
id                INT NOT NULL auto_increment,
username          VARCHAR(255) NOT NULL,
password          VARCHAR(255) NOT NULL,
email             VARCHAR(255) NOT NULL,
bio               text,
favourite_section VARCHAR(25),
PRIMARY KEY (id)
)engine=INNODB auto_increment=1000 default charset=utf8mb4;

CREATE TABLE blog (
id          INT NOT NULL  auto_increment,
author_id   INT NOT NULL,
title       VARCHAR(255),
PRIMARY KEY (id)
)engine=INNODB auto_increment=1000 default charset=utf8mb4;
CREATE TABLE post (
id          INT NOT NULL  auto_increment,
blog_id     INT,
author_id   INT NOT NULL,
created_on  TIMESTAMP NOT NULL default current_timestamp on update current_timestamp
,
section     VARCHAR(25) NOT NULL,
subject     VARCHAR(255) NOT NULL,
body        text NOT NULL,
draft       INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (blog_id) REFERENCES blog(id)
)engine=INNODB auto_increment=1000 default charset=utf8mb4;

CREATE TABLE tag (
id          INT NOT NULL  auto_increment,
name        VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
)engine=INNODB auto_increment=1000 default charset=utf8mb4;

CREATE TABLE post_tag (
post_id     INT NOT NULL,
tag_id      INT NOT NULL,
PRIMARY KEY (post_id, tag_id)
)engine=INNODB default charset=utf8mb4;

CREATE TABLE comment (
id          INT NOT NULL  auto_increment,
post_id     INT NOT NULL,
name        VARCHAR(64) NOT NULL,
comment     text NOT NULL,
PRIMARY KEY (id)
)engine=INNODB auto_increment=1000 default charset=utf8mb4;
CREATE TABLE node (
id  INT NOT NULL,
parent_id INT,
PRIMARY KEY(id)
)engine=INNODB default charset=utf8mb4;

INSERT INTO author (id,username, password, email, bio, favourite_section) VALUES (101,'jim','********','jim@ibatis.apache.org','','NEWS');
INSERT INTO author (id,username, password, email, bio, favourite_section) VALUES (102,'sally','********','sally@ibatis.apache.org',null,'VIDEOS');

INSERT INTO blog (id,author_id,title) VALUES (1,101,'Jim Business');
INSERT INTO blog (id,author_id,title) VALUES (2,102,'Bally Slog');

INSERT INTO post (id,blog_id,author_id,created_on,section,subject,body,draft) VALUES (1,1,101,'2007-12-05-00.00.00','NEWS','Corn nuts','I think if I never smelled another corn nut it would be too soon...',1);
INSERT INTO post (id,blog_id,author_id,created_on,section,subject,body,draft) VALUES (2,1,101,'2008-01-12-00.00.00','VIDEOS','Paul Hogan on Toy Dogs','That''s not a dog.  THAT''s a dog!',0);
INSERT INTO post (id,blog_id,author_id,created_on,section,subject,body,draft) VALUES (3,2,102,'2007-12-05-00.00.00','PODCASTS','Monster Trucks','I think monster trucks are great...',1);
INSERT INTO post (id,blog_id,author_id,created_on,section,subject,body,draft) VALUES (4,2,102,'2008-01-12-00.00.00','IMAGES','Tea Parties','A tea party is no place to hold a business meeting...',0);

-- BAD POST
INSERT INTO post (id,blog_id,author_id,created_on,section,subject,body,draft) VALUES (5,null,101,'2008-01-12-00.00.00','IMAGES','An orphaned post','this post is orphaned',0);

INSERT INTO tag (id,name) VALUES (1,'funny');
INSERT INTO tag (id,name) VALUES (2,'cool');
INSERT INTO tag (id,name) VALUES (3,'food');

INSERT INTO post_tag (post_id,tag_id) VALUES (1,1);
INSERT INTO post_tag (post_id,tag_id) VALUES (1,2);
INSERT INTO post_tag (post_id,tag_id) VALUES (1,3);
INSERT INTO post_tag (post_id,tag_id) VALUES (2,1);
INSERT INTO post_tag (post_id,tag_id) VALUES (4,3);

INSERT INTO comment (id,post_id,name,comment) VALUES (1,1,'troll','I disagree and think...');
INSERT INTO comment (id,post_id,name,comment) VALUES (2,1,'anonymous','I agree and think troll is an...');
INSERT INTO comment (id,post_id,name,comment) VALUES (4,2,'another','I don not agree and still think troll is an...');
INSERT INTO comment (id,post_id,name,comment) VALUES (3,3,'rider','I prefer motorcycles to monster trucks...');


--       1
--    2     3
--  4  5   6  7

INSERT INTO node (id, parent_id) VALUES (1,null);
INSERT INTO node (id, parent_id) VALUES (2,1);
INSERT INTO node (id, parent_id) VALUES (3,1);
INSERT INTO node (id, parent_id) VALUES (4,2);
INSERT INTO node (id, parent_id) VALUES (5,2);
INSERT INTO node (id, parent_id) VALUES (6,3);
INSERT INTO node (id, parent_id) VALUES (7,3);