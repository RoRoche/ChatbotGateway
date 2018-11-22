package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.domain.Room;

public interface AddRoomConversation {
    String name();

    Integer capacity();

    Room newRoom();
}
