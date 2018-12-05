package fr.guddy.recastclient.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class QuickRepliesContent {
    private final String title;
    private final List<? extends Button> buttons;

    public QuickRepliesContent(final String title, final List<? extends Button> buttons) {
        this.title = title;
        this.buttons = buttons;
    }

    public String getTitle() {
        return title;
    }

    public List<? extends Button> getButtons() {
        return buttons;
    }
}
