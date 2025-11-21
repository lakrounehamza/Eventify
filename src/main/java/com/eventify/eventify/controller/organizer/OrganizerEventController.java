package com.eventify.eventify.controller.organizer;


import com.eventify.eventify.dto.request.EventCreateRequest;
import com.eventify.eventify.dto.request.EventUpdateRequest;
import com.eventify.eventify.dto.response.EventResponse;
import com.eventify.eventify.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/organizer/events")
@RequiredArgsConstructor
public class OrganizerEventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventCreateRequest request) {
        return ResponseEntity.ok(eventService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> updateEvent(@PathVariable UUID id, @RequestBody EventUpdateRequest request) {
        return ResponseEntity.ok(eventService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable UUID id) {
        return ResponseEntity.ok(eventService.delete(id));
    }
}