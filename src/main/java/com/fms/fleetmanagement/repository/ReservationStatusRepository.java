package com.fms.fleetmanagement.repository;

import com.fms.fleetmanagement.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Integer> {
    ReservationStatus findByStatusId(int id);
}