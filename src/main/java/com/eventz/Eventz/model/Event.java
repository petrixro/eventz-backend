package com.eventz.Eventz.model;
import lombok.*;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;


@Setter @Getter
@NoArgsConstructor
@Entity
@Table (name = "events")
public class Event {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    private Integer tickets;

    @NotBlank
    private LocalDateTime date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EventType type;

    @NotBlank
    private String description;

    @NotBlank
    private String location;

    @ManyToMany
    private Set<User> userEvents = new HashSet<>();

}
