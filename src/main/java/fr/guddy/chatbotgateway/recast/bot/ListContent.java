package fr.guddy.chatbotgateway.recast.bot;

import java.util.Collections;
import java.util.List;

public final class ListContent {
    private final List<Element> elements;
    private final List<Button> buttons = Collections.emptyList();

    public ListContent(final List<Element> elements) {
        this.elements = elements;
    }

    public List<Element> getElements() {
        return elements;
    }

    public List<Button> getButtons() {
        return buttons;
    }
}
