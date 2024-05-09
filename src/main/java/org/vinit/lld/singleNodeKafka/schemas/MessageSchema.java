package org.vinit.lld.singleNodeKafka.schemas;

import lombok.Data;

@Data
public class MessageSchema {
    String message;
    Long timestamp;
}
