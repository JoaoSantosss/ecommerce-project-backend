package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.models.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{

}
