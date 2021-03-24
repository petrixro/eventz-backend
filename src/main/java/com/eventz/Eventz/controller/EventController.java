package com.eventz.Eventz.controller;

import com.eventz.Eventz.converter.EventConverter;
import com.eventz.Eventz.dto.EventDTO;
import com.eventz.Eventz.dto.UserDTO;
import com.eventz.Eventz.model.Event;
import com.eventz.Eventz.model.EventType;
import com.eventz.Eventz.model.User;
import com.eventz.Eventz.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://eventz-app.herokuapp.com/")
public class EventController {

    @Autowired
    private EventConverter eventConverter;

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<EventDTO> getAllUsers() {
        List<Event> events = eventService.getAllEvents();
        return eventConverter.modelToDto(events);
    }

    @PostMapping("/events")
    public EventDTO addEvent(@RequestBody EventDTO newEvent){
        Event event = eventConverter.dtoToModel(newEvent);
        return eventConverter.modelToDto(eventService.addEvent(event));
    }

    @GetMapping("/events/{id}")
    public EventDTO getEventByID(@PathVariable UUID id){
        Event event = eventService.getEventById(id);
        return eventConverter.modelToDto(event);
    }

    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable UUID id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/events/type/{type}")
    public List<EventDTO> getEventsByType(@PathVariable (value = "type") EventType eventType) {
        List<Event> events = eventService.getEventsByType(eventType);
        return eventConverter.modelToDto(events);
    }

    @GetMapping("/events/title/{title}")
    public List<EventDTO> getEventsByTitle(@PathVariable (value = "title") String Title) {
        List<Event> events = eventService.getEventsByName(Title);
        return eventConverter.modelToDto(events);
    }


}
