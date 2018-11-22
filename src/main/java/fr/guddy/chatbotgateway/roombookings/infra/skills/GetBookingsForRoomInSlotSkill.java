package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.recast.RecastResponse;
import fr.guddy.chatbotgateway.recast.bot.Reply;
import fr.guddy.chatbotgateway.recast.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.domain.Booking;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.GetBookingsForRoomInSlotConversation;
import fr.guddy.chatbotgateway.roombookings.infra.replies.BookingsTextReplies;
import io.javalin.Context;
import org.eclipse.jetty.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class GetBookingsForRoomInSlotSkill implements Skill {

    private final RoomBookingsApi api;
    private final GetBookingsForRoomInSlotConversation conversation;

    public GetBookingsForRoomInSlotSkill(final RoomBookingsApi api, final GetBookingsForRoomInSlotConversation conversation) {
        this.api = api;
        this.conversation = conversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<List<Booking>> response = api.bookingsForRoomInSlot(
                conversation.roomName(),
                conversation.timestampStart(),
                conversation.timestampEnd()
        ).execute();
        final List<Reply<String>> roomReplies = Optional.ofNullable(response.body())
                .map(bookings -> new BookingsTextReplies(bookings).replies())
                .orElseGet(this::emptyReply);
        final RecastResponse<Reply<String>> recastRsp = new RecastResponse<>(roomReplies);
        context.json(recastRsp).status(HttpStatus.OK_200);
    }

    @NotNull
    private List<Reply<String>> emptyReply() {
        return Collections.singletonList(
                new TextReply("Cette salle n'est pas réservée sur ce créneau")
        );
    }
}