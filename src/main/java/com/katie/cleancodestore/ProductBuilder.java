package com.katie.cleancodestore;

public interface ProductBuilder {
    Product build();
    ProductBuilder setName(final String name);
    ProductBuilder setPrice(final Double price);

}
