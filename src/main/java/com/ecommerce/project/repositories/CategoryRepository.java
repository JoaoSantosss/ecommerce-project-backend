package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
