package by.grsu.budko.library.controller;

import by.grsu.budko.library.model.User;
import by.grsu.budko.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    // return list of users
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        System.out.println(userService.getAllUsers());
        return  userService.getAllUsers(); }

    // return user getting by id for
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id) { return userService.getUserById(id); }
}
