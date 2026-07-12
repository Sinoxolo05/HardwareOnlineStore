package za.ac.cput.repository;

import za.ac.cput.domain.Address;

import java.util.ArrayList;
import java.util.List;

/* AddressRepository.java
   Address Repository Implementation
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public class AddressRepository implements IAddressRepository {

    private static AddressRepository repository = null;
    private final List<Address> addressList;

    private AddressRepository() {
        addressList = new ArrayList<>();
    }

    public static AddressRepository getRepository() {
        if (repository == null) {
            repository = new AddressRepository();
        }
        return repository;
    }

    @Override
    public Address create(Address address) {
        boolean success = addressList.add(address);
        if (success) {
            return address;
        }
        return null;
    }

    @Override
    public Address read(String streetAddress) {
        return addressList.stream()
                .filter(address -> address.getStreetAddress().equalsIgnoreCase(streetAddress))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Address update(Address address) {
        Address existingAddress = read(address.getStreetAddress());

        if (existingAddress != null) {
            addressList.remove(existingAddress);
            addressList.add(address);
            return address;
        }

        return null;
    }

    @Override
    public boolean delete(String streetAddress) {
        Address address = read(streetAddress);

        if (address != null) {
            return addressList.remove(address);
        }

        return false;
    }

    public List<Address> getAll() {
        return addressList;
    }
}