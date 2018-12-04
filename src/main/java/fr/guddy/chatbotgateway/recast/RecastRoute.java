package fr.guddy.chatbotgateway.recast;

import fr.guddy.chatbotgateway.roombookings.RecastRoomBookingsRoute;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.mails.AuthorizedRecipients;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.path;

public final class RecastRoute implements EndpointGroup {
    private final RoomBookingsApi roomBookingsApi;
    private final AuthorizedRecipients authorizedRecipients;

    public RecastRoute(final RoomBookingsApi roomBookingsApi, final AuthorizedRecipients authorizedRecipients) {
        this.roomBookingsApi = roomBookingsApi;
        this.authorizedRecipients = authorizedRecipients;
    }

    @Override
    public void addEndpoints() {
        path(
                "roombookings",
                new RecastRoomBookingsRoute(roomBookingsApi, authorizedRecipients)
        );
    }
}
