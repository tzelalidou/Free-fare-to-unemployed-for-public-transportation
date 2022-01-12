package gr.hua.ds.springboot1;

import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringBoot1Application.class, args);
		User u1=new User("giorgos","petroy","Sd@gmsil.com","gpetrou","12345","ROLE_UNEMPLOYED",1);
		User u2=new User("ggsrfsvs","pgregwsoy","Swfsfeswfewd@gmsil.com","gpetfwefweafewrou","12345","ROLE_UNEMPLOYED",1);
		User u3=new User("ad","d","gergrege@gmsil.com","q","12345","ROLE_ADMIN",1);
		User u4=new User("oed","df","ger@gmsil.com","r","12345","ROLE_OAED",1);
		User u5=new User("sa","fg","ger@gmsil.com","v","12345","ROLE_OASA",1);
		Map<String,User> unempl=new HashMap<>();
		Map<String,User> OASA=new HashMap<>();
		Map<String,User> OAED=new HashMap<>();
		Map<String,User> ADMIN=new HashMap<>();

		System.out.println();
	}

}
