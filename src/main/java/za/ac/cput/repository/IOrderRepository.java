package za.ac.cput.repository;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 21 June 2026
 */

import za.ac.cput.domain.Order;
import java.util.List;
import java.util.Optional;

    public interface IOrderRepository {
        Order save(Order order);
        Optional<Order> findById(String orderId);
        List<Order> findAll();
        void deleteById(String orderId);
    }


