package gr.hua.ds.springboot1.service;
import gr.hua.ds.springboot1.entity.User;
import gr.hua.ds.springboot1.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
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

    // get all the users
    public List<User> getUsers() {
        return userRepository.findAll();
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


