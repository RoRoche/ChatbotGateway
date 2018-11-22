package fr.guddy.chatbotgateway.roombookings.infra.requirements;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;

import javax.json.JsonObject;

public final class BookingIdRequirement implements Requirement<Long> {

    private final JsonObject bookingId;

    public BookingIdRequirement(final JsonObject bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public Long value() {
        return bookingId.getJsonNumber("scalar").longValue();
    }
}
