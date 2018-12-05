package fr.guddy.recastclient.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ListContent {
    private final List<Element> elements;
    private final List<Button> buttons;

    public ListContent(final List<Element> elements, final List<Button> buttons) {
        this.elements = elements;
        this.buttons = buttons;
    }

    public ListContent(final List<Element> elements) {
        this(elements, Collections.emptyList());
    }

    public List<Element> getElements() {
        return elements;
    }

    public List<Button> getButtons() {
        return buttons;
    }
}
