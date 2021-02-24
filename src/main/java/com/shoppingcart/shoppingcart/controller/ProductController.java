package com.shoppingcart.shoppingcart.controller;

import java.util.List;

import com.shoppingcart.shoppingcart.Exceptions.ProductNotFound;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/shoppingcart")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // get all products

    @GetMapping(path = "/all/products")
    public List<Product> getAllProducts() throws ProductNotFound {

        return productService.getAllProduct();
    }

    // save product
    @PostMapping(path = "/create/product")
    public Product saveProduct(@RequestBody Product product) {

        return productService.saveProduct(product);
    }

    // update Product
    @PutMapping(path = "update/product/{product_Id}")
    public Product updateProduct(@PathVariable("product_Id") Long product_Id, @RequestBody Product product) {
        return productService.updateProduct(product_Id, product);
    }

}
