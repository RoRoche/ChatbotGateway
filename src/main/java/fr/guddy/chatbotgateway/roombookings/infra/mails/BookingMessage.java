package fr.guddy.chatbotgateway.roombookings.infra.mails;

import fr.guddy.chatbotgateway.roombookings.domain.Booking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class BookingMessage implements Message {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private final Booking booking;

    public BookingMessage(final Booking booking) {
        this.booking = booking;
    }

    @Override
    public String value() {
        return String.format(
                "ID: %d\nRoom: %s (%d personnes)\nDe %s à %s",
                booking.getId(),
                booking.getRoom().getName(),
                booking.getRoom().getCapacity(),
                DATE_FORMAT.format(
                        new Date(
                                booking.getSlot().getTimestampStart() * 1000
                        )
                ),
                DATE_FORMAT.format(
                        new Date(
                                booking.getSlot().getTimestampEnd() * 1000)
                )
        );
    }
}
