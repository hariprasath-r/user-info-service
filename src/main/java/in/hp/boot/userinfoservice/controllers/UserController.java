package in.hp.boot.userinfoservice.controllers;

import in.hp.boot.userinfoservice.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @GetMapping
    public List<User> getUsers() {
        return Arrays.asList(new User(), new User());
    }
}
