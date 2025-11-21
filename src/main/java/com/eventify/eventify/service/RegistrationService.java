package com.eventify.eventify.service;

import com.eventify.eventify.dto.request.RegistrationCreateRequest;
import com.eventify.eventify.dto.request.RegistrationUpdateRequest;
import com.eventify.eventify.dto.response.RegistrationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RegistrationService {
    public RegistrationResponse save(RegistrationCreateRequest registrationRequest);
    public RegistrationResponse getRegistrationById(UUID id);
    public RegistrationResponse update(UUID id , RegistrationUpdateRequest registrationResponseRequest);
    public String  delete(UUID id);
    public Page<RegistrationResponse> getAll(Pageable pageable);
}
