package com.throrun.messenger.user.data.repsitory;

import com.throrun.messenger.user.data.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByNameOrEmail(String name, String email);
}
