package com.fms.fleetmanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int UserId;
    private String email;
    private String passwordHash;
    private String sessionToken;
}
