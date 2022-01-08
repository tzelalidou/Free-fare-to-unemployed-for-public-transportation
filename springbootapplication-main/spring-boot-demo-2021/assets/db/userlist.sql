
CREATE TABLE IF NOT EXISTS `user` (
    `first_name` varchar(50) NOT NULL,
    `last_name` varchar(50) NOT NULL,
    `email` varchar(50) NULL,
    `username` varchar(50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    `authority` varchar(50) NOT NULL,
    PRIMARY KEY (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `application` (
    `amkaNumber` varchar(15) NOT NULL,
    `birthDate` date NOT NULL,
    `address` varchar(50) NOT NULL,
    `yearOfUnemployment` date NOT NULL,
    `imgName` varchar(20) NOT NULL,
    `applicationStatus` tinyint(1) NOT NULL,
    PRIMARY KEY (`amkaNumber`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`first_name`,`last_name`,`email`,`username`, `password`, `enabled`,`authority`) VALUES
                                                                                                        ('argiris','tsadimas','argiristsad@gmail.com','argiris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_USER'),
                                                                                                        ('maria','dhmoy','mariadhmoyd@gmail.com','root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_ADMIN');


INSERT INTO `application` (`amkaNumber`,`birthDate`,`address`, `yearOfUnemployment`, `imgName`,`applicationStatus`) VALUES
                                                                                                                        ('15101993294','1993/10/15','Kapadokias 25','2007/03/07', 'mypic.jpg', 1),
                                                                                                                        ('11081999260','1999/08/11','Pyrgou 13','2004/01/19', 'me.jpg', 1);

select * from user;
select * from application;
DROP TABLE application;
DROP TABLE user;