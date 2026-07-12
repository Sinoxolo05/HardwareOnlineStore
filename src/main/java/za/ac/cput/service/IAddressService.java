package za.ac.cput.service;

import za.ac.cput.domain.Address;
import java.util.List;

/* IAddressService.java
   Address Service Interface
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

public interface IAddressService {

    Address create(Address address);

    Address read(String streetAddress);

    Address update(Address address);

    boolean delete(String streetAddress);

    List<Address> getAll();
}