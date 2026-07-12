package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

    class OrderServiceTest {

        @Mock
        private OrderRepository orderRepository;

        private OrderService orderService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            orderService = new OrderService(orderRepository);
        }

        @Test
        void testCreateOrder() {
            OrderItem item = new OrderItem.Builder()
                    .itemId("ITEM-001")
                    .quantity(2)
                    .unitPrice(50.0)
                    .build();

            Order order = orderService.createOrder("ORD-001", List.of(item));

            assertNotNull(order);
            assertEquals("ORD-001", order.getOrderId());
            verify(orderRepository, times(1)).save(any(Order.class));
        }

        @Test
        void testGetOrderById() {
            Order mockOrder = new Order.Builder().orderId("ORD-001").build();
            when(orderRepository.findById("ORD-001")).thenReturn(Optional.of(mockOrder));

            Optional<Order> result = orderService.getOrderById("ORD-001");

            assertTrue(result.isPresent());
            assertEquals("ORD-001", result.get().getOrderId());
        }

        @Test
        void testDeleteOrder() {
            orderService.deleteOrder("ORD-001");
            verify(orderRepository, times(1)).deleteById("ORD-001");
        }
    }

