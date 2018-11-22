package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.domain.Room;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.common.Requirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.RoomCapacityRequirement;
import fr.guddy.chatbotgateway.roombookings.infra.requirements.RoomNameRequirement;
import io.javalin.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public final class RecastAddRoomConversation implements AddRoomConversation {

    private final Requirement<String> name;
    private final Requirement<Integer> capacity;

    public RecastAddRoomConversation(final Requirement<String> name, final Requirement<Integer> capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public RecastAddRoomConversation(final JsonObject memory) {
        this(
                new RoomNameRequirement(memory),
                new RoomCapacityRequirement(memory.getJsonObject("capacity"))
        );
    }

    public RecastAddRoomConversation(final Context context) {
        this(
                Json.createReader(new StringReader(context.body()))
                        .readObject()
                        .getJsonObject("conversation")
                        .getJsonObject("memory")
        );
    }

    @Override
    public String name() {
        return name.value();
    }

    @Override
    public Integer capacity() {
        return capacity.value();
    }

    @Override
    public Room newRoom() {
        return new Room(name.value(), capacity.value());
    }
}
