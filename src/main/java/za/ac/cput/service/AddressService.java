package za.ac.cput.service;

import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

/* AddressService.java
   Address Service Implementation
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

public class AddressService implements IAddressService {

    private static AddressService service = null;
    private final AddressRepository repository;

    private AddressService() {
        repository = AddressRepository.getRepository();
    }

    public static AddressService getService() {
        if (service == null) {
            service = new AddressService();
        }
        return service;
    }

    @Override
    public Address create(Address address) {
        return repository.create(address);
    }

    @Override
    public Address read(String streetAddress) {
        return repository.read(streetAddress);
    }

    @Override
    public Address update(Address address) {
        return repository.update(address);
    }

    @Override
    public boolean delete(String streetAddress) {
        return repository.delete(streetAddress);
    }

    @Override
    public List<Address> getAll() {
        return repository.getAll();
    }
}