package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// PermissionRepository.java
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findById(int id);
    Optional<Permission> findByName(String name);
}

