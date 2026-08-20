package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/*
 ProductControllerTest.java
 Product Controller Test
 Author: Sinoxolo Kobeni (230801846)
 Date: 19/07/2026
*/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

    @Autowired
    private ProductController controller;

    private static final Product product = new Product.Builder()
            .setProductId("P001")
            .setCategoryId("C001")
            .setName("Laptop")
            .setSku("SKU001")
            .setDescription("A laptop computer")
            .setPrice(new BigDecimal("999.99"))
            .setWeight(2.5)
            .setDimensions("35x25x2")
            .setImageUrl("https://example.com/laptop.jpg")
            .build();

    @Test
    @Order(1)
    void create() {
        Product created = controller.create(product);

        assertNotNull(created);
        assertEquals("P001", created.getProductId());
    }

    @Test
    @Order(2)
    void read() {
        Product read = controller.read(product.getProductId());

        assertNotNull(read);
        assertEquals("P001", read.getProductId());
    }

    @Test
    @Order(3)
    void update() {

        Product updated = new Product.Builder()
                .copy(product)
                .setName("Gaming Laptop")
                .setPrice(new BigDecimal("1299.99"))
                .build();

        Product result = controller.update(updated);

        assertNotNull(result);
        assertEquals("Gaming Laptop", result.getName());
        assertEquals(new BigDecimal("1299.99"), result.getPrice());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(controller.delete(product.getProductId()));
    }
}
