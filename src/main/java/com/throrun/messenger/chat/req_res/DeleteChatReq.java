package com.throrun.messenger.chat.req_res;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DeleteChatReq {
    UUID uuid;
}
