package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.recast.RecastResponse;
import fr.guddy.chatbotgateway.recast.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.CancelBookingConversation;
import io.javalin.Context;
import okhttp3.ResponseBody;
import org.eclipse.jetty.http.HttpStatus;
import retrofit2.Response;

import java.io.IOException;

public final class CancelBookingSkill implements Skill {

    private final RoomBookingsApi api;
    private final CancelBookingConversation conversation;

    public CancelBookingSkill(final RoomBookingsApi api, final CancelBookingConversation conversation) {
        this.api = api;
        this.conversation = conversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<ResponseBody> response = api.deleteBooking(conversation.bookingId()).execute();
        final RecastResponse<TextReply> recastRsp = new RecastResponse<>(
                new TextReply(textToReply(response.code()))
        );
        context.json(recastRsp).status(HttpStatus.OK_200);
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
