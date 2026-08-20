package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

/*
 CategoryControllerTest.java
 Category Controller Test
 Author: Sinoxolo Kobeni (230801846)
 Date: 19/07/2026
*/

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryControllerTest {

    @Autowired
    private CategoryController controller;

    private static final Category category = new Category.Builder()
            .setCategoryId("C001")
            .setName("Electronics")
            .setParentId("P000")
            .build();

    @Test
    @Order(1)
    void create() {
        Category created = controller.create(category);

        assertNotNull(created);
        assertEquals("C001", created.getCategoryId());
    }

    @Test
    @Order(2)
    void read() {
        Category read = controller.read(category.getCategoryId());

        assertNotNull(read);
        assertEquals("C001", read.getCategoryId());
    }

    @Test
    @Order(3)
    void update() {

        Category updated = new Category.Builder()
                .copy(category)
                .setName("Home Electronics")
                .build();

        Category result = controller.update(updated);

        assertNotNull(result);
        assertEquals("Home Electronics", result.getName());
    }

    @Test
    @Order(4)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(controller.delete(category.getCategoryId()));
    }
}