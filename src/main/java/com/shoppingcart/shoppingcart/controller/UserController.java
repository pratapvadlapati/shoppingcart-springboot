package com.shoppingcart.shoppingcart.controller;

import java.lang.StackWalker.Option;
import java.util.Optional;

import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/shoppingcart")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // save user
    @PostMapping(path = "user")
    public Object registerUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    // getuserById
    @GetMapping(path = "/user/{userId}")
    public Optional<User> getUser(@PathVariable("userId") Long user_id) {

        return userService.getUserById(user_id);
    }

    // DeleteUserByID

    @DeleteMapping(path = "/user/{userId}")
    public String deleteUserById(@PathVariable("userId") Long user_id) {
        return userService.deleteUserById(user_id);

    }

    // user Signin

    @PostMapping(path = "/user/signin")
    public Optional<User> userSignIn(@RequestBody User user) {
        return userService.SignIn(user);

    }

}
