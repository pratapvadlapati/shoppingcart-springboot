package com.shoppingcart.shoppingcart.service;

import java.util.Optional;

import com.shoppingcart.shoppingcart.Exceptions.Unauthorized;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.UserRepository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // saveUser
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    // getUserById
    public Optional<User> getUserById(Long user_id) {

        if (!userRepository.findById(user_id).isPresent()) {

            throw new Unauthorized("no user found!");
        }

        return userRepository.findById(user_id);

    }

    // delete User
    public String deleteUserById(Long user_id) {

        if (!userRepository.findById(user_id).isPresent()) {

            throw new Unauthorized("no user found!");
        }

        userRepository.deleteById(user_id);
        return null;

    }

    // userSign in

    public Optional<User> SignIn(User user) {

        JSONObject obj = new JSONObject(user);

        String email = obj.getString("email");
        String password = obj.getString("password");

        Optional<User> usr = userRepository.findByEmail(email);
        String encodedPswd = usr.get().getPassword();

        if (passwordEncoder.matches(password, encodedPswd)) {
            return usr;
        }
        throw new Unauthorized("Username or password mismatched!");

    }

}
