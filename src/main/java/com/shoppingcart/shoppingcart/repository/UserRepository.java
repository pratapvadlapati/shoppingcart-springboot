package com.shoppingcart.shoppingcart.repository;

import java.util.Optional;

import com.shoppingcart.shoppingcart.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(@Param("email") String email);

}
