package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.UserIdRequirement;
import io.javalin.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public final class RecastGetBookingRemindersConversation implements GetBookingRemindersConversation {
    private final Requirement<String> userId;

    public RecastGetBookingRemindersConversation(final Requirement<String> userId) {
        this.userId = userId;
    }

    public RecastGetBookingRemindersConversation(final Context context) {
        this(
                Json.createReader(new StringReader(context.body()))
                        .readObject()
                        .getJsonObject("conversation")
                        .getJsonObject("memory")
                        .getJsonObject("user_id")
        );
    }

    public RecastGetBookingRemindersConversation(final JsonObject userId) {
        this(new UserIdRequirement(userId));
    }

    @Override
    public Requirement<String> userId() {
        return userId;
    }
}
