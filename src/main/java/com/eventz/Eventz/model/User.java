package com.eventz.Eventz.model;

import com.eventz.Eventz.dto.EventDTO;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;


@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean isEnabled;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_events",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "events_id",
                    referencedColumnName = "id"))
    private Set<Event> events = new HashSet<>();;


}
