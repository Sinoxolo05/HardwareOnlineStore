package za.ac.cput.domain;

import za.ac.cput.util.Helper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Category.java
 * Category Domain Entity using Builder Pattern
 * Author: Francine Mulangu Kasongo
 * student: 230978649
 * Date: 21 June 2026
 */
public class Order {
    private final String orderId;
    private final LocalDate orderDate;
    private final String status;
    private final double totalAmount;
    private final List<OrderItem> items;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.status = builder.status;
        this.items = builder.items;
        this.totalAmount = calculateTotal();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    private double calculateTotal() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Order{ " + "orderId =" + orderId + "\" " + ", orderDate = " + orderDate + ", status = " + status + "\" " + ", totalAmount =" + totalAmount +
                ", itemsCount =" + items.size() + "}";
    }

    public static class Builder {
        private String orderId;
        private LocalDate orderDate;
        private String status;
        private final List<OrderItem> items = new ArrayList<>();

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Order build() {
            if (Helper.isNullOrEmpty(orderId))
                throw new IllegalArgumentException("orderId is required");
            if (Helper.isNullOrEmpty(orderDate))
                throw new IllegalArgumentException("Date is required");
            if (Helper.isNullOrEmpty(status))
                throw new IllegalArgumentException("Status: ");
            if (Helper.isNullOrEmpty(items))
                throw new IllegalArgumentException("List of items");
            return new Order(this);
        }
    }
}





