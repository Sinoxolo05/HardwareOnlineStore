package za.ac.cput.repository;

import za.ac.cput.domain.Product;

import java.util.HashSet;
import java.util.Set;

/* ProductRepository.java
   Product Repository Implementation
   Author: Sinoxolo Kobeni (230801846)
   Date: 5 June 2026 */

public class ProductRepository implements IProductRepository {

    private static ProductRepository repository = null;

    private final Set<Product> productDB;

    private ProductRepository() {
        productDB = new HashSet<>();
    }

    public static ProductRepository getRepository() {
        if (repository == null) {
            repository = new ProductRepository();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        productDB.add(product);
        return product;
    }

    @Override
    public Product read(String productId) {
        for (Product product : productDB) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product update(Product product) {

        Product oldProduct = read(product.getProductId());

        if (oldProduct != null) {
            productDB.remove(oldProduct);
            productDB.add(product);
            return product;
        }

        return null;
    }

    @Override
    public boolean delete(String productId) {

        Product product = read(productId);

        if (product != null) {
            productDB.remove(product);
            return true;
        }

        return false;
    }

    public Set<Product> getAll() {
        return productDB;
    }
}
