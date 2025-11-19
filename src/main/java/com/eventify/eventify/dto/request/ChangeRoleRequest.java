package com.eventify.eventify.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ChangeRoleRequest {

    @NotBlank
    @Pattern(regexp = "ROLE_USER|ROLE_ORGANIZER|ROLE_ADMIN", message = "Invalid role")
    private String newRole;
}