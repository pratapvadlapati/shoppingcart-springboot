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

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long Id;

    @Column(name = "productname")
    @Length(max = 16, message = ("*Pls provide valid product name"))
    @NotBlank
    private String productName;

    @Column(name = "description")
    @Length(max = 30, message = ("*Pls prodive limited description"))
    @NotBlank
    private String description;

    @Column(name = "price")
    private Integer price;

    public Product(Long id, String productName, String description, Integer price) {
        Id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [Id=" + Id + ", description=" + description + ", price=" + price + ", productName="
                + productName + "]";
    }

    public Product() {
    }

}
