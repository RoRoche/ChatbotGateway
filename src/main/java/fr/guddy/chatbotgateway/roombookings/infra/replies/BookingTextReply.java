package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.recastclient.bot.Reply;
import fr.guddy.recastclient.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.domain.Booking;

public final class BookingTextReply implements Reply<String> {

    private final Reply<String> delegate;

    public BookingTextReply(final Reply<String> delegate) {
        this.delegate = delegate;
    }

    public BookingTextReply(final Booking booking) {
        this(
                new TextReply(
                        String.format(
                                "%s (par: %s) [id: %d]",
                                new SlotTextReply(booking.getSlot()).getContent(),
                                booking.getUserId(),
                                booking.getId()
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
