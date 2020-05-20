package in.hp.boot.userinfoservice.services;

import in.hp.boot.userinfoservice.entities.User;
import in.hp.boot.userinfoservice.exceptions.ResourceNotFoundException;
import in.hp.boot.userinfoservice.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) throws SQLException {
        log.info("saveUser: [{}]", user);
        if (Objects.nonNull(userRepository.findByEmail(user.getEmail()))) {
            throw new SQLException("User already present. Try updating.");
        }
        userRepository.save(user);
        log.info("saveUser done");
    }

    public User getUserByEmail(String email) {
        log.info("getUserByEmail: [{}]", email);
        User user = userRepository.findByEmail(email);
        if (!Objects.nonNull(user)) {
            log.error("Exception: getUserByEmail [{}]", email);
            throw new ResourceNotFoundException("User:: " + email);
        }
        log.info("getUserByEmail done [{}]", user);
        return user;
    }

    /**
     * Will later be developed if needed
     *
     * @param fname
     * @param lname
     * @return
     */
    public User getUserByFnameLname(String fname, String lname) {
        return userRepository.findByUserFnameAndLname(fname, lname);
    }

    public List<User> getUsers() {
        log.info("getUsers");
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        log.info("updateUser [{}]", user);
        user.setId(getUserByEmail(user.getEmail()).getId());
        userRepository.save(user);
        log.info("updateUsers done");
    }

    public void deleteUserByEmail(String email) {
        log.info("deleteUserByEmail [{}]", email);
        userRepository.delete(getUserByEmail(email));
        log.info("deleteUserByEmail done");
    }
}
