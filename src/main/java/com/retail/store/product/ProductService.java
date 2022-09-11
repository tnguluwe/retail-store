package com.retail.store.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * <p>Description: This is a service class that simply stores a list of products in memory for demonstration purposes.</p>
 * <p>
 * Created by tonderain on 2022/09/05.
 */
@Service
public class ProductService implements IProductService {

    // Temporarily store the products in memory
    final List<Product> products = new ArrayList<>();

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
    public Product findProductById(Long productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addProduct(Product newProduct) {
        Optional.ofNullable(newProduct).orElseThrow(() -> new ProductException("The new supplied product cannot be null"));
        products.add(newProduct);
    }

    @Override
    public void modifyProduct(Product modifiedProduct) {
        removeProductById(modifiedProduct.getId());
        products.add(modifiedProduct);
    }

    @Override
    public void removeProduct(Long id) {
        removeProductById(id);
    }

    private void removeProductById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }
}
