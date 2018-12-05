package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.recastclient.bot.Button;
import fr.guddy.recastclient.bot.SimpleButton;
import fr.guddy.chatbotgateway.roombookings.domain.Booking;

public final class CancelBookingButton implements Button {

    private final Button delegate;

    public CancelBookingButton(final Button delegate) {
        this.delegate = delegate;
    }

    public CancelBookingButton(final String title, final Booking booking) {
        this(
                new SimpleButton(
                        title,
                        String.format("Annule la réservation dont l'identifiant est %d", booking.getId())
                )
        );
    }

    @Override
    public String getTitle() {
        return delegate.getTitle();
    }

    @Override
    public String getValue() {
        return delegate.getValue();
    }
}
