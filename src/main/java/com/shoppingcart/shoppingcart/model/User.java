package com.shoppingcart.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

//import lombok.Data;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long Id;

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, message = "Your username should have min 5 charecters!!")
    @NotBlank(message = "*Please provide username")
    private String username;

    @Column(name = "password", nullable = false)
    @Length(min = 3, message = "*Your password must have 5 charecters")
    @NotBlank(message = "*Please provide password")
    private String password;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "*Email must not be empty")
    private String email;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [Id=" + Id + ", email=" + email + ", password=" + password + ", username=" + username + "]";
    }

    public User(
            @Length(min = 5, message = "Your username should have min 5 charecters!!") @NotBlank(message = "*Please provide username") String username,
            @Length(min = 3, message = "*Your password must have 5 charecters") @NotBlank(message = "*Please provide password") String password,
            @NotBlank(message = "*Email must not be empty") String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

}
