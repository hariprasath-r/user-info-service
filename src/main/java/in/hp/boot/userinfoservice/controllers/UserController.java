package in.hp.boot.userinfoservice.controllers;

import in.hp.boot.userinfoservice.entities.User;
import in.hp.boot.userinfoservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        log.info("getUsers");
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        log.info("getUserByEmail");
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        log.info("addUser");
        try {
            userService.saveUser(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path(user.getEmail())
                    .buildAndExpand()
                    .toUri();
            return ResponseEntity.created(uri).build();
        } catch (SQLException e) {
            log.error("Exception: addUser [{}]", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        log.info("updateUser: [{}]", user);
        userService.updateUser(user);
        return ResponseEntity.accepted().body(user);
    }

    @DeleteMapping("{email}")
    public void deleteUser(@PathVariable String email) {
        log.info("deleteUser: [{}]", email);
        userService.deleteUserByEmail(email);
    }
}
