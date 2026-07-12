package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import java.util.List;

/* ICustomerService.java
   Customer Service Interface
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

public interface ICustomerService {

    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(Customer customer);

    boolean delete(String customerId);

    List<Customer> getAll();
}