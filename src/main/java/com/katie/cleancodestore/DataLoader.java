package com.katie.cleancodestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product blueChair = new Product();
        blueChair.setName("Blue chair");
        productRepository.save(blueChair);
        System.out.println("Blue chair saved " + blueChair);

        Product redChair = new Product();
        redChair.setName("Red chair");
        productRepository.save(redChair);
        System.out.println("Red chair saved " + redChair);

        Product faucetHandle = new Product();
        faucetHandle.setName("Faucet handle");
        productRepository.save(faucetHandle);
        System.out.println("Faucet handle saved " + faucetHandle);
    }
}
