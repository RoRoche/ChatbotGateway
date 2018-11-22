package fr.guddy.chatbotgateway.recast;

import fr.guddy.chatbotgateway.roombookings.RecastRoomBookingsRoute;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.path;

public final class RecastRoute implements EndpointGroup {
    private final RoomBookingsApi roomBookingsApi;

    public RecastRoute(final RoomBookingsApi roomBookingsApi) {
        this.roomBookingsApi = roomBookingsApi;
    }

    @Override
    public void addEndpoints() {
        path(
                "roombookings",
                new RecastRoomBookingsRoute(roomBookingsApi)
        );
    }
}
