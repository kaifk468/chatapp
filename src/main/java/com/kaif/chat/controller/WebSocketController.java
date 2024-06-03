package com.kaif.chat.controller;


import com.kaif.chat.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @MessageMapping("/message")//the complete url is like ("/app/meesage") request will come to this url
    @SendTo("/topic/return-to")//broadcasting will happen to this url
    public Message messageController(@RequestAttribute Message message)  {
        try{
            Thread.sleep(2000);
            //we can do some processing
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return message;
    }
}
