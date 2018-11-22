package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.recast.RecastResponse;
import fr.guddy.chatbotgateway.recast.bot.Reply;
import fr.guddy.chatbotgateway.recast.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.AddRoomConversation;
import io.javalin.Context;
import okhttp3.ResponseBody;
import org.eclipse.jetty.http.HttpStatus;
import retrofit2.Response;

import java.io.IOException;

public final class AddRoomSkill implements Skill {

    private final RoomBookingsApi api;
    private final AddRoomConversation conversation;

    public AddRoomSkill(final RoomBookingsApi api, final AddRoomConversation conversation) {
        this.api = api;
        this.conversation = conversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<ResponseBody> response = api.createRoom(conversation.newRoom()).execute();
        final RecastResponse<Reply<String>> recastRsp = new RecastResponse<>(
                new TextReply(textToReply(response.code()))
        );
        context.json(recastRsp).status(HttpStatus.OK_200);
    }

    private String textToReply(final int responseCode) {
        switch (responseCode) {
            case HttpStatus.CREATED_201:
                return "Salle créée avec succès";
            case HttpStatus.CONFLICT_409:
                return String.format("Une salle porte déjà le nom '%s'", conversation.name());
            default:
                return "Une erreur est survenue";
        }
    }
}
