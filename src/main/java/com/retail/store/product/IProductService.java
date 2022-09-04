package com.retail.store.product;

import java.util.List;

/**
 * Created by tonderain on 2022/09/05.
 */
public interface IProductService {

    List<Product> allProducts();

    Product findProductById(long id);

    void addProduct(Product newProduct);

    void updateProduct(Product product);
}
