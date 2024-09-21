package com.fms.fleetmanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private int userRolesId;
    private int userId;
    private int permissionId;
}
