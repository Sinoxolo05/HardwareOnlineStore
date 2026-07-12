package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

/* CustomerService.java
   Customer Service Implementation
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

public class CustomerService implements ICustomerService {

    private static CustomerService service = null;
    private final CustomerRepository repository;

    private CustomerService() {
        repository = CustomerRepository.getRepository();
    }

    public static CustomerService getService() {
        if (service == null) {
            service = new CustomerService();
        }
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer read(String customerId) {
        return repository.read(customerId);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public boolean delete(String customerId) {
        return repository.delete(customerId);
    }

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }
}