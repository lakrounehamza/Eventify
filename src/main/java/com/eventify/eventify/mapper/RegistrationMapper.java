package com.eventify.eventify.mapper;

import com.eventify.eventify.config.MapstructConfig;
import com.eventify.eventify.dto.response.RegistrationResponse;
import com.eventify.eventify.entity.Registration;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = MapstructConfig.class)
public interface RegistrationMapper {

     RegistrationResponse toResponse(Registration registration);

    List<RegistrationResponse> toResponseList(List<Registration> registrations);
}