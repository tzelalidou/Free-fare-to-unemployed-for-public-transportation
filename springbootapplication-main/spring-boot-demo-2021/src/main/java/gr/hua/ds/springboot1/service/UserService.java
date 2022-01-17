package gr.hua.ds.springboot1.service;
import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service

public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all the users except unemployees
    public List<User> getUsersExceptUnemployed() {
        List<User> u=userRepository.findAll();
        List <User> employees=new ArrayList<>();
        for(int i=0;i<u.size();i++){
            if(u.get(i).getAuthority().equals("ROLE_UNEMPLOYED")){
            }else{
                employees.add(u.get(i));
            }
        }
        return employees;
    }
    public List<User> getUnemployedUsers() {
        List<User> usrs= userRepository.findAll();
        List <User> unemployees=new ArrayList<>();
        for(int i=0;i<usrs.size();i++){
            if(usrs.get(i).getAuthority().equals("ROLE_UNEMPLOYED")) {
                unemployees.add(usrs.get(i));
            }
        }
        return unemployees;
    }

    public User getUnemployedUserByUsername(String username) {
        List<User> listOfUsers = getUnemployedUsers();
        for(int i=0;i<listOfUsers.size();i++){
            if(listOfUsers.get(i).getUsername().equals(username)) {
                return listOfUsers.get(i);
            }
        }
        return null;
    }
    public User getUserByUsername(String username) {
        List<User> listOfUsers =userRepository.findAll();
        for(int i=0;i<listOfUsers.size();i++){
            if(listOfUsers.get(i).getUsername().equals(username)) {
                return listOfUsers.get(i);
            }
        }
        return null;
    }

    // get a user by id
    public User getUser(int id) {
        return userRepository.getById(id);
    }

    // save a user
    public User saveUser(User usr) {
        return userRepository.save(usr);
    }

    // remove a user
    public void removeUser(User usr) {
        userRepository.delete(usr);
    }

    // remove a user by id
    public void removeUserById(int id) {
        userRepository.deleteById(id);
    }

    //get all the unemployed
    public List<User> findUnemployed(List<User> users){

        return users;
    }




}


