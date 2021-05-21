package com.eventz.Eventz.model;

import lombok.*;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "events")
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


//    @JoinTable(name = "user_events",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "events_id",
//                    referencedColumnName = "id"))
    @ManyToMany(mappedBy = "events")
    private Set<User> users = new HashSet<>();

    @NotBlank
    private String location;



}
