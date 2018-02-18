package pl.waterborn.messagesender.domain;

import pl.waterborn.messagesender.service.MessageDto;

public class myMessageFactory {
    public Message create(MessageDto messageDto) {
        return new Message.MessageBuilder()
                .withBody(messageDto.getBody())
                .withSubject(messageDto.getSubject())
                .withFrom(messageDto.getFrom())
                .withTo(messageDto.getTo())
                .build();
    }
}
