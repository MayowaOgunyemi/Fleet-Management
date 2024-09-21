package com.fms.fleetmanagement.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleReservationDTO {
    private int reservationID;
    private int requestId;
    private int approvedBy;
    private LocalDateTime approvalDate;
}
