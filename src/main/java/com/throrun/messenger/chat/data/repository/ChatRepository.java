package com.throrun.messenger.chat.data.repository;

import com.throrun.messenger.chat.data.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
