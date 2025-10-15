package com.wipro.vaish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    private final WebSocketConfig webSocketConfig;
    
    

    @Autowired
    private ChatService chatService;

    ChatController(WebSocketConfig webSocketConfig) {
        this.webSocketConfig = webSocketConfig;
    }

    @GetMapping("/history")
    public List<ChatMessage> getChatHistory(@RequestParam String user1, @RequestParam String user2) {
    	System.out.println(user1 + " : "+user2);
        return chatService.getChatHistory(user1, user2);
    }
}

