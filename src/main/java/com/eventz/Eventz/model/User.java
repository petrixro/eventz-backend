package com.eventz.Eventz.model;

import lombok.*;
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

    @ManyToMany(mappedBy="userEvents", fetch = FetchType.LAZY)
    private Set<Event> events = new HashSet<>();

    @Override
    public String toString(){
        return "User [id=" + id + ", name=" + username + "]";
    }
}
