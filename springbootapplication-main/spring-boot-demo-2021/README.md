Instructions for our WEB-APP 
---------------------

* Introduction
* URLS
* Operations
* Installation


The Home Menu  displays the entire  menu tree
(and most local tasks) in a drop-down menu, providing  one- or
two-click access to most pages.  Other modules may also add menu links to the
menu.

* Visit the project page(Home page/Login-Page):
    http://localhost:9000/api
* Login page:
    http://localhost:9000/login
* Register Page:
    http://localhost:9000/register
* Admin Page(fixed data:username:root,password:pass123):
    http://localhost:9000/admin
* OAED Page(fixed data:username:marianthi,password:pass123):
    http://localhost:9000/oaed
* OASA Page(fixed data:username:lefteris,password:pass123):
    http://localhost:9000/oasa
* UNEMPLOYEE Page(fixed data:username:argiris,password:pass123):
    http://localhost:9000/unemployed

Admin:
* Add User (oasa,oaed employee)
* Delete User (oasa,oaed employee)

OASA employee:
* Validate application

OAED employee:
* Check application

Unemployed:
* Create applications


Installation
git clone https://github.com/tzelalidou/springbootapp.git


Some ready inserts in MySQL for quicker check
INSERT INTO `user` (`first_name`,`last_name`,`email`,`username`, `password`, `enabled`,`authority`) VALUES
   ('argiris','tsadimas','argiristsad@gmail.com','argiris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_UNEMPLOYED'),
   ('marianthi','karvoynh','marianthikarv@gmail.com','marianthi', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_OAED'),
   ('lefteris','xasan','lefxasan@gmail.com','lefteris', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_OASA'),
   ('maria','dhmoy','mariadhmoyd@gmail.com','root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1,'ROLE_ADMIN');


INSERT INTO `application` (`amkaNumber`,`birthDate`,`address`, `yearOfUnemployment`, `imgName`,`user_id`,`applicationStatus`) VALUES
   ('15101993294','1993/10/15','Kapadokias 25','2007/03/07', 'mypic.jpg',1, 0),
   ('11081999260','1999/08/11','Pyrgou 13','2004/01/19', 'me.jpg',1, 0),
      ('81123456760','1964/08/11','Sanou 172','2014/12/29', 'image.jpg',1, 1);
