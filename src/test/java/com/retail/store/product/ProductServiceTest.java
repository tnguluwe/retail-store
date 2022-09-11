package com.retail.store.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Created by tonderain on 2022/09/10.
 */

public class ProductServiceTest {
    ProductService productService;

    @BeforeEach
    public void setup() {
        productService = new ProductService();
    }

    @Test
    void allProducts() {
        assertEquals(3, productService.allProducts().size(), "The size should not be null.");
    }

    @Test
    void findProductById() {
        Product firstProduct = productService.findProductById(1L);
        assertTrue(firstProduct.getDescription().equalsIgnoreCase("Cooking Oil"));
    }

    @Test
    void findNonExistentProductById() {
        assertNull(productService.findProductById(-100L));
    }

    @Test
    void addProduct() {
        Product newProduct = new Product(-1, "Test Product");
        productService.addProduct(newProduct);
        Product addedProduct = productService.findProductById(newProduct.getId());
        assertEquals(newProduct.getId(), addedProduct.getId());
        assertEquals(newProduct.getDescription(), addedProduct.getDescription());
    }

    @Test
    void addNullProduct() {
        assertThrows(ProductException.class, () -> productService.addProduct(null));
    }

    @Test
    void modifyProduct() {
        Long modifiedProductId = 1L;
        Product productToModify = productService.findProductById(modifiedProductId);
        String newDescription = "Test Product 1";
        productToModify.setDescription(newDescription);
        productService.modifyProduct(productToModify);

        Product modifiedProduct = productService.findProductById(modifiedProductId);
        assertTrue(modifiedProduct.getDescription().equalsIgnoreCase(newDescription));
    }

    @Test
    void removeProduct() {
        assertFalse(productService.allProducts().isEmpty());
        int currentSize = productService.allProducts().size();
        Long removedProductId = 1L;
        productService.removeProduct(removedProductId);
        assertEquals(productService.allProducts().size(), currentSize - 1);
        assertNull(productService.findProductById(removedProductId));
    }
}