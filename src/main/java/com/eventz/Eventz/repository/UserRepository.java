package com.eventz.Eventz.repository;
import com.eventz.Eventz.dto.EventDTO;
import com.eventz.Eventz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findByEmailIgnoreCase(String email);

}
