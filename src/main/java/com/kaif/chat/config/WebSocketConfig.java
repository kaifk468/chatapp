package com.kaif.chat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //This is the url which will establish the connection b/w client and this server
        registry.addEndpoint("/server1").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //the is the prifix using which will clien app will sent request to this client
        //i.e ("/app/some-api-name")
        registry.setApplicationDestinationPrefixes("/app");
        //this is prifix URL for  broadcasting to the subscribed client
        //client to subscribe the URL like this ("/topic/some-topic-name") in order to receive the message form
        //this client
        registry.enableSimpleBroker("/topic");
    }
}
