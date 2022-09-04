package com.retail.store.product;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tonderain on 2022/09/05.
 */
@Component
public class ProductService implements IProductService {

    // Temporarily store the products in memory
    List<Product> products = new ArrayList<>();

    {
        products.addAll(Arrays.asList(
                new Product(1, "Cooking Oil"),
                new Product(2, "Juice"),
                new Product(3, "Mealie Meal"))
        );
    }

    @Override
    public List<Product> allProducts() {
        return products;
    }

    @Override
    public Product findProductById(long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Product with id %d has not been found.", id)));  // Note that a new exception class should be created e.g. ProductNotFoundException a sub-class of RuntimeException.
    }

    @Override
    public void addProduct(Product newProduct) {
        // TODO - implement me
    }

    @Override
    public void updateProduct(Product product) {
        // TODO - implement me
    }
}
