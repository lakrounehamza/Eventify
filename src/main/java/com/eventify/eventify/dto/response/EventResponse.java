package com.eventify.eventify.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime dateTime;
    private Integer capacity;
    private Long organizerId;
    private String organizerName;
    private int registeredCount;
}