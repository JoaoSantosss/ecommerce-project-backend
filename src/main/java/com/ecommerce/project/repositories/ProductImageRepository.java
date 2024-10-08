package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.models.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{

}
