package com.jonandroid;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    private final ChatClient chatClient;

    public AIService(ChatClient.Builder builder) {

        chatClient = builder.build();
    }

    public String chat(String question) {

        ChatOptions options = ChatOptions.builder()
                .model("gpt-4.1-nano")
                .maxTokens(50)        // Set the maximum number of tokens
                .build();

        return chatClient
                .prompt()
                .user(question)
                .options(options)
                .call()
                .content();
    }



}
