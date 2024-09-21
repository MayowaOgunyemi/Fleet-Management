package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerId(int id);
}