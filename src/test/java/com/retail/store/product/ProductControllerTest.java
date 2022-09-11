package com.retail.store.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tonderain on 2022/09/11.
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void findAllProducts() throws Exception {
        mockMvc.perform(get("/view-products"))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("Cooking Oil")))
                .andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("Juice")))
                .andExpect(result -> assertTrue(result.getResponse().getContentAsString().contains("Mealie Meal")));
    }

    @Test
    void findProductById() throws Exception {
        Product product = new Product(1, "Cooking Oil");
        mockMvc.perform(get("/view-product/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(product)));
    }

    @Test
    void addProduct() throws Exception {
        Product newProduct = new Product(-1, "Test Product");
        mockMvc.perform(post("/add-product")
                        .content(objectMapper.writeValueAsString(newProduct))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        // Retrieve the added product
        mockMvc.perform(get("/view-product/{id}", newProduct.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(newProduct)));
    }

    @Test
    void modifyProduct() throws Exception {
        Product modifiedProduct = new Product(2, "Juice 2l");
        mockMvc.perform(put("/modify-product")
                        .content(objectMapper.writeValueAsString(modifiedProduct))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        // Retrieve the modified product
        mockMvc.perform(get("/view-product/{id}", modifiedProduct.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(modifiedProduct)));
    }

    @Test
    void removeProduct() throws Exception {
        Long deletedProductId = 3L;
        mockMvc.perform(delete("/remove-product/{id}", deletedProductId))
                .andExpect(status().isOk());
    }

}
