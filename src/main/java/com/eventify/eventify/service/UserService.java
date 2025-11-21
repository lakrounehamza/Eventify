package com.eventify.eventify.service;

import com.eventify.eventify.dto.request.RegistrationCreateRequest;
import com.eventify.eventify.dto.response.RegistrationResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {
    public RegistrationResponse save(RegistrationCreateRequest registrationRequest);
    public RegistrationResponse getEventById(UUID id);
    public RegistrationResponse update(UUID id ,RegistrationResponse registrationResponseRequest);
    public String  delete(UUID id);
    public Page<RegistrationResponse> getAll();
}
