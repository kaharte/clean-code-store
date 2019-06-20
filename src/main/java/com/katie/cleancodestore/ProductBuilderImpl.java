package com.katie.cleancodestore;

public class ProductBuilderImpl implements ProductBuilder {
    Product productTemp;

    public ProductBuilderImpl() {
        productTemp = new Product();
    }

    @Override
    public Product build() {
        return null;
    }

    //How important is it that these methods return an instance of ProductBuilder?
    @Override
    public ProductBuilder setName(String name) {
        productTemp.setName(name);

        return this;
    }

    @Override
    public ProductBuilder setPrice(Double price) {
        productTemp.setPrice(price);

        return this;
    }
}
