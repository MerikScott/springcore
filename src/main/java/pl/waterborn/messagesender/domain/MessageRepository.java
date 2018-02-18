package pl.waterborn.messagesender.domain;

public interface MessageRepository {

    boolean exists(String id);

    void add(Message message);

    boolean exists(Message message);
}
