package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByUserRolesId(int id);
}