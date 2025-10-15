package com.wipro.vaish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    public void sendMessage(ChatMessage message) {
    	System.out.println(message);
        chatService.saveMessage(message);
        messagingTemplate.convertAndSend("/topic/messages/" + message.getReceiver(), message);
        messagingTemplate.convertAndSend("/topic/messages/" + message.getSender(), message); 
    }
}

