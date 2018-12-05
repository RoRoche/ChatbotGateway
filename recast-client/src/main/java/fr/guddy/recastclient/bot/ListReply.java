package fr.guddy.recastclient.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ListReply implements Reply<ListContent> {
    private final ListContent content;

    public ListReply(final ListContent content) {
        this.content = content;
    }

    @Override
    public String getType() {
        return "list";
    }

    @Override
    public ListContent getContent() {
        return content;
    }
}
