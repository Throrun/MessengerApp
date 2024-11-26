package com.throrun.messenger.chat.req_res;

import com.throrun.messenger.chat.data.model.Chat;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetChatsRes {
    List<Chat> chatList;
}
