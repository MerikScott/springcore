package pl.waterborn.messagesender.domain;

import pl.waterborn.messagesender.service.MessageDto;

public class MyMessageFactory {
    public Message createFrom(MessageDto messageDto) {
        return new Message.MessageBuilder()
                .withBody(messageDto.getBody())
                .withSubject(messageDto.getSubject())
                .withFrom(messageDto.getFrom())
                .withTo(messageDto.getTo())
                .build();
    }

}
