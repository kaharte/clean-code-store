package com.katie.cleancodestore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTests {

    @Test
    public void productShouldReturnCorrectName() {
        Product product = new Product();
        product.setName("Dongle");

        Assert.assertEquals("Dongle", product.getName());
    }

    @Test
    public void productShouldBeAddedToDatabase() {
        Product product = new Product();
        String id = product.getId();

        ProductDatabase database = new ProductDatabase();

        Assert.assertNotNull(database.getProduct(id));
    }

}
