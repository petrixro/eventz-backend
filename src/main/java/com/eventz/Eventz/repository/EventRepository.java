package com.eventz.Eventz.repository;

import com.eventz.Eventz.model.Event;
import com.eventz.Eventz.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findEventByType(EventType type);
    List<Event> findEventsByTitleContainingIgnoreCase(String title);

    @Query(value = "SELECT id, date, description, location, tickets, title, type from events " +
            "INNER JOIN user_events ue on events.id = ue.events_id where ue.user_id = ?1", nativeQuery = true)
    List<Event> findEventsByUserId(UUID uuid);


}
