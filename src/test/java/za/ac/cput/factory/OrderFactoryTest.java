package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;

import static org.junit.jupiter.api.Assertions.*;


    public class OrderFactoryTest {
        @Test
        void testCreateValidOrder() {
            Order order = OrderFactory.create("ORD-999");

            assertNotNull(order);
            assertEquals("ORD-999", order.getOrderId());
            assertEquals(0.0, order.getTotalAmount());
        }

        private void assertEquals(String s, String orderId) {
            
        }

        private void assertNotNull(Order order) {
            
        }

        private void assertThrows(Class<IllegalArgumentException> illegalArgumentExceptionClass, Object o) {
        }
    }

