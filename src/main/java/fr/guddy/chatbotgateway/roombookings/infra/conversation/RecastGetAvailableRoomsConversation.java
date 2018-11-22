package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.domain.Timestamp;
import io.javalin.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public final class RecastGetAvailableRoomsConversation implements GetAvailableRoomsConversation {

    private final JsonObject memory;

    public RecastGetAvailableRoomsConversation(final JsonObject memory) {
        this.memory = memory;
    }

    public RecastGetAvailableRoomsConversation(final Context context) {
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

    @Override
    public long timestampStart() {
        final String begin = memory.getJsonObject("slot").getString("begin");
        return new Timestamp(begin).value();
    }

    @Override
    public long timestampEnd() {
        final String end = memory.getJsonObject("slot").getString("end");
        return new Timestamp(end).value();
    }
}
