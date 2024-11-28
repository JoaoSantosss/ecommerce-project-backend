package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.models.SellerUser;

public interface SellerUserRepository extends JpaRepository<SellerUser, Integer>{

}
