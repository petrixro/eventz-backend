package com.eventz.Eventz.controller;

import com.eventz.Eventz.converter.EventConverter;
import com.eventz.Eventz.dto.EventDTO;
import com.eventz.Eventz.dto.UserDTO;
import com.eventz.Eventz.model.Event;
import com.eventz.Eventz.model.EventType;
import com.eventz.Eventz.model.User;
import com.eventz.Eventz.service.EventService;
import com.eventz.Eventz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

    @Autowired
    private EventConverter eventConverter;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @GetMapping("/events/")
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return eventConverter.modelToDto(events);
    }

    @GetMapping("/events/user/{userId}")
    public List<EventDTO> getEventsByUser(@PathVariable(value = "userId") UUID userid){
        List<Event> events = eventService.getEventsByUserId(userid);
        return eventConverter.modelToDto(events);
    }

    @PostMapping("/events/add/{uId}")
    public EventDTO addEvent(@RequestBody EventDTO newEvent, @PathVariable(value = "uId") UUID id){
        Event event = eventConverter.dtoToModel(newEvent);
        User user = userService.getUserById(id);
        user.getEvents().add(event);
        return eventConverter.modelToDto(eventService.addEvent(event));
    }

    @GetMapping("/events/{id}")
    public EventDTO getEventByID(@PathVariable UUID id){
        Event event = eventService.getEventById(id);
        return eventConverter.modelToDto(event);
    }

    @PostMapping("/events/tickets/{id}/{userId}")
    public ResponseEntity updateTickets(@RequestBody String tickets, @PathVariable("id") UUID id, @PathVariable("userId") UUID userid) throws JSONException {
        System.out.println(tickets);
        JSONObject jsonObject = new JSONObject(tickets);
        Integer ticketsnumber = jsonObject.getInt("tickets");
        Event event = eventService.getEventById(id);
        User user = userService.getUserById(userid);
        user.getEvents().add(event);
        event.setTickets(event.getTickets()-ticketsnumber);
        return ResponseEntity.ok("Event Booked");
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
