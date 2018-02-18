package pl.waterborn.messagesender.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.waterborn.messagesender.domain.MessageRepository;
import pl.waterborn.messagesender.domain.MyMessageFactory;

import static org.hamcrest.CoreMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/message-sender.xml")
public class MessageCrudTest {
    public static final String BODY = "body";
    public static final String SUBJECT = "subject";
    public static final String FROM = "from";
    public static final String TO = "to";
    @Autowired private MessageRepository messageRepository;
    @Autowired private MessageCrud messageCrud;

    @Test
    public void shouldCreateNewMessage() {

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject(SUBJECT);
        messageDto.setBody(BODY);
        messageDto.setFrom(FROM);
        messageDto.setTo(TO);

        Response response = messageCrud.createNew(messageDto);

        Assert.assertTrue(response.isSuccess());
        Assert.assertThat(response.getMessage(), any(String.class));
        Assert.assertTrue(messageRepository.exists(response.getMessage()));
    }

    @Test
    public void shouldNotCreateNewMessage() {

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject(SUBJECT);
        messageDto.setBody(BODY);
        messageDto.setFrom(FROM);
        messageDto.setTo(TO);

        messageRepository.add(new MyMessageFactory().createFrom(messageDto));

        Response response = messageCrud.createNew(messageDto);

        Assert.assertFalse(response.isSuccess());
    }
}