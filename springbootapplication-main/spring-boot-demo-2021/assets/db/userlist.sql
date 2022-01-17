
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` int NOT NULL AUTO_INCREMENT,
                                      `first_name` varchar(50) NOT NULL,
                                      `last_name` varchar(50) NOT NULL,
                                      `email` varchar(50) NULL,
                                      `username` varchar(50) NOT NULL,
                                      `password` varchar(100) NOT NULL,
                                      `enabled` tinyint(1) NOT NULL,
                                      `authority` varchar(50) NOT NULL,
                                      PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `application` (
                                             `aid` int NOT NULL AUTO_INCREMENT,
                                             `amkanumber` bigint NOT NULL,
                                             `birthdate` varchar(50) NOT NULL,
                                             `address` varchar(50) NOT NULL,
                                             `yearofunemployment` varchar(50) NOT NULL,
                                             `imgname` varchar(20) NOT NULL,
                                             `applicationstatus` tinyint(1) NOT NULL,
                                             `user_id` int NOT NULL,
                                             PRIMARY KEY (aid),
                                             FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`first_name`,`last_name`,`email`,`username`, `password`, `enabled`,`authority`) VALUES
                                                                                                        ('argiris','tsadimas','argiristsad@gmail.com','argiris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_UNEMPLOYED'),
                                                                                                        ('marianthi','karvoynh','marianthikarv@gmail.com','marianthi', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_OAED'),
                                                                                                        ('lefteris','xasan','lefxasan@gmail.com','lefteris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_OASA'),
                                                                                                        ('maria','dhmoy','mariadhmoyd@gmail.com','root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_ADMIN');


INSERT INTO `application` (`amkaNumber`,`birthDate`,`address`, `yearOfUnemployment`, `imgName`,`user_id`,`applicationStatus`) VALUES
                                                                                                                                  ('15101993294','1993/10/15','Kapadokias 25','2007/03/07', 'mypic.jpg',1, 1),
                                                                                                                                  ('11081999260','1999/08/11','Pyrgou 13','2004/01/19', 'me.jpg',1, 1),
                                                                                                                                  ('81123456760','1964/08/11','Sanou 172','2014/12/29', 'image.jpg',1, 1);

select * from user;
select * from application;
DROP TABLE application;
DROP TABLE user;
select * from user where authority = 'ROLE_ADMIN';
select * from application where amkaNumber = '15101993294';
INSERT INTO `user` (`first_name`,`last_name`,`email`,`username`, `password`, `enabled`,`authority`) VALUES
    ('lefteris','xasan','lefxasan@gmail.com','lefteris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_OASA');