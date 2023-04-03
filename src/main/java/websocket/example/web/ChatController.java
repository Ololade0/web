package websocket.example.web;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
    public class ChatController {

        @MessageMapping("/chat.register")
        @SendTo("/topic/public")
        public Chats register(@Payload Chats chatMessage, SimpMessageHeaderAccessor headerAccessor) {
            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
            return chatMessage;
        }

        @MessageMapping("/chat.send")
        @SendTo("/topic/public")
        public Chats sendMessage(@Payload Chats chatMessage) {
            return chatMessage;
        }
    }

