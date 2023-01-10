package com.hasandag.ws.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WsMessage {
    private String sender;
    private String message;
}
