package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 28 June 2026
 */

public class OrderItemFactory {

        public static OrderItem create(String itemId, int quantity, double unitPrice) {
            if (Helper.isNullOrEmpty(itemId)) {
                throw new IllegalArgumentException("Item ID can not  be empty or null");
            }
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative or empty");
            }
            if (unitPrice < 0) {
                throw new IllegalArgumentException("Price cannot be negative or empty");
            }

            return new OrderItem.Builder()
                    .itemId(itemId)
                    .quantity(quantity)
                    .unitPrice(unitPrice)
                    .build();
        }
    }

