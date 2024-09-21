package com.fms.fleetmanagement.entity;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StatusID")
    private int statusId;

    @Column(name = "Status")
    private String status;
}
