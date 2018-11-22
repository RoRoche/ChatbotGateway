package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.recast.RecastResponse;
import fr.guddy.chatbotgateway.recast.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.BookRoomConversation;
import io.javalin.Context;
import okhttp3.ResponseBody;
import org.eclipse.jetty.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public final class BookRoomSkil implements Skill {

    private final RoomBookingsApi api;
    private final BookRoomConversation conversation;

    public BookRoomSkil(final RoomBookingsApi api, final BookRoomConversation conversation) {
        this.api = api;
        this.conversation = conversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Call<ResponseBody> request = api.createBooking(
                conversation.roomName(),
                conversation.booking()
        );
        final Response<ResponseBody> response = request.execute();
        final RecastResponse<TextReply> recastRsp = new RecastResponse<>(
                new TextReply(textToReply(response.code()))
        );
        context.json(recastRsp).status(HttpStatus.OK_200);
    }

    private String textToReply(final int responseCode) {
        switch (responseCode) {
            case HttpStatus.CREATED_201:
                return "Réservation effectuée avec succès";
            case HttpStatus.CONFLICT_409:
                return "Cette salle n'est pas disponible sur ce créneau";
            default:
                return "Une erreur est survenue";
        }
    }
}
