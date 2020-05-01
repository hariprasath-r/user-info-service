package in.hp.boot.userinfoservice.services;

import in.hp.boot.userinfoservice.entities.User;
import in.hp.boot.userinfoservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(String fname, String lname) {
        return userRepository.findByUserFnameAndLname(fname, lname);
    }

    public List<User> getUsers() {
         return userRepository.findAll();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
