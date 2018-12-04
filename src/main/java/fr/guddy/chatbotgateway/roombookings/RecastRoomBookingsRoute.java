package fr.guddy.chatbotgateway.roombookings;

import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.conversation.*;
import fr.guddy.chatbotgateway.roombookings.infra.mails.AuthorizedRecipients;
import fr.guddy.chatbotgateway.roombookings.infra.skills.*;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.post;

public final class RecastRoomBookingsRoute implements EndpointGroup {

    private final RoomBookingsApi roomBookingsApi;
    private final AuthorizedRecipients authorizedRecipients;

    public RecastRoomBookingsRoute(final RoomBookingsApi roomBookingsApi, final AuthorizedRecipients authorizedRecipients) {
        this.roomBookingsApi = roomBookingsApi;
        this.authorizedRecipients = authorizedRecipients;
    }

    @Override
    public void addEndpoints() {
        post(
                "skills/add_room",
                ctx ->
                        new AddRoomSkill(
                                roomBookingsApi,
                                new RecastAddRoomConversation(ctx)
                        ).perform(ctx)
        );
        post(
                "skills/get_all_rooms",
                ctx ->
                        new GetAllRoomsSkill(roomBookingsApi).perform(ctx)
        );
        post(
                "skills/get_capable_rooms",
                ctx ->
                        new GetCapableRoomsSkill(
                                roomBookingsApi,
                                new RecastGetCapableRoomsConversation(ctx)
                        ).perform(ctx)
        );
        post(
                "skills/get_available_rooms",
                ctx ->
                        new GetAvailableRoomsSkill(
                                roomBookingsApi,
                                new RecastGetAvailableRoomsConversation(ctx)
                        ).perform(ctx)
        );
        post(
                "/skills/book_room",
                ctx ->
                        new BookRoomSkil(
                                roomBookingsApi,
                                new RecastBookRoomConversation(ctx),
                                authorizedRecipients
                        ).perform(ctx)
        );
        post(
                "/skills/booking_reminders",
                ctx ->
                        new GetBookingRemindersSkill(
                                roomBookingsApi,
                                new RecastGetBookingRemindersConversation(ctx)
                        ).perform(ctx)
        );
        post(
                "/skills/cancel_booking",
                ctx ->
                        new CancelBookingSkill(
                                roomBookingsApi,
                                new RecastCancelBookingConversation(ctx),
                                authorizedRecipients
                        ).perform(ctx)
        );
    }
}
