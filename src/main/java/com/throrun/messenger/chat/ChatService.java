package com.throrun.messenger.chat;

import com.throrun.messenger.chat.req_res.*;


public interface ChatService {
    CreateChatRes createChat(NewChatReq chatReq);

    GetChatsRes getAllChats();

    GetChatsRes getMyChats();

    DeleteChatRes deleteChat(DeleteChatReq chatReq);
}
