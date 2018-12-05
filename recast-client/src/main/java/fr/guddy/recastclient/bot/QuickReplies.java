package fr.guddy.recastclient.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuickReplies implements Reply<QuickRepliesContent> {
    private final QuickRepliesContent content;

    public QuickReplies(final QuickRepliesContent content) {
        this.content = content;
    }

    @Override
    public String getType() {
        return "quickReplies";
    }

    @Override
    public QuickRepliesContent getContent() {
        return content;
    }
}
