package com.eventify.eventify.mapper;

import com.eventify.eventify.dto.request.UserRegisterRequest;
import com.eventify.eventify.dto.request.UserUpdateRequest;
import com.eventify.eventify.dto.response.UserResponse;
import com.eventify.eventify.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", constant = "ROLE_USER")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(UserRegisterRequest request);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(UserUpdateRequest request, @MappingTarget User user);
}