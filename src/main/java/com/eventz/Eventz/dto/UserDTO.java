package com.eventz.Eventz.dto;

import com.eventz.Eventz.model.Event;
import com.eventz.Eventz.model.EventType;
import com.eventz.Eventz.model.UserRole;
import lombok.Data;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@ToString
public class UserDTO {

    private UUID id;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String password;


    private Set<EventDTO> events;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserRole role;


}
