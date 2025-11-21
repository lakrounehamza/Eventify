package com.eventify.eventify.mapper;

import com.eventify.eventify.config.MapstructConfig;
import com.eventify.eventify.dto.request.EventCreateRequest;
import com.eventify.eventify.dto.request.EventUpdateRequest;
import com.eventify.eventify.dto.response.EventResponse;
import com.eventify.eventify.entity.Event;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = MapstructConfig.class)
public interface EventMapper {

    Event toEntity(EventCreateRequest request);

    EventResponse toResponse(Event event);

    List<EventResponse> toResponseList(List<Event> events);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEventFromRequest(EventUpdateRequest request, @MappingTarget Event event);
}