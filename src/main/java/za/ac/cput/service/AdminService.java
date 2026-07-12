package za.ac.cput.service;

import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;

import java.util.List;

/* AdminService.java
   Admin Service Implementation
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

public class AdminService implements IAdminService {

    private static AdminService service = null;
    private final AdminRepository repository;

    private AdminService() {
        repository = AdminRepository.getRepository();
    }

    public static AdminService getService() {
        if (service == null) {
            service = new AdminService();
        }
        return service;
    }

    @Override
    public Admin create(Admin admin) {
        return repository.create(admin);
    }

    @Override
    public Admin read(String adminId) {
        return repository.read(adminId);
    }

    @Override
    public Admin update(Admin admin) {
        return repository.update(admin);
    }

    @Override
    public boolean delete(String adminId) {
        return repository.delete(adminId);
    }

    @Override
    public List<Admin> getAll() {
        return repository.getAll();
    }
}