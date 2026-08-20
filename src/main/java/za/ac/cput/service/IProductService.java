package za.ac.cput.service;

import za.ac.cput.domain.Product;
import java.util.List;
/* IProductService.java
   Product Service Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 12 July 2026 */

public interface IProductService {

    Product create(Product product);

    Product read(String productId);

    Product update(Product product);

    boolean delete(String productId);

    List<Product> getAll();
}