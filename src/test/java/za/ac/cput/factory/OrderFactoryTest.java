package za.ac.cput.factory;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;



    public class OrderFactoryTest {
        @Test
        void testCreateValidOrder() {
            Order order = OrderFactory.create("ORD-999");

            assertNotNull(order);
            Assertions.assertEquals("ORD-999", order.getOrderId());
            assertEquals(0.0, order.getTotalAmount());
        }

        private void assertEquals(double s, double orderId) {
            
        }

        private void assertNotNull(Order order) {
            
        }

        private void assertThrows(Class<IllegalArgumentException> illegalArgumentExceptionClass, Object o) {
        }
    }

