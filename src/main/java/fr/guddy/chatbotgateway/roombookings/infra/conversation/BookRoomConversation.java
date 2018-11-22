package fr.guddy.chatbotgateway.roombookings.infra.conversation;

import fr.guddy.chatbotgateway.roombookings.domain.Booking;

public interface BookRoomConversation {
    String roomName();

    Booking booking();
}
