package fr.guddy.chatbotgateway.common.infra;

import fr.guddy.chatbotgateway.recast.RecastRoute;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.handlers.MissingRequirementHandler;
import fr.guddy.chatbotgateway.roombookings.infra.mails.Authentication;
import fr.guddy.chatbotgateway.roombookings.infra.mails.AuthorizedRecipients;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.exceptions.MissingRequirementException;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.path;

public final class Api {
    private final Javalin app;
    private final int port;

    public Api(final Javalin app, final int port) {
        this.app = app;
        this.port = port;
    }

    public Api(final int port,
               final RoomBookingsApi roomBookingsApi,
               final AuthorizedRecipients authorizedRecipients,
               final Authentication authentication
    ) {
        this(
                Javalin.create()
                        .routes(() ->
                                path(
                                        "recast",
                                        new RecastRoute(
                                                roomBookingsApi,
                                                authorizedRecipients,
                                                authentication
                                        )
                                )
                        )
                        .exception(
                                MissingRequirementException.class,
                                new MissingRequirementHandler()
                        ),
                port);
    }

    public void start() {
        app.start(port);
    }

    public void stop() {
        app.stop();
    }
}
