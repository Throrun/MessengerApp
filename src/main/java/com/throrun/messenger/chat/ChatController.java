package com.throrun.messenger.chat;

import com.throrun.messenger.chat.req_res.*;
import com.throrun.messenger.common.type.MessengerResponse;
import org.springframework.http.ResponseEntity;

public class ChatController implements ChatApi{


    @Override
    public ResponseEntity<MessengerResponse<CreateChatRes>> createChat(NewChatReq chatReq) {
        return null;
    }

    @Override
    public ResponseEntity<MessengerResponse<GetChatsRes>> getAllChats() {
        return null;
    }

    @Override
    public ResponseEntity<MessengerResponse<GetChatsRes>> getMyChats() {
        return null;
    }

    @Override
    public ResponseEntity<MessengerResponse<DeleteChatRes>> deleteChat(DeleteChatReq chatReq) {
        return null;
    }
}
