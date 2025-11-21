package com.eventify.eventify.controller.user;

import com.eventify.eventify.dto.response.UserResponse;
import com.eventify.eventify.dto.response.RegistrationResponse;
import com.eventify.eventify.service.RegistrationService;
import com.eventify.eventify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RegistrationService registrationService;

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(@RequestParam UUID id) {
        return ResponseEntity.ok(userService.getEventById(id));
    }

    @PostMapping("/events/{id}/register")
    public ResponseEntity<RegistrationResponse> registerEvent(
            @PathVariable UUID id,
            @RequestBody RegistrationResponse registrationRequest) {
        return ResponseEntity.ok(registrationService.save(null));
    }

    @GetMapping("/registrations")
    public Page<RegistrationResponse> getAllRegistrations(Pageable pageable) {
        return registrationService.getAll(pageable);
    }
}