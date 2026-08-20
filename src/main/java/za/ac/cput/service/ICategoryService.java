package za.ac.cput.service;

import za.ac.cput.domain.Category;
import java.util.List;

import java.util.Set;
/* ICategoryService.java
   Category Service Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

public interface ICategoryService {

    Category create(Category category);

    Category read(String categoryId);

    Category update(Category category);

    boolean delete(String categoryId);

    List<Category> getAll();
}