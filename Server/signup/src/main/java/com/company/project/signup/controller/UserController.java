package com.company.project.signup.controller;

import ch.qos.logback.core.boolex.EvaluationException;
import com.company.project.signup.model.User;
import com.company.project.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllStudent() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{email}")
    public User getAllUsersInfo(@PathVariable String email) {
        return userService.getUserInfo(email);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{email}")
    public User editUser(@PathVariable String email, @RequestBody User user) {
        userService.editUser(email,user);
        return user;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }
}
