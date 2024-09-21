package com.fms.fleetmanagement.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalRequestDTO {
    private int requestId;
    private int customerId;
    private int vehicleId;
    private int approvedBy;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
}
