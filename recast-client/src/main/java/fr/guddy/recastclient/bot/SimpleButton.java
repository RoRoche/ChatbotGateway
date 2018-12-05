package fr.guddy.recastclient.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class SimpleButton implements Button {
    private final String title;
    private final String value;

    public SimpleButton(final String title, final String value) {
        this.title = title;
        this.value = value;
    }

    public SimpleButton(final Text text, final String value) {
        this(text.value(), value);
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
