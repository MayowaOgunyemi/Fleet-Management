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
public class RentalRequest {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "VehicleID", referencedColumnName = "VehicleID")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "ApprovedBy", referencedColumnName = "UserID")
    private User approvedBy;

    @Column(name = "RentalDate")
    private LocalDateTime rentalDate;

    @Column(name = "ReturnDate")
    private LocalDateTime returnDate;
}