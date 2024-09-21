package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RentalRequestRepository extends JpaRepository<RentalRequest, Integer> {
    RentalRequest findByRequestId(int id);
}