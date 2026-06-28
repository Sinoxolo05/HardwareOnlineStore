package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;
/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 28 June 2026
 */

public class OrderFactory {



        public static Order create(String orderId) {
            if (Helper.isNullOrEmpty(orderId)) {
                throw new IllegalArgumentException("Order ID cannot be empty");
            }

            return new Order.Builder()
                    .orderId(orderId)
                    .status("PENDING")
                    .build();
        }
    }


