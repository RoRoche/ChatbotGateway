package fr.guddy.chatbotgateway.roombookings.infra.replies;

import fr.guddy.chatbotgateway.recast.bot.Reply;
import fr.guddy.chatbotgateway.roombookings.domain.Room;

import java.util.List;
import java.util.stream.Collectors;

public final class RoomsTextReplies {
    private final List<Room> rooms;

    public RoomsTextReplies(final List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Reply<String>> replies() {
        return rooms.stream()
                .map(room -> (Reply<String>) new RoomTextReply(room))
                .collect(Collectors.toList());
    }
}
