package fr.guddy.chatbotgateway.roombookings.infra.conversation;

public interface GetBookingsForRoomInSlotConversation {
    String roomName();

    long timestampStart();

    long timestampEnd();
}
