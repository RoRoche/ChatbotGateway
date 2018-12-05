package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.roombookings.domain.Room;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.GetAvailableRoomsConversation;
import fr.guddy.chatbotgateway.roombookings.infra.replies.BookRoomButton;
import fr.guddy.recastclient.RecastResponse;
import fr.guddy.recastclient.bot.QuickReplies;
import fr.guddy.recastclient.bot.QuickRepliesContent;
import fr.guddy.recastclient.bot.TextReply;
import io.javalin.Context;
import org.eclipse.jetty.http.HttpStatus;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class GetAvailableRoomsSkill implements Skill {

    private final RoomBookingsApi api;
    private final GetAvailableRoomsConversation conversation;

    public GetAvailableRoomsSkill(final RoomBookingsApi api, final GetAvailableRoomsConversation conversation) {
        this.api = api;
        this.conversation = conversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<List<Room>> response = api.availableRooms(
                conversation.capacity(),
                conversation.timestampStart(),
                conversation.timestampEnd()
        ).execute();
        final Optional<List<Room>> body = Optional.ofNullable(response.body());
        if (body.isPresent()) {
            final List<BookRoomButton> buttons = body.get().stream()
                    .map(BookRoomButton::new)
                    .collect(Collectors.toList());
            final QuickReplies replies = new QuickReplies(
                    new QuickRepliesContent(
                            "Salles disponibles",
                            buttons
                    )
            );
            context.json(
                    new RecastResponse<>(replies)
            ).status(HttpStatus.OK_200);
        } else {
            context.json(
                    new RecastResponse<>(
                            new TextReply("Aucune salle n'est disponible sur ce créneau")
                    )
            ).status(HttpStatus.OK_200);
        }
    }
}