package com.wipro.vaish;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final List<ChatMessage> messages = new CopyOnWriteArrayList<>();

    public void saveMessage(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        messages.add(message);
    }

    public List<ChatMessage> getChatHistory(String user1, String user2) {
        return messages.stream()
            .filter(msg -> (msg.getSender().equals(user1) && msg.getReceiver().equals(user2)) ||
                           (msg.getSender().equals(user2) && msg.getReceiver().equals(user1)))
            .collect(Collectors.toList());
    }
}

