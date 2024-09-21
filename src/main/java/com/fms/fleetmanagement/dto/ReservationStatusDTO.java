package com.fms.fleetmanagement.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationStatusDTO {
    private int statusID;
    private String status;
}
