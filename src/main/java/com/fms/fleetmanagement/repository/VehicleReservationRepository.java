package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.Vehicle;
import com.fms.fleetmanagement.entity.VehicleReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReservationRepository extends JpaRepository<VehicleReservation, Long> {
    Vehicle findByReservationId(int id);
}
