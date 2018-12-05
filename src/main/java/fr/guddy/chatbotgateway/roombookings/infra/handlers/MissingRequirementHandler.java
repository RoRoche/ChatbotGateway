package fr.guddy.chatbotgateway.roombookings.infra.handlers;

import fr.guddy.recastclient.RecastResponse;
import fr.guddy.recastclient.bot.TextReply;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.exceptions.MissingRequirementException;
import io.javalin.Context;
import io.javalin.ExceptionHandler;
import org.eclipse.jetty.http.HttpStatus;

public final class MissingRequirementHandler implements ExceptionHandler<MissingRequirementException> {
    @Override
    public void handle(final MissingRequirementException exception, final Context ctx) {
        final RecastResponse<TextReply> recastRsp = new RecastResponse<>(
                new TextReply(exception.getMessage())
        );
        ctx.status(HttpStatus.BAD_REQUEST_400).json(recastRsp);
    }
}
