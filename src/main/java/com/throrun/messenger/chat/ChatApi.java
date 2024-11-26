package com.throrun.messenger.chat;

import com.throrun.messenger.chat.data.model.Chat;
import com.throrun.messenger.chat.req_res.*;
import com.throrun.messenger.common.type.MessengerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChatApi {
    ResponseEntity<MessengerResponse<CreateChatRes>> createChat(NewChatReq chatReq);
    ResponseEntity<MessengerResponse<GetChatsRes>> getAllChats();
    ResponseEntity<MessengerResponse<GetChatsRes>> getMyChats();
    ResponseEntity<MessengerResponse<DeleteChatRes>> deleteChat(DeleteChatReq chatReq);
}
