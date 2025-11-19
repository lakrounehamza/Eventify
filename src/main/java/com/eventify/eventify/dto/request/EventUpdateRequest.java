package com.eventify.eventify.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventUpdateRequest {

    @Size(max = 200)
    private String title;

    private String description;

    private String location;

    @FutureOrPresent
    private LocalDateTime dateTime;

    @Min(1)
    @Max(10000)
    private Integer capacity;
}