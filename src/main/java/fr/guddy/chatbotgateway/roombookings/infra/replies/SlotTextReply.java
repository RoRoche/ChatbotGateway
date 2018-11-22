package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.chatbotgateway.recast.bot.Reply;
import fr.guddy.chatbotgateway.recast.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.domain.Slot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class SlotTextReply implements Reply<String> {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private final Reply<String> delegate;

    public SlotTextReply(final Reply<String> delegate) {
        this.delegate = delegate;
    }

    public SlotTextReply(final Slot slot) {
        this(
                new TextReply(
                        String.format(
                                "De %s à %s",
                                DATE_FORMAT.format(new Date(slot.getTimestampStart() * 1000)),
                                DATE_FORMAT.format(new Date(slot.getTimestampEnd() * 1000))
                        )
                )
        );
    }

    @Override
    public String getType() {
        return delegate.getType();
    }

    @Override
    public String getContent() {
        return delegate.getContent();
    }
}