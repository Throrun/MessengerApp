package com.throrun.messenger.chat;

import com.throrun.messenger.chat.data.model.Chat;
import com.throrun.messenger.chat.data.repository.ChatRepository;
import com.throrun.messenger.chat.req_res.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;

    @Override
    public CreateChatRes createChat(NewChatReq chatReq) {
        Chat chat = Chat.builder()
                .name(chatReq.getName())
                .users(chatReq.getUsers())
                .build();
        chatRepository.save(chat);
        return CreateChatRes.builder().name(chatReq.getName()).build();
    }

    @Override
    public GetChatsRes getAllChats() {
        List<Chat> chats = chatRepository.findAll();
        return GetChatsRes.builder().chatList(chats).build();
    }

    @Override
    public GetChatsRes getMyChats() {
        return null; // here I need to get info about current user
    }

    @Override
    public DeleteChatRes deleteChat(DeleteChatReq chatReq) {
        Chat chat = chatRepository.findById(chatReq.getUuid()).orElseThrow(() -> new RuntimeException("user not exist"));
        chatRepository.delete(chat);
        return DeleteChatRes.builder().name(chat.getName()).build();
    }
}
