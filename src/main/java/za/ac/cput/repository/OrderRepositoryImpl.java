package za.ac.cput.repository;


/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 12 July 2026
 */

import za.ac.cput.domain.Order;
import java.util.List;
import java.util.Optional;


    public class OrderRepositoryImpl implements IOrderRepository {



        @Override
        public Order save(Order order) {
            if (order.getOrderId() == null || order.getOrderId().isEmpty()) {
                em.persist(order);
                return order;
            } else {
                return em.merge(order);
            }
        }

        @Override
        public Optional<Order> findById(String orderId) {
            return Optional.ofNullable(em.find(Order.class, orderId));
        }

        @Override
        public List<Order> findAll() {
            return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
        }

        @Override
        public void deleteById(String orderId) {
            Order order = em.find(Order.class, orderId);
            if (order != null) {
                em.remove(order);
            }
        }
    }

