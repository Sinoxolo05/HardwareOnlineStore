package za.ac.cput.repository;

import za.ac.cput.domain.Category;

/* ICategoryRepository.java
   Category Repository Interface
   Author: Sinoxolo Kobeni (230801846)
   Date: 05 July 2026 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
}