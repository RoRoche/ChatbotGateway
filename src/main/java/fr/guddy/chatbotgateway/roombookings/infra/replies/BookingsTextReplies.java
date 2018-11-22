package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.chatbotgateway.recast.bot.Reply;
import fr.guddy.chatbotgateway.roombookings.domain.Booking;
import fr.guddy.chatbotgateway.roombookings.domain.Room;

import java.util.List;
import java.util.stream.Collectors;

public final class BookingsTextReplies {
    private final List<Booking> bookings;

    public BookingsTextReplies(final List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Reply<String>> replies() {
        return bookings.stream()
                .map(booking -> (Reply<String>) new BookingTextReply(booking))
                .collect(Collectors.toList());
    }
}
