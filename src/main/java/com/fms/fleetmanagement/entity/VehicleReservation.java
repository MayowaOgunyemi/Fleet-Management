package com.fms.fleetmanagement.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;


// Role.java
@Getter
@Setter
@Entity
@Data
public class VehicleReservation {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservationID")
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "RequestID", referencedColumnName = "RequestID")
    private RentalRequest rentalRequest;

    @ManyToOne
    @JoinColumn(name = "ApprovedBy", referencedColumnName = "UserID")
    private User approvedBy;

    @Column(name = "ApprovalDate")
    private LocalDateTime approvalDate;
}