package pl.waterborn.messagesender.service;
import pl.waterborn.messagesender.domain.Message;
import pl.waterborn.messagesender.domain.MessageRepository;
import pl.waterborn.messagesender.domain.myMessageFactory;

public class MessageCrud {
    private final MessageRepository messageRepository;

    public MessageCrud(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Response createNew(MessageDto messageDto) {

        Message message = new myMessageFactory().create(messageDto);

        if (!messageRepository.exists(message)) {
            message.setId("1");
            messageRepository.add(message);

            return Response.aSuccessfulResponseWith("1");
        }

        return Response.aFailureResponse("Message already exists");

    }

}