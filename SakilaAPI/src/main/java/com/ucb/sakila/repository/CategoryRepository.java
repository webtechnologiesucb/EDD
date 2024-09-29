package com.ucb.sakila.repository;

import com.ucb.sakila.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByIsDeletedFalse();
}
