package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.recast.RecastResponse;
import fr.guddy.chatbotgateway.recast.bot.*;
import fr.guddy.chatbotgateway.roombookings.domain.Room;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.GetCapableRoomsConversation;
import fr.guddy.chatbotgateway.roombookings.infra.replies.BookRoomButton;
import io.javalin.Context;
import org.eclipse.jetty.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class GetCapableRoomsSkill implements Skill {

    private final RoomBookingsApi api;
    private final GetCapableRoomsConversation conversation;

    public GetCapableRoomsSkill(final RoomBookingsApi api, final GetCapableRoomsConversation conversation) {
        this.api = api;
        this.conversation = conversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<List<Room>> response = api.capableRooms(conversation.capacity()).execute();
        final Optional<List<Room>> body = Optional.ofNullable(response.body());
        body.ifPresentOrElse(
                rooms -> populateRooms(context, rooms),
                () -> populateEmpty(context)
        );
    }

    private void populateEmpty(final Context context) {
        final RecastResponse<Reply<String>> recastRsp = new RecastResponse<>(
                new TextReply(
                        String.format(
                                "Aucune salle ne peut contenir %d personnes",
                                conversation.capacity()
                        )
                )
        );
        context.json(recastRsp).status(HttpStatus.OK_200);
    }

    private void populateRooms(final Context context, final List<Room> rooms) {
        final List<Element> elements = rooms.stream()
                .map(this::elementForRoom)
                .collect(Collectors.toList());
        final ListContent content = new ListContent(elements);
        final ListReply listReply = new ListReply(content);
        final RecastResponse<Reply<?>> recastRsp = new RecastResponse<>(listReply);
        context.json(recastRsp).status(HttpStatus.OK_200);
    }

    @NotNull
    private Element elementForRoom(final Room room) {
        final Element element = new Element();
        element.setTitle(room.getName());
        element.setSubtitle(
                String.format(
                        "Capacité: %d personnes",
                        room.getCapacity()
                )
        );
        final List<Button> buttons = Collections.singletonList(
                new BookRoomButton("Réserver", room)
        );
        element.setButtons(buttons);
        return element;
    }
}