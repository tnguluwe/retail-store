package com.retail.store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description: This is a controller class that is used to expose the REST API endpoint for the retail store.</p>
 *
 * Created by tonderain on 2022/09/05.
 */
@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/view-products", method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAllProducts() {
        return productService.allProducts();
    }

    @GetMapping("/view-product/{id}")
    public Product findProductById(@PathVariable Long id) {
        if (id == null)
            return null;
        return productService.findProductById(id);
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
    }

    @PutMapping("/modify-product")
    public void modifyProduct(@RequestBody Product newProduct) {
        productService.modifyProduct(newProduct);
    }

    @DeleteMapping("/remove-product/{id}")
    public void removeProduct(@PathVariable Long id) {
        productService.removeProduct(id);
    }
}
