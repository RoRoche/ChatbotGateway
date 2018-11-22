package fr.guddy.chatbotgateway.recast.bot;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Element {
    private String title;
    private String imageUrl;
    private String subtitle;
    private List<Button> buttons = Collections.emptyList();

    public Element() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(final String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(final List<Button> buttons) {
        this.buttons = buttons;
    }
}
