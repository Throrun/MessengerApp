package com.throrun.messenger.chat;

import com.throrun.messenger.chat.req_res.*;
import com.throrun.messenger.common.type.MessengerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface ChatApi {
    @PostMapping("/")
    ResponseEntity<MessengerResponse<CreateChatRes>> createChat(NewChatReq chatReq);

    @GetMapping("/")
    ResponseEntity<MessengerResponse<GetChatsRes>> getAllChats();

    @GetMapping("/my")
    ResponseEntity<MessengerResponse<GetChatsRes>> getMyChats();

    @DeleteMapping("/")
    ResponseEntity<MessengerResponse<DeleteChatRes>> deleteChat(DeleteChatReq chatReq);
}
