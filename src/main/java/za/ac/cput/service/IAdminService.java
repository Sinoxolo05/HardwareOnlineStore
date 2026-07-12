package za.ac.cput.service;

import za.ac.cput.domain.Admin;
import java.util.List;

/* IAdminService.java
   Admin Service Interface
   Author: Paul Khumalo (230108547)
   Date: 12/07/2026
*/

public interface IAdminService {

    Admin create(Admin admin);

    Admin read(String adminId);

    Admin update(Admin admin);

    boolean delete(String adminId);

    List<Admin> getAll();
}