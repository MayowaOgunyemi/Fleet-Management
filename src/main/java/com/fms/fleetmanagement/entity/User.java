package com.fms.fleetmanagement.entity;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;

    @Email
    private String email;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Column(name = "SessionToken")
    private String sessionToken;
}
