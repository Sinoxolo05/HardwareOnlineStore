package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.util.List;
/* ProductService.java
   Product Service Implementation using Singleton Pattern
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

import org.springframework.stereotype.Service;
import za.ac.cput.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product read(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public boolean delete(String productId) {
        if (repository.existsById(productId)) {
            repository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
}