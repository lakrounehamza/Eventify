package com.eventify.eventify.service;

import com.eventify.eventify.dto.request.EventCreateRequest;
import com.eventify.eventify.dto.request.EventUpdateRequest;
import com.eventify.eventify.dto.response.EventResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface EventService {
    public EventResponse save(EventCreateRequest eventRequest);
    public EventResponse getEventById(UUID id);
    public EventResponse update(UUID id , EventUpdateRequest eventRequest);
    public String  delete(UUID id);
    public Page<EventResponse> getAll();
}
