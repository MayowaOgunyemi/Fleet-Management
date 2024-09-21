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
    public class UserRole {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "UserRolesID")
        private int userRolesId;

        @ManyToOne
        @JoinColumn(name = "UserID", referencedColumnName = "UserID")
        private User user;

        @ManyToOne
        @JoinColumn(name = "RoleID", referencedColumnName = "Id")
        private Role role;
    }
