package com.katie.cleancodestore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductTests {

    //default implementation is SimpleJpaRepository
    ProductRepository repository;
    Product product;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @Before
    public void setUp() {
        product = new Product();
        product.setName("Dongle");
        product.setId("123");
        repository.save(product);
    }

    @Test
    public void productShouldReturnCorrectName() {
        Assert.assertEquals("Dongle", product.getName());
    }

    @Test
    public void productShouldBeAddedToDatabase() {

        String id = product.getId();

        Assert.assertNotNull(repository.getOne(id));
        Assert.assertEquals(product, repository.getOne(id));
    }

    @Test
    public void uniqueProductIdsShouldBeAutoGenerated() {
        Product product1 = new Product();
        Product product2 = new Product();

        Assert.assertNotNull(repository.getOne(product1.getId()));
        Assert.assertNotNull(repository.getOne(product2.getId()));

        Assert.assertNotEquals(product1.getId(), product2.getId());
    }

}
