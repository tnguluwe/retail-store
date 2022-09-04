package com.retail.store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tonderain on 2022/09/05.
 */
@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/product/all")
    public List<Product> findAllProducts() {
        return productService.allProducts();
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product findAllProducts(@PathVariable Long id) {
        if (id == null)
            return null;
        return productService.findProductById(id);
    }
}
