package com.fms.fleetmanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private int customerID;
    private String email;
    private String passwordHash;
    private String sessionToken;
}
