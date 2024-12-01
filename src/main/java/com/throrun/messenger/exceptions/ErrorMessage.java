package com.throrun.messenger.exceptions;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    String message;
}
