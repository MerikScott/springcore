package pl.waterborn.messagesender.domain;
import org.junit.Assert;

public class MessageTest {

    public void shouldCreateMessageWithRequiredFields() {
        String sendTo = "to";
        String sendFrom = "from";
        String subject = "subject";
        String body = "body";

        Message message = new Message.MessageBuilder()
                .withSubject(subject)
                .withBody(body)
                .withFrom(sendFrom)
                .withTo(sendTo)
                .build();

        Assert.assertEquals(subject, message.getSubject());
        Assert.assertEquals(body, message.getBody());
        Assert.assertEquals(sendFrom, message.getFrom());
        Assert.assertEquals(sendTo, message.getTo());
    }

}
