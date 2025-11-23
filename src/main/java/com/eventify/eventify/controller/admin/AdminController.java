package com.eventify.eventify.controller.admin;


import com.eventify.eventify.dto.response.UserResponse;
import com.eventify.eventify.service.EventService;
import com.eventify.eventify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final EventService eventService;

    @GetMapping("/users")
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userService.getAll(pageable);
    }

    @PutMapping("/users/{id}/role")
    public ResponseEntity<UserResponse> updateUserRole(
            @PathVariable UUID id,
            @RequestParam String role) {
        UserResponse updatedUser = userService.updateRole(id, role);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable UUID id) {
        eventService.delete(id);
        return ResponseEntity.ok("Event deleted");
    }
}