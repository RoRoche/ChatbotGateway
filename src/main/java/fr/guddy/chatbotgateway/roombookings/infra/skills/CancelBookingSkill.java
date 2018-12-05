package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.roombookings.domain.Booking;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.CancelBookingConversation;
import fr.guddy.chatbotgateway.roombookings.infra.mails.AuthorizedRecipients;
import fr.guddy.recastclient.RecastResponse;
import fr.guddy.recastclient.bot.TextReply;
import io.javalin.Context;
import org.eclipse.jetty.http.HttpStatus;
import retrofit2.Response;

import java.io.IOException;

public final class CancelBookingSkill implements Skill {

    private final RoomBookingsApi api;
    private final CancelBookingConversation conversation;
    private final AuthorizedRecipients authorizedRecipients;

    public CancelBookingSkill(
            final RoomBookingsApi api,
            final CancelBookingConversation conversation,
            final AuthorizedRecipients authorizedRecipients
    ) {
        this.api = api;
        this.conversation = conversation;
        this.authorizedRecipients = authorizedRecipients;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<Booking> response = api.deleteBooking(conversation.bookingId()).execute();
        final RecastResponse<TextReply> recastRsp = new RecastResponse<>(
                new TextReply(textToReply(response.code()))
        );
        context.json(recastRsp).status(HttpStatus.OK_200);
        if (response.code() == HttpStatus.OK_200) {
            final Booking booking = response.body();
            if (booking != null && authorizedRecipients.contains(booking.getUserId())) {
                // TODO: send mail
            }
        }
    }

    private String textToReply(final int responseCode) {
        switch (responseCode) {
            case HttpStatus.OK_200:
                return "Réservation annulée";
            case HttpStatus.NOT_FOUND_404:
                return "Impossible de retrouver cette réservation dans le système";
            default:
                return "Une erreur est survenue";
        }
    }
}
