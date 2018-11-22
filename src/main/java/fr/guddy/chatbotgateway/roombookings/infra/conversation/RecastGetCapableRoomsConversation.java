package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import io.javalin.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public final class RecastGetCapableRoomsConversation implements GetCapableRoomsConversation {

    private final JsonObject memory;

    public RecastGetCapableRoomsConversation(final JsonObject memory) {
        this.memory = memory;
    }

    public RecastGetCapableRoomsConversation(final Context context) {
        this(
                Json.createReader(new StringReader(context.body()))
                        .readObject()
                        .getJsonObject("conversation")
                        .getJsonObject("memory")
        );
    }

    @Override
    public int capacity() {
        return memory.getJsonObject("capacity").getInt("scalar");
    }
}
