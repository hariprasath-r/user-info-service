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

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Will later be developed if needed
     * @param fname
     * @param lname
     * @return
     */
    public User getUserByFnameLname(String fname, String lname) {
        return userRepository.findByUserFnameAndLname(fname, lname);
    }

    public List<User> getUsers() {
         return userRepository.findAll();
    }

    public void updateUser(User user) {
        user.setId(getUserByEmail(user.getEmail()).getId());
        userRepository.save(user);
    }

    public void deleteUserByEmail(String email) {
        userRepository.delete(getUserByEmail(email));
    }
}
