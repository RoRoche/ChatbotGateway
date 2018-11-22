package fr.guddy.chatbotgateway.recast.bot;

import java.util.List;

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
