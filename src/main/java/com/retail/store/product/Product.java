package com.retail.store.product;

/**
 * Created by tonderain on 2022/09/05.
 */
public class Product {
    private final long id;
    private final String description;

    public Product(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
