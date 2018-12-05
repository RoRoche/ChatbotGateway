package fr.guddy.recastclient.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class TextReply implements Reply<String> {

    private final String text;

    public TextReply(final String text) {
        this.text = text;
    }

    public TextReply(final Text text) {
        this(text.value());
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public String getContent() {
        return text;
    }
}
