package za.ac.cput.repository;

import za.ac.cput.domain.Admin;

import java.util.ArrayList;
import java.util.List;

/* AdminRepository.java
   Admin Repository Implementation
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public class AdminRepository implements IAdminRepository {

    private static AdminRepository repository = null;
    private final List<Admin> adminList;

    private AdminRepository() {
        adminList = new ArrayList<>();
    }

    public static AdminRepository getRepository() {
        if (repository == null) {
            repository = new AdminRepository();
        }
        return repository;
    }

    @Override
    public Admin create(Admin admin) {
        boolean success = adminList.add(admin);

        if (success) {
            return admin;
        }

        return null;
    }

    @Override
    public Admin read(String adminId) {
        return adminList.stream()
                .filter(admin -> admin.getAdminId().equalsIgnoreCase(adminId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        Admin existingAdmin = read(admin.getAdminId());

        if (existingAdmin != null) {
            adminList.remove(existingAdmin);
            adminList.add(admin);
            return admin;
        }

        return null;
    }

    @Override
    public boolean delete(String adminId) {
        Admin admin = read(adminId);

        if (admin != null) {
            return adminList.remove(admin);
        }

        return false;
    }

    public List<Admin> getAll() {
        return adminList;
    }
}