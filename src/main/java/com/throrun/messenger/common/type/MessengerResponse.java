package com.throrun.messenger.common.type;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessengerResponse<T> {
    private String message;
    private T data;
}
