package com.fms.fleetmanagement.entity;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private int customerId;

    @Email
    private String email;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Column(name = "SessionToken")
    private String sessionToken;
}
