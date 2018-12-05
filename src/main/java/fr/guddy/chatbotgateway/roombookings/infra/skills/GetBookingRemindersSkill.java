package fr.guddy.chatbotgateway.roombookings.infra.skills;

import fr.guddy.chatbotgateway.common.infra.bot.Skill;
import fr.guddy.chatbotgateway.roombookings.domain.Booking;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.GetBookingRemindersConversation;
import fr.guddy.chatbotgateway.roombookings.infra.replies.CancelBookingButton;
import fr.guddy.chatbotgateway.roombookings.infra.replies.SlotTextReply;
import fr.guddy.recastclient.RecastResponse;
import fr.guddy.recastclient.bot.*;
import io.javalin.Context;
import org.eclipse.jetty.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class GetBookingRemindersSkill implements Skill {

    private final RoomBookingsApi roomBookingsApi;
    private final GetBookingRemindersConversation getBookingRemindersConversation;

    public GetBookingRemindersSkill(final RoomBookingsApi roomBookingsApi, final GetBookingRemindersConversation getBookingRemindersConversation) {
        this.roomBookingsApi = roomBookingsApi;
        this.getBookingRemindersConversation = getBookingRemindersConversation;
    }

    @Override
    public void perform(final Context context) throws IOException {
        final Response<List<Booking>> response = roomBookingsApi.bookingReminders(
                getBookingRemindersConversation.userId().value()
        ).execute();
        final Optional<List<Booking>> body = Optional.ofNullable(response.body());
        body.ifPresentOrElse(
                bookings -> populateBookings(context, bookings),
                () -> populateEmpty(context)
        );
    }

    private void populateBookings(final Context context, final List<Booking> bookings) {
        final List<Element> elements = bookings.stream()
                .map(this::elementForBooking)
                .collect(Collectors.toList());
        final ListContent content = new ListContent(elements);
        final ListReply listReply = new ListReply(content);
        final RecastResponse<Reply<?>> recastRsp = new RecastResponse<>(listReply);
        context.json(recastRsp).status(HttpStatus.OK_200);
    }

    @NotNull
    private Element elementForBooking(final Booking booking) {
        final Element element = new Element();
        element.setTitle(booking.getRoom().getName());
        element.setSubtitle(
                new SlotTextReply(booking.getSlot()).getContent()
        );
        final List<Button> buttons = Collections.singletonList(
                new CancelBookingButton("Annuler", booking)
        );
        element.setButtons(buttons);
        return element;
    }

    private void populateEmpty(final Context context) {
        final RecastResponse<Reply<String>> recastRsp = new RecastResponse<>(
                new TextReply("Aucune réservation à venir")
        );
        context.json(recastRsp).status(HttpStatus.OK_200);
    }
}
