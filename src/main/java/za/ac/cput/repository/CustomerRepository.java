package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

/* CustomerRepository.java
   Customer Repository Implementation
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public class CustomerRepository implements ICustomerRepository {

    private static CustomerRepository repository = null;
    private final List<Customer> customerList;

    private CustomerRepository() {
        customerList = new ArrayList<>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        boolean success = customerList.add(customer);

        if (success) {
            return customer;
        }

        return null;
    }

    @Override
    public Customer read(String customerId) {
        return customerList.stream()
                .filter(customer -> customer.getCustomerId().equalsIgnoreCase(customerId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        Customer existingCustomer = read(customer.getCustomerId());

        if (existingCustomer != null) {
            customerList.remove(existingCustomer);
            customerList.add(customer);
            return customer;
        }

        return null;
    }

    @Override
    public boolean delete(String customerId) {
        Customer customer = read(customerId);

        if (customer != null) {
            return customerList.remove(customer);
        }

        return false;
    }

    public List<Customer> getAll() {
        return customerList;
    }
}