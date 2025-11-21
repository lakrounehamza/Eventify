package com.eventify.eventify.repository;

import com.eventify.eventify.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository  extends JpaRepository<Event, UUID> {
}
