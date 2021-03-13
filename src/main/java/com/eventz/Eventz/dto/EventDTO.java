package com.eventz.Eventz.dto;

import com.eventz.Eventz.model.EventType;
import lombok.Data;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EventDTO {

    private UUID id;

    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    private Integer tickets;

    @NotBlank
    private LocalDateTime date;

    @NotBlank
    private String description;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EventType type;

    @NotBlank
    private String location;
}
