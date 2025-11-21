package com.eventify.eventify.mapper;

import com.eventify.eventify.config.MapstructConfig;
import com.eventify.eventify.dto.response.RegistrationResponse;
import com.eventify.eventify.entity.Registration;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = MapstructConfig.class)
public interface RegistrationMapper {

    default RegistrationResponse toResponse(Registration registration) {
        if (registration == null) return null;

        return RegistrationResponse.builder()
                .id(registration.getId())
                .userId(registration.getUserId())
                .eventId(registration.getEventId())
                .registeredAt(registration.getRegisteredAt())
                .status(registration.getStatus())
                .build();
    }

    List<RegistrationResponse> toResponseList(List<Registration> registrations);
}