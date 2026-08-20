package za.ac.cput.service;

import za.ac.cput.domain.Category;
import za.ac.cput.repository.AddressRepository;

import java.util.List;
/* CategoryService.java
   Category Service Implementation using Singleton Pattern
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

import org.springframework.stereotype.Service;
import za.ac.cput.repository.ICategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Category read(String categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public Category update(Category category) {
        return repository.save(category);
    }

    @Override
    public boolean delete(String categoryId) {
        if (repository.existsById(categoryId)) {
            repository.deleteById(categoryId);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }
}