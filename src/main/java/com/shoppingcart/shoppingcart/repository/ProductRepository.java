package com.shoppingcart.shoppingcart.repository;

import com.shoppingcart.shoppingcart.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
