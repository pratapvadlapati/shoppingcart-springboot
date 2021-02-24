package com.shoppingcart.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.shoppingcart.Exceptions.ProductNotFound;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // get all products
    public List<Product> getAllProduct() {

        if (productRepository.findAll().isEmpty()) {
            throw new ProductNotFound("product not found");
        }

        return productRepository.findAll();

    }

    // save product //
    public Product saveProduct(Product product) {

        return productRepository.save(product);

    }

    // update product
    public Product updateProduct(Long product_Id, Product product) {

        if (productRepository.findById(product_Id).isPresent()) {
            Optional<Product> prod = productRepository.findById(product_Id);

            Product updatedProduct = prod.get();
            updatedProduct.setPrice(product.getPrice());

            return productRepository.save(updatedProduct);

        }
        throw new ProductNotFound("Product Id" + " " + product_Id + " " + "not found to update!");

    }

}
