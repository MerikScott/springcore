package pl.waterborn.messagesender.domain;

import org.junit.Assert;
import org.junit.Test;
import pl.waterborn.messagesender.service.MessageDto;

public class MessageTest {
    public static final String BODY = "body";
    public static final String SUBJECT = "subject";
    public static final String FROM = "from";
    public static final String TO = "to";
    @Test
    public void shouldCreateMessageWithRequiredFields() {

        MessageDto messageDto = new MessageDto();
        messageDto.setSubject(SUBJECT);
        messageDto.setBody(BODY);
        messageDto.setFrom(FROM);
        messageDto.setTo(TO);

        Message message = new MyMessageFactory().createFrom(messageDto);

        Assert.assertEquals(SUBJECT, message.getSubject());
        Assert.assertEquals(BODY, message.getBody());
        Assert.assertEquals(FROM, message.getFrom());
        Assert.assertEquals(TO, message.getTo());
    }
}