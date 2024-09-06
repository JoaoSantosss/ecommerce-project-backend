package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
