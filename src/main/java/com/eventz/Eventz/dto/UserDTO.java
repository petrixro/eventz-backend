package com.eventz.Eventz.dto;

import com.eventz.Eventz.model.EventType;
import com.eventz.Eventz.model.UserRole;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
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
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserRole role;


}
