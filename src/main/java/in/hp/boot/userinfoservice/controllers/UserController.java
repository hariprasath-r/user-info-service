package in.hp.boot.userinfoservice.controllers;

import in.hp.boot.userinfoservice.entities.User;
import in.hp.boot.userinfoservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@Email @PathVariable String email) { return userService.getUserByEmail(email); }

    @PostMapping
    public void addUser(@Valid @RequestBody User user) throws SQLException {
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@Valid @RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("{email}")
    public void deleteUser(@Email @PathVariable String email) {
        userService.deleteUserByEmail(email);
    }
}
