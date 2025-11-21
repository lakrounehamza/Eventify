package com.eventify.eventify.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUpdateRequest {
    private UUID userId;

    private UUID eventId;

    private LocalDateTime registeredAt;

    private String status ;

}
