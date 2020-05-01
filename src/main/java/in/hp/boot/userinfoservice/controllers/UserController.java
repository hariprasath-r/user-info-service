package in.hp.boot.userinfoservice.controllers;

import in.hp.boot.userinfoservice.entities.User;
import in.hp.boot.userinfoservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
