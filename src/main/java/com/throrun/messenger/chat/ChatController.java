package com.throrun.messenger.chat;

import com.throrun.messenger.chat.req_res.*;
import com.throrun.messenger.common.type.MessengerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ChatController.REQUEST_MAPPING)
@RequiredArgsConstructor
public class ChatController implements ChatApi {
    public static final String REQUEST_MAPPING = "/api/messenger/chat";
    private final ChatService chatService;

    @Override
    public ResponseEntity<MessengerResponse<CreateChatRes>> createChat(NewChatReq chatReq) {
        CreateChatRes createChatRes = chatService.createChat(chatReq);
        return ResponseEntity.status(201)
                .body(MessengerResponse.<CreateChatRes>builder()
                        .message("Chat created successfully")
                        .data(createChatRes)
                        .build());
    }

    @Override
    public ResponseEntity<MessengerResponse<GetChatsRes>> getAllChats() {
        GetChatsRes getChatsRes = chatService.getAllChats();
        return ResponseEntity.status(200)
                .body(MessengerResponse.<GetChatsRes>builder()
                        .message("Chat created successfully")
                        .data(getChatsRes)
                        .build());
    }

    @Override
    public ResponseEntity<MessengerResponse<GetChatsRes>> getMyChats() {
        GetChatsRes getChatsRes = chatService.getMyChats();
        return ResponseEntity.status(200)
                .body(MessengerResponse.<GetChatsRes>builder()
                        .message("Chat created successfully")
                        .data(getChatsRes)
                        .build());
    }

    @Override
    public ResponseEntity<MessengerResponse<DeleteChatRes>> deleteChat(DeleteChatReq chatReq) {
        DeleteChatRes deleteChatRes = chatService.deleteChat(chatReq);
        return ResponseEntity.status(204)
                .body(MessengerResponse.<DeleteChatRes>builder()
                        .message("Chat created successfully")
                        .data(deleteChatRes)
                        .build());
    }
}
