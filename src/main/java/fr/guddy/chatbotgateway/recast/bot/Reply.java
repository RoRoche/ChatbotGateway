package fr.guddy.chatbotgateway.recast.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface Reply<C> {
    @JsonProperty("type")
    String getType();

    @JsonProperty("content")
    C getContent();
}
