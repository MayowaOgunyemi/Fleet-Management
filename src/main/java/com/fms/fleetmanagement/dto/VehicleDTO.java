package com.fms.fleetmanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private int vehicleID;
    private String make;
    private int statusId;
}
