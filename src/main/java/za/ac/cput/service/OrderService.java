package za.ac.cput.service;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 12 July 2026
 */
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;
import za.ac.cput.repository.IOrderRepository;


import java.util.List;
import java.util.Optional;


    public class OrderService {

        private final IOrderRepository orderRepository;


        public OrderService(IOrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }


        public Order createOrder(String orderId, List<OrderItem> items) {
            Order order = OrderFactory.create(orderId);
            for (OrderItem item : items) {
            }
            return orderRepository.save(order);
        }


        public Optional<Order> getOrderById(String orderId) {
            return orderRepository.findById(orderId);
        }

        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public void deleteOrder(String orderId) {
            orderRepository.deleteById(orderId);
        }


        public Order addItemToOrder(String orderId, String itemId, int quantity, double unitPrice) {
            Optional<Order> orderOpt = orderRepository.findById(orderId);
            if (orderOpt.isEmpty()) {
                throw new IllegalArgumentException("Order not found: " + orderId);
            }

            OrderItem newItem = OrderItemFactory.create(itemId, quantity, unitPrice);
            Order order = orderOpt.get();



            Order updatedOrder = new Order.Builder()
                    .orderId(order.getOrderId())
                    .OrderDate(order.getOrderDate())
                    .status(order.getStatus())
                    .addItems(order.getItems())
                    .addItem(newItem)
                    .build();

            return orderRepository.save(updatedOrder);
        }
    }

