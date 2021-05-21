package com.eventz.Eventz.service;


import com.eventz.Eventz.exceptions.EventNotFoundException;
import com.eventz.Eventz.model.Event;
import com.eventz.Eventz.model.EventType;
import com.eventz.Eventz.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByUserId(UUID userID){
        return eventRepository.findEventsByUserId(userID);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(UUID id) {
        eventRepository.delete(getEventById(id));
    }

    public Event getEventById(UUID id) {
        return eventRepository.findById(id).
                orElseThrow(() -> new EventNotFoundException(id));
    }

    public List<Event> getEventsByName(String name){
        return eventRepository.findEventsByTitleContainingIgnoreCase(name);
    }

    public List<Event> getEventsByType(EventType eventType){
        return eventRepository.findEventByType(eventType);
    }
}
