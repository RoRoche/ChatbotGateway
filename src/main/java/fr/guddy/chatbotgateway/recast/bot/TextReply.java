package fr.guddy.chatbotgateway.recast.bot;

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
