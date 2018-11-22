package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.BookingIdRequirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;
import io.javalin.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public final class RecastCancelBookingConversation implements CancelBookingConversation {

    private final Requirement<Long> bookingId;

    public RecastCancelBookingConversation(final Requirement<Long> bookingId) {
        this.bookingId = bookingId;
    }

    public RecastCancelBookingConversation(final Context context) {
        this(
                Json.createReader(new StringReader(context.body()))
                        .readObject()
                        .getJsonObject("conversation")
                        .getJsonObject("memory")
                        .getJsonObject("booking_id")
        );
    }

    public RecastCancelBookingConversation(final JsonObject bookingId) {
        this(new BookingIdRequirement(bookingId));
    }

    @Override
    public long bookingId() {
        return bookingId.value();
    }
}
