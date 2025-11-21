package com.eventify.eventify.controller.publi;


import com.eventify.eventify.dto.response.EventResponse;
import com.eventify.eventify.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/events")
@RequiredArgsConstructor
public class PublicEventController {

    private final EventService eventService;

    @GetMapping
    public Page<EventResponse> getAllEvents(Pageable pageable) {
        return eventService.getAll(pageable);
    }
}