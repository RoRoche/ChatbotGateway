package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.domain.Booking;
import fr.guddy.chatbotgateway.roombookings.domain.Slot;
import fr.guddy.chatbotgateway.roombookings.domain.Timestamp;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.RoomNameRequirement;
import io.javalin.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public final class RecastBookRoomConversation implements BookRoomConversation {

    private final JsonObject memory;
    private final Requirement<String> roomName;

    public RecastBookRoomConversation(final JsonObject memory, final Requirement<String> roomName) {
        this.memory = memory;
        this.roomName = roomName;
    }

    public RecastBookRoomConversation(final JsonObject memory) {
        this(memory, new RoomNameRequirement(memory));
    }

    public RecastBookRoomConversation(final Context context) {
        this(
                Json.createReader(new StringReader(context.body()))
                        .readObject()
                        .getJsonObject("conversation")
                        .getJsonObject("memory")
        );
    }

    @Override
    public String roomName() {
        return roomName.value();
    }

    @Override
    public Booking booking() {
        final JsonObject slot = memory.getJsonObject("slot");
        return new Booking(
                memory.getJsonObject("user_id").getString("raw"),
                new Slot(
                        new Timestamp(slot.getString("begin")).value(),
                        new Timestamp(slot.getString("end")).value()
                )
        );
    }
}
