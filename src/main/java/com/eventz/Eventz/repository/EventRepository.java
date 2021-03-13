package com.eventz.Eventz.repository;

import com.eventz.Eventz.model.Event;
import com.eventz.Eventz.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findEventByType(EventType type);
}
