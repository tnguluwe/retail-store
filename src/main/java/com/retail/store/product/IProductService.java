package com.retail.store.product;

import java.util.List;

/**
 *  <p>Description: This interface defines the contract for the service class used to support the rest endpoint functionality.</p>
 *
 *  <p>Note: I decided to use this for the flexibility of demonstrating how one can apply different implementations/flavours of retrieving data and then inject/autowire
 *          each of them to separately in the rest controller class to experience different implementations. Examples implementation are:
 *          <li>1. One that stores and retrieves objects in memory as a list</li>
 *          <li>2. One that stores and retrieves objects in an in-memory database like H2</li>
 *          <li>2. One that stores and retrieves objects in an relational database like oracle, mysql, postgresql etc</li>
 *          </p>
 *
 * Created by tonderain on 2022/09/05.
 */
public interface IProductService {

    List<Product> allProducts();

    Product findProductById(long id);

    void addProduct(Product newProduct);

    void updateProduct(Product product);
}
