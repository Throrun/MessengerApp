package com.throrun.messenger.chat.req_res;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class NewChatReq {
    String name;
    List<UUID> users;
}
