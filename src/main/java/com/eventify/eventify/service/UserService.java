package com.eventify.eventify.service;

import com.eventify.eventify.dto.request.RegistrationCreateRequest;
import com.eventify.eventify.dto.request.UserRegisterRequest;
import com.eventify.eventify.dto.request.UserUpdateRequest;
import com.eventify.eventify.dto.response.RegistrationResponse;
import com.eventify.eventify.dto.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {
    public UserResponse save(UserRegisterRequest userRequest);
    public UserResponse getEventById(UUID id);
    public UserResponse update(UUID id , UserUpdateRequest userRequest);
    public String  delete(UUID id);
    public Page<UserResponse> getAll(Pageable pageable);
}
