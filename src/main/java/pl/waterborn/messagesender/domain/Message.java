package pl.waterborn.messagesender.domain;

public class Message {
    private final String subject;
    private final String body;
    private final String from;
    private final String to;

    public Message(MessageBuilder messageBuilder) {

        to = messageBuilder.sendTo;
        from = messageBuilder.sendFrom;
        subject = messageBuilder.subject;
        body = messageBuilder.body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    public static class MessageBuilder {
        private String subject;
        private String body;
        private String sendFrom;
        private String sendTo;

        public MessageBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public MessageBuilder withBody(String body) {
            this.body = body;
            return this;
        }


        public MessageBuilder withFrom(String sendFrom) {
            this.sendFrom = sendFrom;
            return this;
        }

        public MessageBuilder withTo(String sendTo) {
            this.sendTo = sendTo;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
