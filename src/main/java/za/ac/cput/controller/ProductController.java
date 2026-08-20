package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.IProductService;
import za.ac.cput.service.ProductService;

import java.util.List;
/* ProductController.java
   Product REST Controller
   Author: Sinoxolo Kobeni (230801846)
   Date: 19/07/2026
*/
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping("/{productId}")
    public Product read(@PathVariable String productId) {
        return service.read(productId);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("/{productId}")
    public boolean delete(@PathVariable String productId) {
        return service.delete(productId);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }
}