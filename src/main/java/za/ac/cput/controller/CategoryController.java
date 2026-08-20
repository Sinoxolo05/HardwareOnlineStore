package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;

import java.util.List;
/* CategoryController.java
   Category REST Controller
   Author: Sinoxolo Kobeni (230801846)
   Date: 19/07/2026
*/
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final ICategoryService service;

    public CategoryController(ICategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    @GetMapping("/{categoryId}")
    public Category read(@PathVariable String categoryId) {
        return service.read(categoryId);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @DeleteMapping("/{categoryId}")
    public boolean delete(@PathVariable String categoryId) {
        return service.delete(categoryId);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }
}