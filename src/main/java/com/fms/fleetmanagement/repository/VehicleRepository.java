package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Vehicle findByVehicleId(int id);
}