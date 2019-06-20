package com.katie.cleancodestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSaver {
//    private static Product product = new Product();
    private static ProductRepository repository;

    @Autowired
    public void setProductRepository(ProductRepository repository) {
        ProductSaver.repository = repository;
    }

    public static void saveProduct(String name, Double price) {
        Product product = new Product();

        List<Product> productList = repository.findAll();
        List<String> productNames = new ArrayList<>();

        product.setName(name);
        product.setPrice(price);

        for (Product currentProduct : productList) {
            productNames.add(currentProduct.getName());
        }

        if (!productNames.contains(name)) {
            repository.save(product);
        } else {
            System.out.println("Product not saved: product with this name is already in the system");
        }
    }
}
