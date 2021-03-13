package com.eventz.Eventz.converter;

import com.eventz.Eventz.dto.EventDTO;
import com.eventz.Eventz.model.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class EventConverter {

    @Autowired
    private ModelMapper modelMapper;

    public EventDTO modelToDto(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }

    public List<EventDTO> modelToDto(List<Event> eventList) {
        return eventList.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    public Set<EventDTO> modelToDto(Set<Event> eventList) {
        return eventList.stream().map(this::modelToDto).collect(Collectors.toSet());
    }

    public Event dtoToModel(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }
}
