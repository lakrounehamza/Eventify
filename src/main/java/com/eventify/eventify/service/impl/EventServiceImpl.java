package com.eventify.eventify.service.impl;

import com.eventify.eventify.dto.request.EventCreateRequest;
import com.eventify.eventify.dto.request.EventUpdateRequest;
import com.eventify.eventify.dto.response.EventResponse;
import com.eventify.eventify.entity.Event;
import com.eventify.eventify.mapper.EventMapper;
import com.eventify.eventify.repository.EventRepository;
import com.eventify.eventify.service.EventService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventResponse save(EventCreateRequest eventRequest) {
        Event event = eventMapper.toEntity(eventRequest);
        event = eventRepository.save(event);
        return eventMapper.toResponse(event);
    }

    @Override
    public EventResponse getEventById(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        return eventMapper.toResponse(event);
    }

    @Override
    public EventResponse update(UUID id, EventUpdateRequest eventRequest) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        eventMapper.updateEventFromRequest(eventRequest, event);
        event = eventRepository.save(event);
        return eventMapper.toResponse(event);
    }

    @Override
    public String delete(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        eventRepository.delete(event);

        return "Event deleted successfully";
    }

    @Override
    public Page<EventResponse> getAll(Pageable pageable) {
        Page<Event> events = eventRepository.findAll(pageable);
        return events.map(eventMapper::toResponse);
    }
}
