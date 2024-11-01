package com.throrun.messenger.user;

import com.throrun.messenger.user.data.model.Profile;
import com.throrun.messenger.user.data.repsitory.ProfileRepository;

import java.util.UUID;

public class ProfileServiceImpl implements ProfileService {
    ProfileRepository userRepository;

    public void registerNewUser(String name, String email) {
        userRepository.save(Profile.builder().id(UUID.randomUUID()).email(email).name(name).build());
    }
}
